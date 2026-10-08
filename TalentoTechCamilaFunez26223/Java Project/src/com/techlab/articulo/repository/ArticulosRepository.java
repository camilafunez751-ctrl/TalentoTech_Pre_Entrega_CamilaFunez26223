package com.techlab.articulo.repository;
import java.util.ArrayList;

import com.techlab.articulo.model.Articulos;

public class ArticulosRepository {
    private ArrayList<Articulos> articulos = new ArrayList<>();
public void agregar(Articulos articulo) {
        articulos.add(articulo);
    }
    public ArrayList<Articulos> listar() {
        return articulos;
    }
    public Articulos buscarPorCodigo(int codigo) {
        for (Articulos articulo : articulos) {
            if (articulo.getCodigo() == codigo) {
                return articulo;
            }
        }

        return null;
    }
public boolean eliminar(int codigo) {
    Articulos articulo = buscarPorCodigo(codigo);

    if (articulo != null) {
        articulos.remove(articulo);
        return true;
    }

    return false;
}
}
