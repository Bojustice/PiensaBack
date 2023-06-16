package com.example.Piensa.model
import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity
@Table
class Alumpara {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? =null
    @NotBlank(message="Obligatorio")
    @Column(name="alumnos_id")
    var alumnosId: Long? = null
    @NotBlank(message="Obligatorio")
    @Column(name="parametros_id")
    var parametrosId: Long? = null
}