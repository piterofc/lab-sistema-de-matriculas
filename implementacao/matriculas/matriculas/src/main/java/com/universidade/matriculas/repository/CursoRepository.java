package com.universidade.matriculas.repository;

import com.universidade.matriculas.model.Curso;
import org.springframework.stereotype.Repository;

@Repository
public class CursoRepository extends ArquivoRepository<Curso> {

	public CursoRepository() {
		super("cursos.dat");
	}
}