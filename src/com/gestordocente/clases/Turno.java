/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gestordocente.clases;

import com.gestordocente.clases.profesor.Profesor;

/**
 *
 * @author sardlimad
 */
public class Turno{
    private String tipo;
    private Profesor profesor;
    private int horasClase;
    
    public Turno(String tipo,int horasC){
        this.tipo = tipo;
        this.horasClase = horasC;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getHorasClase() {
        return horasClase;
    }

    public void setHorasClase(int horasClase) {
        this.horasClase = horasClase;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }
    
    
}
