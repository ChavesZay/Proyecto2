/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.Date;

/**
 *
 * @author jordy
 */
public class Cliente extends Persona{
    
    private int edad;
    
    public Cliente(String nombre, String apellido1, String apellido2, int cedula, Date fecha, int telefono, String correo) {
        super(nombre, apellido1, apellido2, cedula, fecha, telefono, correo);
    }

    public Cliente(int cedula) {
        super(cedula);
    }

    public Cliente() {
    }

    public int getEdad() {
        return edad;
    }
    
    
    
}
