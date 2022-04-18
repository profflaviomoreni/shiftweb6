package br.com.fiap.shiftweb6.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.fiap.shiftweb6.model.CategoriaModel;

@Repository
public interface CategoriaRepository extends JpaRepository<CategoriaModel, Long> {

	static final String QUERY_TOTAL_CATEGORIA = "SELECT COUNT(ATIVO) QUANT FROM SHIFT6_CATEGORIA WHERE ATIVO = 1";
	
	
	@Override
	@Query(value="SELECT c FROM CategoriaModel c WHERE ativo = 1")
	public List<CategoriaModel> findAll();
	
	
	@Override
	@Query(value="SELECT c FROM CategoriaModel c WHERE ativo = 1 AND idCategoria = :id")
	public Optional<CategoriaModel> findById(Long id);
	
	
	@Query(	value=QUERY_TOTAL_CATEGORIA, nativeQuery = true)
	public Long getTotalCategorias();
	
	
	public List<CategoriaModel> findByNomeCategoriaContains(String nome);
	
}
