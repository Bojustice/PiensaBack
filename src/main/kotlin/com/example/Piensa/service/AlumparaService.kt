package com.example.Piensa.service

import com.example.Piensa.model.Alumpara
import com.example.Piensa.repository.AlumparaRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Example
import org.springframework.data.domain.ExampleMatcher
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class AlumparaService {
    @Autowired
    lateinit var alumparaRepository: AlumparaRepository

    fun list(): List<Alumpara>{
        return alumparaRepository.findAll()
    }

    fun save(alumpara: Alumpara): Alumpara {
        return alumparaRepository.save(alumpara)
    }

    fun update(alumpara: Alumpara):Alumpara{
        try{
            alumparaRepository.findById(alumpara.id)
                    ?:throw Exception("El id ${alumpara.id} en alumpara no existe")
            return alumparaRepository.save(alumpara)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }

    }

    fun list (pageable: Pageable, alumpara: Alumpara): Page<Alumpara> {
        val matcher = ExampleMatcher.matching()
                .withIgnoreNullValues()
                .withMatcher(("field"), ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
        return alumparaRepository.findAll(Example.of(alumpara, matcher), pageable)
    }
}