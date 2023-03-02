package miniEstante.controller;

import java.util.ArrayList;

import miniEstante.model.Livro;
import miniEstante.repository.LivroRepository;

public class LivroController implements LivroRepository {

	private ArrayList<Livro> listaLivro = new ArrayList<Livro>();

	int idLivro = 0;

	@Override
	public void cadastrar(Livro livro) {
		listaLivro.add(livro);
		System.out.println("Livro Cadastrado");
	}

	@Override
	public void atualizar(Livro livro) {
		var procurarLivro = buscarLivroNaCollectio(livro.getIdLivro());
		if (procurarLivro != null) {
			listaLivro.set(listaLivro.indexOf(procurarLivro), livro);
			System.out.println("O Livro foi atualizado");
		} else
			System.out.println("O Livro não foi encontrado");
	}

	@Override
	public void procurarLivro(int idLivro) {
		var livro = buscarLivroNaCollectio(idLivro);

		if (livro != null)
			livro.visualizar();
		else
			System.out.println("O Livro " + idLivro + " Não foi encontrado");
	}

	@Override
	public void listarLivro() {
		for (var livro : listaLivro) {
			livro.visualizar();
		}

	}

	@Override
	public void deletarLivro(int idLivro) {
		var livro = buscarLivroNaCollectio(idLivro);

		if (livro != null) {
			if (listaLivro.remove(livro) == true)
				System.out.println("O livro foi excluido");
		} else
			System.out.println("O livro não foi encontrado!");
	}

	public Livro buscarLivroNaCollectio(int idLivro) {
		for (var livro : listaLivro) {
			if (livro.getIdLivro() == idLivro)
				return livro;
		}
		return null;
	}

	public int gerarIdLivro() {
		return ++idLivro;
	}

}
