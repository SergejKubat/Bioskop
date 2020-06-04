
package com.bioskop.model;

public class Klub {
    private int KLUB_ID;
    private String KLUB_NAZIV;
    private String KLUB_POGODNOSTI;
    private float KLUB_CLANARINA;
    private String SLIKA_KLUBA;

    public void setSLIKA_KLUBA(String SLIKA_KLUBA) {
        this.SLIKA_KLUBA = SLIKA_KLUBA;
    }

    public String getSLIKA_KLUBA() {
        return SLIKA_KLUBA;
    }

    public int getKLUB_ID() {
        return KLUB_ID;
    }

    public String getKLUB_NAZIV() {
        return KLUB_NAZIV;
    }

    public String getKLUB_POGODNOSTI() {
        return KLUB_POGODNOSTI;
    }

    public float getKLUB_CLANARINA() {
        return KLUB_CLANARINA;
    }

    public void setKLUB_ID(int KLUB_ID) {
        this.KLUB_ID = KLUB_ID;
    }

    public void setKLUB_NAZIV(String KLUB_NAZIV) {
        this.KLUB_NAZIV = KLUB_NAZIV;
    }

    public void setKLUB_POGODNOSTI(String KLUB_POGODNOSTI) {
        this.KLUB_POGODNOSTI = KLUB_POGODNOSTI;
    }

    public void setKLUB_CLANARINA(float KLUB_CLANARINA) {
        this.KLUB_CLANARINA = KLUB_CLANARINA;
    }
    
    
}

