/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author jordy
 */
public interface DAO<Clase> {
    public boolean insertar(Clase ob);
    public boolean modificar(Clase ob);
    public boolean eliminar(Clase ob);
    public Clase buscar(Clase ob);
    public Clase[] listar();
    public boolean validarPK(Clase ob);
    public boolean validarFK(Clase ob);
}
