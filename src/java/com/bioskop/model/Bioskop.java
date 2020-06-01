package com.bioskop.model;

public class Bioskop {

    private int BIOSKOP_ID;
    private int GRAD_ID;
    private String BIOSKOP_NAZIV;
    private String BIOSKOP_ADRESA;
    private String BIOSKOP_BR_TEL;

    public void setBIOSKOP_ID(int BIOSKOP_ID) {
        this.BIOSKOP_ID = BIOSKOP_ID;
    }

    public void setGRAD_ID(int GRAD_ID) {
        this.GRAD_ID = GRAD_ID;
    }

    public void setBIOSKOP_NAZIV(String BIOSKOP_NAZIV) {
        this.BIOSKOP_NAZIV = BIOSKOP_NAZIV;
    }

    public void setBIOSKOP_ADRESA(String BIOSKOP_ADRESA) {
        this.BIOSKOP_ADRESA = BIOSKOP_ADRESA;
    }

    public void setBIOSKOP_BR_TEL(String BIOSKOP_BR_TEL) {
        this.BIOSKOP_BR_TEL = BIOSKOP_BR_TEL;
    }

    public int getBIOSKOP_ID() {
        return BIOSKOP_ID;
    }

    public int getGRAD_ID() {
        return GRAD_ID;
    }

    public String getBIOSKOP_NAZIV() {
        return BIOSKOP_NAZIV;
    }

    public String getBIOSKOP_ADRESA() {
        return BIOSKOP_ADRESA;
    }

    public String getBIOSKOP_BR_TEL() {
        return BIOSKOP_BR_TEL;
    }

}
