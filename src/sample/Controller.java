package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;

public class Controller {
    public TextField nameTextField;
    public TextField amountTextField;
    public ToggleButton countDownToggleButton;
    public VBox flowPane;

    public void addButtonAction(ActionEvent event) {
        String name = nameTextField.getText();
        int amount = Integer.parseInt(amountTextField.getText());
        boolean countDown = countDownToggleButton.isSelected();
        CounterButton e = new CounterButton(name, amount, countDown);
        e.setMinWidth(flowPane.getPrefWidth());
        flowPane.getChildren().add(e);
    }
}
