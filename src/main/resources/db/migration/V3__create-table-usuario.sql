create table usuario(

    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre varchar(100) NOT NULL,
    email varchar(100) NOT NULL,
    contrasenia varchar(100) NOT NULL,
    autor_id bigint not null,
    activo tinyint not null default 1,
    FOREIGN KEY (autor_id) references autor(id)



)