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
import java.util.Date;

@Entity
@Table(name = "veiculo")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Veiculo implements Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @JsonIgnore
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "i_modelo")
    private Modelo modelo;

    @Column(name = "cor_externa")
    @Enumerated(EnumType.STRING)
    private CorExterna corExterna;

    @Column(name = "pintura")
    @Enumerated(EnumType.STRING)
    private Pintura pintura;

    @Column(name = "revestimento_interno")
    @Enumerated(EnumType.STRING)
    private RevestimentoInterno revestimentoInterno;

    @Column(name = "ano")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy")
    private Date ano;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
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

    public Date getAno() {
        return ano;
    }

    public void setAno(Date ano) {
        this.ano = ano;
    }
}
