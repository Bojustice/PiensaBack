package com.example.Piensa.controller
import com.example.Piensa.model.Profalum
import com.example.Piensa.service.ProfalumService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/profalum")
class ProfalumController {
    @Autowired
    lateinit var profalumService: ProfalumService

    @GetMapping
    fun list (profalum: Profalum, pageable: Pageable): ResponseEntity<*> {
        val response= profalumService.list(pageable, profalum)
        return ResponseEntity(response, HttpStatus.OK)
    }

    @PostMapping
    fun save(@RequestBody @Valid profalum: Profalum): ResponseEntity<Profalum> {
        return ResponseEntity(profalumService.save(profalum), HttpStatus.OK)
    }

    @PutMapping
    fun update(@RequestBody profalum: Profalum): ResponseEntity<Profalum> {
        return ResponseEntity(profalumService.update(profalum), HttpStatus.OK)
    }
}