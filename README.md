# Reto 4: La Estafa de la Casa de Cambio

## Contexto del Problema
Una casa de cambio tenía como anterior propietario a "El Gringo", quien utilizaba la misma tasa de cambio para todas las conversiones, estafando a los usuarios. El nuevo dueño requiere un sistema que permita convertir cualquier moneda con tasas reales.

## Categoría de Patrón de Diseño
**Estructural**

## Patrón Utilizado
**Adapter**

## Justificación
El sistema original utilizaba una tasa de cambio fija e injusta para todas las monedas. El patrón Adapter nos permite conectar el servicio de cambio con una lógica de "tasas reales" sin alterar la estructura del cliente, permitiendo la flexibilidad de agregar o cambiar tasas en el futuro sin romper el sistema.

## Cómo lo aplico
He creado una interfaz `IConversor` que define el método de conversión estándar y una clase `CasaCambioAdapter` que implementa esta interfaz, realizando los cálculos específicos según las monedas de origen y destino solicitadas. El adaptador utiliza USD como moneda pivote para conversiones indirectas entre cualquier par de monedas.

## Estructura del Proyecto
```
src/main/java/com/dosw/reto4/
├── IConversor.java              # Interfaz Target del patrón Adapter
├── CasaCambioAdapter.java       # Adapter con tasas reales
├── Transaccion.java             # Modelo de datos (POO)
├── Reto4CasaCambio.java         # Lógica principal con Streams
└── App.java                     # Punto de entrada
```

## Características Implementadas
- Conversión entre múltiples monedas: USD, EUR, JPY, COP
- Soporte para X transacciones definidas por el usuario
- Conversión a múltiples monedas destino en una sola transacción
- Uso de Java Streams para agrupar y sumar totales por moneda
- Formato de salida con 2 decimales para evitar errores de precisión
- Tasas de cambio bidireccionales usando USD como pivote

## Cómo Ejecutar

### Compilar
```bash
mvn clean compile
```

### Ejecutar
```bash
java -cp target/classes com.dosw.reto4.App
```

### Ejemplo de Uso
```
Ingrese número de transacciones: 2
Transacción 1
Ingrese monto: 50
Ingrese moneda de origen: EUR
Ingrese monedas destino (separadas por coma): USD,JPY
Convertido a USD: 55,00 USD
Convertido a JPY: 8250,00 JPY

Transacción 2
Ingrese monto: 100000
Ingrese moneda de origen: COP
Ingrese monedas destino (separadas por coma): USD,EUR
Convertido a USD: 25,00 USD
Convertido a EUR: 22,73 EUR

Totales por moneda
JPY: 8250,00 JPY
USD: 80,00 USD
EUR: 22,73 EUR
```

## Tasas de Cambio Implementadas
| Moneda | Tasa a USD |
|--------|------------|
| USD    | 1.0        |
| EUR    | 1.1        |
| JPY    | 0.0067     |
| COP    | 0.00025    |

## Requisitos Cumplidos
- [x] El sistema acepta cualquier cantidad de monedas
- [x] El usuario puede ingresar X transacciones
- [x] El servicio muestra tanto la cantidad original como la convertida
- [x] Se usan Streams para sumar varios pagos y calcular el total
- [x] Documentación del patrón de diseño en README.md

## Tecnologías
- Java 8+ (Streams, Lambdas)
- Maven
- Patrón de Diseño: Adapter (Estructural)
