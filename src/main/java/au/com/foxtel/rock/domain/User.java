package au.com.foxtel.rock.domain;

import io.vavr.control.Option;

import java.util.Scanner;

public class User implements Player {
    private final Scanner scanner;

    public User(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public Option<Symbol> choose() {
        System.out.println("Choose one of the following option\n Rock: 1 \n Paper: 2 \n Scissors: 3 \n Exit: any other input");
        try {
            return Symbol.from(scanner.nextInt());
        } catch(Exception ex) {
            return Option.none();
        }
    }

    @Override
    public String name() {
        return "User";
    }
}
