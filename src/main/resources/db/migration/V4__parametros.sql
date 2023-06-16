CREATE TABLE if NOT EXISTS parametros (
    id SERIAL,
    materia VARCHAR (50) NOT NULL,
    inatencion INT NOT NULL,
    inatencion2 INT NOT NULL,
    hiperactividad INT NOT NULL,
    hiperactividad2 INT NOT NULL,
    hiperactividad3 INT NOT NULL,
    PRIMARY KEY (id)
);