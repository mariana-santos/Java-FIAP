package CP3;

public class Coordenador extends Pessoa{
	
	private String cursos[];
	
	public Coordenador(){
		
	}
	
	public Coordenador(String nome, String ra, String disciplinas[]){
		super(nome, ra);
		this.cursos = disciplinas;
	}

	public String[] getCursos() {
		return cursos;
	}

	public void setCursos(String[] disciplinas) {
		this.cursos = disciplinas;
	}
}
