package com.company;

import java.util.Vector;

public class Category<E extends Data> {
    //classe riservata alla gestione della categoria Category

    private String nomeCat; //nome categoria
    private Vector<Data> datiCat;  //dati categoria
    private Vector<String> amici;

    public Category(String nomeCat) { //non c'è bisogno di passare niente perche c'è gia la stringa nel metodo createCategory
        this.nomeCat = nomeCat;
        datiCat = new Vector<Data>();   //inizializzo il vettore dei dati a vuoto
        amici = new Vector<String>();
    }

    public String getNomeCat() {
        return nomeCat;
    }

    public void setNomeCat(String nomeCat) {
        this.nomeCat = nomeCat;
    }

    public void setDatiCat(Vector<Data> datiCat) {
        this.datiCat = datiCat;
    }

    public void setAmici(Vector<String> amici) {
        this.amici = amici;
    }

    public Vector<Data> getDatiCat() {
        return datiCat;
    }

    public Vector<String> getAmici() {
        return amici;
    }
}
