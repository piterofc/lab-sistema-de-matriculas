package com.universidade.matriculas.service;

import com.universidade.matriculas.exception.RecursoNaoEncontradoException;
import com.universidade.matriculas.exception.RegraDeNegocioException;
import com.universidade.matriculas.model.Aluno;
import com.universidade.matriculas.model.Disciplina;
import com.universidade.matriculas.repository.DisciplinaRepository;
import com.universidade.matriculas.repository.MatriculaRepository;
import com.universidade.matriculas.repository.ProfessorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ProfessorService {

	private final ProfessorRepository professorRepository;
	private final DisciplinaRepository disciplinaRepository;
	private final MatriculaRepository matriculaRepository;

	public ProfessorService(ProfessorRepository professorRepository, DisciplinaRepository disciplinaRepository,
			MatriculaRepository matriculaRepository) {
		this.professorRepository = professorRepository;
		this.disciplinaRepository = disciplinaRepository;
		this.matriculaRepository = matriculaRepository;
	}

	public List<Aluno> listarAlunosPorDisciplina(Long professorId, Long disciplinaId) {
		Disciplina disciplina = disciplinaRepository.buscarPorId(disciplinaId).orElseThrow(
				() -> new RecursoNaoEncontradoException("Disciplina não encontrada com o ID: " + disciplinaId));

		professorRepository.buscarPorId(professorId).orElseThrow(
				() -> new RecursoNaoEncontradoException("Professor não encontrado com o ID: " + professorId));

		if (disciplina.getProfessor() == null || !Objects.equals(disciplina.getProfessor().getId(), professorId)) {
			throw new RegraDeNegocioException("Acesso negado. Você não é o professor desta disciplina.");
		}

		return matriculaRepository.findAlunosByDisciplina(disciplina);
	}
}