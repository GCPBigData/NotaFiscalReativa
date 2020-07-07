package br.googolplex.client.dto;

/**
 * @author Jose R F Junior
 * web2ajax@gmail.com
 * Santiago Chile 07/07/2020
 */
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
