package exercicios;

import java.util.Scanner;

public class ex37 {

	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
		
//		37. Exibir a tabuada dos valores de um a vinte, no intervalo de um a dez. Entre as tabuadas, solicitar que o usuário pressione uma tecla.

	
		int i = 1, numero = 1;
		
		 while(numero <= 20){
			 System.out.println("Tabuada de "+numero+" com while");
			 while(i <= 10){
				 System.out.println(i+" x "+ numero +" = " + numero * i);
				 i++;
			 }
			 if(numero != 20){
				 System.out.println("Digite qualquer número para continuar");
				 int n = in.nextInt();
			 }
			 numero++;
			 i = 1;
		 }
		 
		 i = 1; numero = 1;
//		 
//		 //cálculo com do while
		 do{
			 System.out.println("Tabuada de "+numero+" com DO WHILE");
			 while(i <= 10){
				 System.out.println(i+" x "+ numero +" = " + numero * i);
				 i++;
			 }
			 if(numero != 20){
				 System.out.println("Digite qualquer número para continuar");
				 int n = in.nextInt();
			 }
			 numero++;
			 i = 1;
		 }while(numero <= 20);
		 
		 
		 //cálculo com for
		 for(numero = 1; numero <= 20; numero++){
			 System.out.println("Tabuada de "+numero+" com FOR");
			 for(i = 1; i <= 10; i++){
				 System.out.println(i+" x "+ numero +" = " + numero * i);
			 }
			 if(numero != 20){
				 System.out.println("Digite qualquer número para continuar");
				 int n = in.nextInt();
			 }
		 }
	}

}
