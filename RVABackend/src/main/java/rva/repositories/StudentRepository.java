package rva.repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import rva.model.Departman;
import rva.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{
	Student findByBrojIndeksa(String brojIndeksa);
	Collection<Student> findByDepartman(Departman departman);
}
