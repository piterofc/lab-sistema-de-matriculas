package com.universidade.matriculas.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Aluno extends Usuario {

	private String matricula;

	@OneToMany(mappedBy = "aluno")
	private List<Matricula> matriculas;

	public Turma[] realizarMatricula(Turma[] turmas) {
		// matricular o aluno nas turmas
		System.out.println("Aluno " + getNome() + " realizando matrícula.");
		return null;
	}

	public void cancelarMatricula(Matricula matricula) {
		// cancelar uma matricula
		System.out.println("Aluno " + getNome() + " cancelando matrícula.");
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public List<Matricula> getMatriculas() {
		return matriculas;
	}

	public void setMatriculas(List<Matricula> matriculas) {
		this.matriculas = matriculas;
	}
}