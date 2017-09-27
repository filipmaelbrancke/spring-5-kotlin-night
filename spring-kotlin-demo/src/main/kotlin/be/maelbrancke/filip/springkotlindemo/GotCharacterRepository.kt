package be.maelbrancke.filip.springkotlindemo

import org.springframework.data.repository.CrudRepository

interface GotCharacterRepository: CrudRepository<GotCharacter, Long> {

    fun findByLastName(lastName: String): Iterable<GotCharacter>
}