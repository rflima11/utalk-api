package com.rodolfo.apiwpp.http;

import com.google.gson.Gson;
import com.rodolfo.apiwpp.http.constant.ApiConstants;
import com.rodolfo.apiwpp.http.dto.response.SetorInfoResponseDTO;
import jodd.http.HttpRequest;
import jodd.http.HttpResponse;

import java.util.Arrays;
import java.util.List;

import static com.rodolfo.apiwpp.http.constant.ApiConstants.BEARER_TOKEN;
import static com.rodolfo.apiwpp.http.constant.ApiConstants.organizationId;

public class SectorHttp {

    private final String SECTOR_API = ApiConstants.API_PATH.concat("/sectors");

    public List<SetorInfoResponseDTO> getSectors() {
        jodd.http.HttpRequest request = jodd.http.HttpRequest
                .get(SECTOR_API)
                .trustAllCerts(true)
                .query("organizationId", organizationId)
                .header("Accept", "text/plain")
                .header("Authorization", "Bearer ".concat(BEARER_TOKEN));

        HttpResponse response = request.send();

        Gson gson = new Gson();
        SetorInfoResponseDTO[] sectors = gson.fromJson(response.bodyText(), SetorInfoResponseDTO[].class);

        return Arrays.asList(sectors);
    }

}
