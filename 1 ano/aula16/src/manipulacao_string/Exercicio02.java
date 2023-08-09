package manipulacao_string;

import java.util.ArrayList;
import java.util.Scanner;

public class Exercicio02 {
	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
		
		ArrayList<Cliente> clientes = new ArrayList<>();
		ArrayList<Produto> produtos = new ArrayList<>();
		
		String baseDados = "CJose dos Santos,42,Sao Paulo|CSandra Silva,36,Sao Jose do Rio Preto|CAugusto Soares,22,Sao Paulo|CVanderlei Azevedo,45,Santos|CVanessa Ferreira,27,Sao Paulo|PMouse,1,9.90|PTeclado,3,19.90|PMonitor,2,349.90|PHD SSD,2,199.90|PProcessador,1,350.00";
		
		String dados[] = baseDados.split("\\|");
		
		for(int i = 0; i < dados.length; i++){
			String campos[] = dados[i].split(",");
			
//			System.out.println(dados[i]);
			
			String tipo = String.valueOf(campos[0].charAt(0));
			String nome = campos[0].substring(1, campos[0].length());
			
			if(tipo.contentEquals("P")){
				Produto prod = new Produto();
				
				prod.setNome(nome);
				prod.setQtd_estoque(Integer.parseInt(campos[1]));
				prod.setPreco(Double.parseDouble(campos[2]));
				
				produtos.add(prod);
			}else{
				Cliente cli = new Cliente();
				
				cli.setNome(nome);
				cli.setIdade(Integer.parseInt(campos[1]));
				cli.setCidade(campos[2]);
				
				clientes.add(cli);
			}
		}
		
		System.out.println("Clientes: \n");
		for(Cliente c: clientes){
			System.out.println("Nome: " + c.getNome());
			System.out.println("Idade: " + c.getIdade());
			System.out.println("Cidade: " + c.getCidade() + "\n");
		}
		
		System.out.println("Produtos: \n");
		for (Produto p: produtos){
			System.out.println("Nome: " + p.getNome());
			System.out.println("Qtd em estoque: " + p.getQtd_estoque());
			System.out.println("Preço: " + p.getPreco() + "\n");
		}

	}
}
