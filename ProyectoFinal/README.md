# Sistema de Gestión de Pacientes

## Descripción del proyecto

Este proyecto es una aplicación de consola desarrollada en Java usando arquitectura por capas.

El sistema permite:

- Registrar pacientes
- Validar pacientes existentes
- Actualizar información de pacientes
- Buscar pacientes por documento
- Visualizar información básica del paciente

El objetivo principal del proyecto es aplicar separación de responsabilidades y buenas prácticas de arquitectura.

---

# Arquitectura del proyecto

El proyecto está dividido en 5 capas principales:

```text
Vista
 ↓
Controlador
 ↓
Servicios
 ↓
Persistencia
 ↓
Modelo
```

Cada capa tiene una responsabilidad específica.

---

# Estructura de carpetas

```text
ProyectoFinal
│
├── Controlador
│   └── ControladorGestionPaciente.java
│
├── Modelo
│   └── Paciente.java
│
├── Persistencia
│   └── RepositorioPaciente.java
│
├── Servicios
│   └── ServicioPaciente.java
│
├── Vista
│   └── InterfazRecepcionista.java
│
└── Main.java
```

---

# Explicación de cada capa

---

## Modelo

### Responsabilidad

Representar las entidades del sistema.

### Clase principal

```text
Paciente.java
```

### Qué contiene

- Atributos del paciente
- Constructores
- Getters y Setters
- Método `toString()`

### Ejemplo de atributos

```java
private String nombre;
private String cedula;
private String telefono;
```

El modelo NO contiene lógica de negocio.

---

## Persistencia

### Responsabilidad

Gestionar almacenamiento y acceso a datos.

### Clase principal

```text
RepositorioPaciente.java
```

### Qué hace

- Guarda pacientes
- Busca pacientes
- Verifica existencia
- Accede al `ArrayList`

### Estructura principal

```java
private List<Paciente> pacientes;
```

El repositorio es la única capa que interactúa directamente con la colección de datos.

---

## Servicios

### Responsabilidad

Contener la lógica de negocio y validaciones.

### Clase principal

```text
ServicioPaciente.java
```

### Qué hace

- Registrar pacientes
- Validar datos
- Actualizar pacientes
- Buscar pacientes
- Verificar reglas de negocio

### Ejemplo de validaciones

```java
if (!cedula.matches("\\d+"))
```

Las validaciones NO deben hacerse en la vista.

---

## Controlador

### Responsabilidad

Coordinar comunicación entre vista y servicios.

### Clase principal

```text
ControladorGestionPaciente.java
```

### Qué hace

- Recibe datos desde la vista
- Llama métodos del servicio
- Retorna respuestas a la vista

El controlador NO contiene lógica compleja.

---

## Vista

### Responsabilidad

Interacción con el usuario.

### Clase principal

```text
InterfazRecepcionista.java
```

### Qué hace

- Mostrar menús
- Leer datos desde consola
- Mostrar mensajes
- Llamar al controlador

La vista NO debe:

- validar reglas de negocio
- acceder al repositorio
- crear servicios manualmente

---

# Flujo general del sistema

Ejemplo: registrar paciente

```text
Usuario ingresa datos
↓
Vista captura datos
↓
Controlador recibe datos
↓
Servicio valida lógica
↓
Repositorio guarda paciente
↓
Respuesta vuelve a la vista
↓
Se muestra resultado
```

---

# Explicación del Main

La clase `Main` es el punto de inicio del programa.

### Responsabilidad

Crear y conectar todas las capas manualmente.

### Flujo

```java
RepositorioPaciente repositorioPaciente =
        new RepositorioPaciente();

ServicioPaciente servicioPaciente =
        new ServicioPaciente(repositorioPaciente);

ControladorGestionPaciente controladorGestionPaciente =
        new ControladorGestionPaciente(servicioPaciente);

InterfazRecepcionista interfazRecepcionista =
        new InterfazRecepcionista(
                controladorGestionPaciente
        );
```

Esto se llama:

```text
Inyección de dependencias manual
```

---

# Explicación de private final

Ejemplo:

```java
private final ServicioPaciente servicioPaciente;
```

## private

La variable solo puede usarse dentro de la clase.

## final

La referencia no puede cambiar después del constructor.

Esto evita modificar dependencias accidentalmente.

---

# Explicación de validaciones

Las validaciones se realizan en la capa de servicios.

Ejemplo:

```java
if (nombre == null || nombre.trim().isEmpty())
```

Se usa:

```java
throw new IllegalArgumentException(...)
```

para detener ejecución cuando hay errores.

---

# Explicación de throw

```java
throw new IllegalArgumentException("Error");
```

Significa:

- lanzar una excepción
- detener el método inmediatamente
- enviar mensaje de error

Cuando ocurre un `throw`, el resto del método ya no se ejecuta.

---

# Explicación de trim()

```java
nombre.trim()
```

Elimina espacios al inicio y final.

Ejemplo:

```text
"   Juan   "
↓
"Juan"
```

Sirve para evitar entradas vacías con espacios.

---

# Explicación de matches("\\d+")

```java
cedula.matches("\\d+")
```

Valida que la cédula tenga solo números.

## Significado

```text
\d
```

representa un dígito.

```text
+
```

significa "uno o más".

Entonces:

```text
\d+
```

significa:

```text
Uno o más números
```

---

# Historias de Usuario implementadas

## HU1

Registrar paciente.

---

## HU2

Validar si el paciente ya existe.

---

## HU3

Actualizar información del paciente.

---

## HU4

Buscar paciente por documento.

---

## HU5

Visualizar información básica del paciente.

---

# Buenas prácticas aplicadas

- Separación por capas
- Responsabilidad única
- Inyección de dependencias manual
- Validaciones centralizadas
- Encapsulamiento
- Reutilización de lógica
- Uso correcto de constructores
- Uso de getters y setters

---

# Problemas corregidos durante el refactor

## Antes

La vista creaba servicios manualmente:

```java
new ServicioPaciente(null)
```

Eso rompía la arquitectura.

---

## Ahora

Todas las dependencias se crean únicamente desde `Main`.

---

## Antes

La vista hacía validaciones de negocio.

---

## Ahora

Las validaciones están centralizadas en `ServicioPaciente`.

---

## Antes

El repositorio solo guardaba pacientes.

---

## Ahora

También puede:

- buscar pacientes
- validar existencia

---

# Conceptos importantes aprendidos

- Arquitectura por capas
- MVC simplificado
- Encapsulamiento
- Responsabilidad única
- Validaciones
- Excepciones
- Inyección de dependencias
- Relaciones entre clases
- Flujo de datos entre capas

---

# Flujo visual completo

```text
                ┌────────────────────┐
                │        Main        │
                └─────────┬──────────┘
                          │
                          ▼
            ┌──────────────────────────┐
            │ InterfazRecepcionista    │
            │          Vista           │
            └─────────┬────────────────┘
                      │
                      ▼
            ┌──────────────────────────┐
            │ ControladorGestionPaciente │
            │        Controlador       │
            └─────────┬────────────────┘
                      │
                      ▼
            ┌──────────────────────────┐
            │     ServicioPaciente     │
            │         Servicios        │
            └─────────┬────────────────┘
                      │
                      ▼
            ┌──────────────────────────┐
            │   RepositorioPaciente    │
            │       Persistencia       │
            └─────────┬────────────────┘
                      │
                      ▼
            ┌──────────────────────────┐
            │        Paciente          │
            │          Modelo          │
            └──────────────────────────┘
```
---

# Métodos importantes del sistema

---

# Clase Paciente.java

## Constructor

```java
public Paciente(String nombre,
                 String cedula,
                 String telefono)
```

### Qué hace

Crea un nuevo objeto paciente con:

- nombre
- cédula
- teléfono

### Ejemplo

```java
Paciente paciente =
        new Paciente(
                "Juan",
                "12345",
                "3001234567"
        );
```

---

## getNombre()

```java
public String getNombre()
```

### Qué hace

Retorna el nombre del paciente.

---

## setNombre()

```java
public void setNombre(String nombre)
```

### Qué hace

Modifica el nombre del paciente.

---

## getCedula()

```java
public String getCedula()
```

### Qué hace

Retorna la cédula del paciente.

---

## setCedula()

```java
public void setCedula(String cedula)
```

### Qué hace

Modifica la cédula del paciente.

---

## getTelefono()

```java
public String getTelefono()
```

### Qué hace

Retorna el teléfono del paciente.

---

## setTelefono()

```java
public void setTelefono(String telefono)
```

### Qué hace

Modifica el teléfono del paciente.

---

## toString()

```java
public String toString()
```

### Qué hace

Convierte el objeto paciente en texto legible.

### Ejemplo de salida

```text
Paciente{
nombre='Juan',
cedula='12345',
telefono='3001234567'
}
```

Se usa para imprimir pacientes en consola.

---

# Clase RepositorioPaciente.java

---

## existePorDocumento()

