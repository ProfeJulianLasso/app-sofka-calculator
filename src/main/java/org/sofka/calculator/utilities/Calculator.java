package org.sofka.calculator.utilities;

import org.sofka.calculator.utilities.interfaces.CalculatorInterface;

import lombok.Data;

@Data
public class Calculator implements CalculatorInterface {

    private Double param;
    private Double answer;
    private Double temp;

    public Calculator() {
        param = 0.0;
        answer = null;
        temp = null;
    }

    public void setParam(Double param) {
        temp = (this.param != null) ? this.param : null;
        this.param = param;
    }

    public void add() {
        answer = param + ((answer != null) ? answer : temp);
    }

    public void subtract() {
        answer = param - ((answer != null) ? answer : temp);
    }

    public void multiply() {
        answer = ((answer != null) ? answer : temp) * param;
    }

    public void divide() {
        if (param == 0.0) {
            throw new MyException("La división por CERO no existe");
        }
        answer = ((answer != null) ? answer : temp) / param;
    }

    public void remainder() {
        answer = ((answer != null) ? answer : temp) % param;
    }

    public void clearMemory() {
        answer = null;
    }

}
