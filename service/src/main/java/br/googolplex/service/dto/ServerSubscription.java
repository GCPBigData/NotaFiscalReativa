package br.googolplex.service.dto;

public class ServerSubscription {

    private String name;

    public ServerSubscription() {
    }

    public ServerSubscription(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
