package com.rodolfo.apiwpp.http.dto.response;

import com.rodolfo.apiwpp.http.dto.request.ContactDTO;

public class ContactDTOResponse {

    private ContactDTO contact;

    public ContactDTO getContact() {
        return contact;
    }

    public void setContact(ContactDTO contact) {
        this.contact = contact;
    }
}
