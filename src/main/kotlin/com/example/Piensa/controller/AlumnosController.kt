package com.example.Piensa.controller
import com.example.Piensa.model.Alumnos
import com.example.Piensa.service.AlumnosService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid


@RestController
@RequestMapping("/alumnos")
class AlumnosController {
    @Autowired
    lateinit var alumnosService: AlumnosService

    @GetMapping
    fun list (alumnos: Alumnos, pageable: Pageable): ResponseEntity<*> {
        val response= alumnosService.list(pageable, alumnos)
        return ResponseEntity(response, HttpStatus.OK)
    }

    @PostMapping
    fun save(@RequestBody @Valid alumnos: Alumnos): ResponseEntity<Alumnos> {
        return ResponseEntity(alumnosService.save(alumnos), HttpStatus.OK)
    }

    @PutMapping
    fun update(@RequestBody alumnos: Alumnos): ResponseEntity<Alumnos> {
        return ResponseEntity(alumnosService.update(alumnos), HttpStatus.OK)
    }
}