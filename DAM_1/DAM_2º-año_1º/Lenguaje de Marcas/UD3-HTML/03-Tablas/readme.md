# Tablas en HTML

## 1. ¿Qué es una tabla en HTML?
Una tabla en HTML se utiliza para organizar y mostrar datos en formato tabular, compuesto por filas y columnas. Las tablas son útiles para mostrar información estructurada, como listas, calendarios o resultados de análisis.

### Estructura básica de una tabla
Una tabla en HTML se define usando la etiqueta `<table>`. Dentro de una tabla, se utilizan las siguientes etiquetas:

- `<tr>`: Define una fila.
- `<th>`: Define un encabezado de columna.
- `<td>`: Define una celda de datos.

#### Ejemplo básico:
```html
<table>
  <tr>
    <th>Nombre</th>
    <th>Edad</th>
    <th>País</th>
  </tr>
  <tr>
    <td>Juan</td>
    <td>25</td>
    <td>España</td>
  </tr>
  <tr>
    <td>Ana</td>
    <td>30</td>
    <td>Argentina</td>
  </tr>
</table>
```

## 2. Estructura de una tabla

### 2.1. `<table>`
Esta etiqueta envuelve toda la estructura de la tabla.

### 2.2. `<tr>` (Table Row - Fila)
Cada fila de la tabla se define con la etiqueta `<tr>`.

#### Ejemplo:
```html
<tr>
  <td>Dato 1</td>
  <td>Dato 2</td>
</tr>
```

### 2.3. `<th>` (Table Header - Encabezado)
Define los encabezados de la tabla. Por defecto, el texto de las celdas de los encabezados se muestra en **negrita** y está centrado.

#### Ejemplo:
```html
<tr>
  <th>Nombre</th>
  <th>Edad</th>
</tr>
```

### 2.4. `<td>` (Table Data - Datos)
Define las celdas de datos en una tabla. Las celdas de datos contienen el contenido que quieres mostrar en la tabla.

#### Ejemplo:
```html
<tr>
  <td>Juan</td>
  <td>25</td>
</tr>
```

## 3. Encabezados y cuerpo de la tabla

### 3.1. `<thead>` (Table Head)
Esta etiqueta se usa para agrupar los encabezados de la tabla. Esto es útil para hacer tablas más accesibles y claras.

#### Ejemplo:
```html
<table>
  <thead>
    <tr>
      <th>Producto</th>
      <th>Precio</th>
    </tr>
  </thead>
</table>
```

### 3.2. `<tbody>` (Table Body)
El cuerpo de la tabla, donde se encuentran los datos, se agrupa con la etiqueta `<tbody>`.

#### Ejemplo:
```html
<table>
  <thead>
    <tr>
      <th>Producto</th>
      <th>Precio</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>Manzanas</td>
      <td>$2</td>
    </tr>
    <tr>
      <td>Naranjas</td>
      <td>$3</td>
    </tr>
  </tbody>
</table>
```

### 3.3. `<tfoot>` (Table Foot)
La etiqueta `<tfoot>` agrupa el pie de una tabla, generalmente contiene cálculos o resúmenes.

#### Ejemplo:
```html
<table>
  <thead>
    <tr>
      <th>Producto</th>
      <th>Precio</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>Manzanas</td>
      <td>$2</td>
    </tr>
    <tr>
      <td>Naranjas</td>
      <td>$3</td>
    </tr>
  </tbody>
  <tfoot>
    <tr>
      <td>Total</td>
      <td>$5</td>
    </tr>
  </tfoot>
</table>
```

## 4. Atributos útiles para tablas

### 4.1. `colspan`
El atributo `colspan` permite que una celda abarque varias columnas.

#### Ejemplo:
```html
<tr>
  <td colspan="2">Celda que abarca 2 columnas</td>
</tr>
```

### 4.2. `rowspan`
El atributo `rowspan` permite que una celda abarque varias filas.

#### Ejemplo:
```html
<tr>
  <td rowspan="2">Celda que abarca 2 filas</td>
  <td>Celda 1</td>
</tr>
<tr>
  <td>Celda 2</td>
</tr>
```

## 5. Estilización de tablas

Puedes usar CSS para dar estilo a tus tablas. Aquí algunos ejemplos de cómo puedes estilizar una tabla.

### 5.1. Bordes en la tabla
```html
<style>
  table, th, td {
    border: 1px solid black;
  }
</style>

<table>
  <tr>
    <th>Nombre</th>
    <th>Edad</th>
  </tr>
  <tr>
    <td>Juan</td>
    <td>25</td>
  </tr>
</table>
```

### 5.2. Alineación del texto
Puedes usar CSS para alinear el texto en las celdas.

#### Ejemplo:
```html
<style>
  td {
    text-align: center;
  }
</style>
```

### 5.3. Colores alternados en filas
Para mejorar la legibilidad, puedes alternar los colores de las filas.

#### Ejemplo:
```html
<style>
  tr:nth-child(even) {
    background-color: #f2f2f2;
  }
</style>

<table>
  <tr>
    <th>Producto</th>
    <th>Precio</th>
  </tr>
  <tr>
    <td>Manzanas</td>
    <td>$2</td>
  </tr>
  <tr>
    <td>Naranjas</td>
    <td>$3</td>
  </tr>
</table>
```

## 6. Tablas accesibles

Para mejorar la accesibilidad de las tablas, puedes añadir el atributo `scope` en los encabezados. Esto indica a los lectores de pantalla que el encabezado pertenece a una fila o columna en particular.

#### Ejemplo:
```html
<table>
  <thead>
    <tr>
      <th scope="col">Producto</th>
      <th scope="col">Precio</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td scope="row">Manzanas</td>
      <td>$2</td>
    </tr>
    <tr>
      <td scope="row">Naranjas</td>
      <td>$3</td>
    </tr>
  </tbody>
</table>
```

## 7. Tablas Responsivas

HTML y CSS permiten hacer tablas adaptativas para dispositivos móviles usando CSS.

#### Ejemplo de una tabla con scroll horizontal en pantallas pequeñas:
```html
<style>
  table {
    width: 100%;
    border-collapse: collapse;
  }
  @media (max-width: 600px) {
    table, thead, tbody, th, td, tr {
      display: block;
    }
    thead {
      display: none;
    }
    tr {
      margin-bottom: 15px;
    }
    td {
      text-align: right;
      position: relative;
      padding-left: 50%;
    }
    td:before {
      content: attr(data-label);
      position: absolute;
      left: 0;
      width: 50%;
      padding-left: 10px;
      font-weight: bold;
    }
  }
</style>

<table>
  <thead>
    <tr>
      <th>Producto</th>
      <th>Precio</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td data-label="Producto">Manzanas</td>
      <td data-label="Precio">$2</td>
    </tr>
    <tr>
      <td data-label="Producto">Naranjas</td>
      <td data-label="Precio">$3</td>
    </tr>
  </tbody>
</table>
```

## Conclusión
Las tablas en HTML son una herramienta poderosa para organizar y mostrar datos. HTML5 ha mantenido la simplicidad en el uso de tablas, pero también ha mejorado la accesibilidad y la capacidad de estilización, especialmente cuando se combina con CSS. Recuerda que es importante hacer tus tablas lo más claras y accesibles posible.
