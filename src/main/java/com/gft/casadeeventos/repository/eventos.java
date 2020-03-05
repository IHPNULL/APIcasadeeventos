package com.gft.casadeeventos.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gft.casadeeventos.model.Evento;

public interface eventos extends JpaRepository<Evento, Long>{

	Optional<Evento> save(Optional<Evento> evexist);

}
