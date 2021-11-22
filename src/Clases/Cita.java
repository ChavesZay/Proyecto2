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
public class Cita {
    private int id;
    private Date fecha;
    private String hora;
    private Cliente cliente;

    public Cita(Date fecha, String hora, Cliente cliente) {
        this.fecha = fecha;
        this.hora = hora;
        this.cliente = cliente;
    }

    public Cita(int id) {
        this.id = id;
    }

    public Cita() {
    }
    
}
