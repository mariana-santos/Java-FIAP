package exercicios;

import java.util.Scanner;

public class ex05 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int c, f;
		
		System.out.printf("Digite os graus em °C: ");
		c = in.nextInt();
		
		f = (c * 9/5) + 32;
		
		System.out.println(c + "°C equivalem a "+ f + "F");
	}
}
