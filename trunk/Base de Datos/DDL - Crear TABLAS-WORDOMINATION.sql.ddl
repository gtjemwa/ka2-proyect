create table Usuario (nombre varchar(50) not null, pass varchar(30) not null, puntuacion int(10), primary key (nombre));
create table Partida (Jugador1 varchar(50) not null, Jugador2 varchar(50) not null, Jugador3 varchar(50), Jugador4 varchar(50), nombrecuadrilla varchar(50) not null);
create table Cuadrilla (nombrecuadrilla varchar(50) not null, cuadrosHorizontales int(10) not null, cuadrosVerticales int(10) not null, primary key (nombrecuadrilla));
create table cuadro (ubicacion int(10) not null auto_increment, letra char(1) not null, nombrecuadrilla varchar(50) not null, primary key (ubicacion));
alter table Partida add index FKPartida791668 (Jugador1), add constraint FKPartida791668 foreign key (Jugador1) references Usuario (nombre);
alter table Partida add index FKPartida791669 (Jugador2), add constraint FKPartida791669 foreign key (Jugador2) references Usuario (nombre);
alter table Partida add index FKPartida791670 (Jugador3), add constraint FKPartida791670 foreign key (Jugador3) references Usuario (nombre);
alter table Partida add index FKPartida791671 (Jugador4), add constraint FKPartida791671 foreign key (Jugador4) references Usuario (nombre);
alter table Partida add index FKPartida303634 (nombrecuadrilla), add constraint FKPartida303634 foreign key (nombrecuadrilla) references Cuadrilla (nombrecuadrilla);
alter table cuadro add index FKcuadro306470 (nombrecuadrilla), add constraint FKcuadro306470 foreign key (nombrecuadrilla) references Cuadrilla (nombrecuadrilla);