```java
public boolean existePorDocumento(
        String documento
)
```

### Qué hace

Verifica si ya existe un paciente con esa cédula.

### Retorna

- `true` → si existe
- `false` → si no existe

### Uso

Evitar registros duplicados.

---

## guardar()

```java
public void guardar(Paciente paciente)
```

### Qué hace

Guarda un paciente dentro del `ArrayList`.

### Internamente

```java
pacientes.add(paciente);
```

---

## buscarPorDocumento()

```java
public Paciente buscarPorDocumento(
        String documento
)
```

### Qué hace

Busca un paciente por cédula.

### Retorna

- el objeto `Paciente`
- `null` si no existe

### Uso

- actualización
- búsqueda
- visualización

---

# Clase ServicioPaciente.java

Esta es la capa más importante del sistema porque contiene la lógica de negocio.

---

## registrarPaciente()

```java
public String registrarPaciente(
        String nombre,
        String cedula,
        String telefono
)
```

### Qué hace

Registra un nuevo paciente.

### Flujo interno

```text
Validar datos
↓
Validar cédula
↓
Verificar si existe
↓
Crear objeto Paciente
↓
Guardar en repositorio
↓
Retornar mensaje
```

### Retorna

Mensaje de éxito o error.

---

## actualizarPaciente()

```java
public String actualizarPaciente(
        String cedula,
        String nuevoNombre,
        String nuevoTelefono
)
```

### Qué hace

Actualiza información de un paciente existente.

### Flujo interno

```text
Validar datos
↓
Buscar paciente
↓
Modificar atributos
↓
Retornar resultado
```

### Importante

La cédula NO se modifica.

---

## buscarPacientePorDocumento()

```java
public Paciente buscarPacientePorDocumento(
        String cedula
)
```

### Qué hace

Busca un paciente desde la capa de servicio.

### Uso

Se usa en:

- búsquedas
- visualización
- futuras validaciones

---

## validarDatosPaciente()

```java
private void validarDatosPaciente(
        String nombre,
        String cedula,
        String telefono
)
```

### Qué hace

Valida datos antes de registrar paciente.

### Valida

- nombre vacío
- cédula vacía
- cédula inválida
- teléfono vacío

### Importante

Es `private` porque solo se usa dentro del servicio.

---

## validarDatosActualizacion()

```java
private void validarDatosActualizacion(
        String cedula,
        String nombre,
        String telefono
)
```

### Qué hace

Valida datos antes de actualizar paciente.

---

## validarCedula()

```java
private void validarCedula(String cedula)
```

### Qué hace

Verifica que:

- la cédula no esté vacía
- tenga solo números

### Uso

Centraliza la validación reutilizable.

---

# Clase ControladorGestionPaciente.java

El controlador coordina comunicación entre vista y servicio.

---

## registrarPaciente()

```java
public String registrarPaciente(
        String nombre,
        String cedula,
        String telefono
)
```

### Qué hace

Recibe datos desde la vista y llama al servicio.

### También

Captura excepciones usando:

```java
try-catch
```

---

## actualizarPaciente()

```java
public String actualizarPaciente(
        String cedula,
        String nuevoNombre,
        String nuevoTelefono
)
```

### Qué hace

Coordina actualización de pacientes.

---

## buscarPacientePorDocumento()

```java
public Paciente buscarPacientePorDocumento(
        String cedula
)
```

### Qué hace

Solicita búsqueda al servicio y retorna el paciente encontrado.

---

# Clase InterfazRecepcionista.java

La vista maneja interacción con el usuario.

---

## mostrarMenuRecepcionista()

```java
public void mostrarMenuRecepcionista()
```

### Qué hace

Muestra el menú principal del sistema.

### También

Controla navegación entre opciones.

---

## registrarPaciente()

```java
private void registrarPaciente()
```

### Qué hace

Solicita datos del paciente desde consola.

### Luego

Llama al controlador para registrar.

---

## actualizarPaciente()

```java
private void actualizarPaciente()
```

### Qué hace

Solicita nuevos datos para modificar paciente.

---

## buscarPaciente()

```java
private void buscarPaciente()
```

### Qué hace

Solicita cédula y muestra información encontrada.

---

# Clase Main.java

Punto de inicio del programa.

---

## main()

```java
public static void main(String[] args)
```

### Qué hace

Crea y conecta todas las capas del sistema.

### Flujo

```text
Repositorio
↓
Servicio
↓
Controlador
↓
Vista
↓
Iniciar menú
```

### Importancia

Centraliza toda la creación de dependencias.