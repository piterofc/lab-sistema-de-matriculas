package com.universidade.matriculas.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Turma {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String status;
	private final int vagas = 60;
	private final int minAlunos = 3;

	@ManyToOne
	private Disciplina disciplina;

	@ManyToOne
	private Semestre semestre;

	@ManyToOne
	private Professor professor;

	@OneToMany(mappedBy = "turma")
	private List<Matricula> matriculas;

	public Aluno[] getAlunosMatriculados() {
		// buscar os alunos a partir da lista de matriculas
		System.out.println("Buscando alunos da turma.");
		return null;
	}

	public void verificarStatusTurma() {
		// verifica se a turma tem o minimo de alunos (chamada por "Secretaria.finalizarPeriodoMatricula()")
		System.out.println("Verificando status da turma.");
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public Semestre getSemestre() {
		return semestre;
	}

	public void setSemestre(Semestre semestre) {
		this.semestre = semestre;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public List<Matricula> getMatriculas() {
		return matriculas;
	}

	public void setMatriculas(List<Matricula> matriculas) {
		this.matriculas = matriculas;
	}

	public int getVagas() {
		return vagas;
	}

	public int getMinAlunos() {
		return minAlunos;
	}
}