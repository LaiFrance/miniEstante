package miniEstante;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import miniEstante.controller.ClienteController;
import miniEstante.controller.EmprestimoController;
import miniEstante.controller.LivroController;
import miniEstante.model.Cliente;
import miniEstante.model.Emprestimo;
import miniEstante.model.Livro;

public class Menu {

	public static void main(String[] args) {

		ClienteController clientes = new ClienteController();

		LivroController livros = new LivroController();

		EmprestimoController emprestimos = new EmprestimoController();


		Livro l1 = new Livro(livros.gerarIdLivro(), "Codar, Rezar, Rodar", "FITZGERALD, Anna", 2020, 2);
		livros.cadastrar(l1);

		Livro l2 = new Livro(livros.gerarIdLivro(), "Desvendando as Collections", "LINS, Armando", 2018, 2);
		livros.cadastrar(l2);

		Livro l3 = new Livro(livros.gerarIdLivro(), "Matrizes: O que realmente são?", "ARAÚJO, Fernanda", 2019, 2);
		livros.cadastrar(l3);

		Livro l4 = new Livro(livros.gerarIdLivro(), "Como usar o Git Bash", "MENDES, Pedro", 2021, 2);
		livros.cadastrar(l4);

		Livro l5 = new Livro(livros.gerarIdLivro(), "Revelando a Linguagem Por Trás do Seu Aplicativo", "NEVES, Bruna",
				2020, 2);
		livros.cadastrar(l5);

		String titulo;

		String autor;

		int idLivro = 0;

		int ano, att = 0;

		int alugado;

		Scanner leia = new Scanner(System.in);

		Cliente c1 = new Cliente("Danilo Moraes", "Avenida Lírio Branco", "(11)999999999", clientes.gerarIdCliente());
		clientes.cadastrar(c1);

		Cliente c2 = new Cliente("Gabriel Farias", "Alameda Manoel Lopes", "(11)999999999", clientes.gerarIdCliente());
		clientes.cadastrar(c2);

		Cliente c3 = new Cliente("Gustavo Santiago", "Avenida Rio Amarelo", "(11)999999999", clientes.gerarIdCliente());
		clientes.cadastrar(c3);

		Cliente c4 = new Cliente("Laise Farias", "Avenida Castro Gomes", "(11)999999999", clientes.gerarIdCliente());
		clientes.cadastrar(c4);

		Cliente c5 = new Cliente("Lucas Marinho", "Alameda João Silva", "(11)999999999", clientes.gerarIdCliente());
		clientes.cadastrar(c5);

		Cliente c6 = new Cliente("Rebeca Damas", "Rua Lago do Sul", "(11)999999999", clientes.gerarIdCliente());
		clientes.cadastrar(c6);

		Cliente c7 = new Cliente("Thayane Almeida", "Rua Pedro Afonso", "(11)999999999", clientes.gerarIdCliente());
		clientes.cadastrar(c7);

		int opcao = 0;
		String nome, endereco, telefone;


		int idEmprestimo;


		int idCliente;
		String dataAluguel, dataDevolucao;

		while (true) {
			System.out.println("==================================================");
			System.out.println("                                                  ");
			System.out.println("========== 📚 Bem-vinde a Mini Estante 📚 ========");
			System.out.println("                                                  ");
			System.out.println("==================================================");
			System.out.println("\t1- Cadastrar Cliente");
			System.out.println("\t2- Listar Clientes");
			System.out.println("\t3- Atualizar Cadastro");
			System.out.println("\t4- Excluir Cadastro");
			System.out.println("\t5- Cadastrar Livro");
			System.out.println("\t6- Listar Livros");
			System.out.println("\t7- Atualizar Livro");
			System.out.println("\t8- Excluir Livro");
			System.out.println("\t9- Alugar Livro");
			System.out.println("\t10- Listar Livros Alugados");
			System.out.println("\t11- Renovar Empréstimo");
			System.out.println("\t12- Registrar Devolução");
			System.out.println("\t0- Sair");
			System.out.println("==================================================");
			System.out.println("Digite a opção desejada: ");

			opcao = leia.nextInt();
			leia.nextLine();

			if (opcao == 0) {
				System.out.println("Obrigade por ter visitado a Mini Estante! Nos vemos logo...");
				leia.close();
				System.exit(0);
			}

			switch (opcao) {
			case 1 -> {

				System.out.println("Cadastrar Cliente");

				do {
					System.out.println("Digitar o Nome do Cliente: ");
					leia.skip("\\R?");
					nome = leia.nextLine();

					if (nome.isEmpty())
						System.out.println("Não pode estar vazio!");

				} while (nome.isEmpty());

				do {
					System.out.println("Digitar o Endereço do Cliente: ");
					leia.skip("\\R?");
					endereco = leia.nextLine();

					if (endereco.isEmpty())
						System.out.println("Não pode estar vazio!");

				} while (endereco.isEmpty());

				do {
					System.out.println("Digitar o Telefone do Cliente: ");
					leia.skip("\\R?");
					telefone = leia.nextLine();

					if (telefone.isEmpty())
						System.out.println("Não pode estar vazio!");

				} while (telefone.isEmpty());

				clientes.cadastrar(new Cliente(nome, endereco, telefone, clientes.gerarIdCliente()));

				keyPress();
			}
			case 2 -> {
				System.out.println("Listar Clientes");
				clientes.listarClientes();
				keyPress();
			}
			case 3 -> {
				System.out.println("Atualizar Cadastro");

				System.out.println("Id Cliente: ");
				idCliente = leia.nextInt();

				if (clientes.buscarClienteCollection(idCliente) != null) {

					do {
						System.out.println("Nome do Cliente: ");
						leia.skip("\\R?");
						nome = leia.nextLine();

						if (nome.isEmpty())
							System.out.println("Não pode estar vazio!");

					} while (nome.isEmpty());

					do {
						System.out.println("Endereço: ");
						leia.skip("\\R?");
						endereco = leia.nextLine();

						if (endereco.isEmpty())
							System.out.println("Não pode estar vazio!");

					} while (endereco.isEmpty());

					do {
						System.out.println("Número de Telefone:");
						leia.skip("\\R?");
						telefone = leia.nextLine();

						if (telefone.isEmpty())
							System.out.println("Não pode estar vazio!");

					} while (telefone.isEmpty());

					clientes.atualizar(new Cliente(nome, endereco, telefone, idCliente));

				} else
					System.out.println("O cliente não foi encontrado!");
				keyPress();
			}
			case 4 -> {
				System.out.println("Excluir Cadastro");

				System.out.println("IdCliente: ");
				idCliente = leia.nextInt();

				clientes.deletarCliente(idCliente);

				keyPress();
			}
			case 5 -> {
				System.out.println("Cadastrar Livro");

				do {
					System.out.println("Digite o Titulo do livro: ");
					leia.skip("\\R?");
					titulo = leia.nextLine();

					if (titulo.isEmpty())
						System.out.println("Não pode estar vazio!");

				} while (titulo.isEmpty());

				do {
					System.out.println("Digite o Autor: ");
					leia.skip("\\R?");
					autor = leia.nextLine();

					if (autor.isEmpty())
						System.out.println("Não pode estar vazio!");

				} while (autor.isEmpty());

				System.out.println("Digite o Ano: ");
				ano = leia.nextInt();

				System.out.println("Digite a Disponibilidade(1- Alugado/ 2- Disponível): ");
				alugado = leia.nextInt();

				livros.cadastrar(new Livro(livros.gerarIdLivro(), titulo, autor, ano, alugado));

				keyPress();
			}
			case 6 -> {
				System.out.println("Listar Livros");
				livros.listarLivro();
				keyPress();
			}
			case 7 -> {
				System.out.println("Atualizar Livro");

				System.out.println("Digite o Id do Livro: ");
				idLivro = leia.nextInt();
				if (livros.buscarLivroNaCollectio(idLivro) != null) {

					do {
						System.out.println("Digite o Titulo: ");
						leia.skip("\\R?");
						titulo = leia.nextLine();

						if (titulo.isEmpty())
							System.out.println("Não pode estar vazio!");

					} while (titulo.isBlank());

					do {
						System.out.println("Digite o Autor: ");
						autor = leia.nextLine();

						if (autor.isEmpty())
							System.out.println("Não pode estar vazio!");

					} while (autor.isEmpty());

					System.out.println("Digite o Ano: ");
					ano = leia.nextInt();

					System.out.println("Digite a Disponibilidade (1- Alugado/ 2- Disponível): ");
					att = leia.nextInt();

					livros.atualizar(new Livro(idLivro, titulo, autor, ano, att));
				}
				keyPress();
			}
			case 8 -> {
				System.out.println("Excluir Livro");
				System.out.println("Digite o Id do Livro: ");
				idLivro = leia.nextInt();
				livros.deletarLivro(idLivro);
				keyPress();
			}
			case 9 -> {
				System.out.println("Alugar Livro");

				System.out.println("Insira o Id do Cliente");
				idCliente = leia.nextInt();
				System.out.println("Insira o Id do Livro");
				idLivro = leia.nextInt();

				do {
					System.out.println("A data de Aluguel: ");
					leia.skip("\\R?");
					dataAluguel = leia.nextLine();

					if (dataAluguel.isEmpty())
						System.out.println("Não pode estar vazio!");

				} while (dataAluguel.isEmpty());

				do {
					System.out.println("A data de Devolução: ");
					leia.skip("\\R?");
					dataDevolucao = leia.nextLine();

					if (dataDevolucao.isEmpty())
						System.out.println("Não pode estar vazio!");

				} while (dataDevolucao.isEmpty());

				Emprestimo e1 = new Emprestimo(idCliente, idLivro, dataAluguel, dataDevolucao, emprestimos.gerarIdEmprestimo());


				if (clientes.buscarClienteCollection(idCliente) != null
						&& livros.buscarLivroNaCollectio(idLivro) != null) {
					emprestimos.registrarEmprestimo(e1);

				} else {
					System.out.println("ID's  não encontrados");
				}

				keyPress();
			}
			case 10 -> {
				System.out.println("\nListar Livros Alugados");
				System.out.println("=======================");

				emprestimos.listarLivrosAlugados();
				keyPress();
			}
			case 11 -> {
				System.out.println("Renovar empréstimo");
				System.out.println("Digite o id do Empréstimo: ");
				idEmprestimo = leia.nextInt();
				System.out.println("A data de Devolução: ");
				leia.skip("\\R?");
				dataDevolucao = leia.nextLine();	
					
		     	emprestimos.renovarEmprestimo(idEmprestimo, dataDevolucao);
				
				keyPress();
			}
			case 12 -> {
				System.out.println("\nRegistrar Devolução");
				System.out.println("=======================");

				System.out.println("Insira o ID do Empréstimo");
				idEmprestimo = leia.nextInt();

				emprestimos.deletarEmprestimo(idEmprestimo);
				keyPress();
			}

			default -> {
				System.out.println("\nOpção Inválida!");
				keyPress();
			}

			}

		}

	}

	public static void keyPress() {

		try {

			System.out.println("\n\nPressione Enter para Continuar...");
			System.in.read();

		} catch (IOException e) {
			System.out.println("\nDigite a tecla Enter!");
		}
	}

}
