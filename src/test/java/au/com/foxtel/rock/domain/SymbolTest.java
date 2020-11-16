package au.com.foxtel.rock.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class SymbolTest {

    @ParameterizedTest
    @CsvSource({
            "ROCK, WINS, over, SCISSORS",
            "PAPER, WINS, over, ROCK",
            "SCISSORS, WINS, over, PAPER",

            "SCISSORS, TIES, with, SCISSORS",
            "ROCK, TIES, with, ROCK",
            "PAPER, TIES, with, PAPER",

            "SCISSORS, LOSES, to, ROCK",
            "ROCK, LOSES, to, PAPER",
            "PAPER, LOSES, to, SCISSORS",
    })
    public void verifyGameRules(String thisSymbol, String resultType, String ignore, String thatSymbol) {
        Symbol mayBeThatSymbol = Symbol.valueOf(thatSymbol);

        Result.Type result = Symbol.valueOf(thisSymbol).competes(mayBeThatSymbol);

        assertThat(result, is(Result.Type.valueOf(resultType)));
    }
}