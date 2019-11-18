package com.company;

public class Data implements Comparable<Data> {
    //classe riservata a gestire il singolo dato
    //bisogna che gestisca ogni dettaglio del singolo dato
    private int like;
    private String autore;
    private String categoria;

    public Data(String autore) {
        this.autore = autore;
        this.like = 0;
    }

    public Data(Data d) {
        d.getAutore();
        d.getLike();
        d.getCategoria();
    }

    public void setLike(int like) {
        this.like = like;
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int addLike(){
        return like++;
    }

    public int getLike() {
        return like;
    }

    @Override
    public int compareTo(Data o) {
        return 0;
    }
}
