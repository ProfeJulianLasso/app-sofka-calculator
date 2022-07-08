package org.sofka.calculator;

import org.sofka.calculator.utilities.Calculator;
import org.sofka.calculator.utilities.MessagesCalculator;
import org.sofka.calculator.utilities.MyException;
import org.sofka.calculator.utilities.MyScanner;

public class App {

    static MessagesCalculator messages = MessagesCalculator.getInstance();
    static MessagesCalculator messages2 = MessagesCalculator.getInstance();
    static Calculator calculator = new Calculator();
    static MyScanner scanner = MyScanner.getInstance();

    public static void main(String[] args) {
        init();
    }

    private static void init() {
        Boolean flag = true;
        messages.showWelcome();
        getNumber();
        while (Boolean.TRUE.equals(flag)) {
            try {
                messages.showSelectAction();
                flag = selectOption(scanner.getString());
            } catch (MyException myException) {
                messages.showMessage(myException.getMessage());
                messages.pressAnyKeyToContinue();
            }
        }
    }

    private static Boolean selectOption(String option) {
        switch (option) {
            case "+":
                getNumber();
                calculator.add();
                messages.showAnswer(calculator.getAnswer());
                break;
            case "-":
                getNumber();
                calculator.subtract();
                messages.showAnswer(calculator.getAnswer());
                break;
            case "*":
                getNumber();
                calculator.multiply();
                messages.showAnswer(calculator.getAnswer());
                break;
            case "/":
                getNumber();
                calculator.divide();
                messages.showAnswer(calculator.getAnswer());
                break;
            case "%":
                getNumber();
                calculator.remainder();
                messages.showAnswer(calculator.getAnswer());
                break;
            case ".":
                scanner.close();
                return false;
            default:
                messages.incorrectChoice();
                messages.pressAnyKeyToContinue();
        }
        return true;
    }

    private static void getNumber() {
        messages.showGetNumber();
        calculator.setParam(scanner.getDouble());
    }
}
