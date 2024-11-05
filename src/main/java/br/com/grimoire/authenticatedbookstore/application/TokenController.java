package br.com.grimoire.authenticatedbookstore.application;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.BodyInserters.FormInserter;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
@RequestMapping("/api/v1/token")
public class TokenController {

    private final WebClient webClient;
    private final static String BASE_URL_KEYCLOAK = "http://localhost:8080/realms/dev-environment/";
    private static final String PATH_GET_TOKEN_ENDPOINT = "protocol/openid-connect/token/";

    public TokenController(WebClient webClient) {
        this.webClient = WebClient.builder()
                .baseUrl(BASE_URL_KEYCLOAK)
                .build();
    }

    @PostMapping
    public ResponseEntity<String> getToken(@RequestBody User user) {

        String token = sendRequestToKeycloak(user);

        return ResponseEntity.ok().body(token);

    }

    private String sendRequestToKeycloak(User user) {

        FormInserter<String> formData = BodyInserters
                .fromFormData("client_id", user.clientId)
                .with("username", user.username)
                .with("password", user.password)
                .with("grant_type", user.grantType);

        String response = webClient.post()
                .uri(PATH_GET_TOKEN_ENDPOINT)
                .header("Content-Type", MediaType.APPLICATION_FORM_URLENCODED_VALUE)
                .body(formData)
                .retrieve()
                .bodyToMono(String.class)
                .block();

        return response;
    }

    public record User(String password, String clientId, String grantType, String username) {
    }
}
