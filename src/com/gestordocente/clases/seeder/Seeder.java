/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gestordocente.clases.seeder;

import com.gestordocente.clases.Asignatura;
import com.gestordocente.clases.Departamento;
import com.gestordocente.clases.categoria.Categoria;
import com.gestordocente.clases.profesor.Adiestrado;
import com.gestordocente.clases.profesor.Profesor;
import java.util.Random;

/**
 *
 * @author sardlimad
 */
public class Seeder {
    
    private static final int maxHorasClase = 60; //Cada turno equivale a 2 h/c, el dia tiene 6 turnos, 5 dias a la semana

    private static final Random random = new Random();

    private static final String nombres[] = {"David", "Antonio", "Ernesto", "Juan", "Pedro", "Manuel", "Enrique", "Diego", "Leonel", "Carlos",
                                             "Maria", "Juana", "Claudia", "Mirta", "Martha", "Laura", "Daniela", "Jennifer", "Caridad", "Mónica"};

    private static final String apellidos[] = {"Gutierrez", "Lopez", "Sardiñas", "Farrés", "Costales", "Lima", "Corzo", "Gallardo", "Vazquez", "Paz", "Velazquez", "Rivero", "Alonso"};
    
    private static final String asignaturas[] = {"Matemática Discreta", "Álgebra", "Cálculo", "Física", "Base de Datos", "Programación", "Estructura de Datos y Algoritmos"};

    private static final String disciplinas[] = {"Álgebra Lineal y Cálculo", "Inteligencia Computacional", "Criptografía", "Redes y Arquitectua de Computadoras", "Estadística", "Análisis Numérico", "Geometría Computacional"};

    private static final String evaluacion[] = {"Prueba Final", "Trabajo Final"};
    
    public static String randomCI() {
        String ci = "";

        for (int i = 0; i < 11; i++) {
            ci += random.nextInt(10);
        }
        return ci;
    }

    public static String randomNombre() {
        String nombreCompleto = nombres[random.nextInt(nombres.length)]+" "+ apellidos[random.nextInt(apellidos.length)]+" "+ apellidos[random.nextInt(apellidos.length)];
        return nombreCompleto;
    }

    public static Categoria randomCatDocente() {
        Categoria[] categorias = Departamento.getCatDocentes();
        return categorias[random.nextInt(categorias.length -1)]; //Length -1 para que nunca establezca la categoria Adiestrado
    }
    
    public static Categoria randomCatCientifica() {
        Categoria[] categorias = Departamento.getCatCientificas();
        return categorias[random.nextInt(categorias.length)];
    }
    
    public static String randomAsignatura(){
        return asignaturas[random.nextInt(asignaturas.length)];
    }
    
    public static String randomDisciplina(){
        return disciplinas[random.nextInt(disciplinas.length)];
    }
    
    public static int[] randomHorasClase(){
        int[] horasClase = new int[5];
        int hc = 0; //Horas Clases consumidas (Max H.C semanales x Asignaturas es 10)
                
        for (int i = 0; i < horasClase.length; i++) {            
            horasClase[i] = random.nextInt(11-hc);
            hc+= horasClase[i];
        }
        return horasClase;
    }
    
    public static String randomCarrera(){
        String[] carreras = Departamento.getCarreras();
        return carreras[random.nextInt(carreras.length)];
    }
    
    public static String randomEvaluacion() {
        return evaluacion[random.nextInt(evaluacion.length)];
    }
    
    //Generadores de Tipos Primarios (Profesores, Asignaturas)

    public static Profesor[] generateProfesor(int cant) {
        Profesor[] profesores = new Profesor[0];
              
        for (int i = 0; i < cant; i++) {
            Profesor[] aux = new Profesor[profesores.length + 1];
            System.arraycopy(profesores, 0, aux, 0, profesores.length);
            if(random.nextBoolean()){
                aux[aux.length - 1] = new Profesor(randomCI(), randomNombre(), randomCatDocente(), randomCatCientifica(), random.nextInt(30));
            }
            else {
                aux[aux.length - 1] = new Adiestrado(randomCI(), randomNombre(), Departamento.getCatDocentes()[4], randomCatCientifica(), random.nextInt(30), random.nextBoolean());
            }
            profesores = aux;
        }
        return profesores;
    }
       
    
    public static Asignatura[] generateAsignatura(int cant){
        Asignatura[] asig_temp = new Asignatura[0];
        
        for (int i = 0; i < cant; i++) {
            Asignatura[] aux = new Asignatura[asig_temp.length + 1];
            System.arraycopy(asig_temp, 0, aux, 0, asig_temp.length);
            if(!random.nextBoolean()){
                aux[aux.length - 1] = new Asignatura(randomAsignatura(), randomDisciplina(), randomHorasClase(), "E", randomCarrera(), random.nextInt(5)+1);
            }
            else {
                aux[aux.length - 1] = new Asignatura(randomAsignatura(), randomDisciplina(), randomHorasClase(), "E", randomCarrera(), random.nextInt(5)+1, randomEvaluacion());
            }
            asig_temp = aux;
        }
        return asig_temp;
    }
}
