# Formularios en HTML

## 1. ¿Qué es un formulario?
Un formulario en HTML es una sección de una página web que permite a los usuarios ingresar datos que luego se pueden enviar a un servidor para su procesamiento. Los formularios son esenciales para interactuar con los usuarios en aplicaciones web.

El formulario básico se crea usando la etiqueta `<form>`. 

### Ejemplo básico de un formulario
```html
<form action="/submit" method="POST">
  <!-- Aquí van los campos del formulario -->
</form>
```

- **`action`**: Define a dónde se envían los datos del formulario (la URL del servidor).
- **`method`**: Define cómo se envían los datos. Los métodos más comunes son:
  - `GET`: Los datos se envían en la URL (usado para solicitudes de búsqueda).
  - `POST`: Los datos se envían de forma oculta en el cuerpo de la solicitud (usado para enviar información sensible o grandes volúmenes de datos).

## 2. Tipos de controles de formulario
HTML ofrece varios tipos de controles de formulario, como campos de texto, botones, menús desplegables y casillas de verificación.

### 2.1 Campo de texto (`<input type="text">`)
Permite al usuario ingresar una sola línea de texto.

```html
<label for="name">Nombre:</label>
<input type="text" id="name" name="name">
```

### 2.2 Contraseña (`<input type="password">`)
Oculta el texto que el usuario escribe (útil para contraseñas).

```html
<label for="password">Contraseña:</label>
<input type="password" id="password" name="password">
```

### 2.3 Botón de envío (`<input type="submit">`)
Envía los datos del formulario al servidor.

```html
<input type="submit" value="Enviar">
```

### 2.4 Botón de reinicio (`<input type="reset">`)
Restablece todos los campos del formulario a sus valores iniciales.

```html
<input type="reset" value="Resetear">
```

### 2.5 Casillas de verificación (`<input type="checkbox">`)
Permiten seleccionar una o más opciones de un grupo.

```html
<label>
  <input type="checkbox" name="subscribe" value="newsletter">
  Suscribirme al boletín
</label>
```

### 2.6 Botones de opción (`<input type="radio">`)
Permiten seleccionar solo una opción entre varias.

```html
<label>
  <input type="radio" name="gender" value="male"> Hombre
</label>
<label>
  <input type="radio" name="gender" value="female"> Mujer
</label>
```

### 2.7 Menús desplegables (`<select>`)
Permiten al usuario seleccionar una opción de una lista.

```html
<label for="country">País:</label>
<select id="country" name="country">
  <option value="es">España</option>
  <option value="mx">México</option>
  <option value="ar">Argentina</option>
</select>
```

## 3. Organización de campos

### 3.1 Etiquetas (`<label>`)
Las etiquetas ayudan a identificar los campos del formulario y mejoran la accesibilidad.

```html
<label for="email">Correo electrónico:</label>
<input type="email" id="email" name="email">
```

### 3.2 Agrupar campos con `<fieldset>` y `<legend>`
Se usa para organizar mejor los formularios largos.

```html
<fieldset>
  <legend>Información Personal</legend>
  <label for="fname">Nombre:</label>
  <input type="text" id="fname" name="fname"><br>
  <label for="lname">Apellido:</label>
  <input type="text" id="lname" name="lname">
</fieldset>
```

## 4. Atributos importantes de los controles de formulario

### 4.1 `required`
Hace que un campo sea obligatorio.

```html
<input type="text" name="username" required>
```

### 4.2 `placeholder`
Muestra un texto dentro del campo que desaparece cuando el usuario empieza a escribir.

```html
<input type="text" name="city" placeholder="Introduce tu ciudad">
```

### 4.3 `value`
Especifica un valor inicial para el campo de formulario.

```html
<input type="text" name="country" value="España">
```

### 4.4 `disabled`
Deshabilita un campo para que no pueda ser modificado ni enviado.

```html
<input type="text" name="username" value="Usuario123" disabled>
```

### 4.5 `maxlength`
Limita el número máximo de caracteres que el usuario puede ingresar en un campo.

```html
<input type="text" name="zip" maxlength="5">
```

## 5. Validación de formularios
Los navegadores modernos proporcionan validación automática para ciertos tipos de campos y atributos.

### 5.1 Validación básica con atributos
- `required`: Indica que el campo es obligatorio.
- `type`: Campos como `email`, `url`, y `number` tienen validación automática.
  
Ejemplo de un campo de correo validado automáticamente:
```html
<input type="email" name="email" required>
```

## 6. Envío de datos del formulario
Cuando el usuario hace clic en un botón de envío (`<input type="submit">` o `<button>`), el navegador envía los datos del formulario al servidor utilizando el método especificado en el atributo `method`.

### Ejemplo de un formulario completo
```html
<form action="/submit" method="POST">
  <label for="name">Nombre:</label>
  <input type="text" id="name" name="name" required><br>

  <label for="email">Correo electrónico:</label>
  <input type="email" id="email" name="email" required><br>

  <label for="country">País:</label>
  <select id="country" name="country">
    <option value="es">España</option>
    <option value="mx">México</option>
    <option value="ar">Argentina</option>
  </select><br>

  <input type="submit" value="Enviar">
</form>
```

