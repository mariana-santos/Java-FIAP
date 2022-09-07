package exercicios;

import java.util.Scanner;

public class ex33 {

	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
		
		System.out.println("Digite seu sexo");
		String sexo = in.next().toUpperCase();
		
//		33. Entrar via teclado com o sexo de determinado usuário, aceitar somente “F” ou “M” como respostas válidas.

//		DO - WHILE
		do{	
			if(!sexo.equals('F') && !sexo.equals('M')){
				System.out.println(sexo + " inválido");
				sexo = in.next().toUpperCase();
			}
		}while(!sexo.equals('F') && !sexo.equals('M'));
		
//		WHILE	
//		while(!sexo.equals('F') && !sexo.equals('M')){
//			System.out.println(sexo + " inválido");
//			sexo = in.next();
//		}

	}

}
