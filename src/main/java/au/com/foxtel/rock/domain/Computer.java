package au.com.foxtel.rock.domain;

import io.vavr.control.Option;

import java.util.Random;

public class Computer implements Player {

    private final Random random;

    public Computer(Random random) {
        this.random = random;
    }

    @Override
    public Option<Symbol> choose() {
        Symbol[] values = Symbol.values();
        return Option.of(values[random.nextInt(values.length)]);
    }

    @Override
    public String name() {
        return "Computer";
    }
}
