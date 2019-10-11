package test.calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ScientificController {

    @FXML
    private Button one;
    @FXML
    private Button two;
    @FXML
    private Button three;
    @FXML
    private Button four;
    @FXML
    private Button five;
    @FXML
    private Button six;
    @FXML
    private Button seven;
    @FXML
    private Button eight;
    @FXML
    private Button nine;
    @FXML
    private Button zero;
    @FXML
    private Button sum;
    @FXML
    private Button product;
    @FXML
    private Button quotient;
    @FXML
    private Button difference;
    @FXML
    private Button equals;
    @FXML
    private Button clear;
    @FXML
    private Button cancel;
    @FXML
    private Button sin;
    @FXML
    private Button cos;
    @FXML
    private Button tan;
    @FXML
    private Button log;
    @FXML
    private Button ln;
    @FXML
    private Button pi;
    @FXML
    private Button factorial;
    @FXML
    private Button squareroot;
    @FXML
    private TextField display;

    private double fnumber;
    private double snumber;
    private int operation;
    private int lenght;


    public void numberPrinter(ActionEvent actionEvent) {
        if (actionEvent.getSource() == one) {
            if (display.getText().equals("÷") || display.getText().equals("×") || display.getText().equals("-") || display.getText().equals("+") || display.getText().equals("0")) {
                display.setText("1");
            } else
                display.setText(display.getText() + 1);
        } else if (actionEvent.getSource() == two) {
            if (display.getText().equals("÷") || display.getText().equals("×") || display.getText().equals("-") || display.getText().equals("+") || display.getText().equals("0")) {
                display.setText("2");
            } else
                display.setText(display.getText() + 2);
        } else if (actionEvent.getSource() == three) {
            if (display.getText().equals("÷") || display.getText().equals("×") || display.getText().equals("-") || display.getText().equals("+") || display.getText().equals("0")) {
                display.setText("3");
            } else
                display.setText(display.getText() + 3);
        } else if (actionEvent.getSource() == four) {
            if (display.getText().equals("÷") || display.getText().equals("×") || display.getText().equals("-") || display.getText().equals("+") || display.getText().equals("0")) {
                display.setText("4");
            } else
                display.setText(display.getText() + 4);
        } else if (actionEvent.getSource() == five) {
            if (display.getText().equals("÷") || display.getText().equals("×") || display.getText().equals("-") || display.getText().equals("+") || display.getText().equals("0")) {
                display.setText("5");
            } else
                display.setText(display.getText() + 5);
        } else if (actionEvent.getSource() == six) {
            if (display.getText().equals("÷") || display.getText().equals("×") || display.getText().equals("-") || display.getText().equals("+") || display.getText().equals("0")) {
                display.setText("6");
            } else
                display.setText(display.getText() + 6);
        } else if (actionEvent.getSource() == seven) {
            if (display.getText().equals("÷") || display.getText().equals("×") || display.getText().equals("-") || display.getText().equals("+") || display.getText().equals("0")) {
                display.setText("7");
            } else
                display.setText(display.getText() + 7);
        } else if (actionEvent.getSource() == eight) {
            if (display.getText().equals("÷") || display.getText().equals("×") || display.getText().equals("-") || display.getText().equals("+") || display.getText().equals("0")) {
                display.setText("8");
            } else
                display.setText(display.getText() + 8);
        } else if (actionEvent.getSource() == nine) {
            if (display.getText().equals("÷") || display.getText().equals("×") || display.getText().equals("-") || display.getText().equals("+") || display.getText().equals("0")) {
                display.setText("9");
            } else
                display.setText(display.getText() + 9);
        } else if (actionEvent.getSource() == zero) {
            if (display.getText().equals("÷") || display.getText().equals("×") || display.getText().equals("-") || display.getText().equals("+") || display.getText().equals("0")) {
                display.setText("0");
            } else
                display.setText(display.getText() + 0);
        } else if (actionEvent.getSource() == pi) {
            display.setText(Double.toString(Math.PI));
        }
    }

    public void printDot(ActionEvent actionEvent) {
        String input = display.getText();
        int lenght = input.length();
        boolean check = true;
        for (int i = 0; i < lenght; i++) {
            if (input.charAt(i) == '.') check = false;
        }
        if (check) display.setText(display.getText() + '.');
    }

    public void operation(ActionEvent actionEvent) {

        if (actionEvent.getSource() == sum) {
            if (!display.getText().isEmpty()) {
                fnumber = Double.parseDouble(display.getText());
                operation = 1;
                display.setText("+");
            }
        } else if (actionEvent.getSource() == difference) {
            if (display.getText().isEmpty()) {
                display.setText("-");
            } else {
                fnumber = Double.parseDouble(display.getText());
                operation = 2;
                display.setText("-");
            }
        } else if (actionEvent.getSource() == product) {
            if (!display.getText().isEmpty()) {
                fnumber = Double.parseDouble(display.getText());
                operation = 3;
                display.setText("×");
            }
        } else if (actionEvent.getSource() == quotient) {
            if (!display.getText().isEmpty()) {
                fnumber = Double.parseDouble(display.getText());
                operation = 4;
                display.setText("÷");
            }
        } else if (actionEvent.getSource() == equals) {
            if (operation == 1) {
                snumber = Double.parseDouble(display.getText());
                display.setText(Double.toString(fnumber + snumber));
            } else if (operation == 2) {
                snumber = Double.parseDouble(display.getText());
                display.setText(Double.toString(fnumber - snumber));
            } else if (operation == 3) {
                snumber = Double.parseDouble(display.getText());
                display.setText(Double.toString(fnumber * snumber));
            } else if (operation == 4) {
                snumber = Double.parseDouble(display.getText());
                if (snumber == 0) {
                    display.setText("Math Error");
                } else
                    display.setText(Double.toString(fnumber / snumber));
            } else if (operation == 5) {

                String sin = display.getText();
                double number = Double.parseDouble(sin.substring(4));
                display.setText(Double.toString(Math.sin(number)));
            } else if (operation == 6) {

                String cos = display.getText();
                double number = Double.parseDouble(cos.substring(4));
                System.out.println(number);
                display.setText(Double.toString(Math.cos(number)));

            } else if (operation == 7) {

                String tan = display.getText();
                double number = Double.parseDouble(tan.substring(4));
                System.out.println(number);
                display.setText(Double.toString(Math.tan(number)));

            } else if (operation == 8) {

                String log = display.getText();
                double number = Double.parseDouble(log.substring(4));
                System.out.println(number);
                display.setText(Double.toString(Math.log10(number)));

            } else if (operation == 9) {

                String ln = display.getText();
                double number = Double.parseDouble(ln.substring(3));
                System.out.println(number);
                display.setText(Double.toString(Math.log(number)));
            } else if (operation == 10) {
                String fact = display.getText();
                int number = Integer.parseInt(fact.substring(0, fact.length() - 1));
                display.setText(Integer.toString(factorial(number)));
            } else if (operation == 11) {
                String sqrt = display.getText();
                double fnumber = 0;
                if (lenght != 0)
                    fnumber = Integer.parseInt(sqrt.substring(0, lenght));
                double snumber = Integer.parseInt(sqrt.substring(lenght + 1));
                System.out.println("sn" + fnumber + "sn" + snumber);
                if (lenght == 0) display.setText(Double.toString(Math.sqrt(snumber)));
                else display.setText(Double.toString(fnumber * Math.sqrt(snumber)));
            }

            fnumber = 0;
            snumber = 0;
            operation = 0;
            lenght = 0;

        } else if (actionEvent.getSource() == cancel) {

            String string = display.getText();
            String cleared = string.substring(0, display.getText().length() - 1);
            display.setText(cleared);

        } else if (actionEvent.getSource() == clear) {

            display.setText("0");
            fnumber = 0;
            snumber = 0;
            operation = 0;

        }
    }

    public void scientificOperation(ActionEvent actionEvent) {
        if (actionEvent.getSource() == sin) {
            display.setText("sin ");
            operation = 5;
        } else if (actionEvent.getSource() == cos) {
            display.setText("cos ");
            operation = 6;
        } else if (actionEvent.getSource() == tan) {
            display.setText("tan ");
            operation = 7;
        } else if (actionEvent.getSource() == log) {
            display.setText("log ");
            operation = 8;
        } else if (actionEvent.getSource() == ln) {
            display.setText("ln ");
            operation = 9;
        } else if (actionEvent.getSource() == factorial) {
            display.setText(display.getText() + "!");
            operation = 10;
        } else if (actionEvent.getSource() == squareroot) {
            lenght = display.getText().length();
            display.setText(display.getText() + "√");
            operation = 11;
        }
    }

    public static int factorial(int i) {
        if (i == 0) return 1;
        else if (i == 1) return 1;
        else return i * factorial(i - 1);
    }

}
