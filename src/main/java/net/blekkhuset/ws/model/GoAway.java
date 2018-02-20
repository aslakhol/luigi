package net.blekkhuset.ws.model;

public class GoAway
{

    private final long id;
    private final String content;

    public GoAway(long id, String content) {
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
