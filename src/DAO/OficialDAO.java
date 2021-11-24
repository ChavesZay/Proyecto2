/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import BaseDatos.BaseDatos;
import Clases.Oficial;

/**
 *
 * @author jordy
 */
public class OficialDAO implements DAO<Oficial> {

    private BaseDatos db;

    public OficialDAO(BaseDatos db) {
        this.db = db;
    }

    @Override
    public boolean insertar(Oficial ob) {
        this.db.prepararSentencia("INSERT INTO oficiales VALUES(?,?,?,?,?,?,?,?)");
        Object[] param = {ob.getCedula(), ob.getNombre(), ob.getApellido1(), ob.getApellido2(), ob.getFecha(), ob.getTelefono(), ob.getCorreo(), ob.getSalario()};
        return this.db.ejecutar(param);
    }

    @Override
    public boolean modificar(Oficial ob) {
        this.db.prepararSentencia("UPDATE oficiales SET Nombre=?,Apellido1=?,Apellido2=?,fecha=?,telefono=?,correo=?,salario=? WHERE Cedula=?");
        Object[] param = {ob.getCedula(), ob.getNombre(), ob.getApellido1(), ob.getApellido2(), ob.getFecha(), ob.getTelefono(), ob.getCorreo(), ob.getSalario()};
        return this.db.ejecutar(param);
    }

    @Override
    public boolean eliminar(Oficial ob) {
        this.db.prepararSentencia("DELETE FROM oficiales WHERE Cedula=?");
        Object[] param ={ob.getCedula()};
        return this.db.ejecutar(param);
    }

    @Override
    public Oficial buscar(Oficial ob) {
       this.db.prepararSentencia("SELECT FROM oficiales WHERE Cedula=?");
       Object[] param = {ob.getCedula()};
        Object[][] valores;
        valores = this.db.Seleccionar(param);
        if (valores.length > 0) {
            //return new Oficial((String) valores[0][0], (String) valores[0][1], (String) valores[0][1] );
        }
        return null;
    }

    @Override
    public Oficial[] listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean validarPK(Oficial ob) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean validarFK(Oficial ob) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
