import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorButtonListener implements ActionListener {
    private JTextField display;
    private String operator = "";
    private double firstOperand = 0;

    public CalculatorButtonListener(JTextField display) {
        this.display = display;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (Character.isDigit(command.charAt(0))) {
            display.setText(display.getText() + command);
        } else if (command.equals("C")) {
            display.setText("");
        } else if (command.equals("=")) {
            double secondOperand = Double.parseDouble(display.getText());
            double result = performOperation(firstOperand, secondOperand, operator);
            display.setText(String.valueOf(result));
        } else {
            operator = command;
            firstOperand = Double.parseDouble(display.getText());
            display.setText("");
        }
    }

    private double performOperation(double a, double b, String operator) {
        switch (operator) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                if (b != 0) {
                    return a / b;
                } else {
                    JOptionPane.showMessageDialog(null, "Cannot divide by zero", "Error", JOptionPane.ERROR_MESSAGE);
                    return 0;
                }
            default:
                return 0;
        }
    }
}

