package heranca;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Programa {
	public static void main(String[] args) throws IOException {
		
		Scanner ler = new Scanner(System.in);
		
		ArrayList<ContaCorrente> listaCC = new ArrayList<>();
		ArrayList<ContaPoupanca> listaCP = new ArrayList<>();
		ArrayList<ContaSalario> listaCS = new ArrayList<>();
		
		int opcao;
		String agencia = "";
		String numero = "";
		double saldo = 0;
		
		do {
			System.out.println("Que tipo de conta deseja cadastrar?");
			System.out.println("1 - Conta Corrente");
			System.out.println("2 - Conta Poupança");
			System.out.println("3 - Conta Salário");
			System.out.println("4 - Consultar contas cadastradas");
			System.out.println("5 - Sair");
			
			opcao = ler.nextInt();
			
			if(opcao < 4 && opcao > 0){
				System.out.println("Digite o número da conta: ");
				numero = ler.next();
				
				System.out.println("Digite a agência da conta: ");
				agencia = ler.next();
				
				System.out.println("Digite o saldo da conta: ");
				saldo = ler.nextDouble();
			}
			
			if(opcao == 1){
				ContaCorrente cc = new ContaCorrente();
				
				cc.setAgencia(agencia);
				cc.setNumero(numero);
				cc.setSaldo(saldo);
				
				System.out.println("Digite o limite da conta");
				cc.setChequeEspecial(ler.nextDouble());
				
				listaCC.add(cc);
				
				System.out.println("Conta cadastrada com sucesso!");
				System.in.read();
			}
			else if(opcao == 2){
				ContaPoupanca cp = new ContaPoupanca();
				
				cp.setAgencia(agencia);
				cp.setNumero(numero);
				cp.setSaldo(saldo);
				
				System.out.println("Digite a rentabilidade da conta");
				cp.setRentabilidade(ler.nextDouble());
				
				listaCP.add(cp);
				
				System.out.println("Conta cadastrada com sucesso!");
				System.in.read();
			}else if(opcao == 3){
				ContaSalario cs = new ContaSalario();
				
				cs.setAgencia(agencia);
				cs.setNumero(numero);
				cs.setSaldo(saldo);
				
				listaCS.add(cs);
				
				System.out.println("Conta cadastrada com sucesso!");
				System.in.read();
				
			}else if(opcao == 4){
				
				String nova_consulta = "S";
				
				while(nova_consulta.contentEquals("S")){
					System.out.println("Quais tipos de conta deseja consultar?");
					System.out.println("1 - Conta Corrente");
					System.out.println("2 - Conta Poupança");
					System.out.println("3 - Conta Salário");
					
					int tipo_conta = ler.nextInt();
					
					while(tipo_conta <= 0 || tipo_conta > 3){
						System.out.println("Tipo de conta inválido! Por favor digite novamente");
						tipo_conta = ler.nextInt();
					}
					
					if(tipo_conta == 1){
						for(ContaCorrente conta : listaCC){
							System.out.println("Ag.: " + conta.getAgencia());
							System.out.println("c/c: "+conta.getNumero());
							System.out.println("Saldo: R$"+conta.getSaldo());
							System.out.println("Limite: R$"+conta.getChequeEspecial());
						}
						
						System.in.read();
						
					}else if(tipo_conta == 2){
						for(ContaPoupanca conta : listaCP){
							System.out.println("Ag.: " + conta.getAgencia());
							System.out.println("c/c: "+conta.getNumero());
							System.out.println("Saldo: R$"+conta.getSaldo());
							System.out.println("Rendimento: R$"+conta.getRentabilidade());
						}
						
						System.in.read();
					}else{
						for(ContaSalario conta : listaCS){
							System.out.println("Ag.: " + conta.getAgencia());
							System.out.println("c/c: "+conta.getNumero());
							System.out.println("Saldo: R$"+conta.getSaldo());
						}
						
						System.in.read();
					}
					
					System.out.println("Deseja consultar outro tipo de conta? (S/N)");
					nova_consulta = ler.next().toUpperCase();
				}
				
				System.in.read();
			}
			
		}while(opcao > 0 && opcao < 5);
	}
}
