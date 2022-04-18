package br.com.fiap.shiftweb6.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.shiftweb6.model.MarcaModel;

@Repository
public interface MarcaRepository extends JpaRepository<MarcaModel, Long> {

}
