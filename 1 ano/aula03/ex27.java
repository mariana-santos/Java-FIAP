package exercicios;

import java.util.Scanner;

public class ex27 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int numero;
		numero = in.nextInt();
		
		if(numero % 2 == 0) {
			System.out.println("Número par - "+(numero + 5));
		}else {
			System.out.println("Número ímpar - "+(numero + 8));
		}
	}
}
