package com.bot.theoffice.chatgpt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;
import org.springframework.context.annotation.Configuration;

import io.github.redouane59.twitter.TwitterClient;
import io.github.redouane59.twitter.signature.TwitterCredentials;

@Configuration
	public class ChatGPT {
			
		private static String search;
		private static TwitterClient twtClient;

		public static void ChatGPT(String text) throws Exception {
			   		          
			
	        String url = "https://api.openai.com/v1/completions";
	        HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();

	        con.setRequestMethod("POST");
	        con.setRequestProperty("Content-Type", "application/json");
	        con.setRequestProperty("Authorization", "Bearer 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");

	        JSONObject data = new JSONObject();
	        data.put("model", "text-davinci-003");
	        data.put("prompt", text);
	        data.put("max_tokens", 4000);
	        data.put("temperature", 1.0);

	        con.setDoOutput(true);
	        con.getOutputStream().write(data.toString().getBytes());

	        String output = new BufferedReader(new InputStreamReader(con.getInputStream())).lines()
	                .reduce((a, b) -> a + b).get();

	       
	        search = new JSONObject(output).getJSONArray("choices").getJSONObject(0).getString("text");
	       
	       System.out.println(search);
	       

    	   System.out.println("Iniciando o bot!\nIniciando a API do Twitter...");

           twtClient = new TwitterClient(TwitterCredentials.builder()
                  .accessToken("1669128834292019201-aIYre5rhokY2kdNNgeVgNdke0zfgkZ")
                  .accessTokenSecret("wD4ZJDkdOb4iWrcGGCioFyhpV6PCwBvMrWOFUMFTPmniE")
                  .apiKey("OTPNNreluL9dmUFU9lOR6zs5K")
                  .apiSecretKey("ESBGwTPMkaYhLM5toc4NqnEfwgQt16MKUXGOhqR9j66zTynUCI")
                  .build());

          System.out.println("API iniciada com sucesso!");
          
        String run =  ChatGPT.search.toString();
          
        twtClient.postTweet(run);

	    }
		
	    
	}


