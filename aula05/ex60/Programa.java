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
                    "6 - Consulta de Extrato \n" +
                    "7 - Sair \n\n");
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
	
      ContaBancaria conta = new ContaBancaria();
      conta.setAgencia("4422");
      
      String num = Integer.toString((clientes.size() + 1));
      conta.setNumero(num);
      
      c.setConta(conta);
      clientes.add(c);
     
      System.out.printf("Cliente e conta incluídos com sucesso!");
      System.in.read();
  }
  else if (opcao == 2) {
	  
	  listarClientes(clientes);
     
      System.out.println("Digite o id do cliente que deseja depositar: ");
      int id_cliente = in.nextInt();
		
		
		if(validaCliente(id_cliente, clientes)){
			
			System.out.println("Digite o valor que deseja depositar");
			double valor = in.nextDouble();
			Cliente cli = clientes.get(id_cliente - 1);
			
			if (cli.getConta().Depositar(valor)) System.out.println("Valor depositado com sucesso!");
			else System.out.println("Não foi possível depositar esse valor!");
			
		}else {
			System.out.println("Cliente não encontrado");
		}
		
		System.in.read();
  }
  else if (opcao == 3) {
	  listarClientes(clientes);
     
      System.out.println("Digite o id do cliente que deseja sacar: ");
      int id_cliente = in.nextInt();
		
		if(validaCliente(id_cliente, clientes)){
			
			System.out.println("Digite o valor que deseja sacar");
			double valor = in.nextDouble();
			Cliente cli = clientes.get(id_cliente - 1);
			
			if(cli.getConta().Sacar(valor)) {
				System.out.println("Valor sacado com sucesso!");
			}else {
				System.out.println("Não é possível sacar essa quantidade.");
			}
		}else {
			System.out.println("Cliente não encontrado");
		}
		
		System.in.read();
  }
  else if (opcao == 4) {
	  
	  listarClientes(clientes);
     
      System.out.println("Digite o id do cliente de onde sairá o valor da transferência");
		int id_origem = in.nextInt();
		
		if(validaCliente(id_origem, clientes)){
			Cliente origem = clientes.get(id_origem - 1);
			
			System.out.println("Digite o id do cliente que receberá o valor da transferência");
			int id_destino = in.nextInt();
			
			if(validaCliente(id_destino, clientes) && id_origem != id_destino){
				Cliente destino = clientes.get(id_destino - 1);
				
				System.out.println("Quanto deseja transferir?");
				double valor = in.nextDouble();
				
				if(origem.getConta().Transferir(valor, destino)) {
					System.out.printf("Transferência realizada com sucesso!");
				} else {
					System.out.println("Não foi possível completar a transferência.");
				}
						
			}else if(id_destino == id_origem) {
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
	  
	  listarClientes(clientes);
	  
	  System.in.read();
	  
  }else if(opcao == 6) {
	  listarClientes(clientes);
	     
      System.out.println("Digite o id do cliente que deseja visualizar o extrato: ");
      int id_cliente = in.nextInt();
		
		if(validaCliente(id_cliente, clientes)){
			
			Cliente cli = clientes.get(id_cliente - 1);
			
			ArrayList <String> extrato = cli.getConta().getExtrato();
			
			System.out.println("===> Extrato de "+ cli.getNome() +"<===\n");
			
			for(String item: extrato) {
		        System.out.println(item);
		    }
			
		}else {
			System.out.println("Cliente não encontrado");
		}
		
		System.in.read();
  }
}while(opcao >= 1 && opcao <= 6);
	
}
 
public static Boolean validaCliente(int idDigitado, ArrayList<Cliente> clientes){
	 
	 int indexCliente = -1;
	 
		for (Cliente cli: clientes){
			if(cli.getId() == idDigitado){
				indexCliente = clientes.indexOf(cli);
				break;
			}
		}
		
	 if (indexCliente != -1) return true;
	 else return false;
}

public static void listarClientes(ArrayList<Cliente> clientes){
	 
	System.out.printf("===> Clientes cadastrados <===\n\n");
	for(Cliente c: clientes) {
        c.exibirCliente();
        c.exibirConta();
        System.out.println();
    }
}


}
