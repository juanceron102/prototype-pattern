package model;

import java.util.ArrayList;
import java.util.List;

public class Inventario {
    private List<String> items;

    public Inventario() {
        this.items = new ArrayList<>();
    }

    public void agregarItem(String item) {
        items.add(item);
    }

    public List<String> getItems() {
        return new ArrayList<>(items);
    }

    //la copia recibe su propia lista no la referencia a la original
    public Inventario copiar() {
        Inventario copia = new Inventario();
        copia.items = new ArrayList<>(this.items);
        return copia;
    }

    @Override
    public String toString() {
        return items.toString();
    }
}
