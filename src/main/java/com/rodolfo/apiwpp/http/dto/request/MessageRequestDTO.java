package com.rodolfo.apiwpp.http.dto.request;

import com.rodolfo.apiwpp.http.constant.ApiConstants;

public class MessageRequestDTO {

    private final String organizationId = ApiConstants.organizationId;
    private String chatId;
    private boolean isPrivate;
    private String messageContent;

    private String file;

    public MessageRequestDTO() {}

    public MessageRequestDTO(String chatId, boolean isPrivate, String messageContent) {
        this.chatId = chatId;
        this.isPrivate = isPrivate;
        this.messageContent = messageContent;
    }


    public String getOrganizationId() {
        return organizationId;
    }

    public String getChatId() {
        return chatId;
    }

    public void setChatId(String chatId) {
        this.chatId = chatId;
    }

    public boolean isPrivate() {
        return isPrivate;
    }

    public void setPrivate(boolean aPrivate) {
        isPrivate = aPrivate;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }
}
