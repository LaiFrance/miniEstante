package miniEstante.model;

public class Emprestimo {

	int idCliente;
	int idLivro;
	String dataAluguel;
	String dataDevolucao;
	int idEmprestimo;

	public Emprestimo(int idCliente, int idLivro, String dataAluguel, String dataDevolucao) {
		this.idCliente = idCliente;
		this.idLivro = idLivro;
		this.dataAluguel = dataAluguel;
		this.dataDevolucao = dataDevolucao;
	}

	public Emprestimo(int idCliente, int idLivro, String dataAluguel, String dataDevolucao, int idEmprestimo) {
		this.idCliente = idCliente;
		this.idLivro = idLivro;
		this.dataAluguel = dataAluguel;
		this.dataDevolucao = dataDevolucao;
		this.idEmprestimo = idEmprestimo;
	}


	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public int getIdLivro() {
		return idLivro;
	}

	public int getIdEmprestimo() {
		return idEmprestimo;
	}


	public void setIdEmprestimo(int idEmprestimo) {
		this.idEmprestimo = idEmprestimo;
	}

	public void setIdLivro(int idLivro) {
		this.idLivro = idLivro;
	}

	public String getDataAluguel() {
		return dataAluguel;
	}

	public void setDataAluguel(String dataAluguel) {
		this.dataAluguel = dataAluguel;
	}

	public String getDataDevolucao(String dataDevolucao) {
		return dataDevolucao;
	}

	public void setDataDevolucao(String dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}

	public void visualizar() {
		System.out.println("==================================================");
		System.out.println("                                                  ");
		System.out.println("================DADOS DO EMPRÉSTIMO===============");
		System.out.println("                                                  ");
		System.out.println("==================================================");
		System.out.println("ID do Livro: " + this.idLivro);
		System.out.println("ID do Cliente: " + this.idCliente);
		System.out.println("Data do aluguel: " + this.dataAluguel);
		System.out.println("Data de devolução: " + this.dataDevolucao);
		System.out.println("ID do Empréstimo: " + this.idEmprestimo);

	}
}
