package com.csi.inventario;

import java.util.List;

/**
 *
 * 
 */
public interface BaseDeDatos {

    /**
     *
     * @param articulo
     */
    void crearArticulo (Articulo articulo);
    
    /**
     *
     * @param numeroDeParte
     * @return
     */
    Articulo obtenerArticulo (String numeroDeParte);
    
    /**
     *
     * @param articulo
     */
    void editarArticulo (Articulo articulo);

    /**
     *
     * @return
     */
    List<Articulo> obtenerTodosLosArticulos();
}
