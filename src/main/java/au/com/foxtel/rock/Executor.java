package au.com.foxtel.rock;

import au.com.foxtel.rock.domain.DigitalTime;
import io.vavr.control.Option;

import java.util.Scanner;

public class Executor {
    private final Scanner scanner;

    public Executor(Scanner scanner) {
        this.scanner = scanner;
    }

    public void execute() {
        Option<DigitalTime> mayBeDigitalTime = new DigitalTimeReader(scanner).time().map(DigitalTime::new);

        mayBeDigitalTime.peek(d -> System.out.println(d.speak()));

        if(mayBeDigitalTime.isDefined()) {
            execute();
        } else {
            System.exit(0);
        }
    }
}
