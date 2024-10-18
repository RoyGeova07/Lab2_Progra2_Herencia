/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab2_herencia;

import java.util.ArrayList;
import javax.swing.JOptionPane;

// trabajo ERNESTO

/**
 *
 * @author royum
 */
public class Tigo {

    ArrayList<Plan> planes = new ArrayList<>();

    public Tigo() {
        this.planes = new ArrayList<>();
    }

    public void AgregarPlan(int numeroTel, String nombre, String extra, String tipo) {
        if (tipo.equalsIgnoreCase("Iphone")) {
            planes.add(new PlanIphone(numeroTel, nombre, extra));
        } else if (tipo.equalsIgnoreCase("Samsung")) {
            planes.add(new PlanSamsung(numeroTel, nombre, extra));
        }
    }

    public boolean busqueda(int numeroTel, String datoExtra, String tipo) {
        for (Plan plan : planes) {
            if (plan.getNumeroTelefono() == numeroTel) {
                return true;
            }

            if (tipo.equalsIgnoreCase("Iphone") && plan instanceof PlanIphone) {
                PlanIphone iphonePlan = (PlanIphone) plan;
                if (iphonePlan.getemailitunes().equals(datoExtra)) {
                    return true;
                }
            }

            if (tipo.equalsIgnoreCase("Samsung") && plan instanceof PlanSamsung) {
                PlanSamsung samsungPlan = (PlanSamsung) plan;
                if (samsungPlan.getPin().equals(datoExtra)) {
                    return true;
                }
            }
        }
        return false;
    }

    public double pagoPlan(int numeroTel, int mins, int msgs) {
        for (Plan plan : planes) {
            if (plan.getNumeroTelefono() == numeroTel) {
                return plan.pagoMensual(mins, msgs);
            }
        }

        return -1;
    }

    public void agregarAmigo(int numeroTel, String pin) {
        for (Plan plan : planes) {
            if (plan.getNumeroTelefono() == numeroTel) {
                if (plan instanceof PlanSamsung) {
                    PlanSamsung samsungPlan = (PlanSamsung) plan;
                    samsungPlan.AgregarAmigo(pin);
                    JOptionPane.showMessageDialog(null, "Amigo agregado exitosamente");
                    return;
                } else {
                    System.out.println("El plan no es de tipo Samsung.");
                    return;
                }
            }
        }
        JOptionPane.showMessageDialog(null, "Amigo no encontrado");
    }

    public void lista() {

        int contadorSamsung = 0;
        int contadorIphone = 0;

        for (Plan plans : planes) {
            plans.Imprimir();
        }
    }
}
