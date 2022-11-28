package com.rodolfo.apiwpp.service;

import com.rodolfo.apiwpp.domain.Contact;
import com.rodolfo.apiwpp.http.dto.request.ContactDTO;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Objects;

public class EnviarMensagensUseCase {

    private final ChatUseCase chatUseCase;
    private final MessageUseCase messageUseCase;
    private final ContactUseCase contactUseCase;
    private final CsvService csvService;

    public EnviarMensagensUseCase() {
        this.csvService = new CsvService();
        messageUseCase = new MessageUseCase();
        chatUseCase = new ChatUseCase();
        contactUseCase = new ContactUseCase();
    }

    public void execute(String message, String sectorId, File anexo, File csvContacts) {
        List<Contact> contacts = csvService.readCsv(csvContacts);
        contacts.stream().forEach(contato -> {
            String contactId = contactUseCase.saveContact(new ContactDTO(contato));
            String chatId = chatUseCase.criarChat(contactId);
            Boolean isMsgEnviada = messageUseCase.enviarMensagens(chatId, message, Objects.nonNull(anexo) ? anexo.getAbsolutePath() : null);
            if (isMsgEnviada) {
                chatUseCase.alterarSetorChat(chatId, sectorId);
            }
        });

    }
}
