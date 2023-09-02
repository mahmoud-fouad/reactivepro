package com.mfouad.reactivepro;

import org.junit.jupiter.api.Test;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class SpringMonoFluxTest {

    // just subscribe one object and call onNext
    @Test
    public void testMonoPrint(){

Mono<String> monString = Mono.just("first Mono").log();

monString.subscribe(System.out::println);

    }


    // to run on error method
     @Test
    public void testMonoPrintWithExcpetion(){

Mono<?> monString = Mono.just("first Mono")
.then(Mono.error(new RuntimeException("excption will printing mono")))
.log();

monString.subscribe(System.out::println,(e)->System.err.println(e));

    }

    // subscripe n objects and call onNext for each one
    @Test
    public void testFlux(){
        Flux<String> fluxData= Flux.just("String","spring boot","microSevices")
        // add other publishers
        .concatWithValues(" mfouad")
        .log();
        fluxData.subscribe(System.out::println);

    }

    // subscripe n objects and call onNext for each one
    @Test
    public void testFluxWithException(){
        Flux<?> fluxData= Flux.just("String","spring boot","microSevices")
        // use on error
        .concatWith(Flux.error(new RuntimeException("error in flux")))
        .log();
        fluxData.subscribe(System.out::println,(e)-> System.err.println(e.getMessage()));

    }

}
