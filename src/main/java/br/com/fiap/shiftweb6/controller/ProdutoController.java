package br.com.fiap.shiftweb6.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.fiap.shiftweb6.model.CategoriaModel;
import br.com.fiap.shiftweb6.model.ProdutoModel;
import br.com.fiap.shiftweb6.model.mixin.LojasMixin;
import br.com.fiap.shiftweb6.model.mixin.ProdutosMixin;
import br.com.fiap.shiftweb6.model.mixin.SkuMixin;
import br.com.fiap.shiftweb6.repository.ProdutoRepository;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

	
	@Autowired
	ProdutoRepository produtoRepository;
	
	
	@GetMapping("/{id}")
	public ResponseEntity<JsonNode> findById(@PathVariable("id") Long id) throws JsonProcessingException {
		ProdutoModel produtoModel = produtoRepository.findById(id).orElse(null);
		
		ObjectMapper mapper = new ObjectMapper(); // mapeamento
		mapper.addMixIn(CategoriaModel.class, ProdutosMixin.class);
		mapper.addMixIn(ProdutoModel.class, SkuMixin.class);
		mapper.addMixIn(ProdutoModel.class, LojasMixin.class);
		
		
		if ( null == produtoModel ) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok( mapper.readTree( mapper.writeValueAsString(produtoModel) ) );  
		}
		
	}
	
	@GetMapping()
	public ResponseEntity<List<ProdutoModel>> findAll() {
		List<ProdutoModel> lista = produtoRepository.findAll();
		
		return ResponseEntity.ok( lista );	// Problema
	}
	
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin("*")
	public ResponseEntity post(@RequestBody ProdutoModel produtoModel) {
		
		produtoRepository.save(produtoModel);
			
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(produtoModel.getIdProduto()).toUri();
		
		return ResponseEntity.created(location).build();
			
	}
	
	@PutMapping("/{id}")
	public ResponseEntity put(@PathVariable("id") Long id,  @RequestBody ProdutoModel produtoModel) {
		produtoModel.setIdProduto(id);
		produtoRepository.save(produtoModel);
		return ResponseEntity.noContent().build();
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity delete(@PathVariable("id") Long id) {
		if ( produtoRepository.existsById(id) ) {
			produtoRepository.deleteById(id);
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
		
	}
	
}
