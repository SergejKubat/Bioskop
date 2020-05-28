package com.bioskop.model;

public class Film {
    
    private int id;
    private String naziv;
    private int godina;
    private String opis;
    private String slika;
    private String trejler;

    public Film() {
    }

    public Film(int id, String naziv, int godina, String opis, String slika, String trejler) {
        this.id = id;
        this.naziv = naziv;
        this.godina = godina;
        this.opis = opis;
        this.slika = slika;
        this.trejler = trejler;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getGodina() {
        return godina;
    }

    public void setGodina(int godina) {
        this.godina = godina;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getSlika() {
        return slika;
    }

    public void setSlika(String slika) {
        this.slika = slika;
    }

    public String getTrejler() {
        return trejler;
    }

    public void setTrejler(String trejler) {
        this.trejler = trejler;
    }
    
}
