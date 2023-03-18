import java.util.HashMap;
import java.util.Scanner;

public class Program {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		HashMap<Integer, Cliente> clientes = new HashMap<Integer, Cliente>();
		
		String opcao;
        int id;
        
        do {        
            System.out.printf("===> Banco Macgyver <===\n\n");
            System.out.printf("Cadastro de clientes\n");
            
            Cliente c = new Cliente();
            
            System.out.println("Por favor, digite seu nome");
            String nome = in.next();
            c.setNome(nome);
            
            System.out.println("Por favor, digite sua idade");
            c.setIdade(in.nextInt());
            
            System.out.println("Por favor, digite seu email");
            c.setEmail(in.next());
            
            System.out.println("Possui conta bancária? (S/N)");
            String possuiConta = in.next();

        	ContaBancaria conta = new ContaBancaria();
            
            if(possuiConta.toUpperCase().contentEquals("S")){
            	
            	conta.setAgencia("4422");

                String num = Integer.toString((clientes.size() + 1));
                conta.setNumero(num);
                
                System.out.println("Conta cadastrada com sucesso!");
            }
            else conta = null;
            
            c.setConta(conta);
            
            id = clientes.size() + 1;
            c.setId(id);
            
            System.out.println("Cliente cadastrado com sucesso!");
            
            clientes.put(id, c);
            
            System.out.println("\nDeseja cadastrar outro cliente?");
            opcao = in.next();
            
        }while(opcao.toUpperCase().contentEquals("S"));
        
        System.out.println("Lista de clientes: ");
        clientes.forEach((key, value) -> {
        	System.out.println(key + ": " + value.getNome());
        	System.out.println(value.getIdade() + " anos");
        	System.out.println(value.getEmail());
        	
        	if(value.getConta() != null){
	        	System.out.println("Ag. " + value.getConta().getAgencia());
	        	System.out.println("C/C. " + value.getConta().getNumero()+"\n");
        	}else{
        		System.out.println("Cliente não possui conta\n");
        	}
        	
        	try {
				System.in.read();
			} catch (Exception e) {
				e.printStackTrace();
			}
        	
        });
        
	}
}
