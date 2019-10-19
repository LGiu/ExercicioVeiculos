package br.com.neogrid.Repository;

import br.com.neogrid.Model.Construcao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContrucaoRepository extends JpaRepository<Construcao, Long> {

    Construcao findVeiculoByIdentificador(String identificaor);

}

