package com.techlab.articulo;

/*
 * IMPORTS
 * ---------------------------------------------------------
 * Importamos clases externas que necesitamos usar.
 *
 * Scanner:
 * Permite leer datos que escribe el usuario por teclado.
 *
 * Articulo:
 * Es nuestra entidad del dominio.
 *
 * RepositorioArticulo:
 * Se encarga de guardar artículos en memoria RAM.
 */
import java.util.Scanner;

import com.techlab.articulo.model.Articulo;
import com.techlab.articulo.repository.RepositorioArticulo;

/*
 * CLASE APP
 * ---------------------------------------------------------
 * Esta clase representa el punto de entrada del sistema.
 *
 * Su responsabilidad NO es guardar datos ni representar artículos.
 *
 * Su trabajo es:
 * - iniciar el programa
 * - mostrar el menú
 * - coordinar el flujo
 * - interactuar con el usuario
 *
 * Esto sigue el principio de:
 * SEPARACIÓN DE RESPONSABILIDADES
 */
public class App {

    /*
     * MÉTODO MAIN
     * ---------------------------------------------------------
     * Java comienza la ejecución del programa desde aquí.
     *
     * La JVM busca exactamente:
     * public static void main(String[] args)
     */
    public static void main(String[] args) {

        /*
         * Creamos el Scanner para leer datos del teclado.
         */
        Scanner scanner = new Scanner(System.in);

        /*
         * Creamos el repositorio.
         *
         * Este objeto actuará como nuestra "base de datos en memoria".
         *
         * Internamente usa ArrayList.
         */
        RepositorioArticulo repositorio = new RepositorioArticulo();

        /*
         * Variable para controlar el menú.
         */
        int opcion;

        /*
         * BUCLE DO WHILE
         * ---------------------------------------------------------
         * El menú se repetirá mientras el usuario NO elija salir.
         */
        do {

            System.out.println("\n========= MENÚ =========");
            System.out.println("1 - Ingresar artículo");
            System.out.println("2 - Consultar artículos");
            System.out.println("3 - Modificar artículo");
            System.out.println("4 - Eliminar artículo");
            System.out.println("5 - Salir");

            System.out.print("Seleccione una opción: ");

            /*
             * Leemos la opción elegida.
             */
            opcion = scanner.nextInt();

            /*
             * SWITCH
             * ---------------------------------------------------------
             * El switch nos permite ejecutar diferentes acciones
             * según la opción elegida.
             */
            switch (opcion) {

                /*
                 * OPCIÓN 1
                 * ---------------------------------------------------------
                 * Crear artículo
                 */
                case 1:

                    System.out.print("Ingrese código: ");
                    int codigo = scanner.nextInt();

                    /*
                     * nextLine() limpia el ENTER pendiente.
                     */
                    scanner.nextLine();

                    System.out.print("Ingrese nombre: ");
                    String nombre = scanner.nextLine();

                    System.out.print("Ingrese precio: ");
                    double precio = scanner.nextDouble();

                    /*
                     * Creamos un objeto Articulo.
                     *
                     * new reserva memoria RAM para el objeto.
                     */
                    Articulo nuevoArticulo =
                            new Articulo(codigo, nombre, precio);

                    /*
                     * Guardamos el artículo en el repositorio.
                     */
                    repositorio.agregarArticulo(nuevoArticulo);

                    System.out.println("Artículo agregado correctamente.");

                    break;

                /*
                 * OPCIÓN 2
                 * ---------------------------------------------------------
                 * Listar artículos
                 */
                case 2:

                    System.out.println("\n===== LISTA DE ARTÍCULOS =====");

                    /*
                     * Verificamos si la lista está vacía.
                     */
                    if (repositorio.listarArticulos().isEmpty()) {

                        System.out.println("No hay artículos cargados.");

                    } else {

                        /*
                         * FOREACH
                         * -------------------------------------------------
                         * Recorremos todos los objetos Articulo
                         * almacenados en memoria.
                         */
                        for (Articulo articulo :
                                repositorio.listarArticulos()) {

                            /*
                             * Java ejecuta automáticamente toString()
                             */
                            System.out.println(articulo);

                        }

                    }

                    break;

                /*
                 * OPCIÓN 3
                 * ---------------------------------------------------------
                 * Modificar artículo
                 */
                case 3:

                    System.out.print(
                            "Ingrese código del artículo a modificar: ");

                    int codigoModificar = scanner.nextInt();

                    /*
                     * Buscamos el artículo en memoria.
                     */
                    Articulo articuloModificar =
                            repositorio.buscarPorCodigo(codigoModificar);

                    /*
                     * Validamos si existe.
                     */
                    if (articuloModificar != null) {

                        scanner.nextLine();

                        System.out.print("Nuevo nombre: ");
                        String nuevoNombre = scanner.nextLine();

                        System.out.print("Nuevo precio: ");
                        double nuevoPrecio = scanner.nextDouble();

                        /*
                         * SETTERS
                         * -------------------------------------------------
                         * Modificamos el estado interno del objeto.
                         */
                        articuloModificar.setNombre(nuevoNombre);
                        articuloModificar.setPrecio(nuevoPrecio);

                        System.out.println("Artículo modificado.");

                    } else {

                        System.out.println("Artículo no encontrado.");

                    }

                    break;

                /*
                 * OPCIÓN 4
                 * ---------------------------------------------------------
                 * Eliminar artículo
                 */
                case 4:

                    System.out.print(
                            "Ingrese código del artículo a eliminar: ");

                    int codigoEliminar = scanner.nextInt();

                    /*
                     * El repositorio intenta eliminar el objeto.
                     */
                    boolean eliminado =
                            repositorio.eliminarArticulo(codigoEliminar);

                    /*
                     * Validamos resultado.
                     */
                    if (eliminado) {

                        System.out.println("Artículo eliminado.");

                    } else {

                        System.out.println("Artículo no encontrado.");

                    }

                    break;

                /*
                 * OPCIÓN 5
                 * ---------------------------------------------------------
                 * Salir del sistema
                 */
                case 5:

                    System.out.println("Saliendo del sistema...");

                    break;

                /*
                 * DEFAULT
                 * ---------------------------------------------------------
                 * Opción inválida.
                 */
                default:

                    System.out.println("Opción inválida.");

            }

        } while (opcion != 5);

        /*
         * Cerramos Scanner para liberar recursos.
         */
        scanner.close();
    }
}