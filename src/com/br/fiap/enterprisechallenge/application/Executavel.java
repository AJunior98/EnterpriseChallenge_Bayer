package com.br.fiap.enterprisechallenge.application;

import java.util.List;
import java.util.Scanner;

import com.br.fiap.enterprisechallenge.model.dao.DadosDao;
import com.br.fiap.enterprisechallenge.model.dao.DaoFactory;
import com.br.fiap.enterprisechallenge.model.dao.DoencaDao;
import com.br.fiap.enterprisechallenge.model.dao.PessoaDao;
import com.br.fiap.enterprisechallenge.model.entites.Dados;
import com.br.fiap.enterprisechallenge.model.entites.Doenca;
import com.br.fiap.enterprisechallenge.model.entites.Pessoa;

public class Executavel {
	static DadosDao dadosDao = DaoFactory.createDadosDao();
	static PessoaDao pessoaDao = DaoFactory.createPessoaDao();
	static DoencaDao doencaDao = DaoFactory.createDoencaDao();

	static Scanner sc = new Scanner(System.in);
	
	public static void menuPrincipal() {
		System.out.println("\t ____________________________ ");
		System.out.println("\t|1. Inclui dados             |");
		System.out.println("\t|2. Atualizar dados          |");
		System.out.println("\t|3. Excluir dados            |");
		System.out.println("\t|4. Consultar dados          |");
		System.out.println("\t|5. Fechar programa          |");
		System.out.println("\t|____________________________|");
		System.out.println();
		System.out.print("Digite a opc�o desejada: ");
		System.out.println();
	}
	
	public static void menu1() {
		System.out.println("|-------------------------------------------|");
		System.out.println("| ##--Sistema de Monitoramento - Bayer--##  |");
		System.out.println("|-------------------------------------------|");
		System.out.println("\t ____________________________ ");
		System.out.println("\t|1. Inclui dados             |");
		System.out.println("\t|2. Atualizar dados          |");
		System.out.println("\t|3. Excluir dados            |");
		System.out.println("\t|4. Consultar dados          |");
		System.out.println("\t|5. Fechar programa          |");
		System.out.println("\t|____________________________|");
		System.out.println();
		System.out.print("Digite a opc�o desejada: ");
		System.out.println();
	}

	public static void menu2() {
		System.out.println();
		System.out.println("Qual dado deseja alterar?");
		System.out.println("\t _______________________________ ");
		System.out.println("\t|1. Numero de CPF               |");
		System.out.println("\t|2. Regiao           		      |");
		System.out.println("\t|3. M�s do contagio             |");
		System.out.println("\t|4. Genero                      |");
		System.out.println("\t|5. Idade					      |");
		System.out.println("\t|6. Voltar para o menu anterior |");
		System.out.println("\t|_______________________________|");
		System.out.println();
		System.out.print("Digite a opc�o desejada: ");
	}
	
	public static void menu3() {
		System.out.println();
		System.out.println("O que voc� deseja consultar?");
		System.out.println("\t ________________________________________________ ");
		System.out.println("\t|1. Buscar por CPF                               |");
		System.out.println("\t|2. Quantidade de contagios por regi�o           |");
		System.out.println("\t|3. Quantidade total de casos por doen�a         |");
		System.out.println("\t|4. Quantidade de casos por m�s e tipo de doen�a |");
		System.out.println("\t|5. Voltar para o menu anterior                  |");
		System.out.println("\t|________________________________________________|");
		System.out.println();
		System.out.print("Digite a opc�o desejada: ");
	}
	
	public static void menu4() {
		System.out.println();
		System.out.println("Informe alguns dados abaixo para incluir um usu�rio.");
		System.out.println("Abaixo alguns tipos de doen�as cadastradas, qual deseja incluir?");
		System.out.println("\t _______________________________________ ");
		System.out.println("\t|1. Zika                                |");
		System.out.println("\t|2. Mal�ria                             |");
		System.out.println("\t|3. Dengue                              |");
		System.out.println("\t|4. Outra                               |");
		System.out.println("\t|5. Voltar para o menu anterior         |");
		System.out.println("\t|_______________________________________|");
		System.out.println();
		System.out.print("Digite a opc�o desejada: ");
	}
	
	public static void inclui() {
		
		int opcao;

		do {
			menu4();
			opcao = sc.nextInt();

			switch (opcao) {
			case 1:
				Doenca doenca = new Doenca(1, null);
				System.out.print("Por gentileza, digite o cpf da pessoa que deseja inserir: ");
				String cpf = sc.next();
				System.out.print("Por gentileza, digite o mes que a pessoa foi contagiada:  ");
				String mes = sc.next();
				System.out.print("Por gentileza, digite a regi�o onde esta pessoa se contagiou: ");
				String regiao = sc.next();
				System.out.print("Por gentileza, digite o genero da pessoa contagiada: ");
				String genero = sc.next();
				System.out.print("Por gentileza, digite a idade da pessoa contagiada: ");
				int idade = sc.nextInt();
				Pessoa newPessoa = new Pessoa(null,cpf,mes, regiao, genero, idade, doenca);
				pessoaDao.insert(newPessoa);
				System.out.print("\t-- >Inser��o realizada com sucesso!<--");
				System.out.println();
				break;

			case 2:
				Doenca doenca2 = new Doenca(2, null);
				System.out.print("Por gentileza, digite o cpf da pessoa que deseja inserir: ");
				String cpf2 = sc.next();
				System.out.print("Por gentileza, digite o mes que a pessoa foi contagiada:  ");
				String mes2 = sc.next();
				System.out.print("Por gentileza, digite a regi�o onde esta pessoa se contagiou: ");
				String regiao2 = sc.next();
				System.out.print("Por gentileza, digite o genero da pessoa contagiada: ");
				String genero2 = sc.next();
				System.out.print("Por gentileza, digite a idade da pessoa contagiada: ");
				int idade2 = sc.nextInt();
				Pessoa newPessoa2 = new Pessoa(null,cpf2,mes2, regiao2, genero2, idade2, doenca2);
				pessoaDao.insert(newPessoa2);
				System.out.print("\t-- >Inser��o realizada com sucesso!<--");
				System.out.println();
				break;

			case 3:
				Doenca doenca3 = new Doenca(3, null);
				System.out.print("Por gentileza, digite o cpf da pessoa que deseja inserir: ");
				String cpf3 = sc.next();
				System.out.print("Por gentileza, digite o mes que a pessoa foi contagiada:  ");
				String mes3 = sc.next();
				System.out.print("Por gentileza, digite a regi�o onde esta pessoa se contagiou: ");
				String regiao3 = sc.next();
				System.out.print("Por gentileza, digite o genero da pessoa contagiada: ");
				String genero3 = sc.next();
				System.out.print("Por gentileza, digite a idade da pessoa contagiada: ");
				int idade3 = sc.nextInt();
				Pessoa newPessoa3 = new Pessoa(null,cpf3,mes3, regiao3, genero3, idade3, doenca3);
				pessoaDao.insert(newPessoa3);
				System.out.print("\t-- >Inser��o realizada com sucesso!<--");
				System.out.println();
				break;

			case 4:
				System.out.print("Por gentileza, digite o nome da doen�a que deseja inserir: ");
				String novaDoenca = sc.next();
				Doenca doenca4 = new Doenca(null, novaDoenca);
				doencaDao.insert(doenca4);
				System.out.print("Por gentileza, digite o cpf da pessoa que deseja inserir: ");
				String cpf4 = sc.next();
				System.out.print("Por gentileza, digite o mes que a pessoa foi contagiada:  ");
				String mes4 = sc.next();
				System.out.print("Por gentileza, digite a regi�o onde esta pessoa se contagiou: ");
				String regiao4 = sc.next();
				System.out.print("Por gentileza, digite o genero da pessoa contagiada: ");
				String genero4 = sc.next();
				System.out.print("Por gentileza, digite a idade da pessoa contagiada: ");
				int idade4 = sc.nextInt();
				Pessoa newPessoa4 = new Pessoa(null,cpf4,mes4, regiao4, genero4, idade4, doenca4);
				pessoaDao.insert(newPessoa4);
				System.out.print("\t-- >Inser��o realizada com sucesso!<--");
				System.out.println();
				break;
			case 5: 
				menuMain();
				break;
			default:
				System.out.println("\t-->Op��o inv�lida.<--");
			}
		} while (opcao != 7);
		
	}

	public static void altera() {
		System.out.println("\tVoc� entrou no m�todo de atualiza��o de dados.");
		PessoaDao pessoaDao = DaoFactory.createPessoaDao();
		Pessoa pessoa = new Pessoa(null,null,null,null,null,null,null);
		System.out.print("Digite o cpf que deseja atualizar: ");
		String cpf = sc.next();
		
		int opcao1;
		
		do {
			menu2();
			opcao1 = sc.nextInt();

			switch (opcao1) {
			case 1:
				pessoa = pessoaDao.findByCpf(cpf);
				System.out.print("Digite o novo CPF do usu�rio: ");
				String cpf1 = sc.next();
				pessoa.setCpf(cpf);
				pessoaDao.update(pessoa);
				System.out.println("\t-->Atualiza��o finalizada<--");
				break;

			case 2:
				pessoa = pessoaDao.findByCpf(cpf);
				System.out.print("Digite a nova regi�o do usu�rio: ");
				String regiao = sc.next();
				pessoa.setRegiao(regiao);
				pessoaDao.update(pessoa);
				System.out.println("\t-->Atualiza��o finalizada<--");
				break;

			case 3:
				pessoa = pessoaDao.findByCpf(cpf);
				System.out.print("Digite o novo m�s de contagio do usu�rio: ");
				String mesContagio = sc.next();
				pessoa.setMes(mesContagio);
				pessoaDao.update(pessoa);
				System.out.println("\t-->Atualiza��o finalizada<--");
				break;

			case 4:
				pessoa = pessoaDao.findByCpf(cpf);
				System.out.print("Digite o novo genero do usu�rio: ");
				String genero = sc.next();
				pessoa.setGenero(genero);
				pessoaDao.update(pessoa);
				System.out.println("\t-->Atualiza��o finalizada<--");
				break;
			case 5: 
				pessoa = pessoaDao.findByCpf(cpf);
				System.out.print("Digite a nova idade do usu�rio: ");
				int idade = sc.nextInt();
				pessoa.setIdade(idade);
				pessoaDao.update(pessoa);
				System.out.println("\t-->Atualiza��o finalizada<--");
				break;
			case 6:
				menuMain();
				break;
			default:
				System.out.println("Op��o inv�lida.");
			}
		} while (opcao1 != 5);
	}
			
