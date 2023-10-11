create table topicos (
    id bigint not null auto_increment,
   titulo varchar (200) not null unique,
   mensaje text,
   fecha_creacion DATETIME,
   status VARCHAR(50),
   usuario_id bigint,
   curso_id bigint,
   primary key(id)

);