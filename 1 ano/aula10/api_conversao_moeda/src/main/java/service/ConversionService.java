package service;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import model.Conversion;;


public class ConversionService {
	public static Conversion getConversion(String tipo) throws ClientProtocolException, IOException {
		
		Conversion conv = null;
		
		HttpGet request = new HttpGet("https://economia.awesomeapi.com.br/json/last/" + tipo);
				
		try(CloseableHttpClient httpClient = HttpClientBuilder.create().disableRedirectHandling().build();
				
				CloseableHttpResponse response = httpClient.execute(request)) {
	           
				    HttpEntity entity = response.getEntity();
				    
				    if(entity != null) {
				        
				        String result = EntityUtils.toString(entity);  

				        Gson gson = new Gson();
				        
				        result = result.substring(10, result.length() - 1);
				        		
				        conv = gson.fromJson(result , Conversion.class);
				    }
				}
	return conv;
}
}