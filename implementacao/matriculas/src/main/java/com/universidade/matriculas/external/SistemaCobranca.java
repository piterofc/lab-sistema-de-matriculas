package com.universidade.matriculas.external;

import com.universidade.matriculas.model.Aluno;

public interface SistemaCobranca {
	void notificarAluno(Aluno aluno, float valor);
}