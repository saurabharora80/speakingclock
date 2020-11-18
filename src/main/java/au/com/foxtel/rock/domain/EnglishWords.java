package au.com.foxtel.rock.domain;

import java.util.HashMap;

public class EnglishWords implements Words {

    private static final String O_CLOCK = "o'clock";

    private static final String OH = "oh";

    private static final String IN_THE_MORNING = "in the morning";

    private static final String IN_THE_AFTERNOON = "in the afternoon";

    private static final String IN_THE_EVENING = "in the evening";

    private static final String MIDNIGHT = "midnight";

    private static final String MIDDAY = "midday";

    private static HashMap<Integer, String> spokenNumbers = new HashMap<Integer, String>() {{
        put(1, "one");
        put(2, "two");
        put(3, "three");
        put(4, "four");
        put(5, "five");
        put(6, "six");
        put(7, "seven");
        put(8, "eight");
        put(9, "nine");
        put(10, "ten");
        put(11, "eleven");
        put(12, "twelve");
        put(13, "thirteen");
        put(14, "fourteen");
        put(15, "fifteen");
        put(16, "sixteen");
        put(17, "seventeen");
        put(18, "eighteen");
        put(19, "nineteen");
        put(20, "twenty");
        put(30, "thirty");
        put(40, "forty");
        put(50, "fifty");
        put(60, "sixty");
        put(70, "seventy");
        put(80, "eighty");
        put(90, "ninety");
    }};

    @Override
    public String get(Integer number) {
        return spokenNumbers.get(number);
    }

    @Override
    public String onTheClock() {
        return O_CLOCK;
    }

    @Override
    public String oh() {
        return OH;
    }

    @Override
    public String inTheMorning() {
        return IN_THE_MORNING;
    }

    @Override
    public String inTheAfternoon() {
        return IN_THE_AFTERNOON;
    }

    @Override
    public String inTheEvening() {
        return IN_THE_EVENING;
    }

    public String midnight() {
        return MIDNIGHT;
    }

    public String midday() {
        return MIDDAY;
    }
}
