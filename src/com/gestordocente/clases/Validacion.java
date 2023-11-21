/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gestordocente.clases;

/**
 *
 * @author sardlimad
 */
public class Validacion {
        
    public static void Float(java.awt.event.KeyEvent evt, javax.swing.JTextField input){
        int key = evt.getKeyChar();
        
        boolean numbers = key >= 48 && key <= 57;
        boolean dot = key == 46;
                       
        boolean hasDot = input.getText().contains(".");
        
        int decimales = 0;
        
        if(hasDot){
           decimales = input.getText().length()-1 - input.getText().indexOf(".");
        }
        
        //Condiciones de Validacion
        if(!numbers && !dot){ //solo admite numeros y punto
            evt.consume();
        }
        if(input.getText().length() == 0 && !numbers && dot){ //Si el primer caracter es un punto se autocompleta con '0.'
            input.setText("0.");
            evt.consume();
        }
        if(input.getText().length() == 0 && key==48){ //Si el primer caracter es un cero se autocompleta con '0.'
            input.setText("0.");
            evt.consume();
        }
        if(hasDot && !numbers){ //Si ya existe un punto no puedo poner otro
            evt.consume();
        }
        if(decimales == 2){ //si la cantidad de decimales es 2 ya no se puede escribir mas
            evt.consume();
        }
    }
    
    public static void Text(java.awt.event.KeyEvent evt, javax.swing.JTextField input, int length){
        int key = evt.getKeyChar();
        
        boolean letters = (key >= 65 && key <= 90) || (key >=97 && key <=122);
        boolean space = key== 32;
        
        if(!letters && !space) evt.consume();
        
        if(input.getText().length() >= length ) evt.consume();
    }
    
    public static void Number(java.awt.event.KeyEvent evt, javax.swing.JTextField input, int length){
        int key = evt.getKeyChar();
        
        boolean numbers = key >= 48 && key <= 57;
        
        if(!numbers) evt.consume();
        
        if (input.getText().length() >= length) evt.consume();
    }
}
