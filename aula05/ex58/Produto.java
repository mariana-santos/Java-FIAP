package ex58;

public class Produto {
	private int id;
	private String nome;
	private double preco;
	private double quantidade;
	private Categoria categoria;
	
	Produto(int id, double preco, double quantidade, Categoria categoria){
		
	}
	
	Produto(){
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(double quantidade) {
		this.quantidade = quantidade;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	public void exibirProduto(){
		System.out.printf("id: %.d - Produto: %.s", id, nome);
		System.out.printf("Preço: %.f - Quantidade: %.d", preco, quantidade);
	}
	
	public void exibirCategoria(){
		System.out.println("Categoria: " + categoria.getNome());
	}
}
