package br.com.fiap.shiftweb6.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.shiftweb6.model.LojaModel;

@Repository
public interface LojaRepository extends JpaRepository<LojaModel, Long> {

	/*
	@Procedure
	int GET_TOTAL_LOJAS(String STR_UF);
	
	@Procedure(procedureName = "GET_TOTAL_LOJAS")
	int getTotalLojas(@Param("STR_UF") String uf);
	
	
	
	@Query(nativeQuery = true, value = "SELECT PKG_TEST.HELLO_WORLD(:text) FROM dual")
	List<Object[]> findStatesByCountry(@Param("text") String texto);
	*/
	
}
