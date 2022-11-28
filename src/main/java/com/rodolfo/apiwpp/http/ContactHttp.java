package com.rodolfo.apiwpp.http;

import com.google.gson.Gson;
import com.rodolfo.apiwpp.http.constant.ApiConstants;
import com.rodolfo.apiwpp.http.dto.request.ContactDTO;
import com.rodolfo.apiwpp.http.dto.response.ContactDTOResponse;
import jodd.http.HttpResponse;

import static com.rodolfo.apiwpp.http.constant.ApiConstants.BEARER_TOKEN;

public class ContactHttp {

    private final String CONTACT_API = ApiConstants.API_PATH.concat("/contacts");

    public String saveContact(ContactDTO contato) throws Exception {
        Gson gson = new Gson();
        jodd.http.HttpRequest request = jodd.http.HttpRequest
                .post(CONTACT_API)
                .trustAllCerts(true)
                .header("Content-Type", "application/json")
                .header("Accept", "text/plain")
                .header("Authorization", "Bearer ".concat(BEARER_TOKEN))
                .body(gson.toJson(contato));

        HttpResponse response = request.send();

        if (response.statusCode() == 200) {
            ContactDTOResponse contactDTOResponse = gson.fromJson(response.bodyText(), ContactDTOResponse.class);
            return contactDTOResponse.getContact().getId();
        }

        throw new RuntimeException("Não foi possível salvar o contato");
    }
}
