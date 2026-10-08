package com.techlab.articulo;


import java.util.Scanner;

import com.techlab.articulo.model.Articulos;
import com.techlab.articulo.model.ArticulosAlimenticio;
import com.techlab.articulo.model.ArticulosElectronico;
import com.techlab.articulo.repository.ArticulosRepository;

public class App {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        
        ArticulosRepository repositorio = new ArticulosRepository();
        
        Articulos alimento = new ArticulosAlimenticio(
            1,
            "Leche",
            1500,
            "20/10/2026"
    );

    Articulos electronico = new ArticulosElectronico(
            2,
            "Televisor",
            300000,
            "Samsung"
    );

    repositorio.agregar(alimento);
    repositorio.agregar(electronico);
        
        int opcion;

        do {

            System.out.println("\n==========================================");
            System.out.println("   SISTEMA DE ARTÍCULOS - CLASE 2 (POO)");
            System.out.println("==========================================");
            System.out.println("1 - Ingresar artículo");
            System.out.println("2 - Listar artículos");
            System.out.println("3 - Consultar un artículo");
            System.out.println("4 - Modificar un artículo");
            System.out.println("5 - Eliminar un artículo");
            System.out.println("0 - Salir");
            System.out.println("==========================================");

            opcion = leerEntero(scanner, "Ingrese una opción: ");

            switch (opcion) {

                case 1:
                    ingresarArticulo(scanner, repositorio);
                    break;

                case 2:
                    listarArticulos(repositorio);
                    break;

                case 3:
                    consultarArticulo(scanner, repositorio);
                    break;

                case 4:
                    modificarArticulo(scanner, repositorio);
                    break;

                case 5:
                    eliminarArticulo(scanner, repositorio);
                    break;

                case 0:
                    System.out.println("\nSaliendo del sistema. ¡Hasta luego!");
                    break;

                default:
                    System.out.println("\nError: la opción ingresada no es válida.");
            }

        } while (opcion != 0);

        scanner.close();
    }

    public static void ingresarArticulo(
            Scanner scanner,
            ArticulosRepository repositorio) {

        System.out.println("\n--- INGRESAR ARTÍCULO ---");

        int codigo = leerEntero(
                scanner,
                "Ingrese el código del artículo: ");

            if (repositorio.buscarPorCodigo(codigo) != null) {
            System.out.println("Error: ya existe un artículo con ese código.");
            return;
        }

        String nombre = leerTextoNoVacio(
                scanner,
                "Ingrese el nombre del artículo: ");

        double precio = leerDoubleNoNegativo(
                scanner,
                "Ingrese el precio del artículo: ");

        Articulos articulo = new Articulos(codigo, nombre, precio);

        repositorio.agregar(articulo);

        System.out.println("Artículo ingresado correctamente.");
    }

    public static void listarArticulos(ArticulosRepository repositorio) {

        System.out.println("\n--- LISTADO DE ARTÍCULOS ---");

        if (repositorio.listar().isEmpty()) {
            System.out.println("No hay artículos cargados.");
            return;
        }

        for (Articulos articulo : repositorio.listar()) {
            System.out.println(articulo);
        }
    }

    public static void consultarArticulo(
            Scanner scanner,
            ArticulosRepository repositorio) {

        System.out.println("\n--- CONSULTAR ARTÍCULO ---");

        if (repositorio.listar().isEmpty()) {
            System.out.println("No hay artículos cargados.");
            return;
        }

        int codigo = leerEntero(
                scanner,
                "Ingrese el código del artículo a consultar: ");

        Articulos articulo = repositorio.buscarPorCodigo(codigo);
        
        if (articulo == null) {
            System.out.println("El artículo no existe.");
        } else {
            System.out.println("Artículo encontrado:");
            System.out.println(articulo);
        }
    }

    public static void modificarArticulo(
            Scanner scanner,
            ArticulosRepository repositorio) {

        System.out.println("\n--- MODIFICAR ARTÍCULO ---");

        if (repositorio.listar().isEmpty()) {
            System.out.println("No hay artículos cargados.");
            return;
        }

        int codigo = leerEntero(
                scanner,
                "Ingrese el código del artículo a modificar: ");

        Articulos articulo = repositorio.buscarPorCodigo(codigo);

        if (articulo == null) {
            System.out.println("El artículo no existe.");
            return;
        }

        String nuevoNombre = leerTextoNoVacio(
                scanner,
                "Ingrese el nuevo nombre del artículo: ");

        double nuevoPrecio = leerDoubleNoNegativo(
                scanner,
                "Ingrese el nuevo precio del artículo: ");

        articulo.setNombre(nuevoNombre);
        articulo.setPrecio(nuevoPrecio);

        System.out.println("Artículo modificado correctamente.");
    }

    public static void eliminarArticulo(
            Scanner scanner,
            ArticulosRepository repositorio) {

        System.out.println("\n--- ELIMINAR ARTÍCULO ---");

        if (repositorio.listar().isEmpty()) {
            System.out.println("No hay artículos cargados.");
            return;
        }

        int codigo = leerEntero(
                scanner,
                "Ingrese el código del artículo a eliminar: ");

        Articulos articulo = repositorio.buscarPorCodigo(codigo);

        if (articulo == null) {
            System.out.println("El artículo no existe.");
            return;
        }

        repositorio.eliminar(codigo);

        System.out.println("Artículo eliminado correctamente.");
    }

    

    public static int leerEntero(
            Scanner scanner,
            String mensaje) {

        while (true) {

            try {

                System.out.print(mensaje);

                return Integer.parseInt(scanner.nextLine());

            } catch (NumberFormatException e) {

                System.out.println(
                        "Error: debe ingresar un número entero válido.");
            }
        }
    }

    public static double leerDoubleNoNegativo(
            Scanner scanner,
            String mensaje) {

        while (true) {

            try {

                System.out.print(mensaje);

                double valor =
                        Double.parseDouble(scanner.nextLine());

                if (valor < 0) {

                    System.out.println(
                            "Error: el precio no puede ser negativo.");

                    continue;
                }

                return valor;

            } catch (NumberFormatException e) {

                System.out.println(
                        "Error: debe ingresar un número decimal válido.");
            }
        }
    }

    public static String leerTextoNoVacio(
            Scanner scanner,
            String mensaje) {

        while (true) {

            System.out.print(mensaje);

            String texto = scanner.nextLine();

            if (!texto.trim().isEmpty()) {

                return texto.trim();
            }

            System.out.println(
                    "Error: el texto no puede estar vacío.");
        }
    }
}