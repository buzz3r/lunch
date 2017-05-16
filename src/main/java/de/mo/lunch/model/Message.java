package de.mo.lunch.model;

public class Message {

    private final int id;

    private String message;

    public Message(int id, String message) {
        this.id = id;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public int getId() {
        return id;
    }
}
