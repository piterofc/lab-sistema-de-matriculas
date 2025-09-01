package com.universidade.matriculas.repository;

import com.universidade.matriculas.model.Entidade;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

// classe base generica para persistencia de dados em arquivos
public abstract class ArquivoRepository<T extends Entidade> {

	private final String NOME_ARQUIVO;
	private final Map<Long, T> cache = new ConcurrentHashMap<>();
	private final AtomicLong sequence;

	public ArquivoRepository(String nomeArquivo) {
		this.NOME_ARQUIVO = nomeArquivo;
		carregarDoArquivo();
		long maxId = cache.keySet().stream().max(Long::compare).orElse(0L);
		this.sequence = new AtomicLong(maxId);
	}

	// salva ou atualiza uma entidade. se o id for nulo, gera um novo id
	public T salvar(T entidade) {
		if (entidade.getId() == null) {
			entidade.setId(sequence.incrementAndGet());
		}
		cache.put(entidade.getId(), entidade);
		salvarNoArquivo();
		return entidade;
	}

	// busca uma entidade pelo seu id
	public Optional<T> buscarPorId(Long id) {
		return Optional.ofNullable(cache.get(id));
	}

	// retorna todas as entidades
	public List<T> listarTodos() {
		return new ArrayList<>(cache.values());
	}

	// deleta uma entidade pelo seu id
	public void deletarPorId(Long id) {
		cache.remove(id);
		salvarNoArquivo();
	}

	// carrega os dados do arquivo para o cache em memoria
	@SuppressWarnings("unchecked")
	private void carregarDoArquivo() {
		File file = new File(NOME_ARQUIVO);
		if (!file.exists()) {
			return;
		}
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
			Map<Long, T> dados = (Map<Long, T>) ois.readObject();
			cache.putAll(dados);
		} catch (IOException | ClassNotFoundException e) {
			System.err.println("Erro ao carregar dados do arquivo: " + NOME_ARQUIVO);
			e.printStackTrace();
		}
	}

	// salva o cache em memoria para o arquivo
	private synchronized void salvarNoArquivo() {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(NOME_ARQUIVO))) {
			oos.writeObject(cache);
		} catch (IOException e) {
			System.err.println("Erro ao salvar dados no arquivo: " + NOME_ARQUIVO);
			e.printStackTrace();
		}
	}
}