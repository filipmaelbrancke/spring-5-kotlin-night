package be.maelbrancke.filip.springkotlindemo.rest

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.getForObject

@RestController
class KotlinRestTemplateController {

    @GetMapping("/kotlinRepo")
    fun getRepoInfo(): Repo? {
        val restTemplate = RestTemplate()
        val url = "https://api.github.com/repos/filipmaelbrancke/mac-install"
        // Kotlin
        val repo: Repo? = restTemplate.getForObject(url)
        val repo2 = restTemplate.getForObject<Repo>(url)
        return repo
    }

    @GetMapping("/kotlinRepos")
    fun getRepos(): List<Repo>? {
        val restTemplate = RestTemplate()
        val url = "https://api.github.com/users/filipmaelbrancke/repos"
        val repos: List<Repo>? = restTemplate.getForObject(url)
        return repos
    }
}