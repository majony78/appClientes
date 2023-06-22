package com.datajpa.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.datajpa.models.entity.Usuario;

public interface IUsuarioDAO extends CrudRepository<Usuario, Long> {
	
	public Usuario findByUsername(String username);

}
