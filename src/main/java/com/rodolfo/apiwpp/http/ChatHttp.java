package com.rodolfo.apiwpp.http;

import com.google.gson.Gson;
import com.rodolfo.apiwpp.http.constant.ApiConstants;
import com.rodolfo.apiwpp.http.dto.request.ChatPutDTO;
import com.rodolfo.apiwpp.http.dto.request.ChatRequestDTO;
import com.rodolfo.apiwpp.http.dto.response.ChatResponseDTO;
import jodd.http.HttpResponse;

import static com.rodolfo.apiwpp.http.constant.ApiConstants.BEARER_TOKEN;
import static com.rodolfo.apiwpp.http.constant.ApiConstants.organizationId;

public class ChatHttp {

    private final String CHAT_API = ApiConstants.API_PATH.concat("/chats");

    public String createNewChat(ChatRequestDTO chatReq) throws Exception {
        Gson gson = new Gson();
        jodd.http.HttpRequest request = jodd.http.HttpRequest
                .post(CHAT_API)
                .trustAllCerts(true)
                .header("Content-Type", "application/json")
                .header("Accept", "text/plain")
                .header("Authorization", "Bearer ".concat(BEARER_TOKEN))
                .body(gson.toJson(chatReq));

        HttpResponse response = request.send();

        if (response.statusCode() == 200) {
            ChatResponseDTO chatResponseDTO = gson.fromJson(response.bodyText(), ChatResponseDTO.class);
            return chatResponseDTO.getId();
        }

        throw new RuntimeException("Não foi possível salvar o contato");
    }

    public void alterChat(String chatId, String sectorId) throws Exception {
        Gson gson = new Gson();
        jodd.http.HttpRequest request = jodd.http.HttpRequest
                .put(CHAT_API)
                .trustAllCerts(true)
                .query("organizationId", organizationId)
                .header("Content-Type", "application/json")
                .header("Accept", "text/plain")
                .header("Authorization", "Bearer ".concat(BEARER_TOKEN))
                .body(gson.toJson(new ChatPutDTO(sectorId)));

        jodd.http.HttpResponse response = request.send();

        if (response.statusCode() == 200) {
            ChatResponseDTO chatResponseDTO = gson.fromJson(response.bodyText(), ChatResponseDTO.class);
            System.out.println("CHAT ALTERADO COM SUCESSO");
        }
    }
}
