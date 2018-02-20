package net.blekkhuset.ws.model;

public class Yo
{

    private final long id;
    private final String content;

    public Yo(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
