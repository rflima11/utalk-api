package com.rodolfo.apiwpp.http.dto.request;

import com.rodolfo.apiwpp.domain.Contact;
import com.rodolfo.apiwpp.http.constant.ApiConstants;

public class ContactDTO {

    private String id;

    private final String organizationId = ApiConstants.organizationId;;
    private String name;
    private String phoneNumber;


    public ContactDTO() {}

    public ContactDTO(Contact entity) {
        this.name = entity.getName();
        this.phoneNumber = entity.getTelefone();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrganizationId() {
        return organizationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
