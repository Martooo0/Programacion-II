Bienvenido al repositorio central de prácticas y TPs para la materia Programación II.

---

### Integrantes

| Nombre            | Legajo   |
|-------------------|----------|
| Pablo Kim         | 1162102  |
| Lisandro Forgione | 1186420  |
| Nicolás Miozi     | 1189992  |
| Matías Parodi     | 1201606  |
| Martín Ferreira   | 1187544  |

---

### 📂 Arquitectura del Proyecto

El proyecto está estructurado de manera que el código central y reutilizable se mantenga aislado de los ejercicios prácticos de cada semana. 

A continuación se detalla el diagrama de directorios principal:

```text
📁 actividadesClases
├── 📁 src
│   ├── 📁 clase2
│   │   └── 📁 archivos                # PDFs, imágenes y resoluciones teóricas
│   ├── 📁 clase3
│   │   ├── 📁 archivos
│   │   └── 📄 GuiaDeTrabajos...md
│   ├── 📁 clase4
│   │   └── 📄 mainClase4.java         # Archivo ejecutable (pizarra) de la clase
│   ├── 📁 claseX                      # Estructura repetible para cada clase
│   │   ├── 📁 archivos
│   │   └── 📄 mainClaseX.java
│   │
│   └── 📁 sources                     # Núcleo del proyecto (Lógica y Contratos)
│       ├── 📁 Implementacion          # Clases con la lógica de los TDAs (Ej: ColaEstatica.java)
│       └── 📁 Interfaces              # Contratos de los TDAs (Ej: ColaTDA.java)
│
├── 📄 .gitignore
└── 📄 README.md
```

---

### Explicación de los Componentes

La arquitectura de este repositorio está dividida en tres pilares principales para garantizar el orden y la reutilización del código.

#### 1. El Núcleo (`sources/`) 
Esta es la carpeta más importante a nivel arquitectónico. Aquí residen todas las estructuras de datos que se construyen durante la cursada, aisladas del código de prueba. Se divide en dos grandes grupos:

* **`Interfaces/` (El Contrato):** Contiene las definiciones puras de los Tipos de Datos Abstractos (TDA). Definen el **QUÉ** hace la estructura (sus métodos y firmas) ocultando los detalles de su programación interna.
* **`Implementacion/` (El Motor):** Contiene las clases concretas de Java. Aquí reside la lógica dura (estática o dinámica) que define el **CÓMO** se guardan, mueven y manipulan los datos físicamente en la memoria.

#### 2. Pizarras de Ejecución (`claseX/mainClaseX.java`) 
Cada carpeta semanal (`clase2`, `clase3`, etc.) funciona como un entorno aislado de pruebas. El archivo principal de cada carpeta actúa como una **"pizarra interactiva"**.
> **Objetivo:** Instanciar las herramientas de la carpeta `sources` para probar algoritmos, resolver guías y verificar el comportamiento de los TDAs en la práctica, manteniendo el código núcleo siempre limpio y sin modificaciones accidentales.

#### 3. Recursos Complementarios (`claseX/archivos/`) 📎
Para no contaminar el directorio con archivos que no sean código fuente de Java, todo el material de apoyo se almacena de forma ordenada en este subdirectorio.

**¿Qué vas a encontrar aquí?**
- 📄 Guías de trabajos prácticos (PDFs).
- 🖼️ Diagramas y visualizaciones de memoria.
- 👨‍🏫 Presentaciones teóricas de la cátedra.
- 📝 Resoluciones escritas o notas teóricas en Markdown (`.md`).

---

### Cómo ejecutar las prácticas

El proyecto está diseñado para que no tengas conflictos al compilar. Cada clase es 100% independiente.

1. **Navegá** a la carpeta de la clase que querés probar (Ejemplo: `clase4/`).
2. **Abrí** el archivo principal (Ejemplo: `mainClase4.java`).
3. **Ejecutá** el archivo directamente en tu IDE. Al estar correctamente empaquetado, este archivo ya está sincronizado e importará automáticamente las herramientas que necesite de la carpeta central `sources/`.
