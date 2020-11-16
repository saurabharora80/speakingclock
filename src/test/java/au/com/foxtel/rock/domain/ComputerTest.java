package au.com.foxtel.rock.domain;

import io.vavr.control.Option;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mockito;

import java.util.Random;

import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;

class ComputerTest {

    private Random random = Mockito.mock(Random.class);
    private Computer computer = new Computer(random);

    @BeforeEach
    public void resetMock() {
        Mockito.reset(random);
    }

    @ParameterizedTest
    @CsvSource({
            "1, ROCK",
            "2, PAPER",
            "3, SCISSORS"
    })
    public void verifyComputerChoices(int symbolIndex, String symbol) {
        given(random.nextInt(3)).willReturn(symbolIndex - 1);

        MatcherAssert.assertThat(computer.choose(), is(Option.of(Symbol.valueOf(symbol))));
    }

}