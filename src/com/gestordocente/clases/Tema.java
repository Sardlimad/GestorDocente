package com.gestordocente.clases;

import java.awt.Color;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author sardlimad
 */
public class Tema {

    //Cambie por los colores de su preferencia
    private static Color primary = new Color(34, 40, 49);
    private static Color secondary = new Color(57, 62, 70);
    private static Color button = new Color(0, 120, 181);
    private static Color background = new Color(238, 238, 238);

    //<-----------GETTERS
    public static Color getPrimary() {
        return primary;
    }

    public static Color getSecondary() {
        return secondary;
    }
    
    public static Color getSecondaryHover(){
        return secondary.darker();
    }

    public static Color getTertiary() {
        return new Color(221,221,221);
    }

    public static Color getButton() {
        return button;
    }

    public static Color getButtonHover() {
        return button.darker();
    }

    public static Color getBackground() {
        return background;
    }   

}
