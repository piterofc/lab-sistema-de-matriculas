package com.universidade.matriculas.repository;

import com.universidade.matriculas.model.Professor;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public class ProfessorRepository extends ArquivoRepository<Professor> {

	public ProfessorRepository() {
		super("professores.dat");
	}

	public Optional<Professor> findByEmail(String email) {
		return listarTodos().stream().filter(professor -> professor.getEmail().equalsIgnoreCase(email)).findFirst();
	}
}