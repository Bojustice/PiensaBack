package com.example.Piensa.service

import com.example.Piensa.model.Profesores
import com.example.Piensa.repository.ProfesoresRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Example
import org.springframework.data.domain.ExampleMatcher
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class ProfesoresService {
    @Autowired
    lateinit var profesoresRepository: ProfesoresRepository

    fun list(): List<Profesores>{
        return profesoresRepository.findAll()
    }

    fun save(profesores:Profesores): Profesores {
        return profesoresRepository.save(profesores)
    }

    fun update(profesores:Profesores):Profesores{
        try{
            profesoresRepository.findById(profesores.id)
                    ?:throw Exception("El id ${profesores.id} en profesores no existe")
            return profesoresRepository.save(profesores)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }

    }

    fun list (pageable: Pageable, profesores: Profesores): Page<Profesores>{
        val matcher = ExampleMatcher.matching()
                .withIgnoreNullValues()
                .withMatcher(("field"), ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
        return profesoresRepository.findAll(Example.of(profesores, matcher), pageable)
    }
}