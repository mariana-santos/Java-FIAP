package exercicios;

import java.util.Scanner;

public class ex28 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int a, b, c;
		
		System.out.println("Insira o primeiro número: ");
		a = in.nextInt();
		
		System.out.println("Insira o segundo número: ");
		b = in.nextInt();
		
		System.out.println("Insira o terceiro número: ");
		c = in.nextInt();
		
		if((a <= b && b <= c)) {
			System.out.printf("A ordem crescente: %d, %d, %d", a, b, c);
		}else if(a <= c && c <= b){
			System.out.printf("A ordem crescente: %d, %d, %d", a, c, b);
		}else if(b <= a && a <= c){
			System.out.printf("A ordem crescente: %d, %d, %d", b, a, c);
		}else if(b <= c && c <= a){
			System.out.printf("A ordem crescente: %d, %d, %d", b, c, a);
		}else if(c <= a && a <= b){
			System.out.printf("A ordem crescente: %d, %d, %d", c, a, b);
		}else{
			System.out.printf("A ordem crescente: %d, %d, %d", c, b, a);
		}
		
	}
}
