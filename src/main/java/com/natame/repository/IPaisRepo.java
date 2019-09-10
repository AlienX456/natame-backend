package com.natame.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.natame.model.Pais;

public interface IPaisRepo extends JpaRepository<Pais, Integer>{
	
}
