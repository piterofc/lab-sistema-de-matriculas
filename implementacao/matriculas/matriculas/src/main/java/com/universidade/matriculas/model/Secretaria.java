package com.universidade.matriculas.model;

public class Secretaria extends Usuario {

    public Secretaria() {
        super();
    }

    public Secretaria(Long id, String nome, String email, String senha) {
        super(id, nome, email, senha);
    }
    
    public Aluno cadastrarAluno(String nome, String email, String senha) {
        return null;
    }

    public Professor cadastrarProfessor(String nome, String email, String senha) {
        return null;
    }
}