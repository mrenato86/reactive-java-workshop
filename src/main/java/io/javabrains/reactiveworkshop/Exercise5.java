package io.javabrains.reactiveworkshop;

import reactor.core.publisher.BaseSubscriber;

import java.io.IOException;

public class Exercise5 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFlux() and ReactiveSources.userFlux()

        // Subscribe to a flux using the error and completion hooks
        ReactiveSources.intNumbersFlux().subscribe(
                System.out::println,
                err -> System.out.println(err.getMessage()),
                () -> System.out.println("Complete")
        );

        // Subscribe to a flux using an implementation of BaseSubscriber
        BaseSubscriber<User> baseSubscriber = new BaseSubscriber<>() {
            @Override
            protected void hookOnNext(User value) {
                System.out.println(value);
            }

            @Override
            protected void hookOnError(Throwable throwable) {
                System.out.println(throwable.getMessage());
            }

            @Override
            protected void hookOnComplete() {
                System.out.println("Complete");
            }
        };

        ReactiveSources.userFlux().subscribe(baseSubscriber);

        System.out.println("Press a key to end");
        System.in.read();
    }

}