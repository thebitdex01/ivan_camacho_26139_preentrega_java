# CRUD Artículos Java - Arquitectura Modular POO

Sistema CRUD desarrollado en Java aplicando Programación Orientada a Objetos (POO), separación de responsabilidades y arquitectura modular preparada para evolucionar hacia Spring Boot.

---

# Objetivo

El proyecto busca simular un pequeño backend de gestión de artículos ejecutado por consola utilizando:

- Java
- ArrayList
- POO
- Packages
- Encapsulamiento
- CRUD en memoria RAM
- Arquitectura por responsabilidades

---

# Funcionalidades

- Agregar artículos
- Listar artículos
- Modificar artículos
- Eliminar artículos
- Menú interactivo por consola

---

# Arquitectura del Proyecto

```text
src/
└── com/
    └── techlab/
        └── articulo/
            ├── App.java
            │
            ├── model/
            │   └── Articulo.java
            │
            └── repository/
                └── RepositorioArticulo.java
```

---

# Responsabilidad de cada componente

## App.java

Punto de entrada del sistema.

Responsabilidades:
- iniciar el programa
- mostrar menú
- leer opciones del usuario
- coordinar flujo del sistema

---

## model/Articulo.java

Representa el dominio del negocio.

Responsabilidades:
- modelar un artículo
- almacenar estado interno
- encapsular atributos
- definir comportamiento básico

Atributos:
- código
- nombre
- precio

---

## repository/RepositorioArticulo.java

Capa de persistencia en memoria.

Responsabilidades:
- guardar artículos
- buscar artículos
- listar artículos
- eliminar artículos

Utiliza:
- `ArrayList<Articulo>`

---

# Conceptos aplicados

- Programación Orientada a Objetos
- Encapsulamiento
- Constructores
- Getters y Setters
- Sobrescritura de `toString()`
- ArrayList
- Packages Java
- Arquitectura modular
- Separación de responsabilidades
- CRUD
- Scanner
- Bucles `do while`
- Condicional múltiple `switch`

---

# Flujo de Arquitectura

```text
Usuario
   ↓
App.java
   ↓
RepositorioArticulo
   ↓
ArrayList<Articulo>
   ↓
Objetos Articulo en memoria RAM
```

---

# Ejecución

Abrir:

```text
App.java
```

Ejecutar:

```text
Run Java
```

o:

```text
F5
```

---

# Tecnologías

- Java 21
- Visual Studio Code
- Extension Pack for Java

---

# Futuras mejoras

- Validaciones centralizadas
- Excepciones personalizadas
- Service Layer
- Interfaces
- Herencia
- Persistencia con Base de Datos
- Spring Boot
- API REST
