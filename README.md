# Fórmula 1

Este proyecto es el resultado del trabajo realizado para la asignatura de Android en Android Studio, utilizando el lenguaje Kotlin.

## Descripción

La aplicación Formula 1 cuenta con un menú de navegación en la parte inferior de la página que permite acceder a las secciones de Circuitos, Pilotos y Equipos.

### Circuitos

En esta sección se muestran todos los circuitos de la temporada de 2023 de Fórmula 1, ordenados según el orden de las carreras. Al seleccionar un circuito, se despliega información detallada, incluyendo la ronda, nombre del Gran Premio, nombre del circuito, país y ciudad, fecha y hora de la carrera.

### Pilotos

Aquí se presentan todos los pilotos de la temporada de 2023 de Fórmula 1, ordenados por apellido. Al hacer clic en un piloto, se muestra información detallada, como nombre, apellidos, código mostrado en la tabla de posición durante las carreras, número del piloto, fecha de nacimiento y nacionalidad.

### Equipos

En esta sección se muestran todos los equipos creados localmente por el usuario. La página carga todos los equipos y su información, lo que puede llevar varios segundos. Al hacer clic en el botón "+" en la esquina inferior derecha, se redirige a una página de creación de equipo. Aquí, el usuario debe ingresar un nombre de equipo, seleccionar dos pilotos de un menú desplegable e indicar los números de cada uno, que deben estar entre 1 y 99. Si hay algún campo vacío, se selecciona el mismo piloto en ambos menús desplegables, o los números de los pilotos son iguales, el botón de "Crear Equipo" no se activará. Junto a este botón hay otro para cancelar el proceso de creación de equipo y volver atrás.

## Tecnologías y API

- La aplicación utiliza la API de [ergast.com](https://ergast.com/mrd/) para obtener datos de circuitos y pilotos.
- Los datos obtenidos de la API y los creados localmente se guardan en una base de datos interna.
- La aplicación está traducida a Español, Inglés e Italiano, y muestra el idioma según la configuración del dispositivo. Si el idioma configurado no es ninguno de los mencionados, se muestra en inglés por defecto.
