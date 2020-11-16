package au.com.foxtel.rock.domain;

import io.vavr.collection.List;
import io.vavr.control.Option;

public enum Symbol {
    ROCK(1) {
        @Override
        Result.Type competes(Symbol symbol) { return competes(symbol, ROCK, SCISSORS); }
    }, PAPER(2) {
        @Override
        Result.Type competes(Symbol symbol) {
            return competes(symbol, PAPER, ROCK);
        }
    }, SCISSORS(3) {
        @Override
        Result.Type competes(Symbol symbol) {
            return competes(symbol, SCISSORS, PAPER);
        }
    };

    private final int id;

    Symbol(int id) {
        this.id = id;
    }

    abstract Result.Type competes(Symbol symbol);

    protected static Result.Type competes(Symbol otherSymbol, Symbol thisSymbol, Symbol beats) {
        if(otherSymbol == thisSymbol) return Result.Type.TIES;
        else if(otherSymbol == beats) return Result.Type.WINS;
        else return Result.Type.LOSES;
    }

    public static Option<Symbol> from(int playerChoice) {
        try {
            return List.of(Symbol.values()).find(s -> s.id == playerChoice);
        } catch(Exception ex) {
            return Option.none();
        }
    }
}
