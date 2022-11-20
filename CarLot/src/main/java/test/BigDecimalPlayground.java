package test;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigDecimalPlayground {
    public static void main(String[] args) {
        BigDecimalPlayground myMath = new BigDecimalPlayground();
        BigDecimal o1 = new BigDecimal("10");
        BigDecimal o2 = new BigDecimal("3");

        System.out.println(myMath.calculate(MathOperator.PLUS, o1, o2));
        System.out.println(myMath.calculate(MathOperator.MINUS, o1, o2));
        System.out.println(myMath.calculate(MathOperator.MULTIPLY, o1, o2));
        // Non-terminating decimal expansion, Must contain a scale and rounding method
        System.out.println(myMath.calculate(MathOperator.DIVIDE, o1, o2));
    }

    public BigDecimal calculate(MathOperator operator, BigDecimal op1, BigDecimal op2) {
        // add, subtract, multiply, divide big decimals
        switch(operator) {
            case PLUS:
                return op1.add(op2);

            case MINUS:
                return op1.subtract(op2);

            case MULTIPLY:
                return op1.multiply(op2);
            case DIVIDE:
                // Scale of 2,
                // Set a rounding method
                return op1.divide(op2, 2, RoundingMode.HALF_UP);
            default:
            throw new UnsupportedOperationException("Unsupported operation");
        }
    }
}
