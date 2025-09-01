package com.universidade.matriculas.service;

import com.universidade.matriculas.exception.RecursoNaoEncontradoException;
import com.universidade.matriculas.model.Disciplina;
import com.universidade.matriculas.model.Matricula;
import com.universidade.matriculas.repository.DisciplinaRepository;
import com.universidade.matriculas.repository.MatriculaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service 
public class AlunoService {

	private final DisciplinaRepository disciplinaRepository;
	private final MatriculaRepository matriculaRepository;

	public AlunoService(DisciplinaRepository disciplinaRepository, MatriculaRepository matriculaRepository) {
		this.disciplinaRepository = disciplinaRepository;
		this.matriculaRepository = matriculaRepository;
	}

	public List<Disciplina> consultarDisciplinasDisponiveis() {
		return disciplinaRepository.listarTodos();
	}

	public Matricula consultarMinhaMatricula(Long alunoId) {
		return matriculaRepository.findByAlunoId(alunoId)
				.orElseThrow(() -> new RecursoNaoEncontradoException("Você ainda não realizou uma matrícula."));
	}
}