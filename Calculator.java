import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Calculator implements ActionListener {

    JFrame frame;
    JTextField text;
    JButton[] numButtons = new JButton[10];
    JButton[] fButtons = new JButton[9];
    JButton decButton, incButton, delButton, eqButton, negButton,
            clrButton, addButton, subButton, mulButton, divButton;
    JPanel panel;
    double num1 = 0, num2 = 0, result = 0;
    char operator;

    Calculator() {
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 550);
        frame.setLayout(null);
        Font myfont = new Font("Ink Free", Font.BOLD, 30);
        text = new JTextField();
        text.setBounds(50, 25, 300, 50);
        text.setEditable(false);
        text.setFont(myfont);

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        eqButton = new JButton("=");
        delButton = new JButton("del");
        clrButton = new JButton("clr");
        negButton = new JButton("(-)");
        fButtons[0] = addButton;
        fButtons[1] = subButton;
        fButtons[2] = mulButton;
        fButtons[3] = divButton;
        fButtons[4] = decButton;
        fButtons[5] = eqButton;
        fButtons[6] = delButton;
        fButtons[7] = clrButton;
        fButtons[8] = negButton;

        for (int i = 0; i < fButtons.length; i++) {
            fButtons[i].addActionListener(this);
            fButtons[i].setFocusable(false);
            fButtons[i].setFont(myfont);

        }

        for (int i = 0; i < numButtons.length; i++) {
            numButtons[i] = new JButton(String.valueOf(i));
            numButtons[i].addActionListener(this);
            numButtons[i].setFocusable(false);
            numButtons[i].setFont(myfont);

        }

        delButton.setBounds(150, 430, 100, 50);
        clrButton.setBounds(250, 430, 100, 50);
        negButton.setBounds(50, 430, 100, 50);
        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));
        panel.setFont(myfont);
        panel.add(numButtons[1]);
        panel.add(numButtons[2]);
        panel.add(numButtons[3]);
        panel.add(addButton);
        panel.add(numButtons[4]);
        panel.add(numButtons[5]);
        panel.add(numButtons[6]);
        panel.add(subButton);
        panel.add(numButtons[7]);
        panel.add(numButtons[8]);
        panel.add(numButtons[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numButtons[0]);
        panel.add(eqButton);
        panel.add(divButton);
        frame.add(negButton);

        frame.add(panel);
        frame.add(clrButton);
        frame.add(delButton);
        frame.add(text);
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        Calculator cal = new Calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numButtons[i]) {
                text.setText(text.getText().concat(String.valueOf(i)));
            }
        }
        if (e.getSource() == decButton) {
            text.setText(text.getText().concat(String.valueOf(".")));
        }
        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(text.getText());
            operator = '+';
            text.setText("");
        }
        if (e.getSource() == subButton) {
            num1 = Double.parseDouble(text.getText());
            operator = '-';
            text.setText("");
        }
        if (e.getSource() == mulButton) {
            num1 = Double.parseDouble(text.getText());
            operator = '*';
            text.setText("");
        }
        if (e.getSource() == divButton) {
            num1 = Double.parseDouble(text.getText());
            operator = '/';
            text.setText("");
        }
        if (e.getSource() == eqButton) {
            num2 = Double.parseDouble(text.getText());

            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;

                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
            }
            text.setText(String.valueOf(result));
            num1 = result;
        }
        if (e.getSource() == clrButton) {
            text.setText("");
        }
        if (e.getSource() == delButton) {
            String str = text.getText();
            text.setText("");
            for (int i = 0; i < str.length() - 1; i++) {
                text.setText(text.getText() + str.charAt(i));
            }
        }
        if (e.getSource() == negButton) {
            double temp = Double.parseDouble(text.getText());
            temp *= -1;
            text.setText(String.valueOf(temp));
        }

    }

}