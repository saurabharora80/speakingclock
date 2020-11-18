package au.com.foxtel.rock;

import io.vavr.control.Option;

import java.util.Scanner;

import static io.vavr.API.Try;

public class DigitalTimeReader {
    private final Scanner scanner;

    public DigitalTimeReader(Scanner scanner) {
        this.scanner = scanner;
    }

    public Option<String> time() {
        System.out.println("Enter time (for example 12:12): ");
        return Try(scanner::nextLine)
                .toOption().filter(t -> t.matches("\\d\\d:\\d\\d"));
    }
}
