package Conta;

public class ContaBancaria {
	private String agencia;
	private String numero;
	private double saldo;
	
	ContaBancaria() {
		
	}
	
	ContaBancaria(String agencia, String numero, double saldo) {
		
	}
	
	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public double consultarSaldo() {
		return saldo;
	}
	
	public void Depositar(double valor) {
		this.saldo += valor;
	}
	
	public void Sacar(double valor) {
		this.saldo -= valor;
	}
	
	public void Transferir(double valor, Cliente destinario) {
		Sacar(valor);
		destinario.getConta().Depositar(valor);
	}
}