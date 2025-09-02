package com.universidade.matriculas.model;

public class Curriculo {

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
}