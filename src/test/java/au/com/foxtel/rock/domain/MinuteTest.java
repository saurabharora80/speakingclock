package au.com.foxtel.rock.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class MinuteTest {

    @ParameterizedTest
    @CsvSource({
            "34, thirty four",
            "04, oh four",
            "20, twenty",
            "0, o'clock"
    })
    public void verifySpokenMinute(String minute, String spoken) {
        assertThat(new Minute(minute, new EnglishWords()).toString(), is(spoken));
    }
}