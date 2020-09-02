package sample;

import javafx.scene.control.Button;

public class CounterButton extends Button {
    private String name;
    private int current;
    private int target;
    private boolean countDown;
    private int step = 1;

    public CounterButton(String name, int target, boolean countDown) {
        this.name = name;
        this.target = target;
        this.countDown = countDown;
        current = countDown ? target : 0;
        updateText();
        this.setOnAction(event -> {
            count();
            updateText();
        });
    }

    void updateText(){
        setText(String.format("%s\n%d/%d (%f%%)", name, current, target, 100.0/target*current));
    }
    void count(){
        if(countDown){
            current -= step;
            if(current < 0) current = 0;
        }else{
            current += step;
            if(current > target) current = target;
        }
    }
}
