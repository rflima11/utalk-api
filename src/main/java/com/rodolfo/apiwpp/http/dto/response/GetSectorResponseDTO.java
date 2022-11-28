package com.rodolfo.apiwpp.http.dto.response;

import java.util.List;

public class GetSectorResponseDTO {

    private List<SetorInfoResponseDTO> sectors;


    public List<SetorInfoResponseDTO> getSectors() {
        return sectors;
    }

    public void setSectors(List<SetorInfoResponseDTO> sectors) {
        this.sectors = sectors;
    }
}
