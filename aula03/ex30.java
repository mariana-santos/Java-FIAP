package exercicios;

import java.util.Scanner;

public class ex30 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int cod, qtd;
		double preco, total;
		
		System.out.println("Digite o valor do preço normal em R$: ");
		preco = in.nextInt();
		
		System.out.println("Códigos de condição de pagamento: ");
		System.out.println("1 - À vista em dinheiro ou cheque, recebe 10% de desconto");
		System.out.println("2 - À vista no cartão de crédito, recebe 15% de desconto");
		System.out.println("3 - Em duas vezes, preço normal de etiqueta sem juros");
		System.out.println("4 - Em quatro vezes, preço normal de etiqueta mais juros de 10%");
		
		System.out.println("Digite o código de condição de pagamento: ");
		cod = in.nextInt();
		
		if(cod == 1) {
			total = preco - (preco * 0.1);
			qtd = 1;
		}else if(cod == 2){
			total = preco - (preco * 0.15);
			qtd = 1;
		}else if(cod == 3){
			total = preco;
			qtd = 2;
		}else{
			total = preco + (preco * 0.1);
			qtd = 4;
		}
		
		System.out.printf("Você pagará %d parcela(s) de %.1f. Total: %.1f", qtd, (total / qtd), total);
	}
}
