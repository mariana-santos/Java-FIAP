package program;

import java.io.IOException;
import java.util.Scanner;

import model.User;
import service.GithubService;

public class Program {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		try {
			System.out.println("Por favor, digite o usuário do github "
					+ "que deseja consultar informações");
			
			String username = in.next();
			
			while(username.length() <= 0){
				System.out.println("O valor do usuário a ser consultado "
						+ "não pode ser vazio. Por favor, "
						+ "digite um usuário válido");
				
				username = in.next();
			}
			
			User user = GithubService.getUser(username);
			
			System.out.println("\n---Dados do usuário "+username+"---");
			System.out.println("Nome: " + user.getName());
			System.out.println("Qtd. de seguidores: " + user.getQtt_followers());
			System.out.println("Qtd. de repositórios: " + user.getQtt_repos());
			
		} catch (IOException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }
	}
}
