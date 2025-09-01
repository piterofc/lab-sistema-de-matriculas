package com.universidade.matriculas.repository;

import com.universidade.matriculas.model.Aluno;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public class AlunoRepository extends ArquivoRepository<Aluno> {

	public AlunoRepository() {
		super("alunos.dat");
	}

	public Optional<Aluno> findByEmail(String email) {
		return listarTodos().stream().filter(aluno -> aluno.getEmail().equalsIgnoreCase(email)).findFirst();
	}
}