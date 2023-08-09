package CP3;

public class Pessoa {
	private String nome;
	private String ra;
	
	Pessoa(){
		
	}
	
	Pessoa(String nome, String ra){
		this.nome = nome;
		this.ra = ra;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getRa() {
		return ra;
	}
	public void setRa(String ra) {
		this.ra = ra;
	}
}
