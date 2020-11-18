package au.com.foxtel.rock.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class TimeOfDayTest {

    @ParameterizedTest
    @CsvSource(
            {
                    "0, in the morning",
                    "11, in the morning",
                    "12, in the afternoon",
                    "13, in the afternoon",
                    "18, in the evening",
                    "19, in the evening"
            }
    )
    public void verifyTimeOfDay(String hour, String timeOfDay) {
        EnglishWords words = new EnglishWords();
        assertThat(new TimeOfDay(new Hour(hour, words), words).toString(), is(timeOfDay));
    }

}