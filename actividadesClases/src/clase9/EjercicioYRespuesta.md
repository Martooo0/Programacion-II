# Ejercicio 1: Análisis de ciclos anidados

<details>
  <summary>Consigna</summary>

  ## Consigna:  
  Dado el siguiente método que busca un elemento y realiza una comprobación secundaria en el resto del arreglo, determiná su familia de complejidad temporal O en el peor caso. Justificá tu respuesta analizando los ciclos

  ```java
  public static int buscarYValidar(int[] array) {
      for(int i = 0; i < array.length; i++) { // Ciclo N1
          if(array[i] == 5) { // C1
              return i;
          } else {
              for(int j = 0; j < i; j++) { // Ciclo N2
                  if(array[j] == 6) { // C3
                      return i;
                  }
              }
          }
      }
      return -1; // C5
  }
```
</details>

### Respuesta
buscarYValidar en su primer ciclo busca un elemento del arreglo con un costo O(n), pero, como realiza una comprobación secundaria que también es O(n) y está dentro del mismo recorrido for esto da un resultado de $O(n) \cdot O(n) = O(n^2)$


## Ejercicio 2: Análisis de un algoritmo integrador (Tipo Examen)

<details>
  <summary>Consigna</summary>
  ## Consigna:   
Se presenta el método filtrar(limite), el cual recibe una Cola original, identifica los elementos mayores a un valor "límite" y los devuelve en una nueva estructura, asegurando que la Cola original quede idéntica a su estado inicial al terminar el proceso

El algoritmo sigue estos pasos:
Recorre la cola original de n elementos extrayéndolos uno a uno.
Guarda cada elemento en una estructura auxiliar tmp.
Si el elemento es mayor al límite, lo guarda también en la cola de resultados res.
Al finalizar, vuelve a volcar los elementos de tmp a la cola original para restaurarla.

### Preguntas:
(a) Determiná la complejidad temporal O(n) justificando la cantidad de recorridos completos que se realizan sobre los datos .
(b) Determiná la complejidad espacial O(n) analizando la necesidad de memoria adicional para las estructuras auxiliares (tmp y res)

</details>

### Respuesta
(a) La complejidad temporal es $O(n)$ dado que itera con un while n veces (siendo n la cantidad de elementos de la cola) en dos ocasiones, primero al recorrer la cola y generando comparaciones y luego al rearmarla.

(b) Espacialmente utiliza adicionalmente a la cola y el valor límite ingresado: Una cola auxiliar y una cola resultado que retorna los valores encontrados, por lo que, al ser tipos de objetos iguales, en total se crean dos nuevas cola con cada una el mismo espacio en memoria que la cola ingresada. Finalizado el método dicho objeto auxiliar es eliminado.

