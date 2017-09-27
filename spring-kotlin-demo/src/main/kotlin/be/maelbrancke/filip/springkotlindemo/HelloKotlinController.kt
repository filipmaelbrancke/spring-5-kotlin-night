package be.maelbrancke.filip.springkotlindemo

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloKotlinController {

    @GetMapping("/hello")
    fun hello(): String {
        return "Hello world"
    }
}