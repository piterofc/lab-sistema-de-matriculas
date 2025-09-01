package com.universidade.matriculas.repository;

import com.universidade.matriculas.model.Curriculo;
import org.springframework.stereotype.Repository;

@Repository
public class CurriculoRepository extends ArquivoRepository<Curriculo> {
	public CurriculoRepository() {
		super("curriculos.dat");
	}
}