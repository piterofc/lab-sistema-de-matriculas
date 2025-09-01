package com.universidade.matriculas.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Curso implements Serializable, Entidade {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String nome;
	private int duracaoEmSemestres;
	private List<Disciplina> disciplinas = new ArrayList<>();

	public Curso() {
	}

	public Curso(Long id, String nome, int duracaoEmSemestres) {
		this.id = id;
		this.nome = nome;
		this.duracaoEmSemestres = duracaoEmSemestres;
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

	public int getDuracaoEmSemestres() {
		return duracaoEmSemestres;
	}

	public void setDuracaoEmSemestres(int duracaoEmSemestres) {
		this.duracaoEmSemestres = duracaoEmSemestres;
	}

	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

	// metodo auxiliar
	public void adicionarDisciplina(Disciplina disciplina) {
		this.disciplinas.add(disciplina);
		disciplina.setCurso(this);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Curso curso = (Curso) o;
		return Objects.equals(id, curso.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public String toString() {
		return "Curso{" + "id=" + id + ", nome='" + nome + '\'' + '}';
	}
}