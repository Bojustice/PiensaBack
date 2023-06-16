CREATE TABLE IF NOT EXISTS profesores_alumnos (
    id SERIAL,
    profesores_id INT NOT NULL,
    alumnos_id INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (profesores_id)
    REFERENCES profesores(id),
    FOREIGN KEY (alumnos_id)
    REFERENCES alumnos(id)
);