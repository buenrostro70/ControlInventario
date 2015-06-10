package com.csi.inventario.gui;

import com.csi.inventario.BaseDeDatos;
import com.csi.inventario.BaseDeDatosArchivo;
import com.csi.inventario.Impresora;
import com.csi.inventario.ImpresoraExcel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 *
 * 
 */
public class Menu extends JFrame{
    
    BaseDeDatos baseDeDatos;
    Impresora impresora;
    
    JButton imprimir;
    JButton crearArticulo;
    JButton buscar;

    /**
     *
     */
    public Menu() {
        super("CSI - ControlInventario");
        inicializarPantalla();
    }

    private void inicializarPantalla() {
        //
        baseDeDatos = new BaseDeDatosArchivo();
        setVisible(true);
        setSize(350, 100);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        // El panel principal del Login va a ser tipo BorderLayout
        getContentPane().setLayout(new BorderLayout());
        // Inicializar panel de contenido y de título
        JPanel panelDeContenido = new JPanel();
        JPanel panelDeTitulo = new JPanel();
        // Insertar paneles de título y de forma en el panel principal (Content Pane)
        getContentPane().add(panelDeTitulo, BorderLayout.NORTH);
        getContentPane().add(panelDeContenido, BorderLayout.CENTER);
        
        // Crear Titulo y agregarlo a panel de título
        JLabel titulo = new JLabel("CSI - Control de Inventario");
        panelDeTitulo.setLayout(new BorderLayout());
        panelDeTitulo.add(titulo, BorderLayout.CENTER);
        
        //Crear impresora Excel
        impresora = new ImpresoraExcel();
        
        // Crear Botones y agregarlo al panel de contenido
        panelDeContenido.setLayout(new FlowLayout());
        imprimir = new JButton("Imprimir");
        imprimir.addActionListener((ActionEvent e)->imprimir(e));
        panelDeContenido.add(imprimir);
        buscar = new JButton("Buscar");
        buscar.addActionListener((ActionEvent e)->buscar(e));
        panelDeContenido.add(buscar);
        crearArticulo = new JButton("Crear Artículo");
        crearArticulo.addActionListener((ActionEvent e)->crearArticulo(e));
        panelDeContenido.add(crearArticulo);
    }
    
    private void imprimir(ActionEvent e){
        impresora.imprimirArticulos(baseDeDatos.obtenerTodosLosArticulos());
    }
    private void buscar(ActionEvent e){
        new EditorDeArticulos(baseDeDatos);
    }
    private void crearArticulo(ActionEvent e){
        new CreadorDeArticulos(baseDeDatos);
    }
}
