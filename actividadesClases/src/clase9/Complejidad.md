## Implementaciones Estáticas

### Cola Estática

| Métodos / Complejidad | $O(1)$ | $O(n)$ | $O(n^2)$ | $O(Log(n))$ |
| --- | --- | --- | --- | --- |
| InicializarCola | x |  |  |  |
| Acolar | x |  |  |  |
| Desacolar |  | x |  |  |
| Primero | x |  |  |  |
| ColaVacia | x |  |  |  |

### Pila Estática 1 (Tope fijo en el origen)

Mantiene el tope de la pila siempre fijo en la posición `0` del arreglo. Para lograr esto, requiere desplazar todos los elementos hacia la derecha al `Apilar` (haciendo lugar en el índice 0) y desplazarlos todos hacia la izquierda al `Desapilar` (sobreescribiendo el índice 0). Es muy ineficiente computacionalmente.

| **Métodos / Complejidad** | **O(1)** | **O(n)** | **O(n2)** | **O(Log(n))** |
| --- | --- | --- | --- | --- |
| InicializarPila | x |  |  |  |
| Apilar |  | x |  |  |
| Desapilar |  | x |  |  |
| Tope | x |  |  |  |
| PilaVacia | x |  |  |  |

### Pila Estática 2 (Señalización en banda)

**Descripción breve:** No utiliza una variable externa para contar la cantidad de elementos. En su lugar, usa el índice `0` del propio arreglo (`datos[0]`) para guardar la cantidad actual de elementos, y guarda los datos de la pila a partir del índice `1`. Esto logra que todo sea $O(1)$, aunque mezcla metadatos con datos reales, reduciendo la legibilidad del código.

| **Métodos / Complejidad** | **O(1)** | **O(n)** | **O(n2)** | **O(Log(n))** |
| --- | --- | --- | --- | --- |
| InicializarPila | x |  |  |  |
| Apilar | x |  |  |  |
| Desapilar | x |  |  |  |
| Tope | x |  |  |  |
| PilaVacia | x |  |  |  |

### Pila Estática 3 (Contador externo)

**Descripción breve:** Es la implementación estándar y recomendada (Clean Code). Utiliza un arreglo para los datos y una variable entera independiente (`cantidad`) que marca dónde está el tope. Agrega en `datos[cantidad]` y saca haciendo una "baja lógica" simplemente restándole `1` a la variable `cantidad`. Todo es eficiente e inmediato.

| **Métodos / Complejidad** | **O(1)** | **O(n)** | **O(n2)** | **O(Log(n))** |
| --- | --- | --- | --- | --- |
| InicializarPila | x |  |  |  |
| Apilar | x |  |  |  |
| Desapilar | x |  |  |  |
| Tope | x |  |  |  |
| PilaVacia | x |  |  |  |

### Cola Prioridad Estática

| Métodos / Complejidad | $O(1)$ | $O(n)$ | $O(n^2)$ | $O(Log(n))$ |
| --- | --- | --- | --- | --- |
| InicializarColaPrioridad | x |  |  |  |
| AcolarPrioridad |  | x |  |  |
| Desacolar |  | x |  |  |
| Primero | x |  |  |  |
| Prioridad | x |  |  |  |
| ColaVacia | x |  |  |  |

### Conjunto Estático

| Métodos / Complejidad | $O(1)$ | $O(n)$ | $O(n^2)$ | $O(Log(n))$ |
| --- | --- | --- | --- | --- |
| InicializarConjunto | x |  |  |  |
| Agregar |  | x |  |  |
| Sacar |  | x |  |  |
| Pertenece |  | x |  |  |
| Elegir | x |  |  |  |
| ConjuntoVacio | x |  |  |  |

### Diccionario Simple Estático

| Métodos / Complejidad | $O(1)$ | $O(n)$ | $O(n^2)$ | $O(Log(n))$ |
| --- | --- | --- | --- | --- |
| InicializarDiccionario | x |  |  |  |
| Agregar |  | x |  |  |
| Eliminar |  | x |  |  |
| Recuperar |  | x |  |  |
| Claves |  | x |  |  |

### Diccionario Múltiple Estático

| Métodos / Complejidad | $O(1)$ | $O(n)$ | $O(n^2)$ | $O(Log(n))$ |
| --- | --- | --- | --- | --- |
| InicializarDiccionario | x |  |  |  |
| Agregar |  | x |  |  |
| EliminarValor |  | x |  |  |
| Eliminar |  | x |  |  |
| Recuperar |  | x |  |  |
| Claves |  | x |  |  |
| buscarClave |  | x |  |  |
| buscarValor |  | x |  |  |
| existeValor |  | x |  |  |

---

## Implementaciones Dinámicas

### Cola Dinámica

| Métodos / Complejidad | $O(1)$ | $O(n)$ | $O(n^2)$ | $O(Log(n))$ |
| --- | --- | --- | --- | --- |
| InicializarCola | x |  |  |  |
| Acolar | x |  |  |  |
| Desacolar | x |  |  |  |
| Primero | x |  |  |  |
| ColaVacia | x |  |  |  |

### Pila Dinámica

| Métodos / Complejidad | $O(1)$ | $O(n)$ | $O(n^2)$ | $O(\log n)$ |
| --- | --- | --- | --- | --- |
| Apilar | x |  |  |  |
| Desapilar | x |  |  |  |
| Tope | x |  |  |  |
| PilaVacia | x |  |  |  |

### Cola Prioridad Dinámica

| Métodos / Complejidad | $O(1)$ | $O(n)$ | $O(n^2)$ | $O(Log(n))$ |
| --- | --- | --- | --- | --- |
| InicializarColaPrioridad | x |  |  |  |
| AcolarPrioridad |  | x |  |  |
| Desacolar | x |  |  |  |
| Primero | x |  |  |  |
| Prioridad | x |  |  |  |
| ColaVacia | x |  |  |  |

### Conjunto Dinámico

| Métodos / Complejidad | $O(1)$ | $O(n)$ | $O(n^2)$ | $O(Log(n))$ |
| --- | --- | --- | --- | --- |
| InicializarConjunto | x |  |  |  |
| Agregar |  | x |  |  |
| Sacar |  | x |  |  |
| Pertenece |  | x |  |  |
| Elegir | x |  |  |  |
| ConjuntoVacio | x |  |  |  |

### Diccionario Simple Dinámico

| Métodos / Complejidad | $O(1)$ | $O(n)$ | $O(n^2)$ | $O(Log(n))$ |
| --- | --- | --- | --- | --- |
| InicializarDiccionario | x |  |  |  |
| Agregar |  | x |  |  |
| Eliminar |  | x |  |  |
| Recuperar |  | x |  |  |
| Claves |  | x |  |  |

### Diccionario Múltiple Dinámico

| Métodos / Complejidad | $O(1)$ | $O(n)$ | $O(n^2)$ | $O(Log(n))$ |
| --- | --- | --- | --- | --- |
| InicializarDiccionario | x |  |  |  |
| Agregar |  | x |  |  |
| EliminarValor |  | x |  |  |
| Eliminar |  | x |  |  |
| Recuperar |  | x |  |  |
| Claves |  | x |  |  |
| buscarClave |  | x |  |  |
| buscarValor |  | x |  |  |
| existeValor |  | x |  |  |
