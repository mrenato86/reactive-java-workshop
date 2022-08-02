package io.javabrains.reactiveworkshop;

import java.util.Optional;

public class Exercise4 {

    public static void main(String[] args) {

        // Use ReactiveSources.intNumberMono()

        // Print the value from intNumberMono when it emits
        ReactiveSources.intNumberMono().subscribe(System.out::println);

        // Get the value from the Mono into an integer variable
        Integer value = ReactiveSources.intNumberMono().block();
        System.out.println("Value: " + value);

        Optional<Integer> optionalValue = ReactiveSources.intNumberMono().blockOptional();
        System.out.println("Optional Value: " + optionalValue);

//        System.out.println("Press a key to end");
//        System.in.read();
    }

}
