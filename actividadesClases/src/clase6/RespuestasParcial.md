
### 5) Ejecutá las instrucciones sobre una cola vacía y para cada línea marcada indicá el valor retornado junto con el contenido de la cola en el formato "Primero → ... → último" o la palabra "vacía" si corresponde.
a) 4, 
`Primero → 4,9,2,7,5 → último` \
b) 2,
`Primero → 2,7,5,11,3 → último` \
c) True
`Primero → null → último`
d) 3 debido a que siempre el valor en la posición `cantidad-1` (última posición) termina siendo arrastrado a la primera posicion, aunque fuera de la lógica de arrays, y volviendo a TDAs el primero es
`Primero → null → último` 

### 6) Ejecutá las instrucciones sobre un conjunto vacío.Para cada línea marcada, indicá el valor retornado y el estado del conjunto en formato {v1,v2, ...}
a) False,
`{3,7,1,5,9}` \
b) False,
`{3,7,1,5,9}`\
c) False,
`{3,7,5,9,4}`\
d) True,
`{3,7,5,9,4}`\
e) True,
`{3,7,5,9,4}`\
f) 3,
`{3,7,5,9,4,2}`\
g) 3, no se agrega el valor debido a que superaría el máximo de elementos
`{3,7,5,9,4,2}`

### 7) ¿Qué ocurre si llamás a Agregar cuando el conjunto ya está lleno (ConjuntoLleno() = true)? ¿Y si llamás a Agregar con un elemento que ya pertenece al conjunto? Explicá el comportamiento basándote en el código.
Al intentar agregar un dato que ya pertenece al conjunto se ignora y no se agrega. Si se detecta que el elemento ya pertenece al conjunto mediante el método pertenece(int x) (que lo que hace es recorrer con un iterador de 0 a cantidad-1 comparando por el valor indexado y x), no se agrega

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

### 10) Describí la diferencia entre el TDA Cola con Prioridad y el TDA Cola simple. ¿En qué se diferencia la semántica de Desacolar en cada uno?
Semánticamente no posee diferencia alguna ambos TDA, ambos se llaman Desacolar, devuelven void y no poseen parámetros.
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
