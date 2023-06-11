
CREATE TABLE `jugador` (
  `codJugador` int(10) UNSIGNED NOT NULL,
  `nombre` varchar(50) COLLATE utf8mb4_spanish_ci NOT NULL,
  `contraseña` varchar(100) COLLATE utf8mb4_spanish_ci NOT NULL,
  `victorias` int(10) UNSIGNED DEFAULT 0,
  `derrotas` int(10) UNSIGNED DEFAULT 0,
  `empates` int(10) UNSIGNED DEFAULT 0,
  `total` int(10) UNSIGNED DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;


CREATE TABLE `partida` (
  `codPartida` int(10) UNSIGNED NOT NULL,
  `jugador1` varchar(50) NOT NULL,
  `jugador2` varchar(50) NOT NULL,
  `ganador` varchar(50) NULL,
  `fechaPartida` date not null
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

ALTER TABLE `jugador` ADD PRIMARY KEY (`codJugador`);

ALTER TABLE `partida` ADD PRIMARY KEY (`codPartida`);

ALTER TABLE `jugador` MODIFY `codJugador` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

ALTER TABLE `partida` MODIFY `codPartida` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

insert into `jugador` (nombre, contraseña, victorias, derrotas, empates, total) values ('Aaron', '1234', default, default, default, default);
insert into `jugador` (nombre, contraseña, victorias, derrotas, empates, total) values ('Mariola', '1234', default, default, default, default);

