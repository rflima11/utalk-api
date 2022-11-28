package com.rodolfo.apiwpp.service;

import com.rodolfo.apiwpp.http.MessageHttp;
import com.rodolfo.apiwpp.http.dto.request.MessageRequestDTO;

import javax.swing.*;
import java.io.*;
import java.util.Base64;
import java.util.Objects;
import java.util.StringJoiner;

public class MessageUseCase {

    private final MessageHttp messageHttp;

    public MessageUseCase() {
        this.messageHttp = new MessageHttp();
    }

    public Boolean enviarMensagens(String chatId, String message, String anexoPath) {
        try {
            MessageRequestDTO msgDto = new MessageRequestDTO(chatId, false, message);

            if (Objects.nonNull(anexoPath)) {
                msgDto.setFile(anexoPath);
            }

            Boolean msgState = messageHttp.sendMessage(msgDto);
            System.out.println(msgState);
            Thread.sleep(20000);
            return msgState;
        } catch (Exception e) {
            throw new RuntimeException("Não foi possível enviar mensagem");
        }
    }
}
