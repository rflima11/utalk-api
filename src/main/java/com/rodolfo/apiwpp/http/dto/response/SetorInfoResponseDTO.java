package com.rodolfo.apiwpp.http.dto.response;

public class SetorInfoResponseDTO {

    private String id;
    private Long order;
    private String name;

    public SetorInfoResponseDTO() {

    }


    public SetorInfoResponseDTO(String id, Long order, String name) {
        this.id = id;
        this.order = order;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getOrder() {
        return order;
    }

    public void setOrder(Long order) {
        this.order = order;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
