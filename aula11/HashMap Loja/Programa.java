package Loja;

import java.util.HashMap;
import java.util.Scanner;

public class Programa {
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		HashMap<Integer, Produto> produtos = new HashMap<Integer, Produto>();
		
		String opcao;
        int id;
        
        do {        
            System.out.printf("===> Loja Macgyver <===\n\n");
            System.out.printf("Cadastro de Produtos\n");
            
            Produto p = new Produto();
            
            System.out.println("Por favor, digite o nome do produto");
            p.setNome(in.next());
            
            System.out.println("Por favor, digite o preço");
            p.setPreco(in.nextDouble());
            
            System.out.println("Por favor, digite a quantidade");
            p.setQuantidade(in.nextDouble());
            
            System.out.println("Produto possui categoria? (S/N)");
            String possuiCategoria = in.next();

        	Categoria categoria = new Categoria();
        	
            id = produtos.size() + 1;
            
            if(possuiCategoria.toUpperCase().contentEquals("S")){
            	
            	categoria.setId(id);

            	System.out.println("Por favor, digite o nome da categoria");
                categoria.setNome(in.next());
                
                System.out.println("Categoria cadastrada com sucesso!");
            }
            else categoria = null;
            
            p.setCategoria(categoria);
            
            p.setId(id);
            
            System.out.println("Produto cadastrado com sucesso!");
            
            produtos.put(id, p);
            
            System.out.println("\nDeseja cadastrar outro produto?");
            opcao = in.next();
            
        }while(opcao.toUpperCase().contentEquals("S"));
        
        System.out.println("Lista de Produtos: ");
        produtos.forEach((key, value) -> {
        	System.out.println(key + ": " + value.getNome());
        	System.out.printf("Preço R$ %.2f: ", value.getPreco());
        	System.out.println();
        	System.out.printf("Quantidade: %.1f", value.getQuantidade());
        	System.out.println();
        	
        	if(value.getCategoria() != null)
	        	System.out.println("Categoria:  " 
	        	+ value.getCategoria().getNome()+"\n");
        	
        	else
        		System.out.println("Produto não possui categoria\n");
        	
        	
        	try {
				System.in.read();
			} catch (Exception e) {
				e.printStackTrace();
			}
        	
        });
	}
}
