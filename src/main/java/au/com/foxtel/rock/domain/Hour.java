package au.com.foxtel.rock.domain;

public class Hour {
    public static final int TWELVE = 12;

    public static final int ZERO = 0;

    private final Integer hour;

    private final Words words;

    public Hour(String hour, Words words) {
        this.hour = Integer.parseInt(hour);
        this.words = words;
    }

    public boolean isZero() {
        return hour == ZERO;
    }

    @Override
    public String toString() {
        if(isZero() || hour == TWELVE) {
            return words.get(TWELVE);
        }
        return words.get(hour % 12);
    }

    public boolean isMorning() {
        return hour >= ZERO && hour < TWELVE;
    }

    public boolean isTwelve() {
        return hour == TWELVE;
    }

    public boolean isAfternoon() {
        return hour >= TWELVE && hour < 18;
    }
}
