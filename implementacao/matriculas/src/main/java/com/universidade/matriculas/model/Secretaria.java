package com.universidade.matriculas.model;

import jakarta.persistence.Entity;

@Entity
public class Secretaria extends Usuario {

	public int criarCurso(String nome, int totalCreditos) {
		// criação de curso
		System.out.println("Criando curso: " + nome);
		return 1; // retorna o id do curso criado
	}

	public int criarDisciplina(String nome, String ementa, int creditos) {
		// criação de disciplina
		System.out.println("Criando disciplina: " + nome);
		return 1; // retorna o id da disciplina criada
	}

	public void definirCurriculoCurso(int cursoId, int[] disciplinas) {
		// associar disciplinas a um curso
		System.out.println("Definindo currículo para o curso " + cursoId);
	}

	public int criarTurma(int disciplinaId, int semestreId, int professorId) {
		// criação de turma
		System.out.println("Criando turma para a disciplina " + disciplinaId);
		return 1; // retorna o id da turma criada
	}

	public void finalizarPeriodoMatricula() {
		// verificando turmas com menos de 3 alunos etc
		System.out.println("Finalizando período de matrícula.");
	}
}