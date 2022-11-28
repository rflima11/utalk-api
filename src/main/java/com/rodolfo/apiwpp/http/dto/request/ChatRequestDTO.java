package com.rodolfo.apiwpp.http.dto.request;

import com.rodolfo.apiwpp.http.constant.ApiConstants;

public class ChatRequestDTO {

    private final String organizationId = ApiConstants.organizationId;

    private final String channelId = ApiConstants.CHANNEL_ID_ATENDIMENTO;
    private String contactId;

    public ChatRequestDTO() {


    }

    public ChatRequestDTO(String contactId) {
        this.contactId = contactId;
    }


    public String getChannelId() {
        return channelId;
    }

    public String getContactId() {
        return contactId;
    }

    public void setContactId(String contactId) {
        this.contactId = contactId;
    }

    public String getOrganizationId() {
        return organizationId;
    }
}
