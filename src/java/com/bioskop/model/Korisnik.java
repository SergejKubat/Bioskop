package com.bioskop.model;

public class Korisnik {

    private int KORISNIK_ID;
    private int ROLA_ID;
    private String KORISNIK_IME;
    private String KORISNIK_PREZIME;
    private String KORISNIK_EMAIL;
    private String KORISNIK_BR_TEL;
    private int KORISNIK_POENI;
    private String KORISNIK_LOZINKA;

    public Korisnik() {
    }

    public Korisnik(int KORISNIK_ID, int ROLA_ID, String KORISNIK_IME, String KORISNIK_PREZIME, String KORISNIK_EMAIL, String KORISNIK_BR_TEL, int KORISNIK_POENI, String KORISNIK_LOZINKA) {
        this.KORISNIK_ID = KORISNIK_ID;
        this.ROLA_ID = ROLA_ID;
        this.KORISNIK_IME = KORISNIK_IME;
        this.KORISNIK_PREZIME = KORISNIK_PREZIME;
        this.KORISNIK_EMAIL = KORISNIK_EMAIL;
        this.KORISNIK_BR_TEL = KORISNIK_BR_TEL;
        this.KORISNIK_POENI = KORISNIK_POENI;
        this.KORISNIK_LOZINKA = KORISNIK_LOZINKA;
    }

    public int getKORISNIK_ID() {
        return KORISNIK_ID;
    }

    public int getROLA_ID() {
        return ROLA_ID;
    }

    public String getKORISNIK_IME() {
        return KORISNIK_IME;
    }

    public String getKORISNIK_PREZIME() {
        return KORISNIK_PREZIME;
    }

    public String getKORISNIK_EMAIL() {
        return KORISNIK_EMAIL;
    }

    public String getKORISNIK_BR_TEL() {
        return KORISNIK_BR_TEL;
    }

    public int getKORISNIK_POENI() {
        return KORISNIK_POENI;
    }

    public String getKORISNIK_LOZINKA() {
        return KORISNIK_LOZINKA;
    }

    public void setKORISNIK_ID(int KORISNIK_ID) {
        this.KORISNIK_ID = KORISNIK_ID;
    }

    public void setROLA_ID(int ROLA_ID) {
        this.ROLA_ID = ROLA_ID;
    }

    public void setKORISNIK_IME(String KORISNIK_IME) {
        this.KORISNIK_IME = KORISNIK_IME;
    }

    public void setKORISNIK_PREZIME(String KORISNIK_PREZIME) {
        this.KORISNIK_PREZIME = KORISNIK_PREZIME;
    }

    public void setKORISNIK_EMAIL(String KORISNIK_EMAIL) {
        this.KORISNIK_EMAIL = KORISNIK_EMAIL;
    }

    public void setKORISNIK_BR_TEL(String KORISNIK_BR_TEL) {
        this.KORISNIK_BR_TEL = KORISNIK_BR_TEL;
    }

    public void setKORISNIK_POENI(int KORISNIK_POENI) {
        this.KORISNIK_POENI = KORISNIK_POENI;
    }

    public void setKORISNIK_LOZINKA(String KORISNIK_LOZINKA) {
        this.KORISNIK_LOZINKA = KORISNIK_LOZINKA;
    }

}
