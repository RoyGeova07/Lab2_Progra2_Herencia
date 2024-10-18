/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab2_herencia;

import java.util.ArrayList;
import javax.swing.JOptionPane;

// TRABAJO ROY
/**
 *
 * @author royum
 */
public class PlanSamsung extends Plan {

    private String pin;
    private ArrayList<String> list;

    public PlanSamsung(int NumeroTelefono, String Nombre, String pin) {
        super(NumeroTelefono, Nombre);
        this.pin = pin;
        this.list = new ArrayList<>();
    }

    @Override
    public double pagoMensual(int mins, int msgs) {

        int minutosAdicionales = 0;
        int mensajesExtra = 0;

        if (mins > 200) {

            minutosAdicionales = mins - 200;

        }

        if (msgs > 300) {

            mensajesExtra = msgs - 300;

        }

        double costoMinutos = minutosAdicionales * 0.8;
        double costoMensajes = mensajesExtra * 0.2;
        return 40 + costoMinutos + costoMensajes; // aqui 40 del plan base

    }

    @Override
    public String Imprimir() {

        return super.Imprimir() + "Pin: " + pin;

    }

    public void AgregarAmigo(String pin) {

        if (!list.contains(pin)) {
            list.add(pin);

        }

    }

    public String getPin() {
        return pin;
    }

}
