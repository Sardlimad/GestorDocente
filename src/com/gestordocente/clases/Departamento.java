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
    protected Profesor[] profesores = new Profesor[0];    
    protected Asignatura[] asignaturas = new Asignatura[0];

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
//    protected int planificacion[][][] = new int[5][this.asignaturas.length][this.profesores.length];
    protected static float salarioBase = 2500;
    protected static float aumentoAntig = 20;

    //Constructor vacio
    public Departamento() {
    }

    public Departamento(String nombre, String facultad, Profesor jefe, Profesor[] profesores, Asignatura[] asignaturas) {

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
        this.jefe = profesores[index];
    }

    public void setProfesores(Profesor[] profesores) {
        this.profesores = profesores;
    }

    public void setAsignaturas(Asignatura[] asignaturas) {
        this.asignaturas = asignaturas;
    }

    public void setAsignatura(int index, String nombre, String diciplina, int[] horasClase, String planEst, String carrera, int aAcad) {
        asignaturas[index] = new Asignatura(nombre, diciplina, horasClase, planEst, carrera, aAcad);
    }

    public void setAsignatura(int index, String nombre, String diciplina, int[] horasClase, String planEst, String carrera, int aAcad, String tipoEvalFinal) {
        asignaturas[index] = new Asignatura(nombre, diciplina, horasClase, planEst, carrera, aAcad, tipoEvalFinal);
    }

    public void setProfesor(int index, String ci, String nombre, Categoria catDocente, Categoria catCientifica, int tiempo, boolean disponible) {
        profesores[index] = new Profesor(ci, nombre, catDocente, catCientifica, tiempo);
        profesores[index].setDisponible(disponible);
    }

    public void setProfesor(int index, String ci, String nombre, Categoria catDocente, Categoria catCientifica, int tiempo, boolean disponible, boolean autorizo) {
        profesores[index] = new Adiestrado(ci, nombre, catDocente, catCientifica, tiempo, autorizo);
        profesores[index].setDisponible(disponible);
    }

    public void setSalarioBase(float salario) {
        salarioBase = salario;
    }

    public static void setAumentoAntig(float aumentoAntig) {
        Departamento.aumentoAntig = aumentoAntig;
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

    public Asignatura[] getAsignaturas() {
        return this.asignaturas;
    }

    public Profesor[] getProfesores() {
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

    public Categoria getCatDocenteAt(int index) {
        return categoriasDocentes[index];
    }

    public Categoria getCatDocenteByName(String text) {
        for (int i = 0; i < categoriasDocentes.length; i++) {
            if (categoriasDocentes[i].getNombre().equals(text)) {
                return categoriasDocentes[i];
            }
        }

        return null;
    }

    public Categoria getCatCientificaAt(int index) {
        return categoriasCientificas[index];
    }

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

    //Otros Metodos
    public void AddProfesor(String ci, String nombre, Categoria catDocente, Categoria catCientifica, int tiempo) {

        Profesor aux[] = new Profesor[this.profesores.length + 1]; //Crear nuevo array

        for (int i = 0; i < this.profesores.length; i++) {
            aux[i] = this.profesores[i];
        }

        //Alamcenar nuevo Profesor en la ultima posicion
        aux[aux.length - 1] = new Profesor(ci, nombre, catDocente, catCientifica, tiempo);

        this.profesores = aux;
    }

    public void AddProfesor(String ci, String nombre, Categoria catDocente, Categoria catCientifica, int tiempo, boolean autorizo) {

        Profesor aux[] = new Profesor[this.profesores.length + 1]; //Crear nuevo array

        for (int i = 0; i < this.profesores.length; i++) {
            aux[i] = this.profesores[i];
        }

        //Alamcenar nuevo Profesor en la ultima posicion (Tipo Adiestrado)
        aux[aux.length - 1] = new Adiestrado(ci, nombre, catDocente, catCientifica, tiempo, false);

        this.profesores = aux;
    }

    public void AddAsignatura(String nombre, String diciplina, int[] horasClase, String planEst, String carrera, int aAcad) {

        Asignatura aux[] = new Asignatura[this.asignaturas.length + 1]; //Crear nuevo array

        for (int i = 0; i < this.asignaturas.length; i++) {
            aux[i] = this.asignaturas[i];
        }

        aux[aux.length - 1] = new Asignatura(nombre, diciplina, horasClase, planEst, carrera, aAcad);

        this.asignaturas = aux;
    }

    public void AddAsignatura(String nombre, String diciplina, int[] horasClase, String planEst, String carrera, int aAcad, String tipoEvalFinal) {
        Asignatura aux[] = new Asignatura[this.asignaturas.length + 1]; //Crear nuevo array

        for (int i = 0; i < this.asignaturas.length; i++) {
            aux[i] = this.asignaturas[i];
        }

        aux[aux.length - 1] = new Asignatura(nombre, diciplina, horasClase, planEst, carrera, aAcad, tipoEvalFinal);

        this.asignaturas = aux;
    }

    public void RemoveAsignaturaAt(int index) {
        Asignatura aux[] = new Asignatura[this.asignaturas.length - 1];

        for (int i = 0; i < aux.length; i++) {

            if (i >= index) {
                aux[i] = this.asignaturas[i + 1];
            } else {
                aux[i] = this.asignaturas[i];
            }

        }
        asignaturas = aux;
    }

    public void RemoveProfesorAt(int index) {
        Profesor aux[] = new Profesor[this.profesores.length - 1];

        for (int i = 0; i < aux.length; i++) {

            if (i >= index) {
                aux[i] = this.profesores[i + 1];
            } else {
                aux[i] = this.profesores[i];
            }

        }
        profesores = aux;
    }

    public void AddCatDocente(String nombre, float aumento) {
        Categoria[] aux = new Categoria[categoriasDocentes.length + 1];

        for (int i = 0; i < categoriasDocentes.length; i++) {
            aux[i] = categoriasDocentes[i];
        }

        aux[aux.length - 1] = new Categoria(nombre, aumento);

        categoriasDocentes = aux;
    }

    public void AddCatCientifica(String nombre, float aumento) {
        Categoria[] aux = new Categoria[categoriasCientificas.length + 1];

        for (int i = 0; i < categoriasCientificas.length; i++) {
            aux[i] = categoriasCientificas[i];
        }

        aux[aux.length - 1] = new Categoria(nombre, aumento);

        categoriasCientificas = aux;
    }

    //Realizar la distribucion de profesores por Tipo de Clase de cada Asignaturas
    public boolean setPlan() {
        System.out.flush();

        if (!posibleSetPlan()) {
            String mensaje = "Imposible generar la Planfificación. Profesores insuficientes.";
            GestorDocente.showAlert(nombre, mensaje, JOptionPane.ERROR_MESSAGE);
            return false; //fallo al crear el plan
        }

        //Liberar a los profesores de todos los turnos
        for (Asignatura asig : asignaturas) {
            for (Turno turno : asig.getTurnos()) {
                turno.setProfesor(null);
            }
        }

        //Reestablecer HorasClase de Profesores
        for (Profesor profesor : profesores) {
            profesor.restartHoras();
        }

        //[0]Catg.Docentes, [1]Profesores pertenecientes a una Catg.
        Profesor[][] profes = agruparProfe();

//        int indexProfe = 0; //Indice del profesor con menor cantidad de Horas ClaSe
//        int minCant = 0; //menor cantidad de Horas Clase;
        //Iterar por Tipos de Clase
        for (int i = 0; i < 5; i++) {
            //Iterar por Asignaturas
            for (int j = 0; j < this.asignaturas.length; j++) {
                if (this.asignaturas[j].getTurnos()[i].getHorasClase() == 0) {
                    continue;
                }
                //Iterar por Array de Arrays de Profesores Agrupados por C. Docente
                for (int k = 0; k < profes.length; k++) {

                    if (profes[k].length == 0) {
                        continue;
                    }
                    int indexProfe = 0; //Indice del profesor con menor cantidad de Horas ClaSe
                    int minCant = profes[k][indexProfe].getHoras(); //menor cantidad de Horas Clase;
                    //Iterar por Profesores de una categoria k
                    for (int l = 0; l < profes[k].length; l++) {
                        //Si las horas clases del profesor son menores que las existentes entonces actualizar indexProfe y minCant
                        if (profes[k][l].getHoras() < minCant) {
                            indexProfe = l;
                            minCant = profes[k][l].getHoras();
                        }
                    }

                    Profesor profe = profes[k][indexProfe];
//                    
                    boolean noExcede = (profe.getHoras() + this.asignaturas[j].getTurnos()[i].getHorasClase()) <= 12; //si super las 12 horas se excede
                    
                    if (noExcede && profe.isCalificado()) {
                        this.asignaturas[j].getTurnos()[i].setProfesor(profe); //Establecer Profesor para ese Turno
                        profe.addHoras(this.asignaturas[j].getTurnos()[i].getHorasClase());  //Aumentar las horas clase del Profesor                      
                        break;
                    }
                }
            }
        }
        return true; //true El plan se creo satisfactoriamente
    }

    public Profesor[][] agruparProfe() {

        Profesor[][] profes = new Profesor[5][];

        for (int i = 0; i < profes.length; i++) {
            profes[i] = new Profesor[0];
        }

        for (Profesor profesor : profesores) {

            switch (profesor.getCatDocente().getNombre()) {

                case "Profesor Titular":
                    Profesor[] titular = new Profesor[profes[0].length + 1];
                    System.arraycopy(profes[0], 0, titular, 0, profes[0].length);
                    titular[titular.length - 1] = profesor;
                    profes[0] = titular;
                    break;

                case "Profesor Auxiliar":
                    Profesor[] auxiliar = new Profesor[profes[1].length + 1];
                    System.arraycopy(profes[1], 0, auxiliar, 0, profes[1].length);
                    auxiliar[auxiliar.length - 1] = profesor;
                    profes[1] = auxiliar;
                    break;

                case "Asistente":
                    Profesor[] asistente = new Profesor[profes[2].length + 1];
                    System.arraycopy(profes[2], 0, asistente, 0, profes[2].length);
                    asistente[asistente.length - 1] = profesor;
                    profes[2] = asistente;
                    break;

                case "Instructor":
                    Profesor[] instructor = new Profesor[profes[3].length + 1];
                    System.arraycopy(profes[3], 0, instructor, 0, profes[3].length);
                    instructor[instructor.length - 1] = profesor;
                    profes[3] = instructor;
                    break;

                case "Adiestrado":
                    Profesor[] adiestrado = new Profesor[profes[4].length + 1];
                    System.arraycopy(profes[4], 0, adiestrado, 0, profes[4].length);
                    adiestrado[adiestrado.length - 1] = profesor;
                    profes[4] = adiestrado;
                    break;

                default:
                    throw new AssertionError();
            }
        }
        return profes;
    }

    public boolean posibleSetPlan() {
        int cantProfes = 0;//Cant. profesor disponibles
        for (Profesor profe : profesores) {
            if (profe.isCalificado()) {
                cantProfes++;
            }
        }

        int horasAsigs = 0;

        for (Asignatura asig : asignaturas) {
            for (Turno turno : asig.getTurnos()) {
                horasAsigs += turno.getHorasClase();
            }
        }
        System.out.println(horasAsigs + "|" + cantProfes * 12);

        return horasAsigs <= cantProfes * 12;
    }
}
