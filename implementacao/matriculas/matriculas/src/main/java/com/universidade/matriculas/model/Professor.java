package com.universidade.matriculas.model;

import java.util.ArrayList;
import java.util.List;

public class Professor extends Usuario {

    private List<Disciplina> disciplinas = new ArrayList<>();

    public Professor() {
        super();
    }

    public Professor(Long id, String nome, String email, String senha) {
        super(id, nome, email, senha);
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