package br.com.fiap.shiftweb6.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.fiap.shiftweb6.model.ProdutoModel;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoModel, Long> {


	@Override
	@Query("SELECT p, p.marcaModel, p.categoriaModel  FROM ProdutoModel p INNER JOIN p.marcaModel INNER JOIN p.categoriaModel ")
	public List<ProdutoModel> findAll();
	
	//JPQL
	@Override
	@Query("SELECT p, p.marcaModel, p.categoriaModel  FROM ProdutoModel p INNER JOIN p.marcaModel INNER JOIN p.categoriaModel WHERE p.idProduto = :id ")
	public Optional<ProdutoModel> findById(Long id);

	
}
