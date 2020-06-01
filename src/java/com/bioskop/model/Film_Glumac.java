package com.bioskop.model;

public class Film_Glumac {

    private int FG_ID;
    private int GLUMAC_ID;
    private int FILM_ID;
    private String FG_ULOGA;

    public int getFG_ID() {
        return FG_ID;
    }

    public int getGLUMAC_ID() {
        return GLUMAC_ID;
    }

    public int getFILM_ID() {
        return FILM_ID;
    }

    public String getFG_ULOGA() {
        return FG_ULOGA;
    }

    public void setFG_ID(int FG_ID) {
        this.FG_ID = FG_ID;
    }

    public void setGLUMAC_ID(int GLUMAC_ID) {
        this.GLUMAC_ID = GLUMAC_ID;
    }

    public void setFILM_ID(int FILM_ID) {
        this.FILM_ID = FILM_ID;
    }

    public void setFG_ULOGA(String FG_ULOGA) {
        this.FG_ULOGA = FG_ULOGA;
    }

}
