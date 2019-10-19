package br.com.neogrid.Repository;

import br.com.neogrid.Model.Construcao;
import br.com.neogrid.Model.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {

}

