package com.example.Piensa.repository

import com.example.Piensa.model.Profesores
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository

interface ProfesoresRepository: JpaRepository<Profesores, Long> {
    fun findById(id: Long?): Profesores?
}
