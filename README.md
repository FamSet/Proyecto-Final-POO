# **Proyecto - Documentación del Código**

Este proyecto implementa una aplicación de gestión escolar en Java. Permite la creación, lectura, actualización y eliminación (CRUD) de registros de alumnos, además de generar datos aleatorios como nombres, direcciones, edades e historial académico. El sistema también incluye un proceso de autenticación mediante usuario y contraseña al inicio.

## **Índice**

1. Descripción General
2. Funcionalidades
3. Clases
   - Proyecto
   - Alumno
   - GeneradorNombres
   - GeneradorDirecciones
   - GeneradorEdad
   - GeneradorHistorial
   - GeneradorIndicador
   - AlumnoCRUD
   - Usuario
   - Login
   - QuickSort
4. Ejecución del Programa
5. Requisitos

---

## **Descripción General**

El proyecto consiste en una aplicación que simula un sistema de servicios escolares. El programa permite gestionar los registros de los alumnos, creando nuevos, listándolos, buscándolos por su número de inscripción, actualizando sus datos y eliminándolos del sistema. También es posible exportar los registros de los alumnos a un archivo CSV.

El sistema comienza solicitando las credenciales de usuario para autenticar al administrador. Una vez autenticado, se genera automáticamente una lista de 1000 alumnos con datos aleatorios, como nombre completo, edad, dirección, historial académico e indicador escolar.

---

## **Funcionalidades**

- **Autenticación:** El sistema permite verificar un usuario y contraseña antes de acceder al sistema de gestión de alumnos.
- **Generación aleatoria de datos:** Se crean 1000 registros de alumnos con datos aleatorios usando archivos CSV y texto predefinidos.
- **Operaciones CRUD:** El administrador puede crear, listar, buscar, actualizar y eliminar alumnos.
- **Exportación a CSV:** Los datos de los alumnos pueden exportarse a un archivo CSV.

---

## **Clases**

### **Proyecto**

La clase **Proyecto** contiene el método principal que ejecuta el programa. Se encarga de:

- Realizar la autenticación del usuario.
- Generar automáticamente los registros de los alumnos.
- Mostrar el menú interactivo para realizar operaciones CRUD.

#### Métodos:
- **public static void main(String[] args):** 
  - Método principal que inicia el sistema y gestiona la interacción con el usuario.
  
- **private static List<Alumno> generarAlumnos():** 
  - Método que genera 1000 alumnos aleatorios utilizando clases auxiliares como `GeneradorNombres`, `GeneradorDirecciones`, `GeneradorHistorial`, etc.

---

### **Alumno**

La clase **Alumno** representa un registro de un estudiante. Contiene atributos como el nombre, edad, dirección, historial académico, número de inscripción e indicador escolar.

#### Atributos:
- **String nombreCompleto:** Nombre completo del alumno.
- **int edad:** Edad del alumno.
- **String direccion:** Dirección del alumno.
- **List<String> historialAcademico:** Listado de materias cursadas por el alumno.
- **int numeroMaterias:** Número de materias que cursó el alumno.
- **String numeroInscripcion:** Número único de inscripción del alumno.
- **double indicadorEscolar:** Indicador académico basado en el número de materias.

#### Métodos:
- **public void actualizarAlumno(Alumno nuevoAlumno):**
  - Actualiza la información del alumno con los datos de un nuevo alumno.
  
- **@Override public String toString():**
  - Devuelve una representación en cadena de texto del alumno.

---

### **GeneradorNombres**

La clase **GeneradorNombres** se encarga de generar nombres completos aleatorios para los alumnos, tomando nombres y apellidos desde un archivo CSV.

#### Métodos:
- **public String generarNombreCompleto():**
  - Genera un nombre completo aleatorio, combinando nombres y apellidos.
  
- **private String obtenerNombreAleatorio():**
  - Devuelve un nombre aleatorio de la lista cargada desde el archivo CSV.
  
- **private String obtenerApellidoAleatorio():**
  - Devuelve un apellido aleatorio de la lista cargada desde el archivo CSV.

---

### **GeneradorDirecciones**

La clase **GeneradorDirecciones** genera direcciones aleatorias para los alumnos, tomando direcciones de un archivo de texto.

#### Métodos:
- **public String obtenerDireccionAleatoria():**
  - Obtiene una dirección aleatoria desde el archivo cargado.

---

### **GeneradorEdad**

La clase **GeneradorEdad** genera aleatoriamente la edad de un alumno en función del número de materias que ha cursado. Utiliza un generador de números aleatorios para determinar la edad dentro de un rango específico.

#### Atributos:
- **random:** Instancia de la clase `Random`, utilizada para generar valores aleatorios.

#### Métodos:
- **GeneradorEdad():**
  - Constructor que inicializa el atributo `random`.

- **generarEdad(int numeroMaterias):**
  - Recibe el número de materias cursadas por el alumno. Si el número de materias está entre 20 y 25, la edad se genera aleatoriamente entre 19 y 27 años; en otros casos, la edad se genera aleatoriamente entre 18 y 27 años.

---

### **GeneradorHistorial**

La clase **GeneradorHistorial** genera un historial académico aleatorio para un alumno, utilizando un archivo de materias para seleccionar aleatoriamente las materias que ha cursado el alumno.

#### Atributos:
- **materias:** Lista de materias leídas desde un archivo de texto.
- **random:** Instancia de la clase `Random`.

#### Métodos:
- **GeneradorHistorial(String archivoMaterias):**
  - Constructor que recibe la ruta de un archivo y carga las materias en la lista `materias`.
  
- **cargarMaterias(String archivo):**
  - Lee las materias desde un archivo de texto y las almacena en la lista `materias`.

- **generarHistorial():**
  - Genera un historial aleatorio de entre 5 y 40 materias, eligiendo las materias aleatoriamente de la lista.

---

### **GeneradorIndicador**

Genera indicadores escolares como el promedio, escolaridad y velocidad, que se basan en el número de materias aprobadas por el alumno.

#### Atributos:
- **random:** Instancia de la clase `Random`.

#### Métodos:
- **generarPromedio():**
  - Genera un promedio aleatorio entre 5 y 10.

- **calcularEscolaridad(int materiasAprobadas):**
  - Calcula la escolaridad en porcentaje, considerando las materias aprobadas y las inscritas.

- **calcularVelocidad(int materiasAprobadas):**
  - Calcula la velocidad de avance en los estudios como un porcentaje de los créditos obtenidos sobre los créditos esperados.

- **calcularIndicador(int materiasAprobadas):**
  - Calcula un indicador que combina el promedio, la escolaridad y la velocidad.

---

### **AlumnoCRUD**

Esta clase gestiona las operaciones CRUD (Crear, Leer, Actualizar, Eliminar) para manejar los datos de los alumnos en un sistema.

#### Atributos:
- **listaAlumnos:** Lista de alumnos que gestionará la clase.
- **contadorInscripcion:** Contador para generar números de inscripción únicos.

#### Métodos:
- **AlumnoCRUD(List<Alumno> listaAlumnos):**
  - Constructor que recibe una lista de alumnos.
  
- **agregarAlumno(Alumno alumno):**
  - Agrega un alumno a la lista `listaAlumnos`.

- **obtenerAlumno(String numeroInscripcion):**
  - Recupera un alumno según su número de inscripción.

- **actualizarAlumno(String numeroInscripcion):**
  - Permite editar los datos de un alumno por su número de inscripción.

- **eliminarAlumno(String numeroInscripcion):**
  - Elimina un alumno de la lista según su número de inscripción.

- **listarAlumnos():**
  - Muestra todos los alumnos registrados en el sistema.

- **crearAlumno():**
  - Permite crear un nuevo alumno, generando automáticamente su historial académico y calculando su indicador escolar.

- **exportarCSV(String nombreArchivo):**
  - Exporta los datos de los alumnos a un archivo CSV.

---

### **Usuario**

Esta clase representa a un usuario del sistema, con su nombre de usuario, contraseña y rol.

#### Atributos:
- **nombreUsuario:** Nombre del usuario.
- **contraseña:** Contraseña del usuario.
- **rol:** Rol del usuario (por ejemplo, "administracion").

#### Métodos:
- **Usuario(String nombreUsuario, String contraseña, String rol):**
  - Constructor que inicializa los atributos de la clase.
  
- **getNombreUsuario():**
  - Retorna el nombre de usuario.

- **getContraseña():**
  - Retorna la contraseña del usuario.

- **getRol():**
  - Retorna el rol del usuario.

---

### **Login**

Esta clase gestiona la autenticación de los usuarios, permitiendo verificar si las credenciales son correctas.

#### Atributos:
- **usuarios:** Lista de usuarios registrados en el sistema.

#### Métodos:
- **Login():**
  - Constructor que inicializa la lista de usuarios con un usuario de prueba.

- **autenticar(String nombreUsuario, String contraseña):**
  - Verifica si el nombre de usuario y la contraseña coinciden con un usuario registrado y con rol de "administracion".
  - Devuelve `true` si las credenciales son correctas, `false` en caso contrario.

---

### **QuickSort**

La clase **QuickSort** implementa el algoritmo de ordenación QuickSort para ordenar una lista de

 alumnos de acuerdo con su indicador escolar. El orden es en **orden inverso**, es decir, los alumnos con el indicador escolar más alto aparecerán primero en la lista.

#### Métodos:
- **public static void quickSort(List<Alumno> lista, int inicio, int fin):**
  - Método principal que ordena la lista utilizando el algoritmo QuickSort.
  
- **private static int particionar(List<Alumno> lista, int inicio, int fin):**
  - Método de partición utilizado en QuickSort, que reorganiza los elementos alrededor de un pivote.
  - En este caso, los alumnos con un indicador escolar mayor se colocan antes que los de menor indicador (orden inverso).

- **private static void intercambiar(List<Alumno> lista, int i, int j):**
  - Método que intercambia dos elementos en la lista de alumnos.

---

## **Ejecución del Programa**

Para ejecutar el programa, basta con ejecutar la clase **Proyecto** que contiene el método `main`. Al iniciar el sistema, se solicitarán las credenciales de un usuario. Tras la autenticación, el sistema generará 1000 alumnos de manera aleatoria y permitirá realizar las operaciones CRUD.

---

## **Requisitos**

- **Java 8 o superior.**
- **Archivos CSV de nombres, apellidos y materias** necesarios para la generación aleatoria de datos.
- **Bibliotecas adicionales** como `java.util.*` para manejo de listas y aleatorización, y `java.io.*` para manejo de archivos.
