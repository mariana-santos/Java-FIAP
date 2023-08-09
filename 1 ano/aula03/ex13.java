package exercicios;

import java.util.Scanner;

public class ex13 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int maior, n2, n3;
		
		System.out.println("Insira o primeiro número: ");
		maior = in.nextInt();
		
		System.out.println("Insira o segundo número: ");
		n2 = in.nextInt();
		
		System.out.println("Insira o terceiro número: ");
		n3 = in.nextInt();
		
		if(n2 > maior && n2 > n3) {
			maior = n2;
		}else if(n3 > maior && n3 > n2){
			maior = n3;
		}
		
		System.out.println("Maior número: "+maior);
	}
}
