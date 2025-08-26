# Nome do projeto
Sistema de Matrículas.

## Integrantes
* Henrique Lima Volponi
* João Vitor Ferreira Jacinto
* Pedro Henrique Novais Baranda

## Orientadores
* João Pedro Oliveira Batisteli

## Instruções de utilização
Assim que a primeira versão do sistema estiver disponível, deverá complementar com as instruções de utilização. Descreva como instalar eventuais dependências e como executar a aplicação.

---

# Histórias de Usuário

### Épico 1: Gestão Acadêmica (Funcionalidades da Secretaria)

Este épico cobre todas as tarefas de configuração e gerenciamento do sistema, realizadas pela secretaria da universidade.

**US01: Gerenciar Cursos**

* **Como um** usuário da Secretaria,  
* **Eu quero** poder criar, visualizar, editar e remover cursos no sistema,  
* **Para que** a oferta acadêmica da universidade esteja sempre atualizada.

**US02: Gerenciar Disciplinas**

* **Como um** usuário da Secretaria,  
* **Eu quero** cadastrar, editar e associar disciplinas a um curso,  
* **Para que** os alunos saibam quais disciplinas compõem seu curso.

**US03: Gerenciar Usuários**

* **Como um** usuário da Secretaria,  
* **Eu quero** cadastrar e gerenciar os usuários (Alunos e Professores), definindo seus perfis de acesso,  
* **Para que** eles possam acessar o sistema com as permissões corretas.

**US04: Definir Período de Matrícula**

* **Como um** usuário da Secretaria,  
* **Eu quero** definir as datas de início e fim do período de matrículas,  
* **Para que** os alunos só possam realizar matrículas dentro da janela de tempo permitida.

### Épico 2: Processo de Matrícula (Funcionalidades do Aluno)

Este épico descreve a jornada do aluno ao interagir com o sistema.

**US05: Realizar Login no Sistema**

* **Como um** usuário (Aluno, Professor ou Secretaria),  
* **Eu quero** fazer login no sistema usando meu usuário e senha,  
* **Para que** eu possa acessar as funcionalidades correspondentes ao meu perfil.

**US06: Visualizar Disciplinas Disponíveis**

* **Como um** Aluno,  
* **Eu quero** visualizar a lista de disciplinas oferecidas para o meu curso no próximo semestre, com informações relevantes,  
* **Para que** eu possa decidir em quais me matricular.

**US07: Realizar Matrícula em Disciplinas**

* **Como um** Aluno,  
* **Eu quero** selecionar e confirmar minha matrícula nas disciplinas desejadas,  
* **Para que** eu possa garantir minha vaga e cursar o próximo semestre.

**US08: Cancelar Matrícula em uma Disciplina**

* **Como um** Aluno,  
* **Eu quero** poder cancelar a matrícula em uma ou mais disciplinas,  
* **Para que** eu possa ajustar minha grade horária antes do fim do período.

### Épico 3: Consulta (Funcionalidades do Professor)

Este épico foca na necessidade do professor de visualizar informações.

**US09: Consultar Alunos Matriculados**

* **Como um** Professor,  
* **Eu quero** visualizar a lista de todos os alunos matriculados em cada uma das minhas disciplinas,  
* **Para que** eu possa ter o controle da minha turma e fazer a chamada.

### Épico 4: Processos Automáticos e Integrações (Sistema)

Este épico descreve ações realizadas pelo próprio sistema, geralmente de forma automática.

**US10: Cancelar Disciplinas sem Quórum Mínimo**

* **Como** o Sistema,  
* **Eu quero** verificar, ao final do período de matrículas, todas as disciplinas que não atingiram o mínimo de 3 alunos e cancelá-las automaticamente,  
* **Para que** a universidade não tenha custos com turmas inviáveis.

**US11: Notificar Sistema de Cobranças**

* **Como** o Sistema,  
* **Eu quero** enviar os dados consolidados das matrículas de cada aluno para o sistema de cobranças,  
* **Para que** o processo de faturamento do semestre possa ser iniciado.

---

# Diagrama de Casos de Uso

<img width="500" alt="Diagrama de casos de uso" src="https://github.com/user-attachments/assets/fee54959-25e1-48ac-a0eb-ea4ab374a305" />

---

# Diagrama de Classes

<img width="500" alt="Diagram sistema de matricula" src="https://github.com/user-attachments/assets/25b4ec14-344d-4a9c-bf2f-75ffde39e260" />

