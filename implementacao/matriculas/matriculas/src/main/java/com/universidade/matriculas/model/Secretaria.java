package com.universidade.matriculas.model;

import java.io.Serializable;

public class Secretaria extends Usuario implements Serializable, Entidade {

	private static final long serialVersionUID = 1L;

	public Secretaria() {
		super();
	}

	public Secretaria(Long id, String nome, String email, String senha) {
		super(id, nome, email, senha);
	}
}