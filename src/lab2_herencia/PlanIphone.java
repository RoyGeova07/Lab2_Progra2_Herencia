/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab2_herencia;

// trabajo ERNESTO
/**
 *
 * @author royum
 */
public class PlanIphone extends Plan {

    protected String emailitunes;

    public PlanIphone(int NumeroTelefono, String Nombre, String emailitunes) {
        super(NumeroTelefono, Nombre);
        this.emailitunes = emailitunes;
    }

    public String getemailitunes() {
        return emailitunes;
    }

    @Override
    public double pagoMensual(int mins, int msgs) {
        return 22 + (mins * 0.4) + (msgs * 0.1);
    }

    @Override
    public String Imprimir() {

        return super.Imprimir() + "Email iTunes: " + emailitunes;

    }

}
