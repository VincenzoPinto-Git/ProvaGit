package it.begear.springTopBoot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import it.begear.springTopBoot.entities.Registrato;

@Repository
public interface VGRepo extends JpaRepository<Registrato, Long>{

	
	List<Registrato> findRegistratoByAcquisto(String acquisto);
	
}