package br.com.neogrid.Model;


import br.com.neogrid.Interface.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "modelo", uniqueConstraints = {@UniqueConstraint(columnNames = {"codigo"})})
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Modelo implements Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @JsonIgnore
    private Long id;

    @Column(name = "codigo")
    @NotNull(message = "O código deve ser informado!")
    private String codigo;

    @Column(name = "numero_rodas")
    @Range(min = 2, max = 4, message = "O número de rodas deve ser de 2 à 4!")
    private Integer numeroRodas;

    @Column(name = "cilindradas")
    @Range(min = 125, max = 2000, message = "O cilindradas do motor deve ser de 125cc à 2000cc!")
    private Integer cilindradas;

    @Column(name = "nome_comercial")
    @Size(max = 255, message = "O nome comercial deve possuir no máximo 255 caracteres!")
    private String nomeComercial;

    @Column(name = "numero_passageiro")
    @Range(min = 0, max = 4, message = "O número de passageiro deve ser de 0 à 4!")
    private Integer numeroPassageiro;

    @Column(name = "ano")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy")
    private Date ano;

    @Column(name = "possui_estepe", columnDefinition = "boolean default false")
    private Boolean possuiEstepe;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Integer getNumeroRodas() {
        return numeroRodas;
    }

    public void setNumeroRodas(Integer numeroRodas) {
        this.numeroRodas = numeroRodas;
    }

    public Integer getCilindradas() {
        return cilindradas;
    }

    public void setCilindradas(Integer cilindradas) {
        this.cilindradas = cilindradas;
    }

    public String getNomeComercial() {
        return nomeComercial;
    }

    public void setNomeComercial(String nomeComercial) {
        this.nomeComercial = nomeComercial;
    }

    public Integer getNumeroPassageiro() {
        return numeroPassageiro;
    }

    public void setNumeroPassageiro(Integer numeroPassageiro) {
        this.numeroPassageiro = numeroPassageiro;
    }

    public Date getAno() {
        return ano;
    }

    public void setAno(Date ano) {
        this.ano = ano;
    }

    public Boolean getPossuiEstepe() {
        return possuiEstepe;
    }

    public void setPossuiEstepe(Boolean possuiEstepe) {
        this.possuiEstepe = possuiEstepe;
    }
}
