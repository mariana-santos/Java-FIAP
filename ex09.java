package exercicios;

import java.util.Scanner;

public class ex09 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		double n1, n2;
		
		System.out.println("digite o primeiro número: ");
		n1 = in.nextDouble();
		System.out.println("digite o segundo número: ");
		n2 = in.nextDouble();

		if (n1 < n2){
			System.out.println(n1+" menor");
		}
		else {
			System.out.println(n2+" menor");
		}
	}
}
