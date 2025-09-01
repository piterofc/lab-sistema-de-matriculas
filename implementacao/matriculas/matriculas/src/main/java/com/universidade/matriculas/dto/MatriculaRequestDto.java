package com.universidade.matriculas.dto;

import java.util.List;

public class MatriculaRequestDto {
	private Long alunoId;
	private List<Long> idsDisciplinasObrigatorias;
	private List<Long> idsDisciplinasOptativas;

	// getters e setters
	public Long getAlunoId() {
		return alunoId;
	}

	public void setAlunoId(Long alunoId) {
		this.alunoId = alunoId;
	}

	public List<Long> getIdsDisciplinasObrigatorias() {
		return idsDisciplinasObrigatorias;
	}

	public void setIdsDisciplinasObrigatorias(List<Long> idsDisciplinasObrigatorias) {
		this.idsDisciplinasObrigatorias = idsDisciplinasObrigatorias;
	}

	public List<Long> getIdsDisciplinasOptativas() {
		return idsDisciplinasOptativas;
	}

	public void setIdsDisciplinasOptativas(List<Long> idsDisciplinasOptativas) {
		this.idsDisciplinasOptativas = idsDisciplinasOptativas;
	}
}