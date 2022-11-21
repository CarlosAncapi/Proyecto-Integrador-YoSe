-- Creamos la tabla de usuario
CREATE TABLE proyyose.usuario (
	userId INT  NOT NULL auto_increment,
	nombre varchar(100) NOT NULL,
	apellido varchar(100) NOT NULL,
	email varchar(50) NOT NULL,
	contraseña varchar(15) NOT NULL,
	creationDate datetime,
	PRIMARY KEY (userId)
);

---------------------------------------------------------------------------------
-- Creamos la tabla de recover
CREATE TABLE proyyose.recover (
	idRecover INT  NOT NULL auto_increment,
	code varchar(10),
	is_used boolean,
	idUsuario int,
	creationDate datetime,
	PRIMARY KEY (idRecover)
);
-- vinculamos los FK
alter table recover add foreign key(idAutor) references usuario(userId);

---------------------------------------------------------------------------------
-- creamos la tabla de posteos
CREATE TABLE proyyose.posteos (
	posId INT  NOT NULL auto_increment,
	titulo varchar (100) NOT NULL,
	texto varchar(1000) NOT NULL,
	url varchar(120),
	creationDate datetime,
	idUsuario int,
	idCategoria int,
	idTypePosteo int,
	idValoracion int,
	PRIMARY KEY (posId)
);
-- vinculamos los FK
alter table posteos add foreign key(idAutor) references usuario(userId);
alter table posteos add foreign key(idCategoria) references categoria(categoriaId);
alter table posteos add foreign key(idTypePosteo) references typePosteo(typeId);
alter table posteos add foreign key(idValoracion) references valoracion(likeid);

---------------------------------------------------------------------------------
-- creamos la tabla de comentarios
CREATE TABLE proyyose.comentario (
	idComentario INT  NOT NULL auto_increment,
	texto varchar(200) NOT NULL,
	creationDate datetime,
	idUsuario int,
	idPosteo int,
	idValoracion int,
	PRIMARY KEY (idComentario)
);
-- vinculamos los FK
alter table comentario add foreign key(idAutor) references usuario(userId);
alter table comentario add foreign key(idPosteo) references posteos(posId);
alter table comentario add foreign key(idValoracion) references valoracion(likeid);
---------------------------------------------------------------------------------
-- creamos la tabla de valoracion
CREATE TABLE proyyose.valoracion (
	likeid INT  NOT NULL auto_increment,
	megusta int,
	creationDate datetime,
	idUsuario int,
	PRIMARY KEY (likeid)
);
-- vinculamos los FK
alter table valoracion add foreign key(idAutor) references usuario(userId);
---------------------------------------------------------------------------------
-- creamos la tabla de categoria
CREATE TABLE proyyose.categoria (
	categoriaId INT  NOT NULL auto_increment,
	detalleCategoria varchar(40),
	PRIMARY KEY (categoriaId)
);

---------------------------------------------------------------------------------
-- creamos la tabla de typePosteo
CREATE TABLE proyyose.typePosteo (
	typeId INT  NOT NULL auto_increment,
	tipo varchar(40),
	PRIMARY KEY (typeId)
);

---------------------------------------------------------------------------------
-- creamos la tabla de Colegas
CREATE TABLE proyyose.Colegas (
	colabId INT  NOT NULL auto_increment,
	creationDate datetime,
	idUsuario int,
	PRIMARY KEY (colabId)
);
-- vinculamos los FK
alter table Colegas add foreign key(idAutor) references usuario(userId);

---------------------------------------------------------------------------------
-- creamos la tabla de imagen
CREATE TABLE proyyose.imagen (
	imagenid INT  NOT NULL auto_increment,
	ruta varchar(100),
	idUsuario int,
	PRIMARY KEY (imagenid)
);

-- vinculamos los FK
alter table imagen add foreign key(idAutor) references usuario(userId);
---------------------------------------------------------------------------------
