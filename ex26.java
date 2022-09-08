package exercicios;

import java.util.Scanner;

public class ex26 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int numero;
		System.out.println("Digite um número");
		numero = in.nextInt();
		
		if(numero < 0) {
			System.out.printf("Triplo de "+numero+": "+ numero*3);
		}else {
			System.out.printf("Dobro de "+numero+": "+ numero*2);
		}
	}
}
