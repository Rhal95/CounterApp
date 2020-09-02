package de.rhal.fx;

import javafx.beans.property.SimpleStringProperty;

import java.text.DecimalFormat;

public class Counter {
    private final String name;
    private final int target;
    private final boolean countDown;
    private final int step = 1;
    public SimpleStringProperty text = new SimpleStringProperty();
    private int current;

    public Counter(String name, int target, boolean countDown) {
        this.name = name;
        this.target = target;
        this.countDown = countDown;
        current = 0;
        updateText();
    }

    public void updateText() {
        text.set(name +
                "\n" +
                (countDown ? target - current : current + "/" + target) +
                " (" +
                new DecimalFormat("#.##").format(100.0 / target * current) +
                "%)"
        );
    }

    public void count() {
        current += step;
        if(current > target) current = target;
        updateText();
    }
}
