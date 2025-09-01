package com.universidade.matriculas.service;

import com.universidade.matriculas.exception.RecursoNaoEncontradoException;
import com.universidade.matriculas.exception.RegraDeNegocioException;
import com.universidade.matriculas.model.*;
import com.universidade.matriculas.repository.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SecretariaService {

	private final DisciplinaRepository disciplinaRepository;
	private final MatriculaRepository matriculaRepository;
	private final AlunoRepository alunoRepository;
	private final ProfessorRepository professorRepository;
	private final CursoRepository cursoRepository;

	public SecretariaService(DisciplinaRepository disciplinaRepository, MatriculaRepository matriculaRepository,
			AlunoRepository alunoRepository, ProfessorRepository professorRepository, CursoRepository cursoRepository) {
		this.disciplinaRepository = disciplinaRepository;
		this.matriculaRepository = matriculaRepository;
		this.alunoRepository = alunoRepository;
		this.professorRepository = professorRepository;
		this.cursoRepository = cursoRepository;
	}

	public Aluno cadastrarAluno(String nome, String email, String senha) {
		if (alunoRepository.findByEmail(email).isPresent()) {
			throw new RegraDeNegocioException("Já existe um aluno com o e-mail: " + email);
		}
		Aluno novoAluno = new Aluno(null, nome, email, senha, null);
		return alunoRepository.salvar(novoAluno);
	}

	public Professor cadastrarProfessor(String nome, String email, String senha) {
		if (professorRepository.findByEmail(email).isPresent()) {
			throw new RegraDeNegocioException("Já existe um professor com o e-mail: " + email);
		}
		Professor novoProfessor = new Professor(null, nome, email, senha);
		return professorRepository.salvar(novoProfessor);
	}

	public Curso cadastrarCurso(String nome, int duracao) {
		Curso novoCurso = new Curso(null, nome, duracao);
		return cursoRepository.salvar(novoCurso);
	}

	public Disciplina cadastrarDisciplina(String nome, int creditos, TipoDisciplina tipo, Long cursoId) {
		Curso curso = cursoRepository.buscarPorId(cursoId)
				.orElseThrow(() -> new RecursoNaoEncontradoException("Curso não encontrado com o ID: " + cursoId));

		Disciplina novaDisciplina = new Disciplina(null, nome, creditos, tipo, curso);
		return disciplinaRepository.salvar(novaDisciplina);
	}

	public void finalizarPeriodoMatricula() {
		System.out.println("Iniciando processo de finalização do período de matrícula...");
		List<Disciplina> todasAsDisciplinas = disciplinaRepository.listarTodos();

		for (Disciplina disciplina : todasAsDisciplinas) {
			long numeroDeInscritos = matriculaRepository.countAlunosByDisciplina(disciplina);

			if (numeroDeInscritos >= 3) {
				disciplina.setStatus(StatusDisciplina.ATIVA);
				System.out.println(
						"Disciplina '" + disciplina.getNome() + "' ATIVADA com " + numeroDeInscritos + " alunos.");
			} else {
				disciplina.setStatus(StatusDisciplina.CANCELADA);
				System.out.println("Disciplina '" + disciplina.getNome() + "' CANCELADA por ter apenas "
						+ numeroDeInscritos + " alunos.");
			}
			disciplinaRepository.salvar(disciplina);
		}
		System.out.println("Processo de finalização concluído.");
	}
}