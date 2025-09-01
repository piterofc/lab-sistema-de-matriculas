package com.universidade.matriculas.model;

import java.io.Serializable;
import java.util.Objects;

public class Curriculo implements Serializable, Entidade {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String nome;
	private int ano;
	private int semestre;
	private Curso curso;

	public Curriculo() {
	}

	public Curriculo(Long id, String nome, int ano, int semestre, Curso curso) {
		this.id = id;
		this.nome = nome;
		this.ano = ano;
		this.semestre = semestre;
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

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public int getSemestre() {
		return semestre;
	}

	public void setSemestre(int semestre) {
		this.semestre = semestre;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Curriculo curriculo = (Curriculo) o;
		return Objects.equals(id, curriculo.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}