# Cheese Store (Testing Levels)

En CheeseWorld™️ tenemos un amplio catálogo de quesos de importación y queremos dar el salto con un e-commerce:

Utiliza este repositorio para comenzar la kata

### Parte 1: Test unitarios

Cada uno de los quesos se crea copiando la etiqueta física completa, que incluye toda la información:

```java
new Cheese("Rochefort|stinky french cheese|250gr")
```

Sin embargo, a la hora de procesar la información querremos conocer las diferentes propiedades de cada uno de los productos por separado.

Extrae la información de cada producto a partir de la etiqueta completa, escribiendo tests e implementando las diferentes funciones en la clase `Cheese`:

- Nombre del queso (es la primera sección de la etiqueta)
- Peso en gramos (en el ejemplo anterior, sería `250`)
- El queso es apestoso (`isStinky()`) si la descripción contiene la palabra `smelly` o la palabra `stinky`.
- El queso puede ser francés (`isFrench()`) si contiene la palabra `french` en la descripción.
- Todos los quesos tienen el mismo precio en euros (`priceInEuros()`): `5`
    - Si la descripción contiene la palabra `discount`, el precio en euros será `4.50`.


### Parte 2: Tests de Integración

La versión inicial de la página nos muestra la lista de quesos completa en `/cheese/all`

Añade diferentes secciones que nos permitan ver partes del catálogo. Para cada una, escribe un test de integración e intenta hacerlo pasar escribiendo el código correspondiente en el controlador. Utiliza siempre la misma vista (`catalog`), no crees nuevos archivos html.

- En `/cheese/stinky` debemos ver únicamente el catálogo de quesos apestosos
- En `/cheese/french` únicamente debemos ver los quesos franceses
- En `/cheese/discount` veremos los quesos que tengan descuento

### Parte 3: Tests de aceptación o UI

`próximamente`