package exercicios;

import java.util.Scanner;

public class ex23 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int a, b, c;
		
		System.out.println("Digite o valor de A");
		a = in.nextInt();
		
		System.out.println("Digite o valor de B");
		b = in.nextInt();
		
		System.out.println("Digite o valor de C");
		c = in.nextInt();
		
		if((a + b) < c) {
			System.out.println("A soma de A + B é menor que C");
		}
	}
}
