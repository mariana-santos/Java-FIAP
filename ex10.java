package exercicios;

import java.util.Scanner;

public class ex10 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		double n1, n2;
		
		System.out.println("digite o primeiro número: ");
		n1 = in.nextDouble();
		System.out.println("digite o segundo número: ");
		n2 = in.nextDouble();

		if (n1 > n2){
			System.out.println(n1+" maior");
		}
		else if(n1 < n2){
			System.out.println(n2+" maior");
		}
		else {
			System.out.println("números iguais");
		}
	}
}
