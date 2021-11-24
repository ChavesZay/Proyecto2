/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import BaseDatos.BaseDatos;
import Clases.Cita;
import java.util.Date;

/**
 *
 * @author jordy
 */
public class CitaDAO implements DAO<Cita> {

    private BaseDatos db;

    public CitaDAO(BaseDatos db) {
        this.db = db;
    }

    @Override
    public boolean insertar(Cita ob) {
        this.db.prepararSentencia("INSERT INTO citas values (?,?,?,?)");
        Object[] parametros = {ob.getId(), ob.getFecha(), ob.getHora(), ob.getCliente().getCedula()};
        return this.db.ejecutar(parametros);
    }

    @Override
    public boolean modificar(Cita ob) {
        this.db.prepararSentencia("UDATE citas SET fecha=?,hora=? WHERE IdCita=?");
        Object[] parametros = {ob.getId(), ob.getFecha(), ob.getHora(), ob.getCliente().getCedula()};
        return this.db.ejecutar(parametros);
    }

    @Override
    public boolean eliminar(Cita ob) {
        this.db.prepararSentencia("DELETE FROM citas Where IdCita=?");
        Object[] param = {ob.getId()};
        return this.db.ejecutar(param);
    }

    @Override
    public Cita buscar(Cita ob) {
        this.db.prepararSentencia("SELECT * FROM citas WHERE IdCita=?");
        Object[] param = {ob.getId()};
        Object[][] valores;
        valores = this.db.Seleccionar(param);
        if (valores.length > 0) {
            //citas[f]= new Cita((int)valores[0][0],(Date)valores[0][1], (String)valores[0][2], new PersonaDao(this.db).buscar(new Provincia(((int) valores[0][3]))));
        }
        return null;
    }

    @Override
    public Cita[] listar() {
        this.db.prepararSentencia("SELECT * FROM citas ORDER BY IdCita ASC");
        Object[] param = {};
        Object[][] valores;
        valores = this.db.Seleccionar(param);
        if (valores.length > 0) {
            Cita[] citas = new Cita[valores.length];
            for (int f = 0; f < valores.length; f++) {
                //citas[f]= new Cita((int)valores[f][0],(Date)valores[f][1], (String)valores[f][2], new PersonaDao(this.db).buscar(new Provincia(((int) valores[f][3]))));
            }
            return citas;
        }
        return null;
    }
    
    public Cita[] filtar(String nombre){
        this.db.prepararSentencia("SELECT * FROM citas WHERE LIKE(?) ORDER BY IdCita ASC");
        Object[] param = {nombre};
        Object[][] valores;
        valores = this.db.Seleccionar(param);
        if(valores.length>0){
            Cita[] citas = new Cita[valores.length];
            for (int f=0;f<valores.length;f++){
                 //citas[f]= new Cita((int)valores[f][0],(Date)valores[f][1], (String)valores[f][2], new PersonaDao(this.db).buscar(new Provincia(((int) valores[f][3]))));
            }
            return citas;
        }
        return null;
    }

    @Override
    public boolean validarPK(Cita ob) {
        ob = buscar(ob);
        return ob == null;
    }

    @Override
    public boolean validarFK(Cita ob) {
        //PersonaDao personaDao = new PersonaDao(this.db);
        //return !personaDao.validarPK(ob.getPersona());
        return false;
    }

}
