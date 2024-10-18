/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab2_herencia;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// TRABAJO ROY

/**
 *
 * @author royum
 */
public class Menu extends JFrame {


    private Tigo tigo;
    
    public Menu(){
        
        tigo = new Tigo();
        
        setTitle("Menu Principal");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets= new Insets(10,10,10,10);
        panelPrincipal.setBackground(Color.BLUE);
        
        // aqui se crean los botones
        
        JButton agregarPlanButton = new JButton("Agregar Plan");
        JButton pagoPlanButton = new JButton("Pago Plan");
        JButton agregarAmigoButton = new JButton("Agregar Amigo");
        JButton listarButton = new JButton("Listar");
        JButton salirButton = new JButton("Salir");
        
        gbc.gridx=0;
        gbc.gridy=0;
        panelPrincipal.add(agregarPlanButton,gbc);
        agregarPlanButton.setBackground(Color.red);

        gbc.gridy=1;
        panelPrincipal.add(pagoPlanButton,gbc);
        pagoPlanButton.setBackground(Color.ORANGE);
        
        gbc.gridy=2;
        panelPrincipal.add(agregarAmigoButton,gbc); 
        agregarAmigoButton.setBackground(Color.GREEN);
        
        gbc.gridy=3;
        panelPrincipal.add(listarButton,gbc);
        listarButton.setBackground(Color.YELLOW);
        
        gbc.gridy=4;
        panelPrincipal.add(salirButton,gbc);
        salirButton.setBackground(Color.PINK);
        
       
        
        

       
        add(panelPrincipal);
        
        
        agregarPlanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarPlan();
            }
        });

        
        pagoPlanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pagoPlan();
            }
        });

        
        agregarAmigoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarAmigo();
            }
        });

      
        listarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listarPlanes();
            }
        });

        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0); 
            }
        });
    }

   
    private void agregarPlan() {
        try {
            int numeroTel = Integer.parseInt(JOptionPane.showInputDialog(this, "Ingrese el numero de telfono:"));
            String nombre = JOptionPane.showInputDialog(this, "Ingrese el nombre del cliente:");
            if(nombre.isEmpty()){
                
                JOptionPane.showMessageDialog(null, "no podes dejar esto vacio");
                return;
                
            }
            String tipo = JOptionPane.showInputDialog(this, "Ingrese el tipo de plan (IPHONE/SAMSUNG):").toUpperCase();
            
            if(tipo.isEmpty()){
                
                JOptionPane.showMessageDialog(null, "no podes dejar esto en blanco");
                return;
                
            }
            
            
            
            if (!tipo.equals("IPHONE") && !tipo.equals("SAMSUNG")) {
                JOptionPane.showMessageDialog(this, "Tipo de plan no valido.");
                return;
            }

            String extra = tipo.equals("IPHONE")
                    ? JOptionPane.showInputDialog(this, "Ingrese el email de iTunes:")
                    : JOptionPane.showInputDialog(this, "Ingrese el PIN de Samsung:");
            
            if(extra.isEmpty()){
                
                JOptionPane.showMessageDialog(null, "no podes dejar esto en blanco");
                return;
                
            }

            if (!tigo.busqueda(numeroTel, extra, tipo)) {
                tigo.AgregarPlan(numeroTel, nombre, extra, tipo);
                JOptionPane.showMessageDialog(this, "Plan agregado exitosamente.");
            } else {
                JOptionPane.showMessageDialog(this, "Numero o dato extra ya existe.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor ingrese un numero valido.");
        }
    }

    private void pagoPlan() {
        try {
            int numeroTel = Integer.parseInt(JOptionPane.showInputDialog(this, "Ingrese el numero de telefono:"));
            int mins = Integer.parseInt(JOptionPane.showInputDialog(this, "Ingrese la cantidad de minutos consumidos:"));
            int msgs = Integer.parseInt(JOptionPane.showInputDialog(this, "Ingrese la cantidad de mensajes enviados:"));

            double pago = tigo.pagoPlan(numeroTel, mins, msgs);
            if (pago != -1) {
                JOptionPane.showMessageDialog(this, "El pago mensual es: $" + pago);
            } else {
                JOptionPane.showMessageDialog(this, "Numero de telefono no encontrado.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor ingrese un numero valido.");
        }
    }

    
    private void agregarAmigo() {
        try {
            int numeroTel = Integer.parseInt(JOptionPane.showInputDialog(this, "Ingrese el numero de telefono del Plan Samsung:"));
            String pin = JOptionPane.showInputDialog(this, "Ingrese el PIN del amigo:");

            tigo.agregarAmigo(numeroTel, pin);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor ingrese un numero valido.");
        }
    }

    
    private void listarPlanes() {
        StringBuilder listado = new StringBuilder();
        int contadorSamsung = 0;
        int contadorIphone = 0;

        for (Plan plan : tigo.planes) {
            if (plan instanceof PlanSamsung) {
                listado.append("Samsung\n");
                contadorSamsung++;
            } else if (plan instanceof PlanIphone) {
                listado.append("iPhone\n");
                contadorIphone++;
            }
            plan.Imprimir();
            listado.append("\n");
        }

        listado.append("\nTotal Planes Samsung: ").append(contadorSamsung);
        listado.append("\nTotal Planes iPhone: ").append(contadorIphone);

        JOptionPane.showMessageDialog(this, listado.toString());
    }

    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }
    
}
=======
    
}
>>>>>>> 7e421b5284332a4ec827320922702ede5caa7e2c
