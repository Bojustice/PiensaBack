package com.example.Piensa.service

import com.example.Piensa.model.Profalum
import com.example.Piensa.repository.ProfalumRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Example
import org.springframework.data.domain.ExampleMatcher
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class ProfalumService {
    @Autowired
    lateinit var profalumRepository: ProfalumRepository

    fun list(): List<Profalum>{
        return profalumRepository.findAll()
    }

    fun save(profalum: Profalum): Profalum {
        return profalumRepository.save(profalum)
    }

    fun update(profalum: Profalum):Profalum{
        try{
            profalumRepository.findById(profalum.id)
                    ?:throw Exception("El id ${profalum.id} en profalum no existe")
            return profalumRepository.save(profalum)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }

    }

    fun list (pageable: Pageable, profalum: Profalum): Page<Profalum> {
        val matcher = ExampleMatcher.matching()
                .withIgnoreNullValues()
                .withMatcher(("field"), ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
        return profalumRepository.findAll(Example.of(profalum, matcher), pageable)
    }
}