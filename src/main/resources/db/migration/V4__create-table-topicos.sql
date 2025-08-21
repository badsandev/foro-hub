create table topicos (
    id BIGINT not null auto_increment,
    titulo varchar(100) not null,
    mensaje varchar(250) not null,
    fecha_creacion datetime not null,
    status tinyint not null,
    id_autor BIGINT not null,
    id_curso BIGINT not null,
    primary key (id),
    foreign key (id_autor) REFERENCES autor(id),
    foreign key (id_curso) REFERENCES curso(id)
);