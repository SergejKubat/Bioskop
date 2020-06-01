
package com.bioskop.model;

public class Karta {
   private int KARTA_ID;
   private int PROJEKCIJA_ID;
   private float KARTA_CENA;

    public int getKARTA_ID() {
        return KARTA_ID;
    }

    public int getPROJEKCIJA_ID() {
        return PROJEKCIJA_ID;
    }

    public float getKARTA_CENA() {
        return KARTA_CENA;
    }

    public void setKARTA_ID(int KARTA_ID) {
        this.KARTA_ID = KARTA_ID;
    }

    public void setPROJEKCIJA_ID(int PROJEKCIJA_ID) {
        this.PROJEKCIJA_ID = PROJEKCIJA_ID;
    }

    public void setKARTA_CENA(float KARTA_CENA) {
        this.KARTA_CENA = KARTA_CENA;
    }
   
   
}
