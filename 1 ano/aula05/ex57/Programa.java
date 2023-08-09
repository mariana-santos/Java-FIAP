package ex57;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Programa {

	public static void main(String[] args) throws IOException {
		
		Scanner in = new Scanner(System.in);
		
		ArrayList<Cliente> clientes = new ArrayList<>();
		
		int opcao = 0, id, indexCliente, idCliente;
		String possuiConta;
		
		do{
			System.out.println("Digite a opção desejada: ");
			System.out.println("1 - Incluir aluno");
			System.out.println("2 - Atualizar aluno");
			System.out.println("3 - Excluir aluno");
			System.out.println("4 - Exibir alunos");
			System.out.println("5 - Sair");
			
			opcao = in.nextInt();
			
			switch(opcao){
				case 1:
					Cliente c = new Cliente();
					
					if(clientes.size() > 0){
						int idUserAnterior = clientes.get(clientes.size() - 1).getId();
						idCliente = idUserAnterior + 1;
					}else{
						idCliente = 1;
					}
					
					c.setId(idCliente);
					
					System.out.println("Digite o nome: ");
					c.setNome(in.next());
					
					System.out.println("Digite a idade: ");
					c.setIdade(in.nextInt());
					
					System.out.println("Digite o email: ");
					c.setEmail(in.next());
					
					System.out.print("Possui conta bancária? S/N");
		            possuiConta = in.next().toUpperCase();

		            if(possuiConta.equals("S")) {
	                   ContaBancaria conta = new ContaBancaria();
	                   
	                   System.out.print("Digite a agencia: ");
	                   conta.setAgencia(in.next());
	                   
	                   System.out.print("Digite o numero: ");
	                   conta.setNumero(in.next());
	                   
	                   conta.setSaldo(0);
	                   
	                   c.setConta(conta);
	               }
	               else {
	                   c.setConta(null);                
	               }
		               
	               clientes.add(c);
	               
	               System.out.printf("Cliente incluído com sucesso!");
	               System.in.read();

					break;
				
				case 2:
					for (Cliente cli: clientes){
						cli.exibirCliente();
					}
					
					System.out.println("Digite o id do cliente que deseja atualizar");
					idCliente = in.nextInt();
					
					indexCliente = -1;
					
					for (Cliente cli: clientes){
						if(cli.getId() == idCliente){
							indexCliente = clientes.indexOf(cli);
							break;
						}
					}
					
					if(indexCliente != -1){
						Cliente cliente = clientes.get(indexCliente);
						
						System.out.println("Digite o novo nome: ");
						cliente.setNome(in.next());
						
						System.out.println("Digite a nova idade: ");
						cliente.setIdade(in.nextInt());
						
						System.out.println("Digite o novo email: ");
						cliente.setEmail(in.next());
					}else{
						System.out.println("Cliente não encontrado!");
					}
					
					break;
				case 3:
					for (Cliente cli: clientes){
						cli.exibirCliente();
					}
					
					System.out.println("Digite o id do cliente que deseja remover");
					idCliente = in.nextInt();
					
					indexCliente = -1;
					
					for (Cliente cli: clientes){
						if(cli.getId() == idCliente){
							indexCliente = clientes.indexOf(cli);
							break;
						}
					}
					
					if(indexCliente != -1){
						clientes.remove(indexCliente);
					}else{
						System.out.println("Cliente não encontrado!");
					}
					break;
					
				case 4:
					System.out.println("Lista de clientes cadastrados:");
					
					for (Cliente cli: clientes){
						cli.exibirCliente();
						if(cli.getConta() != null){
							cli.exibirConta();
						}
					}
					
					break;
				default:
					System.out.println("Opção inválida!");
					
				System.in.read();
			}
		}while(opcao != 5);

	}

}
