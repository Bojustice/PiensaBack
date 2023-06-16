package com.example.Piensa.repository
import com.example.Piensa.model.Alumpara
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository

interface AlumparaRepository: JpaRepository<Alumpara, Long> {
    fun findById(id: Long?): Alumpara?
}