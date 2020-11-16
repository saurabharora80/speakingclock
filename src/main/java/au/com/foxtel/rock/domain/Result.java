package au.com.foxtel.rock.domain;

import io.vavr.Tuple2;

public class Result {

    public enum Type {
        WINS, LOSES, TIES
    }

    private final Tuple2<String, Symbol> first;
    private final Tuple2<String, Symbol> second;

    public Result(Tuple2<String, Symbol> first, Tuple2<String, Symbol> second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public String toString() {
        Type result = result();
        return String.format("%s chooses %s and %s chooses %s. %s %s %s %s. %s %s %s %s",
                first._1, first._2.name(), second._1, second._2.name(),
                first._2.name(), result.name(), joinWord(result), second._2.name(),
                first._1, result.name(), joinWord(result), second._1);
    }

    private String joinWord(Result.Type result) {
        if(result == Result.Type.WINS) return "over";
        else if(result == Result.Type.LOSES) return "to";
        else return "with";
    }

    protected Result.Type result() {
        return first._2.competes(second._2);
    }
}
