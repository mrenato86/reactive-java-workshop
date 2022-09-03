package io.javabrains.reactiveworkshop;

import java.time.Duration;
import java.util.List;

public class Exercise6 {


    public static void main(String[] args) {

        // Use ReactiveSources.unresponsiveFlux() and ReactiveSources.unresponsiveMono()

        // Get the value from the Mono into a String variable but give up after 5 seconds

        //String result = ReactiveSources.unresponsiveMono().block(Duration.ofSeconds(5)); //Exception
        String result_alt = ReactiveSources.unresponsiveMono()
                .timeout(Duration.ofSeconds(5))
                .doOnError(e -> System.out.println("No value from unresponsiveMono within 5 seconds"))
                .onErrorReturn("n/a")
                .block();

        System.out.println(result_alt);


        // Get the value from unresponsiveFlux into a String list but give up after 5 seconds
        // Come back and do this when you've learnt about operators!
        List<String> results = ReactiveSources.unresponsiveFlux()
                .timeout(Duration.ofSeconds(5))
                .doOnError(e -> System.out.println("No value from unresponsiveFlux within 5 seconds"))
                .onErrorReturn("n/a")
//                .collectList()
//                .block();
                .toStream()
                .toList();

        System.out.println(results);

//        System.out.println("Press a key to end");
//        System.in.read();
    }

}
