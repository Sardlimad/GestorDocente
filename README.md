![Gedoo-Banner](Godoo_brand_banner.png)
# GestorDocente
Gedoo es un Gestor de Carga Docente desarrollado en Java. Este software se encarga de administrar la distribución de asignaturas entre los profesores de un Departamento. 
Permite el registro de profesores y asignaturas, y luego asigna las asignaturas a los profesores de siguiendo determinados criterios. 
Gedoo es una herramienta útil para los departamentos académicos que buscan optimizar la distribución de carga de trabajo entre sus profesores.

##Introducción
El proyecto UCi tiene como objetivo automatizar la planificación de la carga docente de un departamento específico. Esto implica la asignación de profesores a las distintas asignaturas que se deben impartir en un semestre.

El departamento a planificar se caracteriza por su nombre, la facultad a la que pertenece, el nombre del jefe del departamento, los profesores y la relación de las asignaturas que debe impartir en el semestre.

Cada profesor del departamento se identifica por su número de identidad, nombre y apellidos, categoría docente (Profesor Titular, Profesor Auxiliar, Asistente, Instructor, Adiestrado), categoría científica (Doctor en Ciencias, Máster) y salario, que varía en función de la categoría docente, la antigüedad y el pago por la categoría científica.

Las asignaturas se identifican por su nombre, la disciplina a la que pertenecen, la cantidad de horas por cada tipo de enseñanza (conferencia, clase práctica, seminario, laboratorio, taller), el plan de estudio al que pertenecen, la carrera y el año en que se imparten y si tienen o no evaluación final, y en caso de tenerla, incluye el tipo de evaluación final (exámen, trabajo de curso).

Para la planificación se considerará la disponibilidad de los profesores en el periodo, es decir, en el caso de los profesores adiestrados, en su primer año de trabajo, deben contar con la autorización de la universidad para impartir docencia.

Además, en la planificación se debe tener en cuenta que las conferencias deben ser impartidas por Profesores Titulares siempre que sea posible. También se establece un límite de que en una semana un profesor no puede impartir más de 12 horas de clases.

Este es el problema que el proyecto UCi busca resolver de manera eficiente y efectiva, contribuyendo a una planificación académica exitosa y potenciando el ambiente de aprendizaje tanto para estudiantes como educadores.

##### Condiciones para la planificación
* Disponibilidad del profesor.
* Los Adiestrados, en su primer año de trabajo necesitan autorización de la universidad para impartir docencia.
* Las clases de Conferencia deben ser impartidas por Profesores Titulares.
* En una semana un profesor no debe impartir más de 12 horas de clase.

### Diagrama de Clases UML

[Diagrama de clases UML (PDF)](/diagrama-clases-UML.pdf)

## Introducción

Aquí puedes proporcionar una descripción general de tu proyecto, incluyendo el objetivo, los requisitos y el alcance.

## Descripción del Proyecto

Describe en detalle el proyecto, incluyendo los componentes principales y cómo interactúan entre sí.

### Componente 1

Describe el primer componente del proyecto.

### Componente 2

Describe el segundo componente del proyecto.

### Componente 3

Describe el tercer componente del proyecto.

## Código

Aquí puedes incluir bloques de código para mostrar cómo se implementan las funcionalidades del proyecto.





Como parte del proyecto UCi se desea automatizar la planificación de la carga docente de un departamento, o sea, 
la asignación de profesores a las distintas asignaturas que se deben impartir en un semestre.

Del departamento a planificar se conoce el nombre, la facultad a la que pertenece, el nombre del jefe del departamento, los profesores y la relación de las asignaturas que debe impartir en el semestre.
De cada profesor del departamento se conoce el número de identidad, nombre y apellidos, categoría docente(Profesor Titular, Profesor Auxiliar, Asistente, Instructor, Adiestrado), categoría científica(Doctor en Ciencias, Máster) 
y salario, el cual depende de la categoría docente, la antigüedad y el pago por la categoría científica.

De cada asignatura se conoce el nombre, la disciplina a la que pertenece, la cantidad de horas por cada tipo de enceñanza(conferencia, clase práctica, seminario, laboratorio, taller),
el plan de estudio al que pertenece, la carrera y el año en que se imparte y si tiene o no evaluación final, y en caso de tener, incluye el tipo de evaluación final(exámen, trabajo de curso).

Para la planficiación se tendrá en cuenta la disponibilidad de los profesores en el periodo, es decir. En el caso de los profesores adiestrados, en su primer año de trabajo, tienen que contar con la autorización de la universidad, para impartir docencia.

En la planificación se debe tener en cuenta que las conferencias deben ser impartidas por Profesores Titulares siempre que se posible.
En una semana un profesor no puede impartir más de 12 horas de clases.