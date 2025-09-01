package com.universidade.matriculas.model;

import java.io.Serializable;
import java.util.Objects;

public class Aluno extends Usuario implements Serializable, Entidade {

	private static final long serialVersionUID = 1L;

	private Curso curso;
	private Matricula matricula;

	public Aluno() {
		super();
	}

	public Aluno(Long id, String nome, String email, String senha, Curso curso) {
		super(id, nome, email, senha);
		this.curso = curso;
	}

	// getters e setters
	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Matricula getMatricula() {
		return matricula;
	}

	public void setMatricula(Matricula matricula) {
		this.matricula = matricula;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		if (!super.equals(o))
			return false;
		Aluno aluno = (Aluno) o;
		return Objects.equals(curso, aluno.curso);
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), curso);
	}

	@Override
	public String toString() {
		return "Aluno{" + "id=" + getId() + 
				", nome='" + getNome() + '\'' + ", curso=" + (curso != null ? curso.getNome() : "N/A") + '}';
	}
}