package exercicios;

import java.util.Scanner;

public class ex20 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		double p1, p2;
		
		System.out.println("Digite a primeira nota:");
		p1 = in.nextDouble();
		
		p2 = (15 - p1) / 2;
		
		System.out.printf("Você precisa de %f. na próxima nota para ser aprovado. Boa sorte!", p2);
	}
}
