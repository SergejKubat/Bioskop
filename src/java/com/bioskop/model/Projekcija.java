package com.bioskop.model;

public class Projekcija {

    private int PROJEKCIJA_ID;
    private int FILM_ID;
    private int SALA_ID;
    private String PROJEKCIJA_DATUM_VREME;

    public int getPROJEKCIJA_ID() {
        return PROJEKCIJA_ID;
    }

    public int getFILM_ID() {
        return FILM_ID;
    }

    public int getSALA_ID() {
        return SALA_ID;
    }

    public void setPROJEKCIJA_ID(int PROJEKCIJA_ID) {
        this.PROJEKCIJA_ID = PROJEKCIJA_ID;
    }

    public void setFILM_ID(int FILM_ID) {
        this.FILM_ID = FILM_ID;
    }

    public void setSALA_ID(int SALA_ID) {
        this.SALA_ID = SALA_ID;
    }

}
