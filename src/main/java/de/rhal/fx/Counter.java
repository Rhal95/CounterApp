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
        current = countDown ? target : 0;
        updateText();
    }

    public void updateText() {
        text.set(String.format("%s\n%d/%d (", name, current, target)
                + new DecimalFormat("#.##").format(100.0 / target * current) +"%)");
    }

    public void count() {
        if (countDown) {
            current -= step;
            if (current < 0) current = 0;
        } else {
            current += step;
            if (current > target) current = target;
        }
        updateText();
    }
}
