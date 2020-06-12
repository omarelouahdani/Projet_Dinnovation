package org.sid.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import org.sid.entities.Departement;


public interface DepartementRepository extends JpaRepository<Departement, Long>{
	public Page<Departement> findByIntituleContains(String mc, Pageable pageable);
}
