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

    private boolean autorizado = false; //autorio para docencia

    public Adiestrado(String ci, String nombre,Categoria catDocente, Categoria catCientifica, int tiempo,boolean disponible, boolean autorizo) {
        super(ci, nombre,catDocente, catCientifica, tiempo, disponible);

        this.autorizado = autorizo;
    }

    public boolean isAutorizado() {
        return autorizado;
    }

    public void setAutorizado(boolean autorizado) {
        this.autorizado = autorizado;
    }
    
    @Override
    public boolean isCalificado(){
                
        if(!disponible) return false;
        
        if(tiempoServicio <= 1) return autorizado;
        
        return true;
        
//        return  disponible && (tiempoServicio <= 1 ? autorizado : true);
    }

}
