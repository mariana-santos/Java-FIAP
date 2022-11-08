package CP3;

public class Aluno extends Pessoa{
	
	private String curso;
	
	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public Aluno(){
		
	}
	
	public Aluno(String nome, String ra, String curso){
		super(nome, ra);
		this.curso = curso;
	}
}
