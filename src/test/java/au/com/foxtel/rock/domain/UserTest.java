package au.com.foxtel.rock.domain;

import io.vavr.control.Option;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mockito;

import java.util.Scanner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;

class UserTest {

    private Scanner scanner = Mockito.mock(Scanner.class);

    private User user = new User(scanner);

    @BeforeEach
    public void resetMock() {
        Mockito.reset(scanner);
    }

    @ParameterizedTest
    @CsvSource({
            "1, ROCK",
            "2, PAPER",
            "3, SCISSORS",
            "4, NONE"
    })
    public void shouldBeAbleToReadUserInput(int userChoice, String symbol) {
        given(scanner.nextInt()).willReturn(userChoice);

        Option<Symbol> expectedSymbol = symbol.equalsIgnoreCase("NONE") ? Option.none() : Option.of(Symbol.valueOf(symbol));

        assertThat(user.choose(), is(expectedSymbol));
    }

    @Test
    public void shouldReturnEmptyIfInputIsNotInteger() {
        given(scanner.nextInt()).willThrow(new RuntimeException());

        assertThat(user.choose(), is(Option.none()));
    }
}