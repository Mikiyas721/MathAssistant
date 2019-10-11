package test.converters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Converters {
    private String name;
    private List<Unit> from;
    private List<Unit> to;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Unit> getFrom() {
        return from;
    }
    public List<String> getFromNames(){
        List<String> stringList = new ArrayList<>();
        getFrom().stream().forEach(unit -> stringList.add(unit.getName()));
        return stringList;
    }

    public void setFrom(List<Unit> from) {
        this.from = from;
    }

    public List<Unit> getTo() {
        return to;
    }
    public List<String> getToNames(){
        List<String> stringList = new ArrayList<>();
        getTo().stream().forEach(unit -> stringList.add(unit.getName()));
        return stringList;
    }

    public void setTo(List<Unit> to) {
        this.to = to;
    }

    public Converters(String name, List<Unit> from, List<Unit> to) {
        this.name = name;
        this.from = from;
        this.to = to;
    }
}
