package com.techlab.articulo.model;

public class ArticulosAlimenticio extends Articulos {
    
private String fechaVencimiento;

    public ArticulosAlimenticio(int codigo, String nombre, double precio, String fechaVencimiento) {
        super(codigo, nombre, precio);
        this.fechaVencimiento = fechaVencimiento;
    }
    public String getFechaVencimiento() {
    return fechaVencimiento;
}
@Override
public String toString() {
    return "Artículo alimenticio {" +
            "código=" + getCodigo() +
            ", nombre='" + getNombre() + '\'' +
            ", precio=" + getPrecio() +
            ", fechaVencimiento='" + fechaVencimiento + '\'' +
            "}\n";
}

}
