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
    private String usuario;
    private String contrasena;
    private String tipo;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
    

    public Usuario( int cedula, String nombre, String apellido1, String apellido2, Date fecha, int telefono, String correo,String usuario, String contrasena, String tipo) {
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

    @Override
    public boolean requeridos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
