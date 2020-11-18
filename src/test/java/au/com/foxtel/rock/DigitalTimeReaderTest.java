package au.com.foxtel.rock;

import io.vavr.control.Option;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Scanner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;

class DigitalTimeReaderTest {

    private Scanner scanner = Mockito.mock(Scanner.class);

    private DigitalTimeReader digitalTimeReader = new DigitalTimeReader(scanner);

    @BeforeEach
    public void resetMock() {
        Mockito.reset(scanner);
    }

    @Test
    public void returnValidInput() {
        given(scanner.nextLine()).willReturn("00:00");

        assertThat(digitalTimeReader.time(), is(Option.of("00:00")));
    }

    @Test
    public void returnNoneForInValidInput() {
        given(scanner.nextLine()).willReturn("00:0");

        assertThat(digitalTimeReader.time(), is(Option.none()));
    }

    @Test
    public void returnNoneForException() {
        given(scanner.nextLine()).willThrow(new RuntimeException());

        assertThat(digitalTimeReader.time(), is(Option.none()));
    }


}