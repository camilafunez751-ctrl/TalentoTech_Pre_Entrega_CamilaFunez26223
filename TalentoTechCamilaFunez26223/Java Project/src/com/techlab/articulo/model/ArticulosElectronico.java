package com.techlab.articulo.model;

public class ArticulosElectronico extends Articulos {
    private String marca;
    
 public ArticulosElectronico(int codigo, String nombre, double precio, String marca) {
        super(codigo, nombre, precio);
        this.marca = marca;
    }

    public String getMarca() {
        return marca;
    }
    @Override
public String toString() {
    return "Artículo electrónico {" +
            "código=" + getCodigo() +
            ", nombre='" + getNombre() + '\'' +
            ", precio=" + getPrecio() +
            ", marca='" + marca + '\'' +
            "}\n";
}    
}
