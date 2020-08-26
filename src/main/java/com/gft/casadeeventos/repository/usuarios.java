package com.gft.casadeeventos.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gft.casadeeventos.model.Usuario;

public interface usuarios extends JpaRepository<Usuario, Long> {

	Usuario findByUsername(String username);

	Optional<Usuario> save(Optional<Usuario> user);

}
