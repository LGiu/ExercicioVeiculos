package br.com.neogrid.Service;


import br.com.neogrid.Model.Modelo;
import br.com.neogrid.Repository.ModeloRepository;
import br.com.neogrid.Util.Retorno;
import br.com.neogrid.Util.ServiceGenerico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ModeloService extends ServiceGenerico<Modelo> {

    private final ModeloRepository modeloRepository;

    @Autowired
    public ModeloService(ModeloRepository modeloRepository) {
        super(modeloRepository, Modelo.class);
        this.modeloRepository = modeloRepository;
    }

    @Override
    @Transactional
    public Retorno salva(Modelo modelo) {
        return super.salva(modelo);
    }

    @Override
    public Retorno validador(Modelo modelo) {
        return super.validador(modelo);
    }

    public Modelo buscaPorCodigo(String codigo) {
        try {
            return modeloRepository.findModeloByCodigo(codigo);
        } catch (Exception e) {
            return null;
        }
    }

    public Retorno altera(Modelo modelo){
        try {
            if(modelo != null && modelo.getCodigo() != null){
                modelo = aplicaAltercoes(modelo, buscaPorCodigo(modelo.getCodigo()));
                if(modelo == null){
                    return new Retorno("Erro ao alterar!");
                }
                return salva(modelo);
            } else {
                return new Retorno("O código do modelo deve ser informado!");
            }
        } catch (Exception e) {
            return null;
        }
    }

    public Retorno exclui(String codigo) {
        try {
            Modelo modelo = buscaPorCodigo(codigo);
            modeloRepository.delete(modelo);
            return new Retorno<>();
        } catch (Exception e) {
            return new Retorno<>("Erro ao excluir!");
        }
    }
}
