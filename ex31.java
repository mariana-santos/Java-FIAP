package exercicios;

import java.util.Scanner;

public class ex31 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.println("Digite um n�mero qualquer");
		int num = in.nextInt();
		
//		31. Criar uma rotina de entrada que aceite somente um valor positivo.
		
//		DO - WHILE
		do{	
			if(num < 0){
				System.out.println("N�mero inv�lido. Somente positivos s�o aceitos");
				System.out.println("Digite um n�mero qualquer");
				num = in.nextInt();
			}
		}while(num < 0);
		
//		WHILE	
		while(num < 0){
			System.out.println("N�mero inv�lido. Somente positivos s�o aceitos");
			System.out.println("Digite um n�mero qualquer");
			num = in.nextInt();
		}

	}

}
