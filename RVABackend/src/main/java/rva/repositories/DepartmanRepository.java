package rva.repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import rva.model.Departman;

public interface DepartmanRepository extends JpaRepository<Departman, Integer> {
	
	Collection<Departman> findByNazivContainingIgnoreCase(String naziv);
}
