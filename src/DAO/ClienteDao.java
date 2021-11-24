/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import BaseDatos.BaseDatos;
import Clases.Cliente;
import java.util.Date;

/**
 *
 * @author chave
 */
public class ClienteDao implements DAO<Cliente>{
      BaseDatos bd;

    public ClienteDao(BaseDatos bd) {
        this.bd = bd;
    }

    @Override
    public boolean insertar(Cliente cliente) {
        if(cliente.requeridos()){
            this.bd.prepararSentencia("Insert into clientes Values(?,?,?,?,?,?,?)");
            Object[] parametros={cliente.getCedula(),cliente.getNombre(),cliente.getApellido1(),cliente.getApellido2(),cliente.getFecha(),cliente.getTelefono(),cliente.getCorreo()};
            return this.bd.ejecutar(parametros);
        }
        return false;
    }

    @Override
    public boolean modificar(Cliente cliente) {
      this.bd.prepararSentencia("Update clientes set Nombre=?,Apellido1=?,Apellido2=?,Fecha=?,Telefono=?Correo=? Where Cedula=?");
        Object[] parametros={cliente.getCedula(),cliente.getNombre(),cliente.getApellido1(),cliente.getApellido2(),cliente.getFecha(),cliente.getTelefono(),cliente.getCorreo()};
        return this.bd.ejecutar(parametros);
    }

    @Override
    public boolean eliminar(Cliente cliente) {
        this.bd.prepararSentencia("Delete from provincia Where Cedula=?");
        Object[] parametros={cliente.getCedula()};
        return this.bd.ejecutar(parametros);
        
    }

    @Override
    public Cliente buscar(Cliente cliente) {
         this.bd.prepararSentencia("Select * from clientes Where Cedula=?");
         Object[] parametros={cliente.getCedula()};
         Object [][] valores;
         valores=this.bd.seleccionar(parametros);
         if(valores.length>0){
             return new Cliente((int)valores[0][0],String.valueOf(valores[0][1]),String.valueOf(valores[0][2]),String.valueOf(valores[0][3]),(Date) valores[0][4],(int) valores[0][5],String.valueOf(valores[0][6]));
         }
         return null;

    }

    @Override
    public Cliente[] listar() {
         this.bd.prepararSentencia("Select * from clientes Order by Cedula");
         Object[] parametros={};
         Object [][] valores;
         valores=this.bd.seleccionar(parametros);
         if(valores.length>0){
             Cliente []clientes=new Cliente[valores.length];
             for(int f=0;f<=valores.length-1;f++){
                 clientes[f]=new Cliente((int)valores[f][0],String.valueOf(valores[f][1]),String.valueOf(valores[f][2]),String.valueOf(valores[f][3]),(Date) valores[f][4],(int) valores[f][5],String.valueOf(valores[f][6]));
             }
             
             return clientes;
         }
         return null;
    }

    @Override
    public boolean validarPK(Cliente cliente) {
         cliente=this.buscar(cliente);
        return cliente==null;
    }

    @Override
    public boolean validarFK(Cliente ob) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     
    
}
