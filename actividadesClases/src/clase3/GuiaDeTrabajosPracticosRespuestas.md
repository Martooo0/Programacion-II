# **GUÍA DE TRABAJOS PRÁCTICOS finde XL: MODELADO DE TDAS**

---

## 2. Bloque 1: Pilas (LIFO- Last In, First Out)

### 1. Historial de Navegación: El botón "Atrás" del Chrome. Si visitás fi.uba.ar, después campus.utn.edu.ar y por último stackoverflow.com: Consigna: Identificá qué se apila en cada paso y qué sucede (qué se desapila) cuando el usuario aprieta la flechita de "Atrás".

*En el procedimiento lo primero que ocurrirá cuando realizamos una búsqueda va a ser apilar fi.uba.ar, luego al realizar la búsqueda de utn.edu.ar, fi.uba va a pasar a estar en la posición 1 en la pila y utn en la posición 0, tope va a pasar a valer 1, luego al apilar por búsqueda stackoverflow.com este mismo queda en la posición 0 y los demás al utilizar apilar se corren una posición más, quedando tope en 2.*

*Luego al tocar el botón atrás desapila el último apilar utilizado que en este caso es stackoverflow, tope vale 1, luego desapilar un espacio más si vuelvo a utilizar atrás, se desapila utn y el tope vale 0 con el único valor fi.uba.*

### 2. Editor de Código (Undo/Deshacer): Estás codeando y borrás una línea por error: Consigna: Describí qué estado del código deberías Apilar cada vez que el usuario hace un cambio y cómo recuperás el estado anterior.

*Cuando el usuario hace un Undo/deshacer, borra de la pantalla lo último que escribió.*

*Para volver al estado anterior, toca ctrl + z, y se desapila el último cambio hecho en pantalla para volver a estar como estaba.*

### 3. Balanceo de Paréntesis: El compilador de Java chequea que no te hayas olvidado de cerrar una llave: Consigna: En la expresión ( ( a + b ) * c ), ¿en qué momento exacto hacés un Apilar y cuándo comparás para hacer un Desapilar?

*Para respetar la jerarquía de los paréntesis se debería leer de afuera para adentro y ejecutar de adentro para afuera y al desapilar guardo la operación para no perderla. es decir:*

a. *Apilo \*c.*

b. *Apilo a+b.*

c. *Antes de desapilar a+b chequeo si tengo una operación guardada, como no desapile nada anteriormente no operó.*

d. *Desapilo a+b y lo guardo.*

e. *Leo \*c, reviso si tengo una operación guardada, si, tengo a+b, se lo aplico a a+b.*

f. *Desapilo \*c y lo guardo (siguiendo la lógica iterativa del algoritmo).*


*Otra forma es con la nomenclatura polaca:*

a. *Leo a, lo guardo en la salida (aux).*

b. *Leo b, lo guardo en la salida.*

c. *Apilo +.*

d. *Antes de desapilar +, reviso si tengo operandos guardados: sí, tengo a y b. Los uno en ab+ y lo guardo.*

e. *Leo c, lo guardo en la salida.*

f. *Apilo \*.*

g. *Antes de desapilar \*, reviso si tengo una operación guardada: sí, tengo ab+. Se lo aplico junto con c.*

h. *Desapilo \* y lo guardo, quedando ab+c\*.*

*En ambos casos no necesito paréntesis porque la pila y el orden de lectura garantizan la jerarquía, por lo que nunca puede haber un error de paréntesis.*

### 4. Reversión de Strings: Querés dar vuelta la palabra "ALGORITMOS": Consigna: Explica el proceso de meter letra por letra en la Pila y cómo quedan al sacarlas.

*En el procedimiento uso apilar por cada letra, el tope queda del largo de la palabra.*

*Luego al yo querer darla vuelta puedo usar una pila aux, desapilar en la pila1 y en la pila aux apilo eso mismo valor quedando como resultado la pila invertida.*

### 5. Pila de Llamadas (Call Stack): Cuando una función llama a otra: Consigna: Si Main() llama a CalcularPromedio() y esta llama a Sumar(), ¿quién está en el Tope() en el momento de la ejecución de la suma?

*Queda en el tope suma, ya que es la última que apilo.*

### 6. Navegación de Directorios: Entrás a C:/, luego a Usuarios, luego a Documentos: Consigna: ¿Cómo usás una Pila para que el sistema sepa a qué carpeta volver si apretás "Subir un nivel"?

*Cada vez q entro a un nuevo nivel apilo ese nombre de ruta.*

*Luego si quiero volver al anterior desapilar.*

---

## 3. Bloque 2: Colas y colas con prioridad (FIFO + Ranking)

### 1. Fila del cajero: Consigna: ¿Es Cola común o de Prioridad? Justificá según la lógica de atención.

*La mejor sería una con prioridad, primero se ordena por orden de llegada pero si un cliente tiene mayor valor de prioridad, sea por la condición de discapacidad, edad o de embarazo, se adelanta a la fila si no existe otro cliente con mayor valor entero de prioridad.*

### 2. Impresora del laboratorio: Consigna: Si la impresora recibe 5 archivos, ¿cuál es el orden de salida?

*El orden de salida debe de seguir la de un FIFO con prioridad por peso del archivo, el valor de prioridad = peso en kb.*

*Por lo que el más liviano sería el primero en imprimirse y el más pesado sería el último.*

### 3. Guardia del Hospital de Clínicas (Triage): Consigna: Definí los valores de prioridad para 3 casos distintos de tu elección.

*Un accidente en moto de alta complejidad prioridad = 850.*

*Una embarazada ya en labor de parto = 800.*

*Un niño esguinzado = 70.*

### 4. Examen Final (Promocionados vs Regulares): Consigna: Si un regular llegó a las 8:00 AM y un promocionado a las 8:30 AM, ¿quién sale primero al hacer Desacolar?

*Sale primero el promocionado. Porque en esta situación no importa el orden de llegada a la hora de dejar pasar al siguiente sino la prioridad que tiene uno. Y en este caso el promocionado siempre tiene prioridad sobre el que rinde final.*

### 5. Buffet de la Facultad: Consigna: ¿Qué operación de TDA Cola usás para asegurar que no se cuele ningún "vibe coder"?

*Puedo utilizar el método Apilar para que lo coloquen en el lugar correcto.*

### 6. Procesador de Tareas (OS Scheduler): Consigna: Asigna prioridades y explica qué pasa si el sistema se sobrecarga.

*Claramente se prioriza los procesos del sistema sobre los de usuario como el uso de Spotify.*

*En caso de sobrecarga se van realizando primero los procesos de sistema para liberar espacio.*

### 7. Embarque de Aerolíneas: Consigna: Identifica el comportamiento si llegan dos personas con la misma prioridad.

*En caso de tener dos personas con la misma prioridad podemos cederle el paso al que llegó primero.*

*Por lo tanto primero se ve la prioridad y si la prioridad es la misma se analiza el orden de llegada.*

### 8. Distribución de Tickets IT: Consigna: Definí explícitamente el valor de prioridad para cada caso.

*El hecho de que se rompa el servidor principal tiene un máximo nivel de prioridad siendo el primer ticket que se distribuye por encima de todos.*

*Por otro lado, el "no me gusta el fondo de pantalla" tiene una prioridad mínima casi nulo, al ser un problema muy insignificante.*

---

## 4. Bloque 3: Conjuntos (Sin Duplicados)

### 1. Padrón Electoral: Registro de alumnos para votar en el Centro de Estudiantes: Operación Clave: ¿Cómo evitás que un "vivo" vote dos veces usando Pertenece?

*Entendiendo que si el conjunto dice ej: juan, juan (sin ordenar) le permitiría a Juan votar dos veces:*

*Para registrar el padrón de la votación del centro de estudiantes se debe de planificar un conjunto debido a que no admite duplicados.*

*Para armar dicho conjunto antes de ingresar al padrón un alumno se verifica si pertenece ya, si no pertenece se introduce, y si pertenece no se introduce.*

### 2. Invitados a la Fiesta de Fin de Cursada: Consigna: ¿Qué pasa si intentás Agregar a alguien que ya está en la lista? ¿Cambia el tamaño del conjunto?

*No el tamaño no cambia ya que al trabajar con conjuntos no me permite agregar repetidos y lo deja igual.*

### 3. Filtro de Spam (Blacklist): Un conjunto de palabras como "Crypto", "Ganá", "Premio": Consigna: ¿Cómo verificás si un mail entrante tiene una palabra prohibida?

a. *Para verificar las palabras de la blacklist de forma iterativa sigo la secuencia de:*

b. *Obtener valor.*

c. *Guardar valor (ejemplo en una lista o un auxiliar que se sobrescribe en la próxima iteración).*

d. *Borrar valor.*

*Chequear que sigan habiendo valores en el conjunto, si es así, sigo el bucle nuevamente y si no, finalizo el bucle.*

### 4. Tags de un Blog de Ingeniería: Consigna: ¿Por qué usamos un conjunto y no una Pila para los tags?

*Porque al usar un conjunto nos aseguramos que no hay tags repetidos.*

### 5. Gestión de Legajos: Consigna: Si un alumno se anota a dos carreras, ¿cómo se asegura el sistema de no duplicar su ID?

*Puede usar el método Pertenece() para ver si ya se encuentra registrado el alumno. De esta forma evita la duplicación de su ID.*

### 6. Operación Elegir vs Sacar: Pregunta Técnica: Si llamás a Elegir dos veces seguidas sin llamar a Sacar, ¿te devuelve el mismo elemento? (Pista: Es arbitrario, no necesariamente aleatorio).

...
