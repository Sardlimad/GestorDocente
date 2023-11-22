/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gestordocente.clases;

/**
 *
 * @author sardlimad
 */
public class Lista<T> {

    protected T[] items = (T[]) new Object[0];//inicialir el array con longitud 0

    public Lista() {
       
    }

    //Agregar elementos
    public void addItem(T item) {
        T[] aux_items = (T[]) new Object[items.length + 1];

        for (int i = 0; i < items.length; i++) {
            aux_items[i] = items[i];
        }

        aux_items[aux_items.length - 1] = item; //agragar el nuevo elemento en la ultima posicion         
        items = aux_items; //igualar el array principal al auxiliar
    }

    //Remover elementos
    public void removeItemAt(int index) {
        
        if(index>= items.length) return;

        T[] aux_items = (T[]) new Object[items.length - 1];

        for (int i = 0; i < aux_items.length; i++) {
            if (i < index) {
                aux_items[i] = items[i];
            } else {
                aux_items[i] = items[i + 1];
            }
        }

        items = aux_items; //igualar el array principal al auxiliar
    }
    
    //Devolver la cantidad de elementos
    public int count() {
        return items.length;
    }
    
    public boolean isEmpty(){
        return items.length == 0;
    }
    
    public T getItemAt(int index){
        return items[index];
    }
    
    public void setItemAt(int index, T item){
        items[index] = item;
    }

}
