package model;

public class Item {
    // classe Item - guarda tipos de categorias

    /*
    types
    0 - livro
    1 - HQ
    3 - mangá
    */

    private int type;
    private Object object;
    // os diferentes tipos vão ser representados por diferentes objetos, e precisam estar em um local
    // que possa recebê-los (classe Object)

    public Item(int type, Object object) {
        this.type = type;
        this.object = object;
    }

    public int getType() {
        return type;
    }

    public Object getObject() {
        return object;
    }
}
