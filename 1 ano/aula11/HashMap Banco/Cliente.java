public class Cliente {
	private int id;
	private String nome;
	private String email;
	private int idade;
	private ContaBancaria conta;

	Cliente(){

	}

	Cliente(int id, String nome, int idade, String email, ContaBancaria conta){

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public ContaBancaria getConta() {
		return conta;
	}

	public void setConta(ContaBancaria conta) {
		this.conta = conta;
	}

	public void exibirCliente(){
		System.out.println("id: " + id + " - " + nome + " | saldo: " + conta.consultarSaldo());
	}

	public void exibirConta(){
		System.out.println("Ag. " + conta.getAgencia() + " - Conta: " + conta.getNumero());
		System.out.printf("Saldo: %.2f \n", conta.consultarSaldo());
	}
}