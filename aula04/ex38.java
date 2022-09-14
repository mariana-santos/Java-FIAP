package exercicios;

public class ex38 {
	public static void main(String[] args) {
//		38. Exibir a soma dos números inteiros positivos do intervalo de um a cem.
		
		int i = 1, soma = 0;

		while(i <= 100){
			soma += i;
			i ++;
		}
		
		System.out.println("Soma dos 100 primeiros números com WHILE: "+soma);
		
		i = 1;
		soma = 0;
		
		do{
			soma += i;
			i ++;
		}while(i <= 100);
		
		System.out.println("Soma dos 100 primeiros números com DO WHILE: "+soma);
		
		soma = 0;
		
		for (i = 0; i <= 100; i++){
			soma += i;
		}
		
		System.out.println("Soma dos 100 primeiros números com FOR: "+soma);
	}
}
