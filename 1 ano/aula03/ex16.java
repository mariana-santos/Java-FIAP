package exercicios;

import java.util.Scanner;

public class ex16 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		double a, b, c, h, c1, c2;
		
		System.out.println("Digite o primeiro lado");
		a = in.nextDouble();
		System.out.println("Digite o segundo lado");
		b = in.nextDouble();
		System.out.println("Digite o terceiro lado");
		c = in.nextDouble();
		
		if ((a > b) && (a > c)){
			h = a;
		    c1 = b;
		    c2 = c;
		}else if((b > c) && (b > a)){
			h = b;
			c1 = c;
			c2 = a;
		}else{
			h = c;
			c1 = b;
			c2 = a;
		}
		
		if (h * h == (c1* c1 + c2 * c2)){
			System.out.println("É um triângulo retângulo");
		}else{
			System.out.println("Não é um triângulo retângulo");
		}

	}

}
