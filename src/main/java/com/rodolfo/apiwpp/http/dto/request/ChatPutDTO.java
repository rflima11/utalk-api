package com.rodolfo.apiwpp.http.dto.request;

public class ChatPutDTO {

    private String sectorId;

    public ChatPutDTO() {}

    public ChatPutDTO(String sectorId) {
        this.sectorId = sectorId;
    }

    public String getSectorId() {
        return sectorId;
    }

    public void setSectorId(String sectorId) {
        this.sectorId = sectorId;
    }
}
