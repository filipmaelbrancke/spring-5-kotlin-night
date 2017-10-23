package be.maelbrancke.filip.springkotlindemo

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloKotlinController {

    @GetMapping("/hello")
    fun hello(): String {
        return "Hello world"
    }

    // "GET /foo" and "GET /foo?bar=baz" are allowed
    @GetMapping("/foo")
    fun foo(@RequestParam bar: String?) = "..."



    // "GET /foo?bar=baz" is allowed and "GET /foo" will error
    @GetMapping("/foo")
    fun foo2(@RequestParam bar: String) = "..."


}