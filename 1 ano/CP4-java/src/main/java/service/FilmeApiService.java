package service;

import java.io.IOException;
import java.util.HashMap;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;


import model.Filme;

public class FilmeApiService {
	public HashMap<Integer, Filme> getFilmes() throws ClientProtocolException, IOException, JSONException {

	    HashMap<Integer, Filme> listaFilmes = new HashMap<>();
	    HttpGet request = new HttpGet("https://sujeitoprogramador.com/r-api/?api=filmes");

	    try (CloseableHttpClient httpClient = HttpClientBuilder.create().disableRedirectHandling().build();

	            CloseableHttpResponse response = httpClient.execute(request)) {

	        HttpEntity entity = response.getEntity();

	        if (entity != null) {

	            String result = EntityUtils.toString(entity);

	            JSONArray jsonArray = new JSONArray(result);

	            for (int i = 0; i < jsonArray.length(); i++) {
	                JSONObject payload = jsonArray.getJSONObject(i);

	                Filme filme = new Filme();

	                int id = payload.getInt("id");
	                filme.setId(id);

	                String nome = payload.getString("nome");
	                filme.setNome(nome);

	                String sinopse = payload.getString("sinopse");
	                filme.setSinopse(sinopse);
	                
	                listaFilmes.put(id, filme);

	            }
	        }
	    }

	    return listaFilmes;
	}

}
