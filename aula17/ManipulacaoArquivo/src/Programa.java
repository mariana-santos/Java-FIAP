import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Programa {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);

		System.out.println("Escrita de produtos em um arquivo txt: \n\n");
		
		String[] produtos = new String[10];
		
		for (int i = 0; i < 10; i++){
			Produto prod = new Produto();
			
			System.out.println("Cadastro do " + (i+1) +"°: \n");
			
			System.out.println("Por favor, digite o nome do produto");
			prod.setNome(in.next());
			
			System.out.println("Por favor, digite a quantidade unitária do produto");
			prod.setQtd(in.nextInt());
			
			System.out.println("Por favor, digite o preço do produto");
			prod.setPreco(in.nextDouble());
			
			produtos[i] = prod.dados();
		}
		
		String path = "C:\\Users\\logonrmlocal\\Desktop\\produtos.txt";
		
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(path))){
			for(String produto: produtos){
				bw.write(produto);
				bw.newLine();
			}
		}catch(IOException e){
			e.printStackTrace();
		}
		
		
	}
}
