package com.universidade.matriculas.model;

import java.util.ArrayList;
import java.util.List;

public class Curso {

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

    public void adicionarDisciplina(Disciplina disciplina) {
    }
}