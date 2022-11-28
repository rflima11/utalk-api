package com.rodolfo.apiwpp.service;

import com.rodolfo.apiwpp.http.ChatHttp;
import com.rodolfo.apiwpp.http.dto.request.ChatRequestDTO;

public class ChatUseCase {

    private final ChatHttp chatHttp;

    public ChatUseCase() {
        this.chatHttp = new ChatHttp();
    }

    public String criarChat(String contactId) {
        try {
            String chatId = chatHttp.createNewChat(new ChatRequestDTO(contactId));
            Thread.sleep(5);
            return chatId;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void alterarSetorChat(String chatId, String sectorId) {
        try {
            chatHttp.alterChat(chatId, sectorId);
            Thread.sleep(5);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
