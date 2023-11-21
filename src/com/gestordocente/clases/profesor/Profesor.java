/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gestordocente.clases.profesor;

import com.gestordocente.clases.Departamento;
import com.gestordocente.clases.categoria.Categoria;

/**
 *
 * @author sardlimad
 */
public class Profesor {
    protected String ci;
    protected String nombre;
    protected Categoria catDocente;
    protected Categoria catCientifica;
    protected int tiempoServicio; //Antiguedad en Años
    protected boolean disponible = true;
    
    protected int horas = 0;

    public Profesor(String ci, String nombre,Categoria catDocente, Categoria catCientifica, int tiempo) {
        this.ci = ci;
        this.nombre = nombre;
        this.catDocente = catDocente;
        this.catCientifica = catCientifica;
        this.tiempoServicio = tiempo;
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Categoria getCatDocente() {
        return catDocente;
    }

    public void setCatDocente(Categoria catDocente) {
        this.catDocente = catDocente;
    }
    
    public void restartHoras(){
        this.horas = 0;
    }

    public void addHoras(int horas) {
        this.horas = this.horas + horas;
    }
    

    public Categoria getCatCientifica() {
        return catCientifica;
    }

    public void setCatCientifica(Categoria catCientifica) {
        this.catCientifica = catCientifica;
    }

    public int getTiempoServicio() {
        return tiempoServicio;
    }

    public void setTiempoServicio(int tiempoServicio) {
        this.tiempoServicio = tiempoServicio;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
    
    
    public int getHoras() {
        return horas;
    }
    
    //Otros Metodos
    
    public boolean isCalificado(){
        System.out.println(catDocente.getNombre()+": "+ nombre +": "+ disponible);
        return disponible; 
    }
    
    public float getSalario(){
        return Departamento.getSalarioBase() + catDocente.getAumento()+ catCientifica.getAumento() + (tiempoServicio*20); 
    }
}
