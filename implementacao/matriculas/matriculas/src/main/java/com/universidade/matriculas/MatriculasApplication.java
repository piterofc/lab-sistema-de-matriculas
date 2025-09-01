package com.universidade.matriculas;

import com.universidade.matriculas.dto.MatriculaRequestDto;
import com.universidade.matriculas.exception.RecursoNaoEncontradoException;
import com.universidade.matriculas.exception.RegraDeNegocioException;
import com.universidade.matriculas.model.*;
import com.universidade.matriculas.repository.*;
import com.universidade.matriculas.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

@SpringBootApplication
public class MatriculasApplication implements CommandLineRunner { 
	
	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private AlunoService alunoService;
	@Autowired
	private ProfessorService professorService;
	@Autowired
	private SecretariaService secretariaService;
	@Autowired
	private MatriculaService matriculaService;
	@Autowired
	private SecretariaRepository secretariaRepository;
	@Autowired
	private CursoRepository cursoRepository;
	@Autowired
	private DisciplinaRepository disciplinaRepository;

	private final Scanner scanner = new Scanner(System.in);
	private Usuario usuarioLogado = null;

	public static void main(String[] args) {
		SpringApplication.run(MatriculasApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("=== Bem-vindo ao Sistema de Matrículas da Universidade (Spring Boot) ===");
		inicializarDados();

		while (true) {
			try {
				if (usuarioLogado == null) {
					menuLogin();
				} else if (usuarioLogado instanceof Aluno) {
					menuAluno();
				} else if (usuarioLogado instanceof Secretaria) {
					menuSecretaria();
				} else if (usuarioLogado instanceof Professor) {
					menuProfessor();
				}
			} catch (RegraDeNegocioException | RecursoNaoEncontradoException e) {
				System.err.println("\n[ERRO] " + e.getMessage());
			} catch (NumberFormatException e) {
				System.err.println("\n[ERRO] Entrada inválida. Por favor, digite um número.");
			} catch (Exception e) {
				System.err.println("\n[ERRO INESPERADO] Ocorreu um problema: " + e.getMessage());
			}
		}
	}

	private void menuLogin() {
		System.out.println("\n--- MENU DE ACESSO ---");
		System.out.println("[1] Fazer Login");
		System.out.println("[2] Sair do Sistema");
		System.out.print("Escolha uma opção: ");
		String opcao = scanner.nextLine();

		if ("1".equals(opcao)) {
			System.out.print("Email: ");
			String email = scanner.nextLine();
			System.out.print("Senha: ");
			String senha = scanner.nextLine();
			usuarioLogado = usuarioService.login(email, senha);

			if (usuarioLogado != null) {
				System.out.println("\nLogin bem-sucedido! Bem-vindo(a), " + usuarioLogado.getNome());
			} else {
				System.out.println("Email ou senha inválidos.");
			}
		} else if ("2".equals(opcao)) {
			System.out.println("Até logo!");
			System.exit(0);
		} else {
			System.out.println("Opção inválida.");
		}
	}

	private void menuSecretaria() {
		System.out.println("\n--- MENU SECRETARIA ---");
		System.out.println("[1] Cadastrar Novo Aluno");
		System.out.println("[2] Cadastrar Novo Professor");
		System.out.println("[3] Cadastrar Novo Curso");
		System.out.println("[4] Cadastrar Nova Disciplina");
		System.out.println("[5] Listar Cursos");
		System.out.println("[6] Finalizar Período de Matrícula");
		System.out.println("[9] Logout");
		System.out.print("Escolha uma opção: ");
		String opcao = scanner.nextLine();

		switch (opcao) {
		case "1":
			System.out.print("Nome do aluno: ");
			String nomeAluno = scanner.nextLine();
			System.out.print("Email do aluno: ");
			String emailAluno = scanner.nextLine();
			System.out.print("Senha do aluno: ");
			String senhaAluno = scanner.nextLine();
			Aluno novoAluno = secretariaService.cadastrarAluno(nomeAluno, emailAluno, senhaAluno);
			System.out.println("Aluno " + novoAluno.getNome() + " cadastrado com sucesso!");
			break;
		case "2":
			System.out.print("Nome do professor: ");
			String nomeProf = scanner.nextLine();
			System.out.print("Email do professor: ");
			String emailProf = scanner.nextLine();
			System.out.print("Senha do professor: ");
			String senhaProf = scanner.nextLine();
			Professor novoProfessor = secretariaService.cadastrarProfessor(nomeProf, emailProf, senhaProf);
			System.out.println("Professor " + novoProfessor.getNome() + " cadastrado com sucesso!");
			break;
		case "3":
			System.out.print("Nome do curso: ");
			String nomeCurso = scanner.nextLine();
			System.out.print("Duração em semestres: ");
			int duracao = Integer.parseInt(scanner.nextLine());
			Curso novoCurso = secretariaService.cadastrarCurso(nomeCurso, duracao);
			System.out.println("Curso " + novoCurso.getNome() + " cadastrado com sucesso!");
			break;
		case "4":
			System.out.print("Nome da disciplina: ");
			String nomeDis = scanner.nextLine();
			System.out.print("Créditos: ");
			int creditos = Integer.parseInt(scanner.nextLine());
			System.out.print("Tipo (OBRIGATORIA/OPTATIVA): ");
			TipoDisciplina tipo = TipoDisciplina.valueOf(scanner.nextLine().toUpperCase());
			System.out.print("ID do Curso: ");
			Long cursoId = Long.parseLong(scanner.nextLine());
			Disciplina novaDisciplina = secretariaService.cadastrarDisciplina(nomeDis, creditos, tipo, cursoId);
			System.out.println("Disciplina " + novaDisciplina.getNome() + " cadastrada com sucesso!");
			break;
		case "5":
			System.out.println("\n--- Cursos Cadastrados ---");
			cursoRepository.listarTodos()
					.forEach(c -> System.out.println("ID: " + c.getId() + ", Nome: " + c.getNome()));
			break;
		case "6":
			secretariaService.finalizarPeriodoMatricula();
			break;
		case "9":
			logout();
			break;
		default:
			System.out.println("Opção inválida.");
		}
	}

	private void menuAluno() {
		System.out.println("\n--- MENU ALUNO ---");
		System.out.println("[1] Realizar Matrícula");
		System.out.println("[2] Consultar Minha Matrícula");
		System.out.println("[3] Consultar Disciplinas Disponíveis");
		System.out.println("[4] Cancelar Matrícula");
		System.out.println("[9] Logout");
		System.out.print("Escolha uma opção: ");
		String opcao = scanner.nextLine();

		switch (opcao) {
		case "1":
			System.out.println("\n--- Realizar Matrícula ---");
			System.out.print("IDs das disciplinas OBRIGATÓRIAS (separados por vírgula): ");
			List<Long> idsObrigatorias = parseIds(scanner.nextLine());
			System.out.print("IDs das disciplinas OPTATIVAS (separados por vírgula): ");
			List<Long> idsOptativas = parseIds(scanner.nextLine());

			MatriculaRequestDto dto = new MatriculaRequestDto();
			dto.setAlunoId(usuarioLogado.getId());
			dto.setIdsDisciplinasObrigatorias(idsObrigatorias);
			dto.setIdsDisciplinasOptativas(idsOptativas);

			matriculaService.realizarMatricula(dto);
			System.out.println("Matrícula realizada com sucesso!");
			break;
		case "2":
			System.out.println("\n--- Minha Matrícula ---");
			Matricula m = alunoService.consultarMinhaMatricula(usuarioLogado.getId());
			System.out.println("Aluno: " + m.getAluno().getNome());
			System.out.println("Período: " + m.getPeriodoMatricula());
			System.out.println("Obrigatórias: " + m.getDisciplinasObrigatorias().stream().map(Disciplina::getNome)
					.collect(Collectors.joining(", ")));
			System.out.println("Optativas: "
					+ m.getDisciplinasOptativas().stream().map(Disciplina::getNome).collect(Collectors.joining(", ")));
			break;
		case "3":
			System.out.println("\n--- Disciplinas Disponíveis ---");
			alunoService.consultarDisciplinasDisponiveis().forEach(d -> System.out.println("ID: " + d.getId()
					+ ", Nome: " + d.getNome() + ", Créditos: " + d.getCreditos() + ", Status: " + d.getStatus()));
			break;
		case "4":
			matriculaService.cancelarMatricula(usuarioLogado.getId());
			break;
		case "9":
			logout();
			break;
		default:
			System.out.println("Opção inválida.");
		}
	}

	private void menuProfessor() {
		System.out.println("\n--- MENU PROFESSOR ---");
		System.out.println("[1] Consultar Alunos por Disciplina");
		System.out.println("[9] Logout");
		System.out.print("Escolha uma opção: ");
		String opcao = scanner.nextLine();

		if ("1".equals(opcao)) {
			System.out.print("ID da disciplina para consulta: ");
			Long disciplinaId = Long.parseLong(scanner.nextLine());
			List<Aluno> alunos = professorService.listarAlunosPorDisciplina(usuarioLogado.getId(), disciplinaId);
			System.out.println(
					"\n--- Alunos em " + disciplinaRepository.buscarPorId(disciplinaId).get().getNome() + " ---");
			alunos.forEach(a -> System.out.println("ID: " + a.getId() + ", Nome: " + a.getNome()));
		} else if ("9".equals(opcao)) {
			logout();
		} else {
			System.out.println("Opção inválida.");
		}
	}

	private void logout() {
		System.out.println("\n" + usuarioLogado.getNome() + " deslogado com sucesso.");
		usuarioLogado = null;
	}

	private void inicializarDados() {
		if (secretariaRepository.listarTodos().isEmpty()) {
			System.out.println("Primeira execução: criando dados iniciais...");
			Secretaria admin = new Secretaria(null, "Admin", "admin@uni.com", "123");
			secretariaRepository.salvar(admin);
			Curso cco = secretariaService.cadastrarCurso("Ciência da Computação", 8);
			Curso eng = secretariaService.cadastrarCurso("Engenharia de Software", 10);
			secretariaService.cadastrarDisciplina("Cálculo I", 4, TipoDisciplina.OBRIGATORIA, cco.getId());
			secretariaService.cadastrarDisciplina("Algoritmos", 4, TipoDisciplina.OBRIGATORIA, cco.getId());
			secretariaService.cadastrarDisciplina("Qualidade de Software", 4, TipoDisciplina.OPTATIVA, eng.getId());
			secretariaService.cadastrarProfessor("Dr. Alan Turing", "turing@uni.com", "abc");
			secretariaService.cadastrarAluno("Ada Lovelace", "ada@uni.com", "abc");
			System.out.println("Dados iniciais criados.");
		}
	}

	private List<Long> parseIds(String idsString) {
		if (idsString == null || idsString.trim().isEmpty()) {
			return List.of();
		}
		return Arrays.stream(idsString.split(",")).map(s -> Long.parseLong(s.trim())).collect(Collectors.toList());
	}
}