package com.sg.foundations.enums;


public class IntMath {
    public static int calculate(MathOperator operator, int operand1, int operand2) {
        switch(operator) {
            case PLUS:
                return operand1 + operand2;
            case MINUS:
                return operand1 - operand2;
            case MULTIPLY:
                return operand1 * operand2;
            case DIVIDE:
                return operand1 / operand2;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public static void main(String[] args) {

        System.out.println(calculate(MathOperator.MULTIPLY, 5, 5));
    }
}


