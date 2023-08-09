package exercicios;

import java.util.Scanner;

public class ex01 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		double base, altura, area;
		
		System.out.printf("Digite a base: ");
		base = in.nextDouble();
		System.out.printf("Digite a altura: ");
		altura = in.nextDouble();
		
		area = base * altura;
		
		System.out.printf("Área: "+area);
	}
}
