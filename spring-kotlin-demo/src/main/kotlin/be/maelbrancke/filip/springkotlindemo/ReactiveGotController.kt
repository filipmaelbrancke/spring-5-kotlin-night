package be.maelbrancke.filip.springkotlindemo

import org.springframework.web.bind.annotation.*

@RestController
class ReactiveGotController(private val repository: ReactiveGotRepository) {

    @GetMapping("/reactive/characters")
    fun findAll() = repository.findAll()

    @GetMapping("/reactive/character/{id}")
    fun findOne(@PathVariable id: String) = repository.findById(id)

    @PostMapping("/reactive/character")
    fun save(@RequestBody character: GotCharacter) = repository.save(character)
}