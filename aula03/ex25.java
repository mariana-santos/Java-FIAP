package exercicios;

import java.util.Scanner;

public class ex25 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int numero;
		numero = in.nextInt();
		
		if(numero % 2 == 0) {
			System.out.println("Número par");
		}else {
			System.out.println("Número ímpar");
		}
	}
}
