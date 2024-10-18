/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab2_herencia;

import javax.swing.JOptionPane;

/**
 *
 * @author royum
 */
public abstract class Plan {
    
    protected int NumeroTelefono;
    protected String Nombre;

    public Plan(int NumeroTelefono, String Nombre) {
        this.NumeroTelefono = NumeroTelefono;
        this.Nombre = Nombre;
    }

    public int getNumeroTelefono() {
        return NumeroTelefono;
    }

    public String getNombre() {
        return Nombre;
    }
    
    public abstract double pagoMensual(int mins, int msgs);
    
   

    public String Imprimir() {
        
        return "Numero Telefono: "+NumeroTelefono+ " Nombre: "+Nombre;
        
    }
    
    
}
