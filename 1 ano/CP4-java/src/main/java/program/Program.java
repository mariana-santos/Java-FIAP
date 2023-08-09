package program;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import org.json.JSONException;

import model.Filme;
import service.FilmeApiService;

public class Program {
	public static void main(String[] args) throws JSONException {
		
		Scanner in = new Scanner (System.in);
		
		FilmeApiService filme_service = new FilmeApiService();

        try {
        	HashMap<Integer, Filme> filmes = filme_service.getFilmes();
        	
        	System.out.println("---- Lista de filmes ----");
        	filmes.forEach((key, value) -> {
                System.out.println(key + " - " + value.getNome() + " ");
            });
        	
        	System.in.read();
           
    		oferece_opcoes();
    		int opcao = in.nextInt();
    		
    		while(opcao <= 3) {
    			System.out.println("Digite o id do filme desejado: ");
    			int id = in.nextInt();
    			
    			boolean filme_valido = valida_id_filme(id, filmes);
    			
//    			System.out.println(filme_valido);
    			
    			while(!filme_valido) {
    				System.out.println("Id inválido. Digite outro id do filme desejado:");
        			id = in.nextInt();
        			filme_valido = valida_id_filme(id, filmes);
    			}
    			
    			if(opcao == 1) detalha_filme(id, filmes);
    			
    			else if(opcao == 2) {
    				System.out.println("Por favor, digite o seu nome: ");
    				String nome = in.next();
    				
    				System.out.println("O que você tem a dizer sobre o filme? ");
    				String comentario = in.next();
    				
    				while(nome.contentEquals("") || comentario.contentEquals("")) {
    					System.out.println("Algum dado inválido. Por favor digite os dados novamente: ");
    					
    					System.out.println("Por favor, digite o seu nome: ");
        				nome = in.next();
        				
        				System.out.println("O que você tem a dizer sobre o filme? ");
        				comentario = in.next();
    				}
    				
    				for (Entry<Integer, Filme> m : filmes.entrySet()) {
    		            if(m.getKey() == id) m.getValue().novo_comentario(nome, comentario);
    		        }
    				
    				System.out.println("Comentário cadastrado com sucesso!");
//    				System.in.read();
    			}
    			else {
    				//Mostrando comentários
    				for (Entry<Integer, Filme> m : filmes.entrySet()) {
    		            if(m.getKey() == id) m.getValue().mostrarComentarios();
    		        }
    				
    				System.out.println("Por favor, digite o id do comentário que deseja excluir: ");
    				int id_coment = in.nextInt();
    				
    				boolean comentario_valido = false;
    				
    				for (Entry<Integer, Filme> m : filmes.entrySet()) {
    		            if(m.getKey() == id) {
    		            	comentario_valido = m.getValue().ExcluirComentario(id_coment);
    		            }
    		        }
    				
    				while(!comentario_valido) {
    					System.out.println("Id inválido! Por favor, escolha outro comentário");
    					
    					id_coment = in.nextInt();
        				
        				comentario_valido = false;
        				
        				for (Entry<Integer, Filme> m : filmes.entrySet()) {
        		            if(m.getKey() == id) {
        		            	comentario_valido = m.getValue().ExcluirComentario(id_coment);
        		            }
        		        }
    				}
    				
    				System.out.println("Comentário excluído com sucesso!");
//    				System.in.read();
    			}
    			
    			oferece_opcoes();
        		opcao = in.nextInt();
    		}
           
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

	}
	
	public static void oferece_opcoes() {
		System.out.println();
		System.out.println("Escolha uma opção:");
		System.out.println("1 - Ver detalhes do filme");
		System.out.println("2 - Fazer um comentário do filme");
		System.out.println("3 - Excluir um comentário");
		System.out.println("4 - Sair");
	}
	
	public static boolean valida_id_filme(int id, HashMap<Integer, Filme> filmes) {
		for (Entry<Integer, Filme> m : filmes.entrySet()) {
            if(m.getKey() == id) return true;
        }
		return false;
	}
	
	public static void detalha_filme(int id, HashMap<Integer, Filme> filmes) {
		filmes.forEach((key, value) -> {
			if (key == id) {
				System.out.println("Sinopse de "+value.getNome());
				System.out.println(value.getSinopse());
				value.mostrarComentarios();
				
				try {
					System.in.read();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}
}
