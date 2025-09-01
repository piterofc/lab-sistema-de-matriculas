package com.universidade.matriculas.repository;

import com.universidade.matriculas.model.Aluno;
import com.universidade.matriculas.model.Disciplina;
import com.universidade.matriculas.model.Matricula;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class MatriculaRepository extends ArquivoRepository<Matricula> {

	public MatriculaRepository() {
		super("matriculas.dat");
	}

	public Optional<Matricula> findByAlunoId(Long alunoId) {
		return listarTodos().stream().filter(matricula -> matricula.getAluno().getId().equals(alunoId)).findFirst();
	}

	public long countAlunosByDisciplina(Disciplina disciplina) {
		return listarTodos().stream().filter(matricula -> matricula.getDisciplinasObrigatorias().contains(disciplina)
				|| matricula.getDisciplinasOptativas().contains(disciplina)).count();
	}

	public List<Aluno> findAlunosByDisciplina(Disciplina disciplina) {
		return listarTodos().stream()
				.filter(matricula -> matricula.getDisciplinasObrigatorias().contains(disciplina)
						|| matricula.getDisciplinasOptativas().contains(disciplina))
				.map(Matricula::getAluno).collect(Collectors.toList());
	}
}