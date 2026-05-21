package com.techlab.articulo.repository;

/*
 * IMPORTS
 * ---------------------------------------------------------
 * ArrayList:
 * colección dinámica de objetos en memoria.
 *
 * Articulo:
 * entidad del dominio.
 */
import java.util.ArrayList;

import com.techlab.articulo.model.Articulo;

/*
 * CLASE REPOSITORIOARTICULO
 * ---------------------------------------------------------
 * Esta clase representa la capa de persistencia.
 *
 * Su responsabilidad es:
 * - guardar objetos
 * - buscarlos
 * - eliminarlos
 * - listarlos
 *
 * NO muestra menús.
 * NO usa Scanner.
 * NO imprime cosas.
 *
 * Solo administra datos.
 *
 * Esto sigue el principio:
 * RESPONSABILIDAD ÚNICA
 */
public class RepositorioArticulo {

    /*
     * ArrayList donde se almacenan los artículos.
     *
     * Esto actúa como una "base de datos en RAM".
     */
    private ArrayList<Articulo> listaArticulos;

    /*
     * CONSTRUCTOR
     * ---------------------------------------------------------
     * Inicializa el ArrayList.
     */
    public RepositorioArticulo() {

        listaArticulos = new ArrayList<>();

    }

    /*
     * agregarArticulo()
     * ---------------------------------------------------------
     * Agrega un objeto Articulo a la colección.
     */
    public void agregarArticulo(Articulo articulo) {

        listaArticulos.add(articulo);

    }

    /*
     * listarArticulos()
     * ---------------------------------------------------------
     * Devuelve toda la lista de artículos.
     */
    public ArrayList<Articulo> listarArticulos() {

        return listaArticulos;

    }

    /*
     * buscarPorCodigo()
     * ---------------------------------------------------------
     * Busca un artículo recorriendo la lista.
     *
     * Si encuentra coincidencia:
     * devuelve el objeto.
     *
     * Si no:
     * devuelve null.
     */
    public Articulo buscarPorCodigo(int codigo) {

        /*
         * FOREACH:
         * recorremos todos los artículos.
         */
        for (Articulo articulo : listaArticulos) {

            /*
             * Comparamos códigos.
             */
            if (articulo.getCodigo() == codigo) {

                return articulo;

            }

        }

        return null;
    }

    /*
     * eliminarArticulo()
     * ---------------------------------------------------------
     * Elimina un artículo según código.
     */
    public boolean eliminarArticulo(int codigo) {

        /*
         * Primero buscamos el objeto.
         */
        Articulo articulo = buscarPorCodigo(codigo);

        /*
         * Si existe:
         * eliminamos.
         */
        if (articulo != null) {

            listaArticulos.remove(articulo);

            return true;
        }

        /*
         * Si no existe:
         * devolvemos false.
         */
        return false;
    }
}