package exercicios;

import java.util.Scanner;

public class ex32 {

	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
		
		System.out.println("Digite o primeiro número");
		int a = in.nextInt();
		
		System.out.println("Digite o segundo número");
		int b = in.nextInt();
		
//		32. Entrar com dois valores via teclado, onde o segundo deverá ser maior que o primeiro. Caso contrário solicitar novamente apenas o segundo valor.
		
//		DO - WHILE
		do{	
			if(b < a){
				System.out.println(b + " não pode ser maior que "+a);
				System.out.println("Digite o segundo número novamente");
				b = in.nextInt();
			}
		}while(b < a);
		
//		WHILE	
		while(b < a){
			System.out.println(b + " não pode ser maior que "+a);
			System.out.println("Digite o segundo número novamente");
			b = in.nextInt();
		}

	}

}
