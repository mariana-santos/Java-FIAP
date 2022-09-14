package exercicios;

import java.util.Scanner;

public class ex06 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		double r, d;
		
		System.out.printf("Digite a quantidade de dinheiro em R$ ");
		r = in.nextInt();
		
		d = r * 5.06;
		
		System.out.printf("R$%.2f em equivalem a $%.2f dólares", r, d);
	}
}
