package be.maelbrancke.filip.springkotlindemo

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class GotController(private val repository: GotCharacterRepository) {

    @GetMapping("/")
    fun findAll() = repository.findAll()

    @GetMapping("/{lastName}")
    fun findByLastName(@PathVariable lastName: String)
            = repository.findByLastName(lastName)

}