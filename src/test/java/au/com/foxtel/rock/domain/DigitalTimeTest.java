package au.com.foxtel.rock.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class DigitalTimeTest {

    @ParameterizedTest
    @CsvSource({
            "00:00, midnight",
            "00:12, twelve twelve in the morning",
            "08:34, eight thirty four in the morning",
            "12:00, midday",
            "12:12, twelve twelve in the afternoon",
            "15:04, three oh four in the afternoon",
            "21:00, nine o'clock in the evening"
    })
    public void verifySpokenTime(String digitalTime, String spokenTime) {
        assertThat(new DigitalTime(digitalTime).speak(), is(spokenTime));
    }

}