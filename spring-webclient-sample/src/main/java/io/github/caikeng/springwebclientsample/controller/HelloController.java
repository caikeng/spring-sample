package io.github.caikeng.springwebclientsample.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
@RequestMapping("/hello")
public class HelloController {

    private int n = 0;

    @RequestMapping
    public Object hello() {

        if ((n++ %2 ) == 0) {
            throw new RuntimeException("error");
        }

        return "hello";
    }

}
