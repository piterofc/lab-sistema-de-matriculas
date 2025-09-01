package com.universidade.matriculas.repository;

import com.universidade.matriculas.model.Disciplina;
import org.springframework.stereotype.Repository;

@Repository
public class DisciplinaRepository extends ArquivoRepository<Disciplina> {

	public DisciplinaRepository() {
		super("disciplinas.dat");
	}
}