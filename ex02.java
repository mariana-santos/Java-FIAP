package exercicios;

import java.util.Scanner;

public class ex02 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		double aresta, area;
		
		System.out.printf("Digite a aresta do quadrado: ");
		aresta = in.nextDouble();
		
		area = aresta * aresta;
		
		System.out.printf("Área: "+area);
		
	}
}
