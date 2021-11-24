/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import BaseDatos.BaseDatos;
import Clases.Usuario;

/**
 *
 * @author chave
 */
public class UsuarioDao implements DAO<Usuario>{
     BaseDatos bd;
    
    @Override
    public boolean insertar(Usuario usuario) {
        bd.prepararSentencia("Insert into usuarios Values(?,?,?,?,?,?,?,?,?,?)");
        Object[]parametros={usuario.getCedula(),usuario.getNombre(),usuario.getApellido1(),usuario.getApellido2(),usuario.getFecha(),usuario.getTelefono(),usuario.getCorreo(),usuario.getUsuario(),usuario.getContrasena(),usuario.getTipo()};
        return this.bd.ejecutar(parametros);
    }

    @Override
    public boolean modificar(Usuario usuario) {
        bd.prepararSentencia("Insert into usuarios Values(?,?,?,?,?,?,?,?,?,?)");
        Object[]parametros={usuario.getCedula(),usuario.getNombre(),usuario.getApellido1(),usuario.getApellido2(),usuario.getFecha(),
                                usuario.getTelefono(),usuario.getCorreo(),usuario.getUsuario(),usuario.getContrasena(),usuario.getTipo()};
        return this.bd.ejecutar(parametros);
        
    }

    @Override
    public boolean eliminar(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario buscar(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario[] listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean validarPK(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean validarFK(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
