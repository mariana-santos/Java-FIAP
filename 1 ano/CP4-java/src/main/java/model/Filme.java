package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Filme {
	private int id;
	private String nome;
	private String sinopse;
	private String url;
	List<Map<String , String>> comentarios = new ArrayList<Map<String,String>>();
	
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
	public String getSinopse() {
		return sinopse;
	}
	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public List<Map<String, String>> getComentarios() {
		return comentarios;
	}
	public void setComentarios(List<Map<String, String>> comentarios) {
		this.comentarios = comentarios;
	}
	
	public void novo_comentario(String nome, String comentario_str) {
		Map<String,String> comentario = new HashMap<String, String>();
		
		int id = comentarios.size() + 1;
		comentario.put("id", Integer.toString(id));
		comentario.put("nome", nome);
		comentario.put("comentario", comentario_str);
		
		comentarios.add(comentario);
	}
	
	public void mostrarComentarios() {
		for (Map<String, String> comentario : comentarios) {
	        System.out.println(comentario.get("id") + " - " + comentario.get("nome"));
	        System.out.println(comentario.get("comentario"));
	    }
	}
	
	public boolean ExcluirComentario(int id) {
		
		Iterator<Map<String, String>> i = comentarios.iterator();
		while (i.hasNext()) {
		   Map<String, String> comentario = i.next();
		   
		   if(comentario.get("id").contentEquals(Integer.toString(id))) {
			   i.remove();
			   return true;
		   }
		}
		
		return false;
	}
}
