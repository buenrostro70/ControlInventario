package com.csi.inventario;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * 
 */
public class BaseDeDatosArchivo implements BaseDeDatos{

    List<Articulo> listaDeArticulos = new ArrayList<>();

    public BaseDeDatosArchivo() {
        List<String> lines;	
        try {
            lines = Files.readAllLines(Paths.get("db.txt"), StandardCharsets.UTF_8);
            lines.stream().forEach((line) -> {
            Articulo articulo = new Articulo(line);
            listaDeArticulos.add(articulo);
        });	
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
       
    }
    
    
    
    /**
     *
     * @param articulo
     */
    @Override
    public void crearArticulo(Articulo articulo) {
        listaDeArticulos.add(articulo);
        guardarArchivo();
    }
    
    /**
     *
     * @param numeroDeParte
     * @return
     */
    @Override
    public Articulo obtenerArticulo(String numeroDeParte) {
        Articulo resultado = null;
        for(Articulo articulo: listaDeArticulos){
            if(articulo.getNumeroDeParte().toUpperCase().equals(numeroDeParte.toUpperCase())){
                resultado = articulo;
            }
        }
        return resultado;
    }

    /**
     *
     * @param articulo
     */
    @Override
    public void editarArticulo(Articulo articulo) {
        boolean huboCambios = false;
        for(Articulo articuloLista: listaDeArticulos){
            if(articuloLista.getNumeroDeParte().equals(articulo.getNumeroDeParte())){
                articuloLista = articulo;
                huboCambios = true;
            }
        }
        if(huboCambios){
            guardarArchivo();
        }
    }

    /**
     *
     * @return
     */
    @Override
    public List<Articulo> obtenerTodosLosArticulos() {
        return listaDeArticulos;
    }

    /**
     *
     * 
     */
    private void guardarArchivo(){
         List<String> strings = new ArrayList<>();
         listaDeArticulos.stream().forEach((articulo) -> {
             strings.add(articulo.toString());
        });
        
        try {
            Files.write(Paths.get("db.txt"), strings, StandardOpenOption.CREATE);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
