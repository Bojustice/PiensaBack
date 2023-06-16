package com.example.Piensa.repository
import com.example.Piensa.model.Profalum
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository

interface ProfalumRepository: JpaRepository<Profalum, Long> {
    fun findById(id: Long?): Profalum?
}