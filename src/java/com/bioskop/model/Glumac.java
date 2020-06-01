package com.bioskop.model;

import java.sql.Date;

public class Glumac {

    private int GLUMAC_ID;
    private String GLUMAC_IME;
    private String GLUMAC_PREZIME;
    private Date GLUMAC_DATUM_RODJENJA;

    public int getGLUMAC_ID() {
        return GLUMAC_ID;
    }

    public String getGLUMAC_IME() {
        return GLUMAC_IME;
    }

    public String getGLUMAC_PREZIME() {
        return GLUMAC_PREZIME;
    }

    public Date getGLUMAC_DATUM_RODJENJA() {
        return GLUMAC_DATUM_RODJENJA;
    }

    public void setGLUMAC_ID(int GLUMAC_ID) {
        this.GLUMAC_ID = GLUMAC_ID;
    }

    public void setGLUMAC_IME(String GLUMAC_IME) {
        this.GLUMAC_IME = GLUMAC_IME;
    }

    public void setGLUMAC_PREZIME(String GLUMAC_PREZIME) {
        this.GLUMAC_PREZIME = GLUMAC_PREZIME;
    }

    public void setGLUMAC_DATUM_RODJENJA(Date GLUMAC_DATUM_RODJENJA) {
        this.GLUMAC_DATUM_RODJENJA = GLUMAC_DATUM_RODJENJA;
    }

}
