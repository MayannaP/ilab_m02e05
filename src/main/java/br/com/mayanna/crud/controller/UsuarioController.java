package br.com.mayanna.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.mayanna.crud.dao.UsuarioDAO;
import br.com.mayanna.crud.model.Usuario;

@RestController
public class UsuarioController {
	@Autowired
	UsuarioDAO dao;  
	
	@PostMapping("/usuario")
	public void createUsuario(@RequestBody Usuario novoUsuario) { 
		dao.save(novoUsuario);
	}
	
	@GetMapping("/usuarios")
	public List<Usuario> getUsuario() {
		List<Usuario> lista = dao.findAll(); 
		return lista; 
	}
	
	@DeleteMapping("/usuario/{id}")
	public void deleteUsuario(@PathVariable Long id) {
		dao.deleteById(id);
	}
	
	@PutMapping("/usuario/{id}")
	public void updateUsuario(@PathVariable Long id, @RequestBody Usuario novoUsuario) {
		Usuario usuario = dao.getById(id); 
		usuario.setNome(novoUsuario.getNome());
		usuario.setEmail(novoUsuario.getEmail());
		usuario.setCpf(novoUsuario.getCpf());
		dao.save(usuario);
	}
	
}
