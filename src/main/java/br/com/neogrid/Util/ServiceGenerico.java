package br.com.neogrid.Util;


import br.com.neogrid.Interface.Model;
import br.com.neogrid.Model.Modelo;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.util.*;

public class ServiceGenerico<U extends Model> {

    private final JpaRepository<U, Long> jpaRepository;
    private final Class aClass;

    public ServiceGenerico(JpaRepository<U, Long> jpaRepository, Class aClass) {
        this.jpaRepository = jpaRepository;
        this.aClass = aClass;
    }

    public Retorno validador(U u) {
        if (u == null) {
            return new Retorno("Objeto nulo!");
        }

        if (u.getId() != null && !existe(u)) {
            return new Retorno("O registro não existe!");
        }

        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<U>> violations = validator.validate(u);
        List<String> erros = new ArrayList<>();
        if (!violations.isEmpty()) {
            for (ConstraintViolation<U> erro : violations) {
                erros.add(u.getClass().getSimpleName() + "." + erro.getPropertyPath() + ":" + erro.getMessage());
            }
            return new Retorno(erros);
        }

        return new Retorno();
    }

    public Retorno salva(U u) {
        return salva(u, true);
    }

    public Retorno salva(U u, boolean valida) {
        try {
            if (valida) {
                Retorno retorno = validador(u);
                if (retorno.isErro()) {
                    return retorno;
                }
            }
            return new Retorno(save(u));
        } catch (Exception e) {
            if (e.getCause().getClass() == org.hibernate.exception.ConstraintViolationException.class) {
                UniqueConstraint[] un = u.getClass().getAnnotation(Table.class).uniqueConstraints();
                if (un.length > 0) {
                    return new Retorno<>("Os atributos " + Arrays.toString(un[0].columnNames()) + " devem ser únicos!");
                } else {
                    return new Retorno<>("Exitem atributos que devem ser únicos!");
                }
            } else {
                return new Retorno<>(e.getMessage());
            }
        }
    }

    public U save(U u){
        return jpaRepository.save(u);
    }

    public List<U> buscaLista() {
        try {
            return jpaRepository.findAll();
        } catch (Exception e) {
            return null;
        }
    }

    public boolean existe(U u) {
        try {
            if (u == null || u.getId() == null) {
                return false;
            }

            return jpaRepository.existsById(u.getId());
        } catch (Exception e) {
            return false;
        }
    }

    public U aplicaAltercoes(U u, U uAnt) {
        if (u != null && uAnt != null) {
            BeanWrapper beanWrapperAnt = new BeanWrapperImpl(uAnt);
            BeanWrapper beanWrapper = new BeanWrapperImpl(u);
            for (PropertyDescriptor propertyDescriptor : beanWrapper.getPropertyDescriptors()) {
                try{
                    if(!propertyDescriptor.getName().equals("id")){
                        beanWrapperAnt.setPropertyValue(propertyDescriptor.getName(), beanWrapper.getPropertyValue(propertyDescriptor.getName()));
                    }
                } catch (Exception ignored) {}
            }
            return (U) beanWrapperAnt.getWrappedInstance();
        }
        return null;
    }

}
