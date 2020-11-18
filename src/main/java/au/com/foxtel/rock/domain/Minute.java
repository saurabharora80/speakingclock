package au.com.foxtel.rock.domain;

public class Minute {

    private final Integer minutes;

    private final Words words;

    public Minute(String minutes, Words words) {
        this.minutes = Integer.parseInt(minutes);
        this.words = words;
    }

    public boolean isZero() {
        return minutes == 0;
    }

    @Override
    public String toString() {
        if(minutes == 0) {
            return words.onTheClock();
        }
        if(minutes > 20) {
            Integer tenspart = ((this.minutes / 10) * 10);
            Integer onespart = (this.minutes % 10);
            return words.get(tenspart) + " " + words.get(onespart);
        }
        return ((minutes < 10 ? words.oh() + " " : "") + words.get(minutes));
    }
}
