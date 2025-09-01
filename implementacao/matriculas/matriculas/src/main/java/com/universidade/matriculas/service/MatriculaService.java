package com.universidade.matriculas.service;

import com.universidade.matriculas.dto.MatriculaRequestDto;
import com.universidade.matriculas.exception.RecursoNaoEncontradoException;
import com.universidade.matriculas.exception.RegraDeNegocioException;
import com.universidade.matriculas.model.Aluno;
import com.universidade.matriculas.model.Disciplina;
import com.universidade.matriculas.model.Matricula;
import com.universidade.matriculas.repository.AlunoRepository;
import com.universidade.matriculas.repository.DisciplinaRepository;
import com.universidade.matriculas.repository.MatriculaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class MatriculaService {

	private final MatriculaRepository matriculaRepository;
	private final AlunoRepository alunoRepository;
	private final DisciplinaRepository disciplinaRepository;

	public MatriculaService(MatriculaRepository matriculaRepository, AlunoRepository alunoRepository,
			DisciplinaRepository disciplinaRepository) {
		this.matriculaRepository = matriculaRepository;
		this.alunoRepository = alunoRepository;
		this.disciplinaRepository = disciplinaRepository;
	}

	public Matricula realizarMatricula(MatriculaRequestDto dto) {
		Aluno aluno = alunoRepository.buscarPorId(dto.getAlunoId()).orElseThrow(
				() -> new RecursoNaoEncontradoException("Aluno não encontrado com o ID: " + dto.getAlunoId()));

		matriculaRepository.findByAlunoId(aluno.getId()).ifPresent(m -> {
			throw new RegraDeNegocioException("Este aluno já possui uma matrícula ativa.");
		});

		if (dto.getIdsDisciplinasObrigatorias().size() > 4) {
			throw new RegraDeNegocioException("Não é permitido se matricular em mais de 4 disciplinas obrigatórias.");
		}
		if (dto.getIdsDisciplinasOptativas().size() > 2) {
			throw new RegraDeNegocioException("Não é permitido se matricular em mais de 2 disciplinas optativas.");
		}

		List<Disciplina> disciplinasObrigatorias = new ArrayList<>();
		for (Long id : dto.getIdsDisciplinasObrigatorias()) {
			disciplinasObrigatorias.add(disciplinaRepository.buscarPorId(id).orElseThrow(
					() -> new RecursoNaoEncontradoException("Disciplina obrigatória não encontrada com ID: " + id)));
		}

		List<Disciplina> disciplinasOptativas = new ArrayList<>();
		for (Long id : dto.getIdsDisciplinasOptativas()) {
			disciplinasOptativas.add(disciplinaRepository.buscarPorId(id).orElseThrow(
					() -> new RecursoNaoEncontradoException("Disciplina optativa não encontrada com ID: " + id)));
		}

		validarVagas(disciplinasObrigatorias);
		validarVagas(disciplinasOptativas);

		Matricula novaMatricula = new Matricula(null, LocalDate.now(), aluno);
		novaMatricula.setDisciplinasObrigatorias(disciplinasObrigatorias);
		novaMatricula.setDisciplinasOptativas(disciplinasOptativas);

		System.out.println("Sistema de cobranças notificado sobre a matrícula do aluno: " + aluno.getNome());

		return matriculaRepository.salvar(novaMatricula);
	}

	public void cancelarMatricula(Long alunoId) {
		Matricula matricula = matriculaRepository.findByAlunoId(alunoId)
				.orElseThrow(() -> new RecursoNaoEncontradoException(
						"Nenhuma matrícula encontrada para o aluno com ID: " + alunoId));

		matriculaRepository.deletarPorId(matricula.getId());
		System.out.println("Matrícula do aluno ID " + alunoId + " cancelada com sucesso.");
	}

	private void validarVagas(List<Disciplina> disciplinas) {
		for (Disciplina disciplina : disciplinas) {
			long inscritos = matriculaRepository.countAlunosByDisciplina(disciplina);
			if (inscritos >= disciplina.getVagas()) {
				throw new RegraDeNegocioException("A disciplina '" + disciplina.getNome() + "' não possui mais vagas.");
			}
		}
	}
}