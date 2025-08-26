package com.universidade.matriculas.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Professor extends Usuario {

	private String departamento;

	@OneToMany(mappedBy = "professor")
	private List<Turma> turmas;

	public void consultarNormas(Turma[] turmas) {
		// consulta
		System.out.println("Professor " + getNome() + " consultando normas.");
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public List<Turma> getTurmas() {
		return turmas;
	}

	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	}
}