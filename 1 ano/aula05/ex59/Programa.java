package Conta;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Programa {
	public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(System.in);
       
        ArrayList<Cliente> clientes = new ArrayList<>();
       
        int opcao;
        int id;
 
        do {        
            System.out.printf("===> Banco Macgyver <===\n\n");
            System.out.printf("Escolha uma opção:\n");

            System.out.printf("1 - Criar cliente/conta \n" +
                    "2 - Depósito \n" +
                    "3 - Saque \n" +
                    "4 - Transferência \n" +
                    "5 - Consulta de Saldo \n" +
                    "6 - Sair \n\n");
  System.out.printf("Digite a opção desejada: ");
  opcao = in.nextInt();
 
  if (opcao == 1) {
      Cliente c = new Cliente();
     
      id = clientes.size() + 1;
      c.setId(id);
     
      System.out.println("Digite o nome: ");
	c.setNome(in.next());
	
	System.out.println("Digite a idade: ");
	c.setIdade(in.nextInt());
	
	System.out.println("Digite o email: ");
	c.setEmail(in.next());
	
	ContaBancaria conta = new ContaBancaria();
    
    System.out.print("Digite a agencia: ");
    conta.setAgencia(in.next());
    
    System.out.print("Digite o numero: ");
    conta.setNumero(in.next());
    
    c.setConta(conta);
     
      clientes.add(c);
     
      System.out.printf("Cliente e conta incluídos com sucesso!");
      System.in.read();
  }
  else if (opcao == 2) {          
	  for(Cliente c: clientes) {
          c.exibirCliente();
      }
     
      System.out.println("Digite o id do cliente que deseja depositar: ");
      int id_cliente = in.nextInt();
		
		int indexCliente = -1;
		
		for (Cliente cli: clientes){
			if(cli.getId() == id_cliente){
				indexCliente = clientes.indexOf(cli);
				break;
			}
		}
		
		if(indexCliente != -1){
			System.out.println("Digite o valor que deseja depositar");
			double valor = in.nextDouble();
			Cliente cli = clientes.get(indexCliente);
			
			cli.getConta().Depositar(valor);
			System.out.println("Valor depositado com sucesso!");
			
		}else {
			System.out.println("Cliente não encontrado");
		}
		
		System.in.read();
  }
  else if (opcao == 3) {
	  for(Cliente c: clientes) {
          c.exibirCliente();
      }
     
      System.out.println("Digite o id do cliente que deseja sacar: ");
      int id_cliente = in.nextInt();
		
		int indexCliente = -1;
		
		for (Cliente cli: clientes){
			if(cli.getId() == id_cliente){
				indexCliente = clientes.indexOf(cli);
				break;
			}
		}
		
		if(indexCliente != -1){
			System.out.println("Digite o valor que deseja sacar");
			double valor = in.nextDouble();
			Cliente cli = clientes.get(indexCliente);
			
			if(valor > cli.getConta().consultarSaldo()) {
				System.out.println("Não é possível sacar essa quantidade. Saldo insuficiente.");
			}else {
				cli.getConta().Sacar(valor);
				System.out.println("Valor sacado com sucesso!");
			}
		}else {
			System.out.println("Cliente não encontrado");
		}
		
		System.in.read();
  }
  else if (opcao == 4) {
	  for(Cliente c: clientes) {
          c.exibirCliente();
      }
     
      System.out.println("Digite o id do cliente de onde sairá o valor da transferência");
		int id_origem = in.nextInt();
		
		int indexClienteOrigem = -1;
		
		for (Cliente cli: clientes){
			if(cli.getId() == id_origem){
				indexClienteOrigem = clientes.indexOf(cli);
				break;
			}
		}
		
		if(indexClienteOrigem != -1){
			Cliente origem = clientes.get(indexClienteOrigem);
			
			System.out.println("Digite o id do cliente que receberá o valor da transferência");
			int id_destino = in.nextInt();
			
			int indexClienteDestino = -1;
			
			for (Cliente cli: clientes){
				if(cli.getId() == id_destino){
					indexClienteDestino = clientes.indexOf(cli);
					break;
				}
			}
			
			if(indexClienteDestino != -1 && indexClienteDestino != indexClienteOrigem){
				Cliente destino = clientes.get(indexClienteDestino);
				
				System.out.println("Quanto deseja transferir?");
				double valor = in.nextDouble();
				
				if(valor > origem.getConta().consultarSaldo()) {
					System.out.println("Valor insuficiente para transferência!");
				} else {
					origem.getConta().Transferir(valor, destino);
					System.out.printf("Transferência realizada com sucesso!");
				}
						
			}else if(indexClienteDestino == indexClienteOrigem) {
				System.out.println("Cliente de origem não pode ser o destinatário da transferência");
			}
			else{
				System.out.println("Cliente não encontrado!");
			}
		}else{
			System.out.println("Cliente não encontrado!");
		}
      
      System.in.read();
  }
  else if(opcao == 5) {
	  System.out.println("Consulta de saldo: ");
	  
	  for(Cliente c: clientes) {
          c.exibirCliente();
      }
	  
	  System.in.read();
  }
}while(opcao != 6);

	
}

}
