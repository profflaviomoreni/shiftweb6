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
import br.com.fiap.shiftweb6.model.LojaModel;
import br.com.fiap.shiftweb6.model.ProdutoModel;
import br.com.fiap.shiftweb6.model.mixin.CategoriaModelMixin;
import br.com.fiap.shiftweb6.model.mixin.LojasMixin;
import br.com.fiap.shiftweb6.model.mixin.MarcaModelMixin;
import br.com.fiap.shiftweb6.model.mixin.ProdutosMixin;
import br.com.fiap.shiftweb6.repository.LojaRepository;

@RestController
@RequestMapping("/loja")
public class LojaController {

	@Autowired
	LojaRepository lojaRepository;

	@GetMapping("/{id}")
	public ResponseEntity<JsonNode> findById(@PathVariable("id") Long id) throws JsonMappingException, JsonProcessingException   {
			
			LojaModel lojaModel = lojaRepository.findById(id).orElse(null);
			
			ObjectMapper mapper = new ObjectMapper();
			mapper.addMixIn(ProdutoModel.class, MarcaModelMixin.class);			
			mapper.addMixIn(ProdutoModel.class, CategoriaModelMixin.class);
			mapper.addMixIn(ProdutoModel.class, LojasMixin.class);
			mapper.addMixIn(CategoriaModel.class, ProdutosMixin.class);
			
			if ( null == lojaModel ) {
				return ResponseEntity.notFound().build();
			} else {
				return ResponseEntity.ok( mapper.readTree( mapper.writeValueAsString(lojaModel) ) );
			}
			
		
			
	}

	@GetMapping()
	public ResponseEntity<List<LojaModel>> findAll() {
		List<LojaModel> lista = lojaRepository.findAll();

		return ResponseEntity.ok(lista); // Problema
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin("*")
	public ResponseEntity post(@RequestBody LojaModel LojaModel) {

		lojaRepository.save(LojaModel);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(LojaModel.getIdLoja()).toUri();

		return ResponseEntity.created(location).build();

	}

	@PutMapping("/{id}")
	public ResponseEntity put(@PathVariable("id") Long id, @RequestBody LojaModel lojaModel) {
		lojaModel.setIdLoja(id);
		lojaRepository.save(lojaModel);
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity delete(@PathVariable("id") Long id) {
		if (lojaRepository.existsById(id)) {
			lojaRepository.deleteById(id);
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}

	}

}
