package com.csi.inventario.gui;

import java.awt.BorderLayout;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * 
 */
public class Login extends JFrame {
    
    JTextField usuario;
    JTextField contrasenia;
    JButton botonLogin;
    
    /**
     *
     */
    public Login(){
        super("CSI - ControlInventario");
        inicializarPantalla();
        
    }
    
    
    private void inicializarPantalla(){
        //
        setVisible(true);
        setSize(380, 150);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        // El panel principal del Login va a ser tipo BorderLayout
        getContentPane().setLayout(new BorderLayout());
        // Inicializar panel de contenido y de título
        JPanel panelDeForma = new JPanel();
        JPanel panelDeTitulo = new JPanel();
        // Insertar paneles de título y de forma en el panel principal (Content Pane)
        getContentPane().add(panelDeTitulo, BorderLayout.NORTH);
        getContentPane().add(panelDeForma, BorderLayout.CENTER);
        
        // Crear Titulo y agregarlo a panel de título
        JLabel titulo = new JLabel("CSI - Control de Inventario");
        panelDeTitulo.setLayout(new BorderLayout());
        panelDeTitulo.add(titulo, BorderLayout.CENTER);
        
        // Crear campos de la forma (variables)
        usuario = new JTextField(20);
        contrasenia = new JPasswordField(20);
        botonLogin = new JButton("Iniciar Sesión");
        
        //Crear accion del JButton (llamará al método iniciar sesión de esta clase)
        botonLogin.addActionListener((ActionEvent e) -> {
            iniciarSesion(e);
        });
        
        // Crear Forma y agregarla al panel de titulo
        panelDeForma.setLayout(new FlowLayout());
        
        panelDeForma.add(new JLabel("Usuario: "));
        panelDeForma.add(usuario);
        panelDeForma.add(new JLabel("Contraseña: "));
        panelDeForma.add(contrasenia);
        panelDeForma.add(botonLogin);
                
        
    }
    
    private void iniciarSesion(ActionEvent e){
        if(usuario.getText().equals("buenrostro") && contrasenia.getText().equals("sanchez")){
            new Menu();
            this.setVisible(false);
        }
        else{
            JOptionPane.showMessageDialog(this, "Usuario/Contraseña inválido", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
}
