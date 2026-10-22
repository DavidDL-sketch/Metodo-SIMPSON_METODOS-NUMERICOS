# Práctica: Implementación de Simpson 1/3 Compuesto y Análisis Comparativo

**Asignatura:** SCC-1017 Métodos Numéricos  
**Unidad:** Tarea 1 Unidad 4  
**Docente:** Víctor Hugo Vásquez Herrera  
**Alumno:** David Domínguez López  
**Institución:** Instituto Tecnológico Superior de Xalapa  
**Carrera:** Ingeniería en Sistemas Computacionales  

---

## 1. Descripción del Proyecto

Este repositorio contiene la implementación en el lenguaje **Java** del método de integración numérica de **Simpson 1/3 Compuesto** mediante refinamiento sucesivo por tolerancia. Asimismo, incluye un análisis comparativo de rendimiento frente al método del **Trapecio Compuesto**, evaluando el número de subintervalos (\(n\)) requeridos por cada algoritmo para converger bajo una misma tolerancia matemática.

---

## 2. Instrucciones de Compilación y Ejecución

Puedes compilar y ejecutar este proyecto desde la terminal utilizando el JDK de Java, o importando la carpeta en cualquier IDE (como Apache NetBeans, IntelliJ IDEA o Eclipse).

### Requisitos Previos
* **Java Development Kit (JDK):** Versión 8 o superior instalado.
* Variables de entorno de Java configuradas (`java` y `javac`).

### Ejecución mediante Terminal de Comandos

1. **Clonar el repositorio** o descargar los archivos fuente:
   ```bash
   git clone https://github.com
   cd TU_REPOSITORIO
   ```

2. **Crear la estructura de carpetas** para los binarios (opcional pero recomendado):
   ```bash
   mkdir bin
   ```

3. **Compilar las clases** desde la raíz del código fuente respetando el paquete `dif_e_integracion`:
   ```bash
   javac -d bin src/dif_e_integracion/*.java
   ```

4. **Ejecutar el programa principal**:
   ```bash
   java -cp bin dif_e_integracion.Main
   ```

---

## 3. Ejemplo de Salida en Consola

Al ejecutar el método `Main` evaluando la función estandarizada \(f(x) = x^2\) en el intervalo \([0.0, 2.0]\) con una tolerancia de \(1\times 10^{-6}\), se obtiene el siguiente comportamiento en consola:

```text
--- INICIANDO ANÁLISIS COMPARATIVO ---
Evaluando integral en el intervalo [0.0, 2.0]

[Trapecio] Convergencia alcanzada con n = 2048 subintervalos.
Resultado Trapecio Compuesto: 2.666667188644409

[Simpson 1/3] Convergencia alcanzada con n = 4 subintervalos.
Resultado Simpson 1/3 Compuesto: 2.6666666666666665
```

---

## 4. Análisis Conceptual (Reporte Comparativo)

### a) ¿Por qué la Regla de Simpson 1/3 Compuesta exige geométricamente que el número total de subintervalos ($n$) sea estrictamente par?
La regla de Simpson 1/3 aproxima el área bajo la curva utilizando **parábolas (polinomios de segundo grado)** en lugar de líneas rectas. Para definir de forma única una función cuadrática $y = ax^2 + bx + c$, la geometría analítica dicta que se requieren estrictamente **3 puntos de control**. 

Cada segmento parabólico individual abarca dos subintervalos consecutivos (utilizando el límite izquierdo, el punto medio y el límite derecho). Por lo tanto, si cada parábola consume exactamente 2 subintervalos, el acoplamiento de múltiples parábolas consecutivas en el método compuesto obliga a que el número total de subintervalos $n$ sea un **múltiplo exacto de 2 (par)**.

### b) ¿A qué se debe el patrón alternado de coeficientes en Simpson (1, 4, 2, 4, ..., 1) en comparación con el Trapecio Compuesto (1, 2, 2, ..., 1)?
Este comportamiento se deriva directamente de **cómo se comparten los límites de los puntos geométricos** entre las figuras adyacentes:

* **En el Trapecio Compuesto:** Cada punto interior $x_k$ actúa simultáneamente como el límite derecho de un trapecio y el límite izquierdo del siguiente. Al sumarse ambas contribuciones idénticas en la ecuación global, su peso se duplica de manera uniforme, generando un patrón constante de coeficientes $2$ para todos los elementos internos.
* **En Simpson 1/3 Compuesto:** El método se compone de múltiples parábolas adyacentes. El punto central de una parábola individual se evalúa exclusivamente dentro de esa parábola aportando un peso de **coeficiente 4** (derivado de la regla de integración de Newton-Cotes). En cambio, los puntos que actúan como extremos fronterizos son compartidos por dos parábolas vecinas; la suma de sus extremos de acoplamiento da como resultado un **coeficiente 2**. Esta alternancia funcional genera el patrón simétrico $(1, 4, 2, 4, 2, ..., 4, 1)$.

---

## 5. Tabla Comparativa de Eficiencia

A partir de los resultados experimentales en el programa se observa la enorme ventaja del uso de interpolaciones de orden superior:

| Métrica Evaluada | Método del Trapecio Compuesto | Método de Simpson 1/3 Compuesto |
| :--- | :---: | :---: |
| **Aproximación geométrica** | Líneas rectas (Polinomio Grado 1) | Parábolas (Polinomio Grado 2) |
| **Subintervalos ($n$) requeridos** | **2048** | **4** |
| **Precisión final** | Baja por unidad de subintervalo | Extremadamente alta |
| **Velocidad de convergencia** | Lenta | Ultra rápida |
