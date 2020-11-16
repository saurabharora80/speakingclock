package au.com.foxtel.rock.domain;

import io.vavr.control.Option;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;

class GameTest {

    private Player playerOne = Mockito.mock(Player.class);

    private Player playerTwo = Mockito.mock(Player.class);

    private Game game = new Game(playerOne, playerTwo);

    @BeforeEach
    public void resetMock() {
        Mockito.reset(playerOne);
        Mockito.reset(playerTwo);
    }

    @Test
    public void returnAResultIfBothPlayersMakesAChoice() {
        given(playerOne.choose()).willReturn(Option.of(Symbol.ROCK));

        given(playerTwo.choose()).willReturn(Option.of(Symbol.SCISSORS));

        assertThat(game.play().map(Result::result), is(Option.of(Result.Type.WINS)));
    }

    @Test
    public void returnEmptyIfPlayerOneDoesntMakeAChoice() {
        given(playerOne.choose()).willReturn(Option.none());

        given(playerTwo.choose()).willReturn(Option.of(Symbol.SCISSORS));

        assertThat(game.play().map(Result::result), is(Option.none()));
    }

    @Test
    public void returnEmptyIfPlayerTwoDoesntMakeAChoice() {
        given(playerOne.choose()).willReturn(Option.of(Symbol.ROCK));

        given(playerTwo.choose()).willReturn(Option.none());

        assertThat(game.play().map(Result::result), is(Option.none()));
    }

}