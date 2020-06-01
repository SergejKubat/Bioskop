package com.bioskop.model;

public class Sediste {

    private int SEDISTE_ID;
    private int SALA_ID;
    private int BROJ_REDA;
    private short SLOBODNO;

    public int getSEDISTE_ID() {
        return SEDISTE_ID;
    }

    public int getSALA_ID() {
        return SALA_ID;
    }

    public int getBROJ_REDA() {
        return BROJ_REDA;
    }

    public short getSLOBODNO() {
        return SLOBODNO;
    }

    public void setSEDISTE_ID(int SEDISTE_ID) {
        this.SEDISTE_ID = SEDISTE_ID;
    }

    public void setSALA_ID(int SALA_ID) {
        this.SALA_ID = SALA_ID;
    }

    public void setBROJ_REDA(int BROJ_REDA) {
        this.BROJ_REDA = BROJ_REDA;
    }

    public void setSLOBODNO(short SLOBODNO) {
        this.SLOBODNO = SLOBODNO;
    }

}
