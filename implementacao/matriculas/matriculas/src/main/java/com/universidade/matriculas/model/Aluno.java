package com.universidade.matriculas.model;

public class Aluno extends Usuario {

    private Curso curso;
    private Matricula matricula;

    public Aluno() {
        super();
    }

    public Aluno(Long id, String nome, String email, String senha, Curso curso) {
        super(id, nome, email, senha);
        this.curso = curso;
    }

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
}