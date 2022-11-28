package com.rodolfo.apiwpp.service;

import com.rodolfo.apiwpp.http.ContactHttp;
import com.rodolfo.apiwpp.http.dto.request.ContactDTO;

public class ContactUseCase {

    private final ContactHttp contactHttp;

    public ContactUseCase() {
        contactHttp = new ContactHttp();
    }

    public String saveContact(ContactDTO contactDTO) {
        try {
            String contactId = contactHttp.saveContact(contactDTO);
            Thread.sleep(5);
            return contactId;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
