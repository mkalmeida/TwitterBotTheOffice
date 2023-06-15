/*package com.bot.theoffice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.bot.theoffice.twitter.BotTweet;
import com.cjcrafter.openai.OpenAI;
import com.cjcrafter.openai.chat.ChatMessage;
import com.cjcrafter.openai.chat.ChatRequest;
import com.cjcrafter.openai.chat.ChatResponse;
import com.cjcrafter.openai.exception.OpenAIError;

public class TheOffice {
	
	public static void main(String[] args) throws OpenAIError {
		 Scanner scan = new Scanner(System.in);
		 
		 BotTweet bootTweet = new BotTweet();
		 
		ChatMessage prompt = ChatMessage.toSystemMessage("You are a customer support chat-bot. Write brief summaries of the user's questions so that agents can easily find the answer in a database.");

        // Use a mutable (modifiable) list! Always! You should be reusing the
        // ChatRequest variable, so in order for a conversation to continue
        // you need to be able to modify the list.
        List<ChatMessage> messages = new ArrayList<>(Collections.singletonList(prompt));

        // ChatRequest is the request we send to OpenAI API. You can modify the
        // model, temperature, maxTokens, etc. This should be saved, so you can
        // reuse it for a conversation.
        ChatRequest request = ChatRequest.builder()
                .model("gpt-3.5-turbo")
                .messages(messages).build();
 

        // Loads the API key from the .env file in the root directory.
        String key = "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";
        OpenAI openai = new OpenAI(key);

        // The conversation lasts until the user quits the program
        while (true) {

            // Prompt the user to enter a response
            System.out.println("Enter text below:\n\n");
            String input = scan.nextLine();

            // Add the newest user message to the conversation
           messages.add(ChatMessage.toUserMessage(input));

            System.out.println("Generating Response");
           
           
		openai.streamChatCompletionAsync(request, response -> System.out.print(response.get(0).getDelta().toString()));
          
		//System.out.println(response);

      //  BotTweet.getTwtClient().postTweet();
                        
        }
       
        
	}

	
	
	
}*/

