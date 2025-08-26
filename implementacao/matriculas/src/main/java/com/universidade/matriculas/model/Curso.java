package com.universidade.matriculas.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Curso {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;
	private int totalCreditos;

	@OneToMany
	@JoinColumn(name = "curso_id") // chave estrangeira na disciplina
	private List<Disciplina> disciplinas;

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

	public int getTotalCreditos() {
		return totalCreditos;
	}

	public void setTotalCreditos(int totalCreditos) {
		this.totalCreditos = totalCreditos;
	}

	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}
}