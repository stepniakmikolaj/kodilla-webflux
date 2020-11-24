package com.kodilla.webflux.controller;

import com.kodilla.webflux.dto.BookDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;

@RestController
public class FluxController {

    @GetMapping(value = "/strings", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<String> getStrings() {
        return Flux
                .just("a", "b", "c", "d", "e")
                .delayElements(Duration.ofSeconds(2))
                .log();
    }

    @GetMapping(value = "/bookDto", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<BookDto> getBooks() {
        return Flux
                .just(new BookDto("Tytul1","Author1",2020),
                        new BookDto("Tytul2","Author2",2019),
                        new BookDto("Tytul3","Author3",2018),
                        new BookDto("Tytul4","Author4",2017),
                        new BookDto("Tytul5","Author5",2016))
                .delayElements(Duration.ofSeconds(2))
                .log();
    }
}
