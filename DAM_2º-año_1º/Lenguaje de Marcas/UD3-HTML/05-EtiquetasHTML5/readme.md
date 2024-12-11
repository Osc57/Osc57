# Nuevas Etiquetas en HTML5

HTML5 introduce una serie de nuevas etiquetas que mejoran la estructura semántica de las páginas web. Estas etiquetas proporcionan más significado y mejoran la accesibilidad, haciendo que el contenido sea más fácil de entender tanto para los usuarios como para los motores de búsqueda.

## 1. Estructura Semántica

### 1.1 `<header>`
La etiqueta `<header>` define la cabecera de un documento o de una sección. Generalmente contiene elementos como el logo, el título, menús de navegación o encabezados.

#### Ejemplo:
```html
<header>
  <h1>Bienvenidos a Mi Sitio Web</h1>
  <nav>
    <ul>
      <li><a href="#home">Inicio</a></li>
      <li><a href="#about">Sobre nosotros</a></li>
    </ul>
  </nav>
</header>
```

### 1.2 `<nav>`
La etiqueta `<nav>` define una sección de navegación dentro de un documento. Es adecuada para enlaces a otras partes del sitio o del documento.

#### Ejemplo:
```html
<nav>
  <ul>
    <li><a href="#services">Servicios</a></li>
    <li><a href="#contact">Contacto</a></li>
  </ul>
</nav>
```

### 1.3 `<section>`
La etiqueta `<section>` agrupa contenido relacionado en una sección temática. Puede contener encabezados y otros contenidos agrupados.

#### Ejemplo:
```html
<section>
  <h2>Productos Destacados</h2>
  <p>Aquí encontrarás una selección de nuestros mejores productos.</p>
</section>
```

### 1.4 `<article>`
La etiqueta `<article>` se usa para contenido independiente y autónomo, como artículos, publicaciones de blogs o comentarios. Cada `<article>` debe poder tener sentido por sí solo.

#### Ejemplo:
```html
<article>
  <h2>Cómo aprender HTML5</h2>
  <p>En este artículo, exploraremos las nuevas etiquetas introducidas en HTML5...</p>
</article>
```

### 1.5 `<aside>`
La etiqueta `<aside>` define contenido que está relacionado de manera indirecta con el contenido principal. Se utiliza para barras laterales, anuncios o información complementaria.

#### Ejemplo:
```html
<aside>
  <h3>Artículos Relacionados</h3>
  <ul>
    <li><a href="#">Cómo usar CSS Grid</a></li>
    <li><a href="#">Introducción a JavaScript</a></li>
  </ul>
</aside>
```

### 1.6 `<footer>`
La etiqueta `<footer>` representa el pie de página de un documento o una sección. Suele contener información como derechos de autor, enlaces a términos de uso, o enlaces sociales.

#### Ejemplo:
```html
<footer>
  <p>&copy; 2024 Mi Sitio Web. Todos los derechos reservados.</p>
</footer>
```

## 2. Mejoras en Formularios

HTML5 también introduce nuevas etiquetas y atributos que mejoran los formularios, facilitando su uso y validación automática.

### 2.1 `<input type="email">` y `<input type="url">`
Nuevos tipos de campos de entrada que permiten validación automática para correos electrónicos y URLs.

#### Ejemplo:
```html
<label for="email">Correo Electrónico:</label>
<input type="email" id="email" name="email" required>
```

### 2.2 `<input type="date">`, `<input type="time">`, `<input type="datetime-local">`
Permiten que los usuarios seleccionen fechas y horas de forma sencilla con interfaces nativas del navegador.

#### Ejemplo:
```html
<label for="bday">Fecha de Nacimiento:</label>
<input type="date" id="bday" name="bday">
```

### 2.3 `<input type="range">`
Permite la selección de un valor dentro de un rango, usando un control deslizante.

#### Ejemplo:
```html
<label for="volume">Volumen:</label>
<input type="range" id="volume" name="volume" min="0" max="100">
```

## 3. Multimedia

HTML5 facilita la integración de contenido multimedia sin necesidad de complementos externos como Flash.

### 3.1 `<audio>`
La etiqueta `<audio>` permite reproducir archivos de audio directamente en la página.

#### Ejemplo:
```html
<audio controls>
  <source src="cancion.mp3" type="audio/mpeg">
  Tu navegador no soporta la reproducción de audio.
</audio>
```

### 3.2 `<video>`
La etiqueta `<video>` permite insertar videos en la página de manera nativa.

#### Ejemplo:
```html
<video controls width="600">
  <source src="video.mp4" type="video/mp4">
  Tu navegador no soporta la reproducción de video.
</video>
```

## 4. Otras Etiquetas Nuevas

### 4.1 `<main>`
La etiqueta `<main>` define el contenido principal de un documento. Solo debe haber un `<main>` por página y debe englobar la parte más importante del contenido.

#### Ejemplo:
```html
<main>
  <h2>Bienvenido a nuestra tienda</h2>
  <p>Aquí encontrarás los mejores productos a precios increíbles.</p>
</main>
```

### 4.2 `<figure>` y `<figcaption>`
La etiqueta `<figure>` se utiliza para agrupar contenido como imágenes, diagramas o cualquier contenido que pueda tener una leyenda. La etiqueta `<figcaption>` añade una leyenda a la figura.

#### Ejemplo:
```html
<figure>
  <img src="imagen.jpg" alt="Descripción de la imagen">
  <figcaption>Figura 1: Descripción de la imagen.</figcaption>
</figure>
```

### 4.3 `<mark>`
La etiqueta `<mark>` destaca texto que es relevante o importante.

#### Ejemplo:
```html
<p>El precio actual es <mark>50€</mark> hasta el fin de la oferta.</p>
```

### 4.4 `<progress>`
La etiqueta `<progress>` representa el progreso de una tarea en curso.

#### Ejemplo:
```html
<label for="file">Subida de archivos:</label>
<progress id="file" value="32" max="100">32%</progress>
```

## 5. Atributos Globales

HTML5 también introduce nuevos atributos globales que pueden ser usados en cualquier etiqueta:

### 5.1 `contenteditable`
Permite que el contenido de un elemento HTML sea editable por el usuario.

#### Ejemplo:
```html
<p contenteditable="true">Puedes editar este texto.</p>
```

### 5.2 `autofocus`
Hace que un elemento del formulario reciba automáticamente el foco cuando se carga la página.

#### Ejemplo:
```html
<input type="text" name="name" autofocus>
```

### 5.3 `placeholder`
Muestra un texto dentro de los campos de entrada que desaparece cuando el usuario empieza a escribir.

#### Ejemplo:
```html
<input type="text" name="nombre" placeholder="Introduce tu nombre">
```

## Conclusión
HTML5 introduce una serie de etiquetas y mejoras que permiten una estructura más semántica, accesible y funcional en los sitios web. Asegúrate de utilizarlas adecuadamente para mejorar tanto la experiencia de usuario como la compatibilidad con motores de búsqueda.
```
