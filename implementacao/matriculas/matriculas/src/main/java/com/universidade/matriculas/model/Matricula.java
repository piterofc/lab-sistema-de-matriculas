package com.universidade.matriculas.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Matricula {

    private Long id;
    private LocalDate periodoMatricula;
    private Aluno aluno;
    private List<Disciplina> disciplinasObrigatorias = new ArrayList<>();
    private List<Disciplina> disciplinasOptativas = new ArrayList<>();

    public Matricula() {
    }

    public Matricula(Long id, LocalDate periodoMatricula, Aluno aluno) {
        this.id = id;
        this.periodoMatricula = periodoMatricula;
        this.aluno = aluno;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getPeriodoMatricula() {
        return periodoMatricula;
    }

    public void setPeriodoMatricula(LocalDate periodoMatricula) {
        this.periodoMatricula = periodoMatricula;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public List<Disciplina> getDisciplinasObrigatorias() {
        return disciplinasObrigatorias;
    }

    public void setDisciplinasObrigatorias(List<Disciplina> disciplinasObrigatorias) {
        this.disciplinasObrigatorias = disciplinasObrigatorias;
    }

    public List<Disciplina> getDisciplinasOptativas() {
        return disciplinasOptativas;
    }

    public void setDisciplinasOptativas(List<Disciplina> disciplinasOptativas) {
        this.disciplinasOptativas = disciplinasOptativas;
    }
}