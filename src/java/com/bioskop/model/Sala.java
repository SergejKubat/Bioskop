package com.bioskop.model;

public class Sala {

    private int SALA_ID;
    private int BIOSKOP_ID;
    private String SALA_NAZIV;

    public int getSALA_ID() {
        return SALA_ID;
    }

    public int getBIOSKOP_ID() {
        return BIOSKOP_ID;
    }

    public String getSALA_NAZIV() {
        return SALA_NAZIV;
    }

    public void setSALA_ID(int SALA_ID) {
        this.SALA_ID = SALA_ID;
    }

    public void setBIOSKOP_ID(int BIOSKOP_ID) {
        this.BIOSKOP_ID = BIOSKOP_ID;
    }

    public void setSALA_NAZIV(String SALA_NAZIV) {
        this.SALA_NAZIV = SALA_NAZIV;
    }

}
