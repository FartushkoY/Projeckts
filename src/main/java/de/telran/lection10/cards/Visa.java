package de.telran.lection10.cards;

public class Visa extends Card {
    private int visaId;

    public Visa(int visaId) {
        this.visaId = visaId;
    }

    public int getVisaId() {
        return visaId;
    }

    @Override
    public String toString() {
        return "Visa{" +
                "visaId=" + visaId +
                '}';
    }

    @Override
    public int getId() {
        return visaId;
    }
}
