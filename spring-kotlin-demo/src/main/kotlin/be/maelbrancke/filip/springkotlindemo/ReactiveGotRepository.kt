package be.maelbrancke.filip.springkotlindemo

import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface ReactiveGotRepository {

    fun findAll(): Flux<GotCharacter>
    fun findById(id: String): Mono<GotCharacter>
    fun save(character: GotCharacter): Mono<Void>
}