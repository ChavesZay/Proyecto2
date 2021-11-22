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
public class Usuario extends Persona{
    String usuario;
    String contrasena;
    String tipo;

    public Usuario(String usuario, String contrasena, String tipo, String nombre, String apellido1, String apellido2, int cedula, Date fecha, int telefono, String correo) {
        super(nombre, apellido1, apellido2, cedula, fecha, telefono, correo);
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.tipo = tipo;
    }

    public Usuario(int cedula) {
        super(cedula);
    }

    public Usuario() {
    }
    
    
}
