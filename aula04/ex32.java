package exercicios;

import java.util.Scanner;

public class ex32 {

	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
		
		System.out.println("Digite o primeiro n�mero");
		int a = in.nextInt();
		
		System.out.println("Digite o segundo n�mero");
		int b = in.nextInt();
		
//		32. Entrar com dois valores via teclado, onde o segundo dever� ser maior que o primeiro. Caso contr�rio solicitar novamente apenas o segundo valor.
		
//		DO - WHILE
		do{	
			if(b < a){
				System.out.println(b + " n�o pode ser maior que "+a);
				System.out.println("Digite o segundo n�mero novamente");
				b = in.nextInt();
			}
		}while(b < a);
		
//		WHILE	
		while(b < a){
			System.out.println(b + " n�o pode ser maior que "+a);
			System.out.println("Digite o segundo n�mero novamente");
			b = in.nextInt();
		}

	}

}
