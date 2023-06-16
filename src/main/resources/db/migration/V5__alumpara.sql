CREATE TABLE IF NOT EXISTS parametros_alumnos (
    id SERIAL,
    parametros_id INT NOT NULL,
    alumnos_id INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (parametros_id)
    REFERENCES parametros(id),
    FOREIGN KEY (alumnos_id)
    REFERENCES alumnos(id)
);