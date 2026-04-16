# EJERCICIO 1 - TDA PILA
<details>
  <summary>Implementación de Pila del exámen</summary>

```java
class PilaTDA {
    static final int MAX = 7;
    int[] datos = new int[MAX + 1];

    void InicializarPila() {
        datos[0] = 0;
    }

    boolean PilaVacia() {
        return datos[0] == 0;
    }

    boolean PilaLlena() {
        return datos[0] == MAX;
    }

    int Tope() {
        return datos[datos[0]];
    }

    void Apilar(int x) {
        if (!PilaLlena()) {
            datos[0]++;
            datos[datos[0]] = x;
        }
    }

    void Desapilar() {
        if (!PilaVacia()) {
            datos[0]--;
        }
    }

    int metodoV() {
        PilaTDA aux = new PilaTDA();
        aux.InicializarPila();
        int suma = 0;
        while (!PilaVacia()) {
            int x = Tope();
            Desapilar();
            suma += x;
            aux.Apilar(x);
        }
        while (!aux.PilaVacia()) {
            Apilar(aux.Tope());
            aux.Desapilar();
        }
        return suma;
    }
}


```
</details>

### 1) Ejecutá las instrucciones sobre una pila vacía. Para cada línea marcada indicá el valor retornado, el valor de datos[0] y el contenido de la pila en formato "base → ... → tope".
```java
PilaTDA p = new PilaTDA();
p.InicializarPila();
p.Apilar(5); p.Apilar(12); p.Apilar(3); p.Apilar(8); p.Apilar(1);
System.out.println(p.Tope());       // (a)
System.out.println(p.datos[0]);     // (b)
p.Desapilar(); p.Desapilar();
p.Apilar(9); p.Apilar(6);
System.out.println(p.Tope());       // (c)
System.out.println(p.datos[0]);     // (d)
System.out.println(p.metodoV())     // (e)
System.out.println(p.Tope());       // (f)
System.out.println(p.datos[0]);     // (g)
p.Apilar(4); p.Apilar(7);
System.out.println(p.datos[0]);     // (h)
```

a) 1, `datos[0]`= 5, `base→5,12,3,8,1→tope` \
b) 5, `datos[0]`= 5, `base→5,12,3,8,1→tope` \
c) 6, `datos[0]`= 5, `base→5,12,3,9,6→tope` \
d) 5, `datos[0]`= 5, `base→5,12,3,9,6→tope` \
e) 35, `datos[0]`= 5, `base→5,12,3,9,6→tope` \
f) 6, `datos[0]`= 5, `base→5,12,3,9,6→tope` \
g) 5, `datos[0]`= 5, `base→5,12,3,9,6→tope` \
h) 7, `datos[0]`= 7, `base→5,12,3,9,6,4,7→tope` \

---
### 2) 
El `metodoV()` mediante un auxiliar `PilaTDA aux` para resguardar los valores de la pila al recorrerla y una variable `x` para guardar los datos de las sumas, se encarga de sumar todos los valores de la pila de manera sucesiva y lo retorna. Gracias a ese auxiliar (que tiene un orden inverso al de la pila original) al apilar cada valor dentro de la pila, que en un punto quedó vacía, la pila queda igual antes de realizar `metodoV()` como luego del mismo. \
Suponiendo que se ejecutara `metodoV()` en la novena linea del código del punto 1; el valor que retornaría sería 35

---
### 3) ¿Qué ocurre si intentás apilar un elemento cuando la pila ya está llena (PilaLlena() = true)? ¿Y si intentás desapilar cuando está vacía (PilaVacia() = true)? Explicá el comportamiento basándote en el código de la implementación.
En esta implementación la condición de apilar es que `PilaLlena()` retorne False, es decir, que la cantidad no haya llegado al último valor (debido a que `datos[0]` retorna el índice del último + 1 y los datos miden `MAX + 1`), por otro lado para desapilar requiere que la pila esté vacía. Así que en ambos casos al apilar o desapilar en dichas condiciones no realizaría nada. 

---
### 4) Describí las diferencias entre la implementación estática (arreglo) y la implementación dinámica (lista enlazada) del TDA Pila. Mencioná una ventaja y una desventaja de cada una.
La diferencia entre ambas implementaciones está en la estructura que utilizan. El arreglo es un conjunto de valores ordenados por índice, donde el primero es 0 y el último corresponde al tamaño menos uno. En cambio, la lista enlazada se organiza mediante nodos, cada uno con un valor y una referencia al siguiente nodo. \
Los arreglos tienen ventaja al recorrer y acceder a sus elementos gracias a la indexación, pero presentan la desventaja de tener un tamaño fijo y generar espacios de memoria no utilizados (rellenos con ceros). Además, para eliminar un dato es necesario aplicar algoritmos como right shift o left shift. Por su parte, las listas enlazadas no tienen límite de tamaño y permiten insertar o eliminar nodos sin desplazar elementos, aunque acceder a un dato siempre requiere recorrer la lista desde el primero, lo que las hace menos eficientes en búsquedas directas. Finalmente, hay que considerar que cada nodo es un objeto y, por lo tanto, consume más memoria que un simple elemento de un arreglo, lo que marca otra diferencia importante entre ambas estructuras.

---

# EJERCICIO 2 - TDA COLA Y TDA CONJUNTO
<details>
  <summary>Implementación de Cola del exámen</summary>

```java
class ColaTDA {
    static class Nodo {
        int val;
        Nodo sig;

        Nodo(int v) {
            val = v;
        }
    }

    Nodo cab = null; // cabeza
    Nodo col = null; // cola

    void InicializarCola() {
        cab = null;
        col = null;
    }

    boolean ColaVacia() {
        return cab == null;
    }

    int Primero() {
        return cab.val;
    }

    void Acolar(int x) {
        Nodo n = new Nodo(x);
        if (col != null) {
            col.sig = n;
        } else {
            cab = n;
        }
        col = n;
    }

    void Desacolar() {
        if (!ColaVacia()) {
            cab = cab.sig;
            if (cab == null) {
                col = null;
            }
        }
    }
}
```
</details>

<details>
  <summary>Implementación de Conjunto del exámen</summary>

```java
class ConjuntoTDA {
    static final int MAX = 6;
    int[] datos = new int[MAX + 1];

    void InicializarConjunto() {
        datos[0] = 0;
    }

    boolean ConjuntoVacio() {
        return datos[0] == 0;
    }

    boolean ConjuntoLleno() {
        return datos[0] == MAX;
    }

    boolean Pertenece(int x) {
        for (int i = 1; i <= datos[0]; i++) {
            if (datos[i] == x) return true;
        }
        return false;
    }

    void Agregar(int x) {
        if (!ConjuntoLleno() && !Pertenece(x)) {
            datos[0]++;
            datos[datos[0]] = x;
        }
    }

    void Sacar(int x) {
        for (int i = 1; i <= datos[0]; i++) {
            if (datos[i] == x) {
                datos[i] = datos[datos[0]];
                datos[0]--;
                return;
            }
        }
    }

    int Elegir() {
        return datos[1];
    }
}
```
</details>

---
### 5) Ejecutá las instrucciones sobre una cola vacía y para cada línea marcada indicá el valor retornado junto con el contenido de la cola en el formato "Primero → ... → último" o la palabra "vacía" si corresponde.

```java
ColaTDA c = new ColaTDA(); c.InicializarCola();
c.Acolar(4);c.Acolar(9);c.Acolar(2);c.Acolar(7);c.Acolar(5);
System.out.println(c.Primero());    //(a)
c.Desacolar();c.Desacolar();
c.Acolar(11);c.Acolar(3);
System.out.println(c.Primero());    //(b)
c.Desacolar();c.Desacolar();c.Desacolar();c.Desacolar();c.Desacolar();
System.out.println(c.ColaVacia());  //(c)
System.out.println(c.Primero());    //(d) — la cola está vacía: ¿qué ocurre?
c.Acolar(8);
System.out.println(c.Primero());    //(e)
```

a) 4, 
`Primero → 4,9,2,7,5 → último` \
b) 2,
`Primero → 2,7,5,11,3 → último` \
c) True
`Primero → null → último`
d) 3 debido a que siempre el valor en la posición `cantidad-1` (última posición) termina siendo arrastrado a la primera posicion, aunque fuera de la lógica de arrays, y volviendo a TDAs el primero es
`vacía` 
e) 8
`Primero → 8 → último`

---
### 6) Ejecutá las instrucciones sobre un conjunto vacío.Para cada línea marcada, indicá el valor retornado y el estado del conjunto en formato {v1,v2, ...}

```java
ConjuntoTDAs=newConjuntoTDA();s.InicializarConjunto();
s.Agregar(3);s.Agregar(7);s.Agregar(1);s.Agregar(5);s.Agregar(9);
System.out.println(s.Pertenece(7));     //(a)
System.out.println(s.Pertenece(4));     //(b)
s.Sacar(1);s.Agregar(4);
System.out.println(s.ConjuntoVacio());  //(c)
System.out.println(s.Pertenece(1));     //(d)
System.out.println(s.Pertenece(4));     //(e)
s.Agregar(2);
System.out.println(s.datos[0]);         //(f)
s.Agregar(6);
System.out.println(s.datos[0]);         //(g) —MAX=6:¿qué ocurre?
```
a) False,
`{3,7,1,5,9}` (lo escribo sin contador)\
b) False,
`{3,7,1,5,9}`\
c) False,
`{3,7,5,9,4}`\
d) True,
`{3,7,5,9,4}`\
e) True,
`{3,7,5,9,4}`\
f) 6,
`{3,7,5,9,4,2}` (datos[0] es el contador\
g) 6, no se agrega el valor debido a que superaría el máximo de elementos
`{3,7,5,9,4,2}`
---
### 7) ¿Qué ocurre si llamás a Agregar cuando el conjunto ya está lleno (ConjuntoLleno() = true)? ¿Y si llamás a Agregar con un elemento que ya pertenece al conjunto? Explicá el comportamiento basándote en el código.
Al intentar agregar un dato que ya pertenece al conjunto se ignora y no se agrega. Si se detecta que el elemento ya pertenece al conjunto mediante el método `pertenece(int x)` (que lo que hace es recorrer con un iterador de 0 a `cantidad-1` comparando por el valor indexado y x), no se agrega

---
### 8) Implementá un método externo estático que, dada una Cola y un Conjunto, elimine de la Cola todos los elementos que pertenezcan al Conjunto, dejando la Cola con el resto de los elementos en el mismo orden. Usá solo las operaciones de ambos TDAs
```Java
public static void DiferenciaColaConjunto(ColaEstatica cola, ConjuntoEstatico conjunto) {
    ColaEstatica aux = new ColaEstatica();
    aux.InicializarCola();

    while (!cola.ColaVacia()){
        if (!conjunto.Pertenece(cola.Primero())){
            aux.Acolar(cola.Primero());// Acolo si no pertenece al conjunto
        }
        cola.Desacolar(); // Desaloco para seguir recorriendo
    }
    while(!aux.ColaVacia()){ // vuelvo a llenar la cola con los elementos que no pertenecen al conjunto
        cola.Acolar(aux.Primero());
        aux.Desacolar();
    }
    // no retorna, si no que modifica la cola existente
}
```
---

# EJERCICIO 3 - TDA COLA CON PRIORIDAD

### 9) Ejecutá las operaciones sobre una Cola con Prioridad vacía. Para cada línea marcada indicá el valor retornado y el estado de las sub colas con el formato de Convenciones
a) 13
```
P2: [13,1]
P1: [6,9,2]
P0: [2,5,4]
``` 
b) 2
```
P2: [13,1]
P1: [6,9,2]
P0: [2,5,4]
``` 
c) 1
```
P2: [1]
P1: [6,9,2]
P0: [2,5,4]
``` 
d) 9
```
P1: [9,2]
P0: [2,5,4]
``` 
e) 1
```
P1: [9,2]
P0: [2,5,4]
``` 
f) 9
```
P1: [9,2]
P0: [2,5,4,7,3]
``` 
g) False
```
P1: [9,2]
P0: [2,5,4,7,3]
``` 
h) devuelve 9
```
P1: [9,2]
P0: [2,5,4,7,3,8]
``` 
---

### 10) Describí la diferencia entre el TDA Cola con Prioridad y el TDA Cola simple. ¿En qué se diferencia la semántica de Desacolar en cada uno?
Semánticamente cola simple elimina el primer elemento ingresado, mientras que cola prioridad elimina el valor con mayor prioridad

---
### 11) Implementá un método externo estático que combine dos Colas con Prioridad CP1 y CP2 en una nueva Cola con Prioridad CP3, de forma que contenga todos los elementos de CP1 y CP2 con sus prioridades originales. CP1 y CP2 deben quedar intactas al terminar. Usá solo las operaciones del TDA.

```Java
public static ColaPrioridadEstatica combinarColasPrioriodad(ColaPrioridadEstatica CP1, ColaPrioridadEstatica CP2) {
    ColaPrioridadEstatica CP3 = new ColaPrioridadEstatica();
    ColaPrioridadEstatica aux1 = new ColaPrioridadEstatica();
    ColaPrioridadEstatica aux2 = new ColaPrioridadEstatica();
    CP3.InicializarColaPrioridad();
    aux1.InicializarColaPrioridad();
    aux2.InicializarColaPrioridad();

    while(!CP1.ColaVacia()){
        CP3.AcolarPrioridad(CP1.Primero(), CP1.Prioridad());
        aux1.AcolarPrioridad(CP1.Primero(), CP1.Prioridad());
        CP1.Desacolar();
    }
    while(!CP2.ColaVacia()){
        CP3.AcolarPrioridad(CP2.Primero(), CP2.Prioridad());
        aux2.AcolarPrioridad(CP2.Primero(), CP2.Prioridad());
        CP2.Desacolar();
    }
    while(!aux1.ColaVacia()){
        CP1.AcolarPrioridad(aux1.Primero(), aux1.Prioridad());
        aux1.Desacolar();
    }
    while(!aux2.ColaVacia()){
        CP2.AcolarPrioridad(aux2.Primero(), aux2.Prioridad());
        aux2.Desacolar();
    }
    return CP3;
}
```
---
# EJERCICIO 4 - TDA DICCIONARIO SIMPLE Y TDA DICCIONARIO MULTIPLE

### 12) Ejecutá las operaciones sobre un Diccionario Simple vacío. Para cada línea marcada indicá el valor retornado y el estado del diccionario en formato "{clave → valor, ...}".
```java
DicSimpleTDA d = new DicSimpleTDA(); d.InicializarDiccionario();
d.Agregar(3,15);
d.Agregar(7,8);
d.Agregar(1,22);
d.Agregar(5,8);
System.out.println(d.Recuperar(7));     //(a)
System.out.println(d.Claves());         //(b)
d.Eliminar(3);
System.out.println(d.Recuperar(1));     //(c)
d.Agregar(7,30);
System.out.println(d.Recuperar(7));     //(d)
System.out.println(d.Claves());         //(e)
d.Eliminar(5); d.Eliminar(1);
System.out.println(d.Claves());         //(f)
d.Agregar(2,10);
System.out.println(d.Recuperar(2));     //(g)
```

a) 8, `{3→15, 7→8, 1→22, 5→8}` \
b) `[3,7,1,5]`, `{3→15, 7→8, 1→22, 5→8}` \
c) 22, `{5→8, 7→8, 1→22}` \
d) 8, `{5→8, 7→8, 1→22}` \
e) `[5,7,1]`, `{5→8, 7→8, 1→22}` \
f) `[7]`, `{7→8}` \
g) 10, `{7→8, 2→10}` 

---
### 13) Ejecutá las operaciones sobre un Diccionario Múltiple vacío. Para cada línea marcada indicá el valor retornado y el estado del diccionario en formato "{clave → {valores}, ...}".
```java
DicMultipleTDA dm = new DicMultipleTDA(); dm.InicializarDiccionario();
dm.Agregar(2,10);
dm.Agregar(2,15);
dm.Agregar(4,7);
dm.Agregar(4,3);
dm.Agregar(4,12);
dm.Agregar(6,5);
dm.Agregar(2,8);
System.out.println(dm.Recuperar(2));    // (a)
System.out.println(dm.Recuperar(4));    // (b)
System.out.println(dm.Claves());        // (c)
dm.EliminarValor(4,3);
System.out.println(dm.Recuperar(4));    // (d)
dm.Eliminar(6);
System.out.println(dm.Claves());        // (e)
dm.Agregar(2,10);
System.out.println(dm.Recuperar(2));    // (f)
dm.EliminarValor(2,99);
System.out.println(dm.Recuperar(2));    // (g)
```
a) `[10,15,8]`, `{2→{10,15,8}, 4→{7,3,12}, 6→{5}}` \
b) `[7,3,12]`, `{2→{10,15,8}, 4→{7,3,12}, 6→{5}}` \
c) `[2,4,6]`, `{2→{10,15,8}, 4→{7,3,12}, 6→{5}}`\
d) `[7,12]`, `{2→{10,15,8}, 4→{7,12}, 6→{5}}`\
e) `[2,4]`, `{2→{10,15,8}, 4→{7,12}}`\
f) `[10,15,8]`, `{2→{10,15,8}, 4→{7,12}}`\
g) `[10,15,8]`, `{2→{10,15,8}, 4→{7,12}}`
---
### 14) Describí la diferencia conceptual entre Diccionario Simple y Diccionario Múltiple. ¿Qué ocurre en cada uno si se llama a Agregar con una clave que ya existe?
Conceptualmente la diferencia es que el diccionario simple permite agregar un único valor relacionado a una clave, si intento agregar un valor a una clave ya existente se remplaza el valor. Por otro lado el diccionario multiple permite agregar mas de un valor a una clave. En el diccionario multiple si intento agregar un valor ya existente a una clave no se agrega.

---
# EJERCICIO 5 - PROBLEMA INTEGRADOR

### 15) Implementá un método externo estático frecuencias(PilaTDA p, DicSimpleTDA d) que, dada una pila p, construya en d un Diccionario Simple donde cada clave es un valor que aparece en la pila y el valor asociado es la cantidad de veces que ese valor aparece. La pila p debe quedar intacta al finalizar.
```java
static void frecuencias(PilaTDA p, DiccionarioSimpleTDA d) {

    PilaDinamica aux = new PilaDinamica(); aux.InicializarPila();

    while(!p.PilaVacia()) {
        int tope = p.Tope();
        int vecesRepetidas = d.Recuperar(tope); // Si no encuentra el valor, devuelve -1

        if (vecesRepetidas != -1) {
            d.Agregar(tope,vecesRepetidas + 1); // Si existe ya un valor con la clave del tope, suma 1 al contador de esa posicion
        }
        else {
            d.Agregar(tope,1); // Si no existe, crea una nueva posicion con valor 1
        }
        aux.Apilar(tope);
        p.Desapilar(); // Desapila para seguir con el siguiente valor
    }
    while(!aux.PilaVacia()) { // Reordena la pila
        p.Apilar(aux.Tope());
        aux.Desapilar();
    }
}
```
---
### 16) Dado un Diccionario Simple d con claves y valores enteros, implementá un método externo estático invertir(DicSimpleTDA d, DicMultipleTDA dm) que construya en dm un Diccionario Múltiple donde cada clave sea un valor de d y el conjunto asociado las claves de d que tenían ese valor, por ejemplo si d = {1→5, 2→8, 3→5, 4→8} entonces dm = {5→{1,3}, 8→{2,4}}.
```java
static void invertir(DiccionarioSimpleTDA d, DiccionarioMultipleTDA dm) {
    int[] claves = d.Claves();
    for (int clave : claves){
        int valorDeDiccionarioSimple = d.Recuperar(clave);
        int claveDeDiccionarioSimple = clave;
        dm.Agregar(valorDeDiccionarioSimple, claveDeDiccionarioSimple);
    }
}
```