package be.maelbrancke.filip.springkotlindemo.rest;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
public class JavaRestTemplateController {

    public JavaRestTemplateController() {
    }

    @GetMapping("/javaRepo")
    public Repo getRepoInfo() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://api.github.com/repos/filipmaelbrancke/mac-install";
        // Java
        Repo repoInfo = restTemplate.getForObject(url, Repo.class);

        return repoInfo;
    }

    @GetMapping("/javaReposCasting")
    public List<Repo> getReposWithCastingSoYouCanLeaveWorkForHome() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://api.github.com/users/filipmaelbrancke/repos";
        Object[] repos = restTemplate.getForObject(url, Object[].class);
        List<Object> reposList = Arrays.asList(repos);
        List<Repo> listOfRepos = (List<Repo>) (Object) reposList;
        return listOfRepos;
    }

    @GetMapping("/javaRepos")
    public List<Repo> getRepos() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://api.github.com/users/filipmaelbrancke/repos";
        ResponseEntity<List<Repo>> repos = restTemplate.exchange(url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Repo>>() {
                });
        return repos.getBody();
    }
}
