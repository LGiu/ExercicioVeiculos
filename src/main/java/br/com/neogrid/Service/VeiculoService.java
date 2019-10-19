package br.com.neogrid.Service;


import br.com.neogrid.Model.Veiculo;
import br.com.neogrid.Repository.VeiculoRepository;
import br.com.neogrid.Util.Retorno;
import br.com.neogrid.Util.ServiceGenerico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class VeiculoService extends ServiceGenerico<Veiculo> {

    private final VeiculoRepository veiculoRepository;

    @Autowired
    public VeiculoService(VeiculoRepository veiculoRepository) {
        super(veiculoRepository, Veiculo.class);
        this.veiculoRepository = veiculoRepository;
    }

    @Override
    @Transactional
    public Retorno salva(Veiculo veiculo) {
        return super.salva(veiculo);
    }

    @Override
    public Retorno validador(Veiculo veiculo) {
        return super.validador(veiculo);
    }
}
