package com.bioskop.model;

import java.sql.Date;

public class Korisnik_Klub {

    private int KK_ID;
    private int KORISNIK_ID;
    private int KLUB_ID;
    private Date KK_DATUM_UCLANJENJA;

    public int getKK_ID() {
        return KK_ID;
    }

    public int getKORISNIK_ID() {
        return KORISNIK_ID;
    }

    public int getKLUB_ID() {
        return KLUB_ID;
    }

    public Date getKK_DATUM_UCLANJENJA() {
        return KK_DATUM_UCLANJENJA;
    }

    public void setKK_ID(int KK_ID) {
        this.KK_ID = KK_ID;
    }

    public void setKORISNIK_ID(int KORISNIK_ID) {
        this.KORISNIK_ID = KORISNIK_ID;
    }

    public void setKLUB_ID(int KLUB_ID) {
        this.KLUB_ID = KLUB_ID;
    }

    public void setKK_DATUM_UCLANJENJA(Date KK_DATUM_UCLANJENJA) {
        this.KK_DATUM_UCLANJENJA = KK_DATUM_UCLANJENJA;
    }

}
