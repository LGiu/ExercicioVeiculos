package br.com.neogrid.Repository;

import br.com.neogrid.Model.Modelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModeloRepository extends JpaRepository<Modelo, Long> {

    Modelo findModeloByCodigo(String codigo);

}