	public static void exclui() {
		System.out.println("|-------------------------------------------| ");
		System.out.println("|Voc� entrou no m�todo de exclus�o de dados.|");
		System.out.println("|-------------------------------------------| ");
		Scanner sc = new Scanner(System.in);
		System.out.print("Digite o cpf que deseja excluir: ");
		System.out.println();
		String cpf = sc.next();
		pessoaDao.deleteByCpf(cpf);
	}

	public static void consulta() {
		int opcao;

		do {
			menu3();
			opcao = sc.nextInt();

			switch (opcao) {
			case 1:
				System.out.println("|-------------------------------------------------------| ");
				System.out.println("|\tVoc� entrou no m�todo de consulta individual         |");
				System.out.println("|-------------------------------------------------------| ");
				System.out.println();
				System.out.print("-->Digite o cpf que deseja procurar: ");
				String cpf = sc.next();
				System.out.println();
				Pessoa pessoa = pessoaDao.findByCpf(cpf);
				if (pessoa != null) {
					System.out.println(pessoa);
				}
				break;
			case 2:
				System.out.println("|-----------------------------------------------------------| ");
				System.out.println("|\tVoc� entrou no m�todo de consulta por regi�o        |");
				System.out.println("|-----------------------------------------------------------| ");
				System.out.println();
				System.out.print("-->Digite a regi�o que voc� deseja consultar: ");
				System.out.println();
				String regiao = sc.next();
				List<Dados> dado = dadosDao.findByRegiao(regiao);
				System.out.println();
				System.out.println("Na regi�o " + regiao);
				for(Dados obj : dado) {
					System.out.println("A doen�a " + obj.getNomeDoenca() + " tem " + obj.getQuantidade() + " casos representando " + obj.getPorcentagem()*100 + "%");
				}
				break;

			case 3:
				System.out.println("|------------------------------------------------| ");
				System.out.println("|\tVoc� entrou no m�todo consulta total.    |");
				System.out.println("|------------------------------------------------| ");
				System.out.println();
				List<Dados> insight2 = dadosDao.findTotal();
				Dados qtd = dadosDao.findAll();
				System.out.println();
				System.out.println("A quantidade de contagios no primeiro trimestre do ano foi de " + qtd.getQuantidade() + ".");
				for(Dados obj : insight2) {
					System.out.println("A doen�a " + obj.getNomeDoenca() + " tem " + obj.getQuantidade() + " casos representando " + obj.getPorcentagem()*100 + "%.");
				}
				break;

			case 4:
				System.out.println("|------------------------------------------------| ");
				System.out.println("|\tVoc� entrou no m�todo consulta por m�s.  |");
				System.out.println("|------------------------------------------------| ");
				System.out.println();
				System.out.print("-->Digite o m�s que voc� deseja consultar: ");
				System.out.println();
				String mes = sc.next();
				System.out.println();
				List<Dados> list = dadosDao.findByMonth(mes);
				System.out.println("No m�s de " + mes);
				for(Dados obj : list) {
					System.out.println("A doen�a " + obj.getNomeDoenca() + " tem " + obj.getQuantidade() + " casos representando " + obj.getPorcentagem()*100 + "%");
				}
				break;
			case 5: 
				menuMain();
				break;

			default:
				System.out.println("Op��o inv�lida.");
			}
		} while (opcao != 6);
	}

	public static void menuMain() {
		int opcao;

		do {
			menuPrincipal();
			opcao = sc.nextInt();

			switch (opcao) {
			case 1:
				inclui();
				break;

			case 2:
				altera();
				break;

			case 3:
				exclui();
				break;

			case 4:
				consulta();
				break;
			case 5: 
				sc.close();
				System.out.println("Obrigado por utilizar nosso monitorador, o sistema ser� finalizado!");
				System.exit(0);
				break;

			default:
				System.out.println("Op��o inv�lida.");
			}
		} while (opcao != 6);
	}
	
	
	public static void main(String[] args) {

		int opcao;

		do {
			menu1();
			opcao = sc.nextInt();

			switch (opcao) {
			case 1:
				inclui();
				break;

			case 2:
				altera();
				break;

			case 3:
				exclui();
				break;

			case 4:
				consulta();
				break;
			case 5: 
				sc.close();
				System.out.println("Obrigado por utilizar nosso monitorador, o sistema ser� finalizado!");
				break;

			default:
				System.out.println("Op��o inv�lida.");
			}
		} while (opcao != 6);
	}
}
		
