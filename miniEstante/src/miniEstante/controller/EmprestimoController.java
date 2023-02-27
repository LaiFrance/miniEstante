package miniEstante.controller;

import java.util.ArrayList;

import miniEstante.model.Emprestimo;
import miniEstante.repository.EmprestimoRepository;
import miniEstante.controller.ClienteController;

public class EmprestimoController implements EmprestimoRepository {

	private ArrayList<Emprestimo> listaEmprestimo = new ArrayList<Emprestimo>();

	@Override
	public void procuraLivroAlugado(int idLivro) {
		var livro = buscarAluguelNaCollection(idLivro);

		if (livro == null)
			System.out.println("O livro " + idLivro + " não foi encontrado!");
		else
			livro.visualizar();

	}

	@Override
	public void listarLivrosAlugados() {

		if (listaEmprestimo.size() != 0) {

			for (var emprestimo : listaEmprestimo) {
				emprestimo.visualizar();
			}

		} else
			System.out.println("\nSem empréstimos efetuados");
	}

	@Override
	public void registrarEmprestimo(Emprestimo e1) {

		listaEmprestimo.add(e1);
		System.out.println("Empréstimo Registrado!");

	}

	@Override
	public void renovarEmprestimo(Emprestimo emprestimo) {
		var buscaEmprestimo = buscarAluguelNaCollection(emprestimo.getIdLivro());

		if (buscaEmprestimo != null) {
			listaEmprestimo.set(listaEmprestimo.indexOf(buscaEmprestimo), emprestimo);
			System.out.println("O empréstimo número " + emprestimo.getIdLivro() + "não foi encontrada!");
		} else
			System.out.println("O empréstimo número " + emprestimo.getIdLivro() + "foi atualizado!");

	}

	@Override
	public void deletarEmprestimo(int idLivro) {
		var emprestimo = buscarAluguelNaCollection(idLivro);

		if (emprestimo != null) {
			if (listaEmprestimo.remove(emprestimo) == true)
				System.out.println("O Empréstimo " + idLivro + " foi retirado da lista!");
		} else
			System.out.println("O Empréstimo " + idLivro + " não foi encontrado!");
	}

	public Emprestimo buscarAluguelNaCollection(int idLivro) {
		for (var emprestimo : listaEmprestimo) {
			if (emprestimo.getIdLivro() == idLivro)
				return emprestimo;
		}

		return null;
	}
}
