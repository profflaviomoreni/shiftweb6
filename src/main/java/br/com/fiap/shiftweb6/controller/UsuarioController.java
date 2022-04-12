package br.com.fiap.shiftweb6.controller;

import java.net.URI;
import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.fiap.shiftweb6.model.UsuarioModel;
import br.com.fiap.shiftweb6.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuario")
@CrossOrigin("*")
public class UsuarioController {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	//UsuarioRepository usuarioRepository = new UsuarioRepository();
	
	

	@GetMapping
	public ResponseEntity<List<UsuarioModel>> findAll() {
		List<UsuarioModel> lista = usuarioRepository.findAll();
		return ResponseEntity.ok(lista);
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<UsuarioModel> findById(@PathVariable("id") Long id) {
		UsuarioModel usuarioModel = usuarioRepository.findById(id).orElse(null);
		
		if ( usuarioModel != null  ) {
			return ResponseEntity.ok(usuarioModel);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping("/{email}/{senha}")	
	public ResponseEntity<UsuarioModel> findByEmailAndSenha(
		@PathVariable("email")	String email, 
		@PathVariable("senha")	String senha) {
		
	
		
		return loginUsuario(email, senha);
		
	}

	@GetMapping("/login")
	public ResponseEntity<UsuarioModel> login(
		@RequestParam	String email, 
		@RequestParam	String senha) {
		
		return loginUsuario(email, senha);
	}

	private ResponseEntity<UsuarioModel> loginUsuario(String email, String senha) {
		UsuarioModel usuarioModel = 
				usuarioRepository.findByEmailAndSenha(email, senha);
		
		if ( usuarioModel != null ) {
			return ResponseEntity.ok(usuarioModel);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	
	
	
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin("*")
	public ResponseEntity post(@RequestBody UsuarioModel usuarioModel) {
		System.out.println(usuarioModel);
		
		if ( null != usuarioModel.getIdade() ) {
			
			usuarioRepository.save(usuarioModel);
			
			URI location = ServletUriComponentsBuilder
					.fromCurrentRequest()
					.path("/{id}")
					.buildAndExpand(usuarioModel.getIdUsuario()).toUri();
			
			return ResponseEntity.created(location).build();
			
			
		} else {
			return ResponseEntity.badRequest().body("Idade não informada");
		}
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity put(@PathVariable("id") Long id,  @RequestBody UsuarioModel usuarioModel) {
		System.out.println(usuarioModel);
		
		if ( (null == id) || ( null == usuarioModel.getIdUsuario() ) ) {
			return ResponseEntity.badRequest().body("id não informado");
			
		} else if ( id != usuarioModel.getIdUsuario() ) {
			return ResponseEntity.badRequest().body("id errado");
			
		} else if ( null == usuarioModel.getIdade() ) {
			return ResponseEntity.badRequest().body("idade não informada");
			
		} else if ( ! usuarioRepository.existsById(id) ) {
			return ResponseEntity.notFound().build();
			
		} else {
			usuarioModel.setIdUsuario(id);
			usuarioRepository.save(usuarioModel);
			return ResponseEntity.noContent().build();
		}
		
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity delete(@PathVariable("id") Long id) {
		
		if ( usuarioRepository.existsById(id) ) {
			usuarioRepository.deleteById(id);
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
		
	}
	
}
