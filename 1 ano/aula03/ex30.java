package exercicios;

import java.util.Scanner;

public class ex30 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int cod, qtd;
		double preco, total;
		
		System.out.println("Digite o valor do pre�o normal em R$: ");
		preco = in.nextInt();
		
		System.out.println("C�digos de condi��o de pagamento: ");
		System.out.println("1 - � vista em dinheiro ou cheque, recebe 10% de desconto");
		System.out.println("2 - � vista no cart�o de cr�dito, recebe 15% de desconto");
		System.out.println("3 - Em duas vezes, pre�o normal de etiqueta sem juros");
		System.out.println("4 - Em quatro vezes, pre�o normal de etiqueta mais juros de 10%");
		
		System.out.println("Digite o c�digo de condi��o de pagamento: ");
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
		
		System.out.printf("Voc� pagar� %d parcela(s) de %.1f. Total: %.1f", qtd, (total / qtd), total);
	}
}
