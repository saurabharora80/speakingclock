package au.com.foxtel.rock.domain;

public class DigitalTime {
    private final Hour hour;

    private final Minute minute;

    private final TimeOfDay timeOfDate;

    private final EnglishWords words;

    public DigitalTime(String time) {
        String[] split = time.split(":");
        this.words = new EnglishWords();
        Hour hour = new Hour(split[0], this.words);
        this.hour = hour;
        this.minute = new Minute(split[1], this.words);
        this.timeOfDate = new TimeOfDay(hour, this.words);
    }

    public String speak() {
        if(hour.isZero() && minute.isZero()) {
            return words.midnight();
        } else if(hour.isTwelve() && minute.isZero()) {
            return words.midday();
        }
        return String.format("%s %s %s", this.hour, this.minute, this.timeOfDate);
    }
}
