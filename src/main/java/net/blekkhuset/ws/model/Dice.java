package net.blekkhuset.ws.model;

import java.util.concurrent.ThreadLocalRandom;

public class Dice {

    public final long id;
    public final int sizeOfDice;
    public final int amountOfDice;
    public final String command;
    public final int result;

    public Dice(long id, int amountOfDice, int sizeOfDice, String command) {
        this.id = id;
        this.amountOfDice = amountOfDice;
        this.sizeOfDice = sizeOfDice;
        this.command = command;
        this.result = roll(amountOfDice, sizeOfDice);
    }

    public Dice(long id, String command) {
        this.id = id;
        this.amountOfDice = 0;
        this.sizeOfDice = 0;
        this.command = command;
        this.result = 0;
    }


    private int roll(int amountOfDice, int sizeOfDice) {
        return ThreadLocalRandom.current().nextInt(amountOfDice, sizeOfDice * amountOfDice + 1);
    }

    public long getId() {
        return id;
    }

    public int getSizeOfDice() {
        return sizeOfDice;
    }

    public int getAmountOfDice() {
        return amountOfDice;
    }

    public String getCommand() {
        return command;
    }

    public int getResult() {
        return result;
    }
}
