/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gestordocente.clases;

import com.gestordocente.GestorDocente;
import com.gestordocente.clases.categoria.Categoria;
import com.gestordocente.clases.profesor.Adiestrado;
import com.gestordocente.clases.profesor.Profesor;
import com.gestordocente.clases.seeder.Seeder;
import javax.swing.JOptionPane;

/**
 *
 * @author sardlimad
 */
public class Departamento {

    protected String nombre = "Departamento";
    protected String facultad = "Facultad";
    protected Profesor jefe;
    protected Lista<Profesor> profesores;
    protected Lista<Asignatura> asignaturas;

    protected static Categoria[] categoriasDocentes = {
        new Categoria("Profesor Titular", 500),
        new Categoria("Profesor Auxiliar", 300),
        new Categoria("Asistente", 250),
        new Categoria("Instructor", 150),
        new Categoria("Adiestrado", 100),};

    protected static Categoria[] categoriasCientificas = {
        new Categoria("Doctor en Ciencias", 500),
        new Categoria("Máster", 300)
    };

    protected static String[] carreras = {"Ingeniería en Ciencias Informáticas",
        "Ingeniería en Ciberseguridad",
        "Ingeniería en Bioinformática",
        "Técnico Superior en Redes y Seguridad Informática"};

    //Array multidimensional de tamaño: Cantidad de Tipos de Clase(5) x Cantidad de Asignaturas x Cantidad de Profesores
    //protected int planificacion[][][] = new int[5][this.asignaturas.length][this.profesores.length];
    protected static float salarioBase = 2500;
    protected static float aumentoAntig = 20;
    
    protected static boolean confProfeT; //Conferencia solo profesores Titulares

    //Constructor vacio
    public Departamento() {
    }

    public Departamento(String nombre, String facultad, Profesor jefe, Lista<Profesor> profesores, Lista<Asignatura> asignaturas) {

        this.nombre = nombre;
        this.facultad = facultad;
        this.jefe = jefe;
        this.profesores = profesores;
        this.asignaturas = asignaturas;

    }

    public void seed(int asigs, int profes) {
        setAsignaturas(Seeder.generateAsignatura(asigs));
        setProfesores(Seeder.generateProfesor(profes));
    }

    //Metodos set
    public void setNombre(String text) {
        this.nombre = text;
    }

    public void setFacultad(String text) {
        this.facultad = text;
    }

    public void setJefe(Profesor jefe) {
        this.jefe = jefe;
    }

    public void setJefe(int index) {
        this.jefe = profesores.getItemAt(index);
    }

    public void setProfesores(Lista<Profesor> profesores) {
        this.profesores = profesores;
    }

    public void setAsignaturas(Lista<Asignatura> asignaturas) {
        this.asignaturas = asignaturas;
    }

    public void setAsignatura(int index, String nombre, String diciplina, int[] horasClase, String planEst, String carrera, int aAcad) {
        Asignatura asignatura = new Asignatura(nombre, diciplina, horasClase, planEst, carrera, aAcad);
        asignaturas.setItemAt(index, asignatura);
    }

    public void setAsignatura(int index, String nombre, String diciplina, int[] horasClase, String planEst, String carrera, int aAcad, String tipoEvalFinal) {
        Asignatura asignatura = new Asignatura(nombre, diciplina, horasClase, planEst, carrera, aAcad, tipoEvalFinal);
        asignaturas.setItemAt(index, asignatura);
    }

    public void setProfesor(int index, String ci, String nombre, Categoria catDocente, Categoria catCientifica, int tiempo, boolean disponible) {
        Profesor profesor = new Profesor(ci, nombre, catDocente, catCientifica, tiempo, disponible);
        profesores.setItemAt(index, profesor);

    }

    public void setProfesor(int index, String ci, String nombre, Categoria catDocente, Categoria catCientifica, int tiempo, boolean disponible, boolean autorizo) {
        Profesor profesor = new Adiestrado(ci, nombre, catDocente, catCientifica, tiempo, disponible, autorizo);
        profesores.setItemAt(index, profesor);
    }

    public void setSalarioBase(float salario) {
        salarioBase = salario;
    }

//    public static void setAumentoAntig(float aumentoAntig) {
//        Departamento.aumentoAntig = aumentoAntig;
//    }

    public static void setConfProfeT(boolean confProfeT) {
        Departamento.confProfeT = confProfeT;
    }
    

    //Metodos get
    public String getNombre() {
        return nombre;
    }

    public String getFacultad() {
        return facultad;
    }

    public Profesor getJefe() {
        return jefe;
    }

