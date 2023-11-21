/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gestordocente.clases;

/**
 *
 * @author sardlimad
 */
public class Asignatura {
    protected String nombre;
    protected String disciplina;
    protected static String[] tipos = {"Conferencia", "Clase Practica", "Seminario", "Laboratorio", "Taller"}; //Cambiar static
    protected Turno[] turnos = new Turno[5]; //[0]Conferencias, [1]CP, [2]Seminario, [3]Laboratorio, [4]Taller.
//    protected int[] horasClase = new int[5];
    protected String planEst;
    protected String carrera;
    protected int aAcademico; //Año Academico
    protected String tipoEvalFinal = "Ninguna";

    //Constructor para Asignatura sin Evaluacion Final
    public Asignatura(String nombre, String disciplina, int[] horasClase, String planEst, String carrera, int aAcad) {

        this.nombre = nombre;
        this.disciplina = disciplina;
        this.planEst = planEst;
        this.carrera = carrera;
        this.aAcademico = aAcad;
        
//        this.horasClase = horasClase;
        
       // Crear los tipos de clases de la asignatura
        for(int i=0; i< this.turnos.length; i++){
            this.turnos[i] = new Turno(this.tipos[i], horasClase[i]);
        }

    }

    //Construcotr para Asignatura con Evaluacion Final
    public Asignatura(String nombre, String disciplina, int[] horasClase, String planEst, String carrera, int aAcad, String tipoEvalFinal) {

        this.nombre = nombre;
        this.disciplina = disciplina;
        this.planEst = planEst;
        this.carrera = carrera;
        this.aAcademico = aAcad;
        this.tipoEvalFinal = tipoEvalFinal;
        
//        this.horasClase = horasClase;

        //Crear los tipos de clases de la asignatura
        for(int i=0; i< this.turnos.length; i++){
            this.turnos[i] = new Turno(this.tipos[i], horasClase[i]);
        }
//        
//        System.out.println("Asig2 Creada");
    }
    
    //Metodos set
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public void setPlanEst(String planEst) {
        this.planEst = planEst;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public void setaAcademico(int aAcademico) {
        this.aAcademico = aAcademico;
    }

    public void setTipoEvalFinal(String tipoEvalFinal) {
        this.tipoEvalFinal = tipoEvalFinal;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public String getDisciplina(){
        return this.disciplina;
    }
    
    public String getPlanEst(){
        return this.planEst;
    }
    
    public String getCarrera(){
        return this.carrera;
    }

    public Turno[] getTurnos() {
        return turnos;
    }

//    public int[] getHorasClase() {
//        return horasClase;
//    }
    
    public int getAnho(){
        return this.aAcademico;
    }
    
    public String getEvalFinal(){
        return this.tipoEvalFinal;
    }
    
    public int getTotalHC(){
        int total = 0;
        
        for (Turno turno : turnos) {
            total += turno.getHorasClase();
        }
        return total;
    }
}
