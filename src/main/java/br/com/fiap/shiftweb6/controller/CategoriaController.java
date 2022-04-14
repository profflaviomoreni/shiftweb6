package br.com.fiap.shiftweb6.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.shiftweb6.model.CategoriaModel;
import br.com.fiap.shiftweb6.repository.CategoriaRepository;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@GetMapping("/{id}")
	public ResponseEntity<CategoriaModel> findById(@PathVariable("id") Long id) {
		CategoriaModel categoriaModel = categoriaRepository.findById(id).orElse(null);
		
		if ( null == categoriaModel ) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(categoriaModel);
		}
		
	}
	
	@GetMapping()
	public ResponseEntity<List<CategoriaModel>> findAll() {
		return ResponseEntity.ok( categoriaRepository.findAll() );	
	}
	
	
	@GetMapping("/total")
	public ResponseEntity<Long> getTotalCategorias() {
		return ResponseEntity.ok(categoriaRepository.getTotalCategorias());
	}
	
	
	@GetMapping("/nome")
	public ResponseEntity<List<CategoriaModel>> findByNome(
			@RequestParam("nome") String nome) {
		
		return ResponseEntity.ok( categoriaRepository.findByNomeCategoriaContains(nome) );
		
	}
	
	
}
