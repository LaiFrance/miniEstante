package miniEstante.controller;

import java.util.ArrayList;

import miniEstante.model.Emprestimo;
import miniEstante.repository.EmprestimoRepository;


public class EmprestimoController implements EmprestimoRepository {

	private ArrayList<Emprestimo> listaEmprestimo = new ArrayList<Emprestimo>();
	int idEmprestimo = 0; 

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

		gerarIdEmprestimo();
		listaEmprestimo.add(e1);
		System.out.println("Empréstimo Registrado!");

	}

	@Override
	public void renovarEmprestimo(int idEmprestimo, String dataDevolucao) {
		var buscaEmprestimo = buscarAluguelNaCollection(idEmprestimo);

		if (buscaEmprestimo != null) {
			int i = listaEmprestimo.indexOf(buscaEmprestimo);
			listaEmprestimo.get(i).setDataDevolucao(dataDevolucao);
			System.out.println("O empréstimo número " + idEmprestimo + "foi atualizado!");
		
		} else
			System.out.println("O  ID do empréstimo não foi encontrado!");

	}

	@Override
	public void deletarEmprestimo(int idEmprestimo) {

		var emprestimo = buscarAluguelNaCollection(idEmprestimo);

		if (emprestimo != null) {
			if (listaEmprestimo.remove(emprestimo) == true)
				System.out.println("O Empréstimo " + idEmprestimo + " foi retirado da lista!");
		} else
			System.out.println("O Empréstimo " + idEmprestimo + " não foi encontrado!");
	}

	public Emprestimo buscarAluguelNaCollection(int idEmprestimo) {
		for (var emprestimo : listaEmprestimo) {
			if (emprestimo.getIdEmprestimo() == idEmprestimo)
				return emprestimo;
		}
		
		return null;
	}
	
	public int gerarIdEmprestimo() {
		
		return ++ idEmprestimo;
	}
}
