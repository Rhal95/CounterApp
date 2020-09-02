package de.rhal.fx;


import javafx.collections.ModifiableObservableListBase;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

public class Controller {
    private final ModifiableObservableListBase<Counter> counters = new ObservableArrayList<>();
    public TextField nameTextField;
    public TextField amountTextField;
    public ToggleButton countDownToggleButton;
    public Button submitButton;
    public VBox flowPane;

    public void addButtonAction() {
        String name = nameTextField.getText();
        int amount = Integer.parseInt(amountTextField.getText());
        boolean countDown = countDownToggleButton.isSelected();

        Counter counter = new Counter(name, amount, countDown);
        counters.add(counter);

        Button button = new Button();
        button.setMaxWidth(Double.MAX_VALUE);
        button.textProperty().bindBidirectional(counter.text);
        button.setOnAction((a) -> counter.count());
        button.setContextMenu(new ContextMenu(
                new MenuItem("Reset counter"),
                new MenuItem("Delete counter"),
                new MenuItem("Set to ..")));
        flowPane.getChildren().add(button);
    }
}
