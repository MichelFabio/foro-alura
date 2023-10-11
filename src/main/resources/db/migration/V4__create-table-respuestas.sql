create table respuestas (
    id bigint not null auto_increment,
    mensaje text,
    topico_id bigint,
    fecha_creacion DATETIME,
    usuario_id bigint,
    solucion tinyint,
    primary key (id)
)