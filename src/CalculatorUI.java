import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorUI {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(CalculatorUI::createAndShowUI);
    }

    private static void createAndShowUI() {
        JFrame frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 400);

        JPanel panel = new JPanel(new GridLayout(4, 4, 10, 10));

        String[] buttons = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "C", "0", "=", "+"
        };

        JTextField display = new JTextField();
        display.setHorizontalAlignment(JTextField.RIGHT);

        panel.add(display);

        ActionListener listener = new CalculatorButtonListener(display);

        for (String button : buttons) {
            JButton btn = new JButton(button);
            btn.addActionListener(listener);
            panel.add(btn);
        }

        frame.add(panel);
        frame.setVisible(true);
    }
}

