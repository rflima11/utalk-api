package com.rodolfo.apiwpp.service;

import com.rodolfo.apiwpp.domain.Contact;
import com.rodolfo.apiwpp.http.ContactHttp;
import com.rodolfo.apiwpp.http.dto.request.ContactDTO;

import java.util.List;

public class WppService {

    private final List<Contact> contatos;
    private final ContactHttp contactHttp;

    public WppService(List<Contact> contatos) {

        this.contatos = contatos;
        this.contactHttp = new ContactHttp();
    }

    public void saveContacts() {
        contatos.stream().forEach(contact -> {
            try {
                contactHttp.saveContact(new ContactDTO(contact));
                Thread.sleep(10000);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }

    public void enviarMensagens() {
        contatos.stream().forEach(contato -> {
            try {
                // impl api enviar mensagem
                Thread.sleep(10000);

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

    }


}
