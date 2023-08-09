package exercicios;

import java.util.Scanner;

public class ex03 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		double base, altura, area;
		
		System.out.printf("Digite a base do triângulo: ");
		base = in.nextDouble();
		System.out.printf("Digite a altura do triângulo: ");
		altura = in.nextDouble();
		
		area = (base*altura) / 2;
		
		System.out.printf("Área: "+area);
	}
}
