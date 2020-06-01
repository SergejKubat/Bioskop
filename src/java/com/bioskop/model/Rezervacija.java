package com.bioskop.model;

public class Rezervacija {

    private int REZERVACIJA_ID;
    private int KORISNIK_ID;
    private int KARTA_ID;
    private String REZERVACIJA_DATUM_VREME;

    public int getREZERVACIJA_ID() {
        return REZERVACIJA_ID;
    }

    public int getKORISNIK_ID() {
        return KORISNIK_ID;
    }

    public int getKARTA_ID() {
        return KARTA_ID;
    }

    public void setREZERVACIJA_ID(int REZERVACIJA_ID) {
        this.REZERVACIJA_ID = REZERVACIJA_ID;
    }

    public void setKORISNIK_ID(int KORISNIK_ID) {
        this.KORISNIK_ID = KORISNIK_ID;
    }

    public void setKARTA_ID(int KARTA_ID) {
        this.KARTA_ID = KARTA_ID;
    }

}
