package au.com.foxtel.rock.domain;

import io.vavr.control.Option;

public interface Player {
    Option<Symbol> choose();

    String name();
}
