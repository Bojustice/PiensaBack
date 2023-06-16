package com.example.Piensa.repository
import com.example.Piensa.model.Alumnos
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository

interface AlumnosRepository: JpaRepository<Alumnos, Long> {
    fun findById(id: Long?): Alumnos?
}