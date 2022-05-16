package br.com.mayanna.crud.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mayanna.crud.model.Usuario;

public interface UsuarioDAO extends JpaRepository<Usuario, Object>{

}
