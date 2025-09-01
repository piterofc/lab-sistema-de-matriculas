package com.universidade.matriculas.model;

// interface que garante que toda classe de modelo tera um getter e um setter para o id
public interface Entidade {
	Long getId();

	void setId(Long id);
}