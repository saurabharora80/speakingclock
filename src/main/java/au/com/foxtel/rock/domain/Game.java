package au.com.foxtel.rock.domain;

import io.vavr.Tuple;
import io.vavr.control.Option;

import static io.vavr.API.*;
import static io.vavr.Patterns.$Some;
import static io.vavr.Patterns.$Tuple2;

public class Game {
    private final Player playerOne;
    private final Player playerTwo;

    public Game(Player playerOne, Player playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    public Option<Result> play() {
        return Match(Tuple.of(playerOne.choose(), playerTwo.choose())).of(
            Case($Tuple2($Some($()), $Some($())), (choiceOne, choiceTwo) ->  {
                Result result = new Result(
                        Tuple.of(playerOne.name(), choiceOne.get()),
                        Tuple.of(playerTwo.name(), choiceTwo.get())
                );
                return Option.of(result);
            }),
            Case($(), anything -> Option.none())
        );
    }
}
