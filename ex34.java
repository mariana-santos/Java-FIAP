package exercicios;

import java.util.Scanner;

public class ex34 {

	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
		
		int i = 1;
		
//		34. Exibir a tabuada do número cinco no intervalo de um a dez.

//		DO - WHILE
		System.out.println("Tabuada do 5 com DO WHILE");
		do{	
			System.out.println("5 x "+ i +" = " + 5 * i);
			i++;
		}while(i <= 10);
		
		i = 0;
//		WHILE
		System.out.println("Tabuada do 5 com WHILE");
		while(i <= 10){
			System.out.println("5 x "+ i +" = " + 5 * i);
			i++;
		}
		
//		FOR
		System.out.println("Tabuada do 5 com FOR");
		for(int c = 1; c <= 10; c++){
			System.out.println("5 x "+ c +" = " + 5 * c);
		}

	}

}
