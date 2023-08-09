package Conta;

import java.util.ArrayList;

public class ContaBancaria {
	private String agencia;
	private String numero;
	private double saldo;
	private double limite = 75;
	private ArrayList<String> extrato = new ArrayList<>();
	
	ContaBancaria() {
		
	}
	
	ContaBancaria(String agencia, String numero, double saldo) {
		
	}
	
	public ArrayList<String> getExtrato() {
		return extrato;
	}

	public void setExtrato(ArrayList<String> extrato) {
		this.extrato = extrato;
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
	
	public double getLimite() {
		return limite;
	}

	public void setLimite(double limite) {
		this.limite = limite;
	}

	public boolean Depositar(double valor) {
		if(valor <= 0) return false;
		else {
			this.saldo += valor; 
			extrato.add("[ENTRADA] Depósito: R$"+valor);
			return true;
		}
	}
	
	public boolean Sacar(double valor) {
		//se o limite for insuficiente ou negativo
		if(valor <= 0 || valor > (saldo + limite)) return false;
		
		//se o limite for suficiente, ele tira do saldo e do limite
		else if(valor >= saldo + limite) {
			this.limite = valor - saldo;
			this.saldo = 0;
			extrato.add("[SAÍDA] Saque: R$%"+valor);
			return true;
		}
		
		//só tira do saldo
		else {
			extrato.add("[SAÍDA] Saque: R$%"+valor);
			this.saldo -= valor; 
			return true;
		}
	}
	
	public Boolean Transferir(double valor, Cliente destinario) {
		
		if(valor <= 0 || valor > (saldo + limite)) return false;

		else {
			if(Sacar(valor)) {
				Sacar(valor);
				destinario.getConta().Depositar(valor);
				extrato.add("[SAÍDA] Transferência: R$%"+valor);
				return true;
			}
			return false;
		}
		
	}
}