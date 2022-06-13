package com.cristianomoraes.libri_retorfit.model;

public class Item
{
    /*
    * Livro
    * HQ
    * manga
    * */

    private int type;
    //classe mais alta do Java - recebe qualquer objeto
    private Object object;

    //construtores
    public Item(){
    }

    public Item(int type, Object object) {
        this.type = type;
        this.object = object;
    }

    //getters e setters
    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
