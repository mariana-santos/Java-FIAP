package program;

import java.io.IOException;
import java.util.Scanner;
import model.Conversion;
import service.ConversionService;

public class App {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		try {
			System.out.println("Conversor de moedas \n"
					+ "Digite o valor em R$ que deseja converter");
			
			double reais = in.nextDouble();
			
			while(reais <= 0){
				System.out.println("O valor em R$ não pode ser 0. "
						+ "Por favor, digite um valor válido");
				
				reais = in.nextDouble();
			}
			
			System.out.println("Dentre as seguintes opções, "
					+ "digite o valor da moeda escolhida para a conversão.\n \n"
					+ "1. Dólar \n"
					+ "2. Euro \n"
					+ "3. Bitcoin \n");
			
			int opcao = in.nextInt();
			
			while(opcao <= 0 || opcao > 3){
				System.out.println("Opção inválida."
						+ "Por favor, digite novamente uma opção"
						+ "1. Dólar \n"
						+ "2. Euro \n"
						+ "3. Bitcoin \n");
				
				opcao = in.nextInt();
			}
			
			Conversion conv = null;
			
			if(opcao == 1)
				conv = ConversionService.getConversion("USD-BRL");
			else if(opcao == 2)
				conv = ConversionService.getConversion("EUR-BRL");
			else 
				conv = ConversionService.getConversion("BTC-BRL");
			
			Double r = Double.parseDouble(conv.getAsk()) * reais;
			
			System.out.println("\n---Resultado conversão " + conv.getName() + "---\n");
			System.out.printf(conv.getCodein() + ": %.2f", reais);
			System.out.println();
			System.out.printf(conv.getCode() + ": %.2f", r);
			
		} catch (IOException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }
	}
}
