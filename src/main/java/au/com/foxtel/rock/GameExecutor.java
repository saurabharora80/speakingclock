package au.com.foxtel.rock;

import au.com.foxtel.rock.domain.*;
import io.vavr.control.Option;

import java.util.Random;
import java.util.Scanner;

public class GameExecutor {

    private final Game game;

    protected GameExecutor(Game game) {
        this.game = game;
    }

    public GameExecutor() {
        this(new Game(new User(new Scanner(System.in)), new Computer(new Random())));
    }

    public void execute() {
        Option<Result> mayBeResult = game.play();

        mayBeResult.peek(result -> System.out.println(result.toString()));

        if(mayBeResult.isDefined()) {
            execute();
        } else {
            System.exit(0);
        }
    }
}
