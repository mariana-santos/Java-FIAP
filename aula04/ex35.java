package exercicios;

import java.util.Scanner;

public class ex35 {

	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
		
//		35. Entrar via teclado com um valor qualquer. Travar a digitação, no sentido de aceitar somente valores positivos. Após a digitação, exibir a tabuada do valor solicitado, no intervalo de um a dez.

		System.out.println("Digite um número qualquer");
		int num = in.nextInt();
		
//		DO - WHILE
		if(num < 0){
			do{	
				System.out.println("Número inválido. Somente positivos são aceitos");
				System.out.println("Digite um número qualquer");
				num = in.nextInt();
				if(num > 0){
					for(int i = 1; i <= 10; i++){
						System.out.println(num+" x "+ i +" = " + num * i);
					}
				}
			}while(num < 0);
		}
		
		
//		WHILE	
		while(num < 0){
			System.out.println("Número inválido. Somente positivos são aceitos");
			System.out.println("Digite um número qualquer");
			num = in.nextInt();
			
			if(num > 0){
				for(int i = 1; i <= 10; i++){
					System.out.println(num+" x "+ i +" = " + num * i);
				}
			}
		}
	}

}
