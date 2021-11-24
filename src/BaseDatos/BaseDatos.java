/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDatos;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jordy
 */
public class BaseDatos {

    private String drive;
    private String api;
    private String motor;
    private String servidor;
    private String base;
    private String usuario;
    private String contrasenia;
    private String error;

    private Connection conexion;
    private PreparedStatement sentencia;
    private ResultSet datos;

    public BaseDatos(String drive, String api, String motor, String servidor, String base, String uauario, String contrasenia) {
        this.drive = drive;
        this.api = api;
        this.motor = motor;
        this.servidor = servidor;
        this.base = base;
        this.usuario = uauario;
        this.contrasenia = contrasenia;

        if (!this.conectar()) {
            throw new NullPointerException();
        }

    }

    public String getError() {
        return error;
    }

    private boolean conectar() {
        try {
            this.error = null;
            Class.forName(this.drive);
            this.conexion = DriverManager.getConnection(this.api + ":" + this.motor + "://" + this.servidor + "/" + this.base, this.usuario, this.contrasenia);
            return true;
        } catch (ClassNotFoundException ex) {
            this.error = ex.toString();
            return false;
        } catch (SQLException ex) {
            this.error = ex.toString();
            return false;
        }
    }

    public boolean prepararSentencia(String sql) {
        this.error = null;
        try {
            this.sentencia = this.conexion.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            return true;
        } catch (SQLException ex) {
            this.error = ex.toString();
            return false;
        }
    }

    public Object[][] Seleccionar(Object[] parametros) {
        this.error = null;
        try {
            this.cargar(parametros);
            this.datos = this.sentencia.executeQuery();
            return this.toArray(this.datos);
        } catch (SQLException ex) {
            this.error = ex.toString();
            return null;
        }
    }

    public boolean ejecutar(Object[] parametros) {
        this.error=null;
        try {
            this.cargar(parametros);
            return this.sentencia.executeUpdate() > 1;
        } catch (SQLException ex) {
            this.error = ex.toString();
            return false;
        }
    }

    private void cargar(Object[] lista) throws SQLException {
        int i = 1;
        for (Object valor : lista) {

            if (valor instanceof Integer) {
                this.sentencia.setInt(i, (int) valor);
            }

            if (valor instanceof Double) {
                this.sentencia.setDouble(i, (double) valor);
            }

            if (valor instanceof String) {
                this.sentencia.setString(i, (String) valor);
            }

            if (valor instanceof Date) {
                this.sentencia.setDate(i, (Date) valor);
            }

            i++;
        }
    }

    private Object[][] toArray(ResultSet rs) throws SQLException {
        rs.last();
        Object[][] datos = new Object[rs.getRow()][rs.getMetaData().getColumnCount()];
        rs.beforeFirst();
        int f = 0;
        while (rs.next()) {
            for (int c = 0; c < rs.getMetaData().getColumnCount(); c++) {
                datos[f][c] = rs.getObject(c + 1);
            }
            f++;
        }
        return datos;
    }
}
