package be.maelbrancke.filip.springkotlindemo

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class SpringKotlinDemoApplication

fun main(args: Array<String>) {
    SpringApplication.run(SpringKotlinDemoApplication::class.java, *args)
}
