package com.rodolfo.apiwpp.http;

import com.rodolfo.apiwpp.http.constant.ApiConstants;
import com.rodolfo.apiwpp.http.dto.request.MessageRequestDTO;
import jodd.http.HttpRequest;
import jodd.http.HttpResponse;

import java.io.File;
import java.util.Objects;

import static com.rodolfo.apiwpp.http.constant.ApiConstants.BEARER_TOKEN;

public class MessageHttp {

    private final String MESSAGE_API = ApiConstants.API_PATH.concat("/messages");

    public Boolean sendMessage(MessageRequestDTO messageReq) throws Exception {
        HttpRequest request = HttpRequest
                .post(MESSAGE_API)
                .trustAllCerts(true)
                .header("Content-Type", "multipart/form-data")
                .header("Accept", "text/plain")
                .header("Authorization", "Bearer ".concat(BEARER_TOKEN))
                .form("ChatId", messageReq.getChatId(),
                        "IsPrivate", messageReq.isPrivate(),
                         "Message", messageReq.getMessageContent(),
                        "OrganizationId", messageReq.getOrganizationId());

        if (Objects.nonNull(messageReq.getFile())) {
            request.form("File", new File(messageReq.getFile()));
        }

        HttpResponse response = request.send();

        System.out.println(response);

        return false;
    }
}
