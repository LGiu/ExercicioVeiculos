package br.com.neogrid.Model;


import br.com.neogrid.Enum.CorExterna;
import br.com.neogrid.Enum.Pintura;
import br.com.neogrid.Enum.RevestimentoInterno;
import br.com.neogrid.Interface.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "construcao", uniqueConstraints = {@UniqueConstraint(columnNames = {"identificador"})})
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Construcao implements Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @JsonIgnore
    private Long id;

    @Column(name = "identificador")
    @NotNull(message = "O identificador deve ser informado!")
    private String identificador;

    @Transient
    private String codigo;

    @Transient
    private CorExterna corExterna;

    @Transient
    private Pintura pintura;

    @Transient
    private RevestimentoInterno revestimentoInterno;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "i_veiculo")
    private Veiculo veiculo;

    @Column(name = "status")
    private String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public CorExterna getCorExterna() {
        return corExterna;
    }

    public void setCorExterna(CorExterna corExterna) {
        this.corExterna = corExterna;
    }

    public Pintura getPintura() {
        return pintura;
    }

    public void setPintura(Pintura pintura) {
        this.pintura = pintura;
    }

    public RevestimentoInterno getRevestimentoInterno() {
        return revestimentoInterno;
    }

    public void setRevestimentoInterno(RevestimentoInterno revestimentoInterno) {
        this.revestimentoInterno = revestimentoInterno;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }
}
