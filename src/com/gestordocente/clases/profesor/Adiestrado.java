/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gestordocente.clases.profesor;

import com.gestordocente.clases.categoria.Categoria;

/**
 *
 * @author sardlimad
 */
public class Adiestrado extends Profesor {

    private boolean autorizo = false; //autorio para docencia

    public Adiestrado(String ci, String nombre,Categoria catDocente, Categoria catCientifica, int tiempo, boolean autorizo) {
        super(ci, nombre,catDocente, catCientifica, tiempo);

        this.autorizo = autorizo;
    }

    public boolean isAutorizo() {
        return autorizo;
    }

    public void setAutorizo(boolean autorizo) {
        this.autorizo = autorizo;
    }
    
    @Override
    public boolean isCalificado(){
                
        if(!disponible) return false;
        
        if(tiempoServicio <= 1) return autorizo;
        
        return true;
        
//        return  disponible && (tiempoServicio <= 1 ? autorizo : true);
    }

}
