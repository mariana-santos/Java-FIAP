package ex58;

import java.util.Scanner;
import java.util.ArrayList;

public class Programa {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		ArrayList<Produto> produtos = new ArrayList<>();
		int id;
		String possuiCategoria;
		
		for (int i = 0; i < 5; i++){
			System.out.println("Cadastro do " + (i+1) + "° produto");
			
			Produto prod = new Produto();
			
			//GERAÇÃO DO ID;
			if(produtos.size() > 0){
				int idUserAnterior = produtos.get(produtos.size() - 1).getId();
				id = idUserAnterior + 1;
			}else{
				id = 1;
			}
			
			prod.setId(id);
			
			System.out.println("Digite o nome do produto");
			prod.setNome(in.next());
			
			System.out.println("Digite o preço do produto");
			prod.setPreco(in.nextDouble());
			
			System.out.println("Digite a quantidade do produto");
			prod.setQuantidade(in.nextDouble());
			
			System.out.println("O produto possui categoria?");
			possuiCategoria = in.next().toUpperCase();
			
			if(possuiCategoria.equals("S")){
				Categoria cat = new Categoria();
				
				System.out.println("Digite o nome da categoria: ");
				cat.setNome(in.next());
				
				prod.setCategoria(cat);
			}else{
				prod.setCategoria(null);
			}
			
			produtos.add(prod);
		}
		
		for (Produto p: produtos){
			p.exibirProduto();
			if(p.getCategoria() != null) p.exibirCategoria();
		}
	}
}
