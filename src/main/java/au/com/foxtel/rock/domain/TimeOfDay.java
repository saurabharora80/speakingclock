package au.com.foxtel.rock.domain;

public class TimeOfDay {

    private final Hour hour;

    private final Words words;

    public TimeOfDay(Hour hour, Words words) {
        this.hour = hour;
        this.words = words;
    }

    @Override
    public String toString() {
        if(hour.isMorning()) return words.inTheMorning();
        else if(hour.isAfternoon()) return words.inTheAfternoon();
        return words.inTheEvening();
    }
}
