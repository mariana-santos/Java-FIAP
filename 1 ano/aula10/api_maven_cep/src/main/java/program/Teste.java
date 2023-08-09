package program;


import java.io.IOException;
import java.util.Scanner;

import model.Endereco;
import service.ViaCepService;

public class Teste {


    public static void main(String[] args) {


        ViaCepService viacepservice = new ViaCepService();
        Scanner in = new Scanner(System.in);

        try {
            
            System.out.println("Por favor, digite o seu CEP com 8 caracteres.");
            String cep = in.next();
            
            while(cep.length() <= 0){
            	System.out.println("Valor do CEP não pode ser vazio. "
            			+ "Digite novamente o CEP.");
            	cep = in.next();
            }
            
            //removendo espaços, traços e pontos da string
            cep.trim().replaceAll("-", "").replaceAll(".", "");
            
            Endereco endereco = viacepservice.getEndereco(cep);
           
            String ddd = endereco.getDdd();
            String uf = endereco.getUf();
            String logradouro = endereco.getLogradouro();
            String bairro = endereco.getBairro();
            String complemento = endereco.getComplemento();
            String localidade = endereco.getLocalidade();
            String gia = endereco.getGia();
            String ibge = endereco.getIbge();
            String siafi = endereco.getSiafi();
            
//            System.out.println("UF: "+ uf + " -  DDD: " + ddd);
            System.out.println("Localidade: " + localidade + " - " + uf);
            System.out.println("Bairro: " + bairro);
            System.out.println("Logradouro: " + logradouro);
//            if(complemento != null) System.out.println("Complemento: " + complemento);
//            System.out.println("Gia: " + gia);
//            System.out.println("IBGE: " + ibge);
//            System.out.println("Siafi: " + siafi);
           
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }  
    }
}
