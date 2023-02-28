package miniEstante.model;

public class Cliente {

	private String nome;
	private String endereco;
	private String telefone;
	private int idCliente;

	public Cliente(String nome, String endereco, String telefone, int idCliente) {

		super();
		this.nome = nome;
		this.endereco = endereco;
		this.telefone = telefone;
		this.idCliente = idCliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public void visualizar() {

		System.out.println("==================================================");
		System.out.println("                                                  ");
		System.out.println("================Dados do Cliente==================");
		System.out.println("                                                  ");
		System.out.println("==================================================");
		System.out.println("Id: " + this.idCliente);
		System.out.println("Nome do Cliente: " + this.nome);
		System.out.println("Endereço: " + this.endereco);
		System.out.println("Telefone: " + this.telefone);
		System.out.println("==================================================");

	}

}
