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
    
     public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    

    
    public Cliente(int cedula,String nombre, String apellido1, String apellido2,  Date fecha, int telefono, String correo) {
        super(nombre, apellido1, apellido2, cedula, fecha, telefono, correo);
    }

    public Cliente(int cedula) {
        super(cedula);
    }

    public Cliente() {
    }

    @Override
    public boolean requeridos() {
        return this.getCedula()!=0&&this.getCorreo()!=null&&this.getNombre()!=null&&this.getApellido1()!=null&&this.getApellido2()!=null&&this.getTelefono()!=0&&this.getCorreo()!=null;
    }

   
    
    
}
