# Ordenamiento Burbuja: Normal y Mejorado (Java)

**Autor:** Said Miguel Meza Lopez
**Docente:** Luis Alberto Mendoza San Juan
**Lenguaje:** Java

## Descripción

Este proyecto implementa en Java dos versiones del algoritmo de ordenamiento por burbuja y compara su rendimiento:

- `ordenamientoBurbuja(int[] arreglo)`: versión tradicional, que recorre el arreglo completo en cada pasada.
- `ordenamientoBurbujaMejorado(int[] arreglo)`: versión optimizada con una bandera que detiene el proceso cuando el arreglo ya está ordenado.

El objetivo de la práctica es entender la lógica y la complejidad del burbuja, aplicar la optimización con una variable de control y usar una IA como tutor en modo de aprendizaje guiado.

## ¿Cómo funciona el burbuja normal?

El algoritmo compara pares de elementos vecinos y los intercambia si el de la izquierda es mayor que el de la derecha. En cada pasada, el elemento más grande de la parte no ordenada “burbujea” hasta el final y queda en su lugar definitivo.

- **Ciclo externo:** hace `n - 1` pasadas (`i` va de 0 a `n - 2`).
- **Ciclo interno:** en la pasada `i` hace `n - 1 - i` comparaciones, porque los últimos `i` elementos ya están ordenados.
- **Intercambio:** se usa una variable temporal (`temp`) para no perder ningún valor.

Ejemplo con `[5, 3, 8, 1, 2]`:

| Pasada | Comparaciones | Resultado |
|---|---|---|
| 1 | 4 | `3, 5, 1, 2, 8` |
| 2 | 3 | `3, 1, 2, 5, 8` |
| 3 | 2 | `1, 2, 3, 5, 8` |
| 4 | 1 | `1, 2, 3, 5, 8` |

El arreglo quedó ordenado desde la pasada 3, pero la versión normal hace las 4 pasadas completas, es decir, 10 comparaciones en total.

## ¿Qué mejora el burbuja mejorado?

Si en una pasada completa no hubo ningún intercambio, todos los pares vecinos están en orden y el arreglo ya está ordenado, así que no tiene sentido seguir.

La mejora usa una variable `boolean huboIntercambio`:

1. Se declara en `false` al inicio de cada pasada (dentro del ciclo externo).
2. Se pone en `true` cada vez que se hace un intercambio.
3. Al terminar el ciclo interno, si sigue en `false`, se sale con `break`.

La optimización son solo tres líneas nuevas respecto al método normal.

## Estructura del proyecto

```
burbuja-java/
├── src/
│   └── burbuja.java
├── evidencia/
│   └── Reporte_Chat_Burbuja_Said_Meza.docx
├── README.md
└── .gitignore
```

- `src/burbuja.java`: contiene la clase `burbuja` con los dos métodos de ordenamiento y el método `main` con la prueba de ejecución.
- `evidencia/`: reporte del chat con la IA usada como tutor.

## Cómo compilar y ejecutar

Requisitos: tener instalado el JDK (Java 8 o superior).

```bash
javac src/burbuja.java
java -cp src burbuja
```

## Pruebas de ejecución

El método `main` ordena el mismo arreglo desordenado con cada algoritmo y muestra en consola el estado inicial y el resultado final:

- Arreglo de prueba: `{64, 34, 25, 12, 22, 11, 90}`
- Salida esperada:

```
Original:  [64, 34, 25, 12, 22, 11, 90]
Burbuja:   [11, 12, 22, 25, 34, 64, 90]
Mejorado:  [11, 12, 22, 25, 34, 64, 90]
```

Ambos métodos ordenan correctamente el arreglo.

## Análisis de comparaciones por caso

Con un arreglo de 5 elementos, estos son los números de comparaciones obtenidos al analizar a mano cada algoritmo (la versión normal siempre hace `n(n - 1) / 2`):

| Caso | Arreglo | Burbuja normal | Burbuja mejorado |
|---|---|---|---|
| Desordenado | `[5, 3, 8, 1, 2]` | 10 | 10 |
| Parcialmente ordenado | `[1, 2, 3, 5, 4]` | 10 | 7 |
| Ya ordenado | `[1, 2, 3, 4, 5]` | 10 | 4 |

Con el arreglo de prueba del programa (7 elementos, desordenado) ambos hacen 21 comparaciones, porque la bandera solo detecta el orden en la última pasada.

- **Desordenado:** el mejorado no ahorra nada.
- **Parcialmente ordenado:** el mejorado se detiene en la pasada 2 y ahorra 3 comparaciones.
- **Ya ordenado:** el mejorado hace una sola pasada sin intercambios y se detiene. Es su mejor caso.

## Complejidad

| | Mejor caso | Peor caso |
|---|---|---|
| Burbuja normal | O(n²) | O(n²) |
| Burbuja mejorado | O(n) | O(n²) |

- La versión normal siempre hace `n(n - 1) / 2` comparaciones, sin importar cómo vengan los datos.
- La versión mejorada, con un arreglo ya ordenado, solo recorre el arreglo una vez. En el peor caso (arreglo en orden inverso) se comporta igual que la normal.
- El espacio adicional es O(1), porque solo se usan variables auxiliares (`temp` y `huboIntercambio`).

## Uso de la IA

Esta práctica se desarrolló con un asistente de IA (Claude) en **modo de aprendizaje guiado**: el tutor explicó conceptos, hizo preguntas y dio pistas, y el código de los dos métodos lo escribió el alumno. El historial completo de la conversación está en la carpeta `evidencia/`.

## Conclusiones

- El burbuja es fácil de entender e implementar, pero poco eficiente con arreglos grandes por su complejidad cuadrática.
- La bandera `huboIntercambio` mejora el rendimiento cuando el arreglo está ordenado o casi ordenado, con un costo mínimo de código.
- Hacer pruebas de escritorio a mano antes de programar ayudó a deducir las fórmulas de los ciclos (`n - 1` pasadas y `n - 1 - i` comparaciones).
- Conviene usar la versión mejorada siempre que el burbuja sea la opción elegida, ya que nunca es peor que la normal.
