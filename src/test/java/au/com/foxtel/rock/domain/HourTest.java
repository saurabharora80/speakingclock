package au.com.foxtel.rock.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class HourTest {

    @ParameterizedTest
    @CsvSource({
        "0, twelve",
        "1, one",
        "12, twelve",
        "18, six",
        "23, eleven"
    })
    public void verifyHour(String hour, String spokenHour) {
        assertThat(new Hour(hour, new EnglishWords()).toString(), is(spokenHour));
    }

    @ParameterizedTest
    @CsvSource({
            "12, true",
            "13, false"
    })
    public void returnTrueFor12(String hour, Boolean isTwelve) {
        assertThat(new Hour(hour, new EnglishWords()).isTwelve(), is(isTwelve));
    }

    @ParameterizedTest
    @CsvSource({
            "11, false",
            "12, true",
            "13, true",
            "17, true",
            "18, false",
            "19, false"
    })
    public void isAfternoonForHoursAtAndAfter12AndBefore18(String hour, Boolean isAfternoon) {
        assertThat(new Hour(hour, new EnglishWords()).isAfternoon(), is(isAfternoon));
    }

    @ParameterizedTest
    @CsvSource({
            "0, true",
            "9, true",
            "11, true",
            "12, false"
    })
    public void isMorningForHoursAtAndAfter0AndBefore12(String hour, Boolean isMorning) {
        assertThat(new Hour(hour, new EnglishWords()).isMorning(), is(isMorning));
    }
}