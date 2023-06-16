package com.example.Piensa.controller
import com.example.Piensa.model.Profesores
import com.example.Piensa.service.ProfesoresService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/profesores")
class ProfesoresController {
    @Autowired
    lateinit var profesoresService: ProfesoresService

    @GetMapping
    fun list (profesores: Profesores,pageable: Pageable):ResponseEntity<*>{
        val response= profesoresService.list(pageable, profesores)
        return ResponseEntity(response, HttpStatus.OK)
    }

    @PostMapping
    fun save(@RequestBody @Valid profesores:Profesores): ResponseEntity<Profesores>{
        return ResponseEntity(profesoresService.save(profesores), HttpStatus.OK)
    }

    @PutMapping
    fun update(@RequestBody profesores:Profesores): ResponseEntity<Profesores>{
        return ResponseEntity(profesoresService.update(profesores), HttpStatus.OK)
    }
}