package com.example.Piensa.controller

import com.example.Piensa.model.Alumpara
import com.example.Piensa.model.Profesores
import com.example.Piensa.service.AlumparaService
import com.example.Piensa.service.ProfesoresService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/alumpara")
class AlumparaController {
    @Autowired
    lateinit var alumparaService: AlumparaService

    @GetMapping
    fun list (alumpara: Alumpara, pageable: Pageable): ResponseEntity<*> {
        val response= alumparaService.list(pageable, alumpara)
        return ResponseEntity(response, HttpStatus.OK)
    }

    @PostMapping
    fun save(@RequestBody @Valid alumpara: Alumpara): ResponseEntity<Alumpara> {
        return ResponseEntity(alumparaService.save(alumpara), HttpStatus.OK)
    }

    @PutMapping
    fun update(@RequestBody alumpara: Alumpara): ResponseEntity<Alumpara> {
        return ResponseEntity(alumparaService.update(alumpara), HttpStatus.OK)
    }
}