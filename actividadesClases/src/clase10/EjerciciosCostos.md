## Ejercicios

### Análisis de Código Secuencial vs. Iterativo

La complejidad temporal de este ejercicio es $O(n)$. Como se puede observar en el código, contamos con dos estructuras for, pero al no estar anidadas (una dentro de otra), el costo solo se suma, no se multiplica.

### El "Bardo" de los Ciclos Anidado

El método 'validarPares' contiene dos ciclos for anidados, lo que hace que el costo de ambos, que es $O(n)$, se multiplique, dándonos un costo de $O(n^2)$ en el peor de los casos.

### Comparación de Implementaciones (TDA Cola)

En este caso el costo del método acolar en la implementation estática es de $O(n)$, ya que cada vez que acolamos algo, se va a tener que mover toda la lista para meter al número. En la dinámica, en cambio, no es necesario esta operación de mover todo para acolar un número, ya que simplemente sé instancia el nuevo nodo y lo enlazamos al final de la cadena, lo que nos da un costo $O(1)$