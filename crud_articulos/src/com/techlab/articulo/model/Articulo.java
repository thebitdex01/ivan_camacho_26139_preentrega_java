package com.techlab.articulo.model;

/*
 * CLASE ARTICULO
 * ---------------------------------------------------------
 * Esta clase representa el modelo del dominio.
 *
 * Es decir:
 * representa un artículo real del sistema.
 *
 * Esta clase NO muestra menús.
 * NO lee teclado.
 * NO guarda datos.
 *
 * Solo representa:
 * - estado
 * - datos
 * - comportamiento del artículo
 *
 * Esto es Programación Orientada a Objetos.
 */
public class Articulo {

    /*
     * ATRIBUTOS
     * ---------------------------------------------------------
     * Los atributos representan el estado interno del objeto.
     *
     * private:
     * significa que solo esta clase puede acceder
     * directamente a estos datos.
     *
     * Esto se llama ENCAPSULAMIENTO.
     */

    private int codigo;

    private String nombre;

    private double precio;

    /*
     * CONSTRUCTOR
     * ---------------------------------------------------------
     * El constructor sirve para crear objetos inicializados.
     *
     * Cuando hacemos:
     *
     * new Articulo(1, "Mouse", 2500)
     *
     * Java:
     * - reserva memoria RAM
     * - crea el objeto
     * - ejecuta este constructor
     */
    public Articulo(int codigo, String nombre, double precio) {

        /*
         * this representa al objeto actual.
         *
         * this.codigo:
         * atributo interno
         *
         * codigo:
         * parámetro recibido
         */
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;

    }

    /*
     * GETTERS
     * ---------------------------------------------------------
     * Permiten LEER los atributos privados.
     */

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    /*
     * SETTERS
     * ---------------------------------------------------------
     * Permiten MODIFICAR atributos privados.
     */

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /*
     * toString()
     * ---------------------------------------------------------
     * Define cómo queremos mostrar el objeto como texto.
     *
     * Si NO sobrescribimos este método,
     * Java mostraría algo como:
     *
     * Articulo@7a81197d
     *
     * Con toString() mostramos información útil.
     */
    @Override
    public String toString() {

        return "Código: " + codigo +
               " | Nombre: " + nombre +
               " | Precio: $" + precio;
    }
}