package com.rodolfo.apiwpp.domain;

import com.opencsv.bean.CsvBindByName;

public class Contact {

    @CsvBindByName(column = "Name", required = true)
    private String name;

    @CsvBindByName(column = "Telefone", required = true)
    private String telefone;

    public Contact() {}

    public Contact(String name, String telefone) {
        this.name = name;
        this.telefone = telefone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
