package be.maelbrancke.filip.springkotlindemo

import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class Application {

    private val log = LoggerFactory.getLogger(Application::class.java)

    @Bean
    fun init(repository: GotCharacterRepository) = CommandLineRunner {
        // save some GOT characters
        repository.save(GotCharacter("Jon", "Snow", 22, "Kit Harington"))
        repository.save(GotCharacter("Tyrion", "Lannister", 39, "Peter Dinklage"))
        repository.save(GotCharacter("Daenerys", "Targaryen", 22, "Emilia Clarke"))
        repository.save(GotCharacter("Sansa", "Stark", 19, "Sophie Turner"))
        repository.save(GotCharacter("Cersei", "Lannister", 43, "Lena Headey"))
        repository.save(GotCharacter("Arya", "Stark", 17, "Maisie Williams"))
        repository.save(GotCharacter("Jaime", "Lannister", 43, "Nikolaj Coster-Waldau"))

        for (character in repository.findAll()) {
            log.info(character.toString())
        }
    }
}

fun main(args: Array<String>) {
    SpringApplication.run(Application::class.java, *args)
}
