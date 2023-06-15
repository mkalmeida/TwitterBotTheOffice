package com.bot.theoffice.application;

import java.time.LocalTime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.bot.theoffice.chatgpt.ChatGPT;

@SpringBootApplication(scanBasePackages = {"com.bot.theoffice.application","com.bot.theoffice.chatgpt" })
@EnableScheduling
@ComponentScan({"com.bot.theoffice.chatgpt"})
public class TheofficeApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(TheofficeApplication.class, args);	
	}
	
	@Scheduled(cron = "0/10 24 7 * * *")
    public static void execute() throws Exception{
		ChatGPT.ChatGPT("tell me a quote by the office");;
    	System.out.println("rodando: " + LocalTime.now());
    	//Thread.sleep(4000);
    	//System.out.println("finalizando: " + LocalTime.now());
    }

}
