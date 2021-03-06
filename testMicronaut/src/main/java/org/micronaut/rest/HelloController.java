package org.micronaut.rest;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.validation.Validated;
import io.reactivex.Single;

import javax.validation.constraints.NotBlank;

@Controller("/api")
@Validated
public class HelloController {

    @Get(uri = "/hello/{name}", produces = MediaType.TEXT_PLAIN)
    public Single<String> hello(@NotBlank String name) {
        return Single.just("Hello " + name + "!");
    }

    @Post(uri = "/hello/$name", produces = MediaType.TEXT_PLAIN)
    public int Singhello(@NotBlank String name) {

        return 200;
    }
}
