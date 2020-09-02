package de.rhal.fx;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.ModifiableObservableListBase;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class Controller {
    public TextField nameTextField;
    public TextField amountTextField;
    public ToggleButton countDownToggleButton;
    public VBox flowPane;

    private final ObservableList<Counter>  counters = new ModifiableObservableListBase<Counter>() {
        private ArrayList<Counter> list = new ArrayList<>();
        @Override
        public Counter get(int index) {
            return list.get(index);
        }

        @Override
        public int size() {
            return list.size();
        }

        @Override
        protected void doAdd(int index, Counter element) {
            list.add(index, element);
        }

        @Override
        protected Counter doSet(int index, Counter element) {
            return list.set(index, element);
        }

        @Override
        protected Counter doRemove(int index) {
            return list.remove(index);
        }
    };

    public void addButtonAction(ActionEvent event) {
        String name = nameTextField.getText();
        int amount = Integer.parseInt(amountTextField.getText());
        boolean countDown = countDownToggleButton.isSelected();


        Counter counter = new Counter(name, amount, countDown);
        counters.add(counter);

        Button button = new Button();

        button.setMaxWidth(Double.MAX_VALUE);
        button.textProperty().bindBidirectional(counter.text);
        button.setOnAction((a)->counter.count());
        flowPane.getChildren().add(button);
    }
}
