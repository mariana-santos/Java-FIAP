package exercicios;

import java.util.Scanner;

public class ex33 {

	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
		
		System.out.println("Digite seu sexo");
		String sexo = in.next().toUpperCase();
		
//		33. Entrar via teclado com o sexo de determinado usu�rio, aceitar somente �F� ou �M� como respostas v�lidas.

//		DO - WHILE
		do{	
			if(!sexo.equals('F') && !sexo.equals('M')){
				System.out.println(sexo + " inv�lido");
				sexo = in.next().toUpperCase();
			}
		}while(!sexo.equals('F') && !sexo.equals('M'));
		
//		WHILE	
//		while(!sexo.equals('F') && !sexo.equals('M')){
//			System.out.println(sexo + " inv�lido");
//			sexo = in.next();
//		}

	}

}