    public Lista<Asignatura> getAsignaturas() {
        return this.asignaturas;
    }

    public Lista<Profesor> getProfesores() {
        return profesores;
    }

    public static Categoria[] getCatDocentes() {
        return categoriasDocentes;
    }

    public static Categoria[] getCatCientificas() {
        return categoriasCientificas;
    }

    public static String[] getCarreras() {
        return carreras;
    }

//    public Categoria getCatDocenteAt(int index) {
//        return categoriasDocentes[index];
//    }

    public Categoria getCatDocenteByName(String text) {
        for (int i = 0; i < categoriasDocentes.length; i++) {
            if (categoriasDocentes[i].getNombre().equals(text)) {
                return categoriasDocentes[i];
            }
        }

        return null;
    }

//    public Categoria getCatCientificaAt(int index) {
//        return categoriasCientificas[index];
//    }

    public Categoria getCatCientificaByName(String text) {

        for (int i = 0; i < categoriasCientificas.length; i++) {
            if (categoriasCientificas[i].getNombre().equals(text)) {
                return categoriasCientificas[i];
            }
        }

        return null;
    }

    public static float getSalarioBase() {
        return salarioBase;
    }

    public static float getAumentoAntig() {
        return aumentoAntig;
    }

    public static boolean getConfProfeT() {
        return confProfeT;
    }
    

    //Otros Metodos
    public void AddProfesor(String ci, String nombre, Categoria catDocente, Categoria catCientifica, int tiempo, boolean disponible) {
        profesores.addItem(new Profesor(ci, nombre, catDocente, catCientifica, tiempo, disponible));
    }

    public void AddProfesor(String ci, String nombre, Categoria catDocente, Categoria catCientifica, int tiempo, boolean disponible, boolean autorizo) {
        profesores.addItem(new Adiestrado(ci, nombre, catDocente, catCientifica, tiempo, disponible, autorizo));
    }

    public void AddAsignatura(String nombre, String diciplina, int[] horasClase, String planEst, String carrera, int aAcad) {
        asignaturas.addItem(new Asignatura(nombre, diciplina, horasClase, planEst, carrera, aAcad));
    }

    public void AddAsignatura(String nombre, String diciplina, int[] horasClase, String planEst, String carrera, int aAcad, String tipoEvalFinal) {
        asignaturas.addItem(new Asignatura(nombre, diciplina, horasClase, planEst, carrera, aAcad, tipoEvalFinal));
    }

    public void RemoveAsignaturaAt(int index) {
        asignaturas.removeItemAt(index);
    }

    public void RemoveProfesorAt(int index) {
        profesores.removeItemAt(index);
    }

//    public void AddCatDocente(String nombre, float aumento) {
//        Categoria[] aux = new Categoria[categoriasDocentes.length + 1];
//
//        for (int i = 0; i < categoriasDocentes.length; i++) {
//            aux[i] = categoriasDocentes[i];
//        }
//
//        aux[aux.length - 1] = new Categoria(nombre, aumento);
//
//        categoriasDocentes = aux;
//    }

//    public void AddCatCientifica(String nombre, float aumento) {
//        Categoria[] aux = new Categoria[categoriasCientificas.length + 1];
//
//        for (int i = 0; i < categoriasCientificas.length; i++) {
//            aux[i] = categoriasCientificas[i];
//        }
//
//        aux[aux.length - 1] = new Categoria(nombre, aumento);
//
//        categoriasCientificas = aux;
//    }

    //Realizar la distribucion de profesores por Tipo de Clase de cada Asignaturas
    public boolean setPlan() {
        //Si la cantidad de profesores *12 es menor que el total de horas/clase
        if (!isSetteablePlan()) {
            String mensaje = "Profesores insuficientes.";
            GestorDocente.showAlert("Imposible Planificar", mensaje, JOptionPane.ERROR_MESSAGE);
            return false; //fallo al crear el plan
        }
        //Si solo los totulares pueden dar conferencia y no hay suficientes profesores para cubir todas
        if (!suficientesTitulares() && confProfeT) {
            String mensaje = "Profesores Titulares insuficientes.";
            GestorDocente.showAlert("Imposible Planificar", mensaje, JOptionPane.ERROR_MESSAGE);
            return false; //fallo al crear el plan
        }

        //Liberar a los profesores de todos los turnos
        for (int i = 0; i < asignaturas.count(); i++) {
            for (Turno turno : asignaturas.getItemAt(i).getTurnos()) {
                turno.setProfesor(null);
            }
        }

        //Reestablecer HorasClase de Profesores
        for (int i = 0; i < profesores.count(); i++) {
            profesores.getItemAt(i).restartHoras();
        }

        //Array de Listas de profesores agrupados por Categorias
        Lista<Profesor>[] profesByCat = agruparProfe();

        //Iterar por Tipos de Clase
        for (int i = 0; i < 5; i++) {
            //Iterar por Asignaturas
            for (int j = 0; j < this.asignaturas.count(); j++) {
                if (this.asignaturas.getItemAt(j).getTurnos()[i].getHorasClase() == 0) {
                    continue;
                }
                //Iterar por Array de Arrays de Profesores Agrupados por C. Docente
                for (int k = 0; k < profesByCat.length; k++) {

                    if (profesByCat[k].isEmpty()) {
                        continue;
                    }
                    //Indice del profesor con menor cantidad de Horas ClaSe
                    int indexProfe = 0;
                    //menor cantidad de Horas Clase que tiene el profesor;
                    int minCant = profesByCat[k].getItemAt(indexProfe).getHoras();

                    //Iterar por Profesores de una categoria k
                    for (int l = 0; l < profesByCat[k].count(); l++) {
                        Profesor profesor = profesByCat[k].getItemAt(l);
                        //Si las horas clases del profesor son menores que las existentes entonces actualizar indexProfe y minCant
                        if (profesor.getHoras() < minCant) {
                            indexProfe = l;
                            minCant = profesor.getHoras();
                        }
                    }

                    Profesor profe = profesByCat[k].getItemAt(indexProfe);
                    Asignatura asig = this.asignaturas.getItemAt(j);

                    boolean noExcede = (profe.getHoras() + asig.getTurnos()[i].getHorasClase()) <= 12; //si supera las 12 horas se excede

                    if (noExcede && profe.isCalificado()) {
                        asig.getTurnos()[i].setProfesor(profe); //Establecer Profesor para ese Turno
                        profe.addHoras(asig.getTurnos()[i].getHorasClase());  //Aumentar las horas clase del Profesor                      
                        break;
                    }
                }
            }
        }
        return true; //true El plan se creo satisfactoriamente
    }

    //Agrupar profesores por categorias docentes
    public Lista<Profesor>[] agruparProfe() {

        Lista<Profesor>[] catgs = (Lista<Profesor>[]) new Lista[5];

        for (int i = 0; i < catgs.length; i++) {
            catgs[i] = new Lista<>();
        }

        for (int i = 0; i < profesores.count(); i++) {
            switch (profesores.getItemAt(i).getCatDocente().getNombre()) {
                case "Profesor Titular":
                    catgs[0].addItem(profesores.getItemAt(i));
                    break;
                case "Profesor Auxiliar":
                    catgs[1].addItem(profesores.getItemAt(i));
                    break;
                case "Asistente":
                    catgs[2].addItem(profesores.getItemAt(i));
                    break;
                case "Instructor":
                    catgs[3].addItem(profesores.getItemAt(i));
                    break;
                case "Adiestrado":
                    catgs[4].addItem(profesores.getItemAt(i));
                    break;

                default:
                    throw new AssertionError();
            }
        }
        return catgs;
    }

//Determinar si es posible establecer el plan teniendo en cuenta la cantidad de Horas Clases Totales y la cantidad de Profesores(max 12 horas)
    public boolean isSetteablePlan() {
        int cantProfes = 0;//Cant. profesor disponibles y calificados para impartir docencia

        for (int i = 0; i < profesores.count(); i++) {
            if (profesores.getItemAt(i).isCalificado()) {
                cantProfes++;
            }
        }

        int horasAsigs = 0; //Sumatoria de Horas Clase de todas las asignaturas

        for (int i = 0; i < asignaturas.count(); i++) {
            for (Turno turno : asignaturas.getItemAt(i).getTurnos()) {
                horasAsigs += turno.getHorasClase();
            }
        }
        
        return horasAsigs <= cantProfes * 12;
    }
    
    public boolean suficientesTitulares(){
        int profesTitulares = 0;//Cant. Profesor Titulares disponibles

        for (int i = 0; i < profesores.count(); i++) {
            Profesor profe = profesores.getItemAt(i);
            if (profe.isDisponible() && profe.getCatDocente().getNombre().equals("Profesor Titular")) {
                profesTitulares++;
            }
        }
        
        int horasConf = 0; //Sumatoria de Horas Clase de conferencia todas las asignaturas
        
        for (int i = 0; i < asignaturas.count(); i++) {
            horasConf += asignaturas.getItemAt(i).getTurnos()[0].getHorasClase(); //Horas Clase de conferencia en cada asignatura            
        }
        
        return horasConf <= profesTitulares *12;
    }
    
}
