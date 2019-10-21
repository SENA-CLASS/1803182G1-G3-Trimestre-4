create table tipo_documento(
	sigla varchar(10),
	nombre varchar(40) not null,
	estado varchar(40) not null,
	primary key(sigla)
);

create table cliente(
	sigla varchar(10),
	numero_documento varchar(40),
	nombres varchar(100) not null,
	apellidos varchar(100) not null,
	constraint fk_tipo_docu FOREIGN key (sigla) REFERENCES tipo_documento(sigla),
	primary key(sigla, numero_documento)
);

