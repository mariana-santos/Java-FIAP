package exercicios;

import java.util.Scanner;

public class ex04 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		double n1, n2, n3, n4, media;
		
		System.out.printf("Digite o primeiro número: ");
		n1 = in.nextDouble();
		System.out.printf("Digite o segundo número: ");
		n2 = in.nextDouble();
		System.out.printf("Digite o terceiro número: ");
		n3 = in.nextDouble();
		System.out.printf("Digite o quarto número: ");
		n4 = in.nextDouble();
		
		media = (n1 + n2 + n3 + n4) / 4;
		
		System.out.printf("A média dos números é %.2f", media);
	}
}
