package com.gft.casadeeventos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gft.casadeeventos.model.Casa;

public interface casas extends  JpaRepository<Casa, Long>{

	Casa findByEnd(String end);
}
