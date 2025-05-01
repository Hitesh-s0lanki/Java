package com.hitesh.springai.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class OpenAIController {

//    private OpenAiChatModel chatModel;

//    public OpenAIController(OpenAiChatModel chatModel) {
//        this.chatModel = chatModel;
//    }

    private ChatClient chatClient;

    public OpenAIController(OpenAiChatModel model) {
        this.chatClient = ChatClient.create(model);
    }

    @GetMapping("/chat")
    public String getAnswer(@RequestParam("query") String query) {

//      return chatModel.call(query);

        ChatResponse chatResponse = chatClient.prompt(query).call().chatResponse();

        System.out.println(chatResponse.getMetadata().getModel());

        String response = chatResponse.getResult().getOutput().getText();

        return response;
    }
}
