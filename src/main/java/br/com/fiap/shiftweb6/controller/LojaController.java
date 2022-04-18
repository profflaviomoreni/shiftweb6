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

import br.com.fiap.shiftweb6.model.LojaModel;
import br.com.fiap.shiftweb6.repository.LojaRepository;

@RestController
@RequestMapping("/loja")
public class LojaController {

	
	@Autowired
	LojaRepository lojaRepository;
	
	
	@GetMapping("/{id}")
	public ResponseEntity<LojaModel> findById(@PathVariable("id") Long id) {
		LojaModel lojaModel = lojaRepository.findById(id).orElse(null);
		
		if ( null == lojaModel ) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(lojaModel);  // Problema
		}
		
	}
	
	@GetMapping()
	public ResponseEntity<List<LojaModel>> findAll() {
		List<LojaModel> lista = lojaRepository.findAll();
		
		return ResponseEntity.ok( lista );	// Problema
	}
	
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin("*")
	public ResponseEntity post(@RequestBody LojaModel LojaModel) {
		
		lojaRepository.save(LojaModel);
			
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(LojaModel.getIdLoja()).toUri();
		
		return ResponseEntity.created(location).build();
			
	}
	
	@PutMapping("/{id}")
	public ResponseEntity put(@PathVariable("id") Long id,  @RequestBody LojaModel lojaModel) {
		lojaModel.setIdLoja(id);
		lojaRepository.save(lojaModel);
		return ResponseEntity.noContent().build();
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity delete(@PathVariable("id") Long id) {
		if ( lojaRepository.existsById(id) ) {
			lojaRepository.deleteById(id);
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
		
	}
	
}
