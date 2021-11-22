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
public class Prueba {
    private Date fecha;
    private String hora;
    private Oficial oficial;
    private String observaciones;
    private int nota;
    private boolean estado;
    private Cliente cliente;
    private int id;
    
    public Prueba(Date fecha, String hora, Oficial oficial, String observaciones, int nota, boolean estado, Cliente cliente) {
        this.fecha = fecha;
        this.hora = hora;
        this.oficial = oficial;
        this.observaciones = observaciones;
        this.nota = nota;
        this.estado = estado;
        this.cliente = cliente;//Preguntar profe
    }

    public Prueba() {
    }

    public Prueba(int id) {
        this.id = id;
    }
}
