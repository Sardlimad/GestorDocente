/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gestordocente.clases.categoria;

/**
 *
 * @author sardlimad
 */
public class Categoria {
    protected boolean docente;
    protected String nombre;
    protected float aumento;
    
    public Categoria(String nombre, float aumento){
        this.nombre = nombre;
        this.aumento = aumento;
    }

    //Metodos GET
    public boolean IsDocente() {
        return docente;
    }

    public String getNombre() {
        return nombre;
    }

    public float getAumento() {
        return aumento;
    }
    
    //Metodos SET

    public void setAumento(float aumento) {
        this.aumento = aumento;
    }
    
}
