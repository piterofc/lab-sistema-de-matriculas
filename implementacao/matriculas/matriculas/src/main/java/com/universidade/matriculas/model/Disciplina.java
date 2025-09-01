package com.universidade.matriculas.model;

import java.io.Serializable;
import java.util.Objects;

public class Disciplina implements Serializable, Entidade {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String nome;
	private int creditos;
	private int vagas = 60;
	private StatusDisciplina status = StatusDisciplina.PLANEJADA;
	private TipoDisciplina tipo;
	private Curso curso;
	private Professor professor;

	public Disciplina() {
	}

	public Disciplina(Long id, String nome, int creditos, TipoDisciplina tipo, Curso curso) {
		this.id = id;
		this.nome = nome;
		this.creditos = creditos;
		this.tipo = tipo;
		this.curso = curso;
	}

	// getters e setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCreditos() {
		return creditos;
	}

	public void setCreditos(int creditos) {
		this.creditos = creditos;
	}

	public int getVagas() {
		return vagas;
	}

	public void setVagas(int vagas) {
		this.vagas = vagas;
	}

	public StatusDisciplina getStatus() {
		return status;
	}

	public void setStatus(StatusDisciplina status) {
		this.status = status;
	}

	public TipoDisciplina getTipo() {
		return tipo;
	}

	public void setTipo(TipoDisciplina tipo) {
		this.tipo = tipo;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Disciplina that = (Disciplina) o;
		return Objects.equals(id, that.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public String toString() {
		return "Disciplina{" + "id=" + id + ", nome='" + nome + '\'' + '}';
	}
}