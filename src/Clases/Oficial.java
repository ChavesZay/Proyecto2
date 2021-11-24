/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.Date;

/**
 *
 * @author chave
 */
public class Oficial extends Persona{
    private double salario;

    public Oficial(String nombre, String apellido1, String apellido2, int cedula, Date fecha, int telefono, String correo, double salario) {
        super(nombre, apellido1, apellido2, cedula, fecha, telefono, correo);
        this.salario=salario;
    }

    public Oficial(int cedula) {
        super(cedula);
    }

    public Oficial() {
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
       
    
}
