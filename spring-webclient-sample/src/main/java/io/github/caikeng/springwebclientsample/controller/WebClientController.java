package io.github.caikeng.springwebclientsample.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

@RestController
@RequestMapping("/req")
public class WebClientController {

    private WebClient webClient = WebClient.builder().baseUrl("http://127.0.0.1:8080").build();

    @RequestMapping("/send")
    public Object sendRequest() {

        String block = webClient.get().uri("/hello").retrieve().bodyToMono(String.class)
                .doOnSuccess(i -> {
                    System.out.println("success" + i);
                })
                .doOnError(WebClientResponseException.class, err -> {
                    System.out.println("error");
                    throw new RuntimeException(err.getRawStatusCode() + ", " + err.getResponseBodyAsString());
                }).block();


        return block;
    }

}
