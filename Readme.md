# Tres en Raya-Proyecto-Cambiado-Por-mi-ivan


## Instalación
Para instalar y usar el proyecto debe descargar la carpeta completa y abrirla con su IDE favorito como un proyecto. Entrar en Main.java y ejecutar el código.

## Descripción
La idea era implementar un aplicativo que tenga acceso a bases de datos con interfaz gráfica y CRUD de la base de datos. El aplicativo es un programa que te permite jugar al tres en raya, añadir, eliminar, modificar o buscar información de un jugador en concreto, mostrar un ranking en forma de tabla de los jugadores (incluyendo victorias, derrotas, empates y el total de partidas) y de las partidas (que incluye información sobre los jugadores que participaron en ella y quien fue el ganador, en caso de empate ese recuadro estará vacio). Esto se encuentra dividido en dinstintas interfaces gráficas.
En la primera encontraremos un menú con cuatro botones, uno para jugar al tres en raya, otro para administrar a los jugadores de la base de datos, otro para ver la lista de partidas y jugadores y por último uno para crear la base de datos y añadir a dos jugadores para empezar a jugar.
Si entramos en "Jugar" encontraremos que nos pide el nombre de los dos jugadores, estos deben existir en la base de datos, en caso contrario no nos dejará jugar. Si los dos jugadores existen despues de escribir los nombre pulsamos en "Jugar" nos llevará al tablero de juego. Al acabar la partida podremos decidir si repetir (en cuyo caso se cambian los turnos, siendo el jugador dos quien empieza ahora) o si volver al menú principal.
Si entramos en "Administrar jugadores" nos encontraremos con cuatro botones, uno para añadir a un jugador nuevo (nos pedirá su nombre y la contraseña que quiera tener), otro para eliminar a un jugador a través de su ID, otro para modificar el nombre y/o contraseña de un usuario y el último para buscar el ID de un jugador a través de su nombre.
Si entramos en "Ranking" nos encontraremos con una interfaz y dos botones, el botón de "Partidas" nos enseñará en la interfaz una lista con las partidas jugadas y sus datos pero si pulsamos en "Jugadores" nos enseñará la lista de los jugadores existentes y sus datos.
## Modelo E-R y Diagrama de clases
![](https://imgur.com/Ft17OOr.png)


## Contribución
Se aceptan contribuciones. Para cambios mayores, por favor abra una incidencia primero para discutir lo que le gustaría cambiar.

Asegúrese de actualizar las pruebas según corresponda.


## Autor
Aarón Curro Solla

## Licencia

[MIT](https://choosealicense.com/licenses/mit/)
