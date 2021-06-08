package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Controller {

    enum OPERATOR {
        PLUS, MINUS, MULTIPLY, DIVIDE, NULL
    }

    public Label prepare;
    public TextField display;

    OPERATOR Operator;
    double number_1;
    double result = 0;
    boolean opBoolean = false;

    public void ac_ButtonOnAction() {
        display.setText("");
        prepare.setText("Ready");
        Operator = OPERATOR.NULL;
        result = 0;
    }

    public void off_ButtonOnAction(ActionEvent actionEvent) {
        ((Stage) (((Button) actionEvent.getSource()).getScene().getWindow())).close();
    }

    public void c_ButtonOnAction() {
        String displayText = display.getText();
        display.setText(displayText.substring(0, displayText.length() - 1));
    }

    public void percent_ButtonOnAction() {
        prepare.setText("Result");
        display.setText(String.valueOf(Double.parseDouble(display.getText()) / 100.00));
    }

    public void dot_ButtonOnAction() {
        if (!display.getText().contains(".")) {
            if (display.getText().equals("")) display.setText(display.getText() + "0.");
            else display.setText(display.getText() + ".");
        }
    }

    public void equals_ButtonOnAction() {
        prepare.setText("Result");
        double number_2 = Double.parseDouble(display.getText());
        if (Operator == OPERATOR.PLUS) {
            result = number_1 + number_2;
            display.setText(String.valueOf(result));
        } else if (Operator == OPERATOR.MINUS) {
            result = number_1 - number_2;
            display.setText(String.valueOf(result));
        } else if (Operator == OPERATOR.MULTIPLY) {
            result = number_1 * number_2;
            display.setText(String.valueOf(result));
        } else if (Operator == OPERATOR.DIVIDE) {
            result = number_1 / number_2;
            display.setText(String.valueOf(result));
        }
    }

    public void numeric_OnClickAction(ActionEvent actionEvent) {
        if (prepare.getText().equals("Result")) {
            display.setText("");
            prepare.setText("Ready");
        }
        if (opBoolean) {
            display.setText("");
            opBoolean = false;
        }
        String number = ((Button) actionEvent.getSource()).getText();
        display.setText(display.getText() + number);
    }

    public void operator_OnClickAction(ActionEvent actionEvent) {
        opBoolean = true;
        number_1 = Double.parseDouble(display.getText());
        String operator = ((Button) actionEvent.getSource()).getText();
        switch (operator) {
            case "+" -> {
                prepare.setText("Addition");
                Operator = OPERATOR.PLUS;
            }
            case "-" -> {
                prepare.setText("Subtract");
                Operator = OPERATOR.MINUS;
            }
            case "*" -> {
                prepare.setText("Multiply");
                Operator = OPERATOR.MULTIPLY;
            }
            case "/" -> {
                prepare.setText("Divide");
                Operator = OPERATOR.DIVIDE;
            }
        }
    }
}
