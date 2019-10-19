package br.com.neogrid.Service;


import br.com.neogrid.Model.Construcao;
import br.com.neogrid.Model.Veiculo;
import br.com.neogrid.Repository.ContrucaoRepository;
import br.com.neogrid.Repository.VeiculoRepository;
import br.com.neogrid.Util.Datas;
import br.com.neogrid.Util.Retorno;
import br.com.neogrid.Util.ServiceGenerico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.UUID;

@Service
public class ContrucaoService extends ServiceGenerico<Construcao> {

    private final ModeloService modeloService;
    private final VeiculoService veiculoService;
    private final ContrucaoRepository contrucaoRepository;

    @Autowired
    public ContrucaoService(ModeloService modeloService, VeiculoService veiculoService, ContrucaoRepository contrucaoRepository) {
        super(contrucaoRepository, Construcao.class);
        this.modeloService = modeloService;
        this.veiculoService = veiculoService;
        this.contrucaoRepository = contrucaoRepository;
    }

    @Override
    @Transactional
    public Retorno salva(final Construcao construcao) {
        construcao.setIdentificador(UUID.randomUUID().toString());
        construcao.setStatus("Em fila para a contrução!");
        Retorno retorno = super.validador(construcao);
        if (retorno.isErro()) {
            return retorno;
        }

        Veiculo veiculo = new Veiculo();

        Thread thread1 = new Thread(() -> {
            construcao.setStatus("Em criação do veículo!");
            super.salva(construcao, false);

            veiculo.setModelo(modeloService.buscaPorCodigo(construcao.getCodigo()));
            veiculo.setAno(Datas.stringToDate(new Date(), "yyyy"));
            veiculoService.save(veiculo);
        });

        Thread thread2 = new Thread(() -> {
            construcao.setStatus("Em criação do veículo!");
            super.salva(construcao, false);

            veiculo.setPintura(construcao.getPintura());
            veiculo.setCorExterna(construcao.getCorExterna());
            veiculoService.save(veiculo);

        });

        Thread thread3 = new Thread(() -> {
            construcao.setStatus("Em revestimento do veículo!");
            super.salva(construcao, false);

            veiculo.setRevestimentoInterno(construcao.getRevestimentoInterno());
            veiculoService.save(veiculo);

            construcao.setStatus("Concluído!");
            construcao.setVeiculo(veiculo);
            super.salva(construcao, false);
        });

        thread1.setPriority(3);
        thread2.setPriority(2);
        thread3.setPriority(1);

        try {
            thread1.start();
            thread1.join();
            thread2.start();
            thread2.join();
            thread3.start();
            thread3.join();
        } catch (Exception e) {
        }

        return new Retorno(construcao, construcao.getIdentificador());
    }

    @Override
    public Retorno validador(Construcao construcao) {
        return super.validador(construcao);
    }

    public Construcao buscaPorCodigo(String codigo) {
        try {
            return contrucaoRepository.findVeiculoByIdentificador(codigo);
        } catch (Exception e) {
            return null;
        }
    }

}
