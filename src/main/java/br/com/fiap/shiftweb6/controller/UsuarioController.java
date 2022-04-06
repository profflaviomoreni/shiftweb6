package br.com.fiap.shiftweb6.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.shiftweb6.model.UsuarioModel;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@GetMapping
	public ResponseEntity<List<UsuarioModel>> findAll() {
		
		List<UsuarioModel> lista = new ArrayList<>();
		lista.add( new UsuarioModel("191", "fmoreni1@gmail.com.br") );
		lista.add( new UsuarioModel("192", "fmoreni2@gmail.com.br") );
		lista.add( new UsuarioModel("193", "fmoreni3@gmail.com.br") );
		
		return ResponseEntity.ok(lista);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UsuarioModel> findById(@PathVariable("id") Long id) {
		
		if( id == 1 ) { 
			UsuarioModel usuarioModel = new UsuarioModel("191", "fmoreni1@gmail.com.br");
			return ResponseEntity.ok(usuarioModel);
		} else {
			return ResponseEntity.notFound().build();
		}
		
	}
	
	// post -- Criar
	
	// put -- Alterar
	
	// Delete
	
}
