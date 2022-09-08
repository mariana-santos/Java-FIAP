package exercicios;

import java.util.Scanner;

public class ex07 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		double total = 0, pago, troco;
		
		for(int i = 0; i < 5; i++) {
			System.out.println("Digite o valor do "+ (i+1) +"° produto");
			total += in.nextDouble();
		}
		System.out.printf("Digite o valor pago nos produtos: ");
		
		pago = in.nextDouble();
		troco = pago - total;
		
		System.out.printf("Total: R$%.2f; Valor pago R$%.2f; Troco R$%.2f", total, pago, troco);
	}
}
