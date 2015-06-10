package com.csi.inventario;

/**
 *
 * 
 */
public class Articulo {
    private String numeroDeParte;
    private String ubicacion;
    private String color;
    private String fecha;
    private String cantidad;

    public Articulo() {
    }

    public Articulo(String articulo) {
        String[] valores = articulo.split(",");
        numeroDeParte = valores[0];
        ubicacion = valores[1];
        color = valores[2];
        fecha = valores[3];
        cantidad = valores[4];  
                
    }
    
    
    
    /**
     *
     * @return
     */
    public String getNumeroDeParte() {
        return numeroDeParte;
    }

    /**
     *
     * @param numeroDeParte
     */
    public void setNumeroDeParte(String numeroDeParte) {
        this.numeroDeParte = numeroDeParte;
    }

    /**
     *
     * @return
     */
    public String getUbicacion() {
        return ubicacion;
    }

    /**
     *
     * @param ubicacion
     */
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    /**
     *
     * @return
     */
    public String getColor() {
        return color;
    }

    /**
     *
     * @param color
     */
    public void setColor(String color) {
        this.color = color;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }
    
    @Override
    public String toString(){
        return numeroDeParte+","+ubicacion+","+color+","+fecha+","+cantidad;
    }
    
}
