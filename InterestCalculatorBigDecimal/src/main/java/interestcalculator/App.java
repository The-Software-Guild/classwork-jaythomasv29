package interestcalculator;

import java.math.BigDecimal;

public class App {
    public static void main(String[] args) {
        InterestCalc interestCalculator = new InterestCalc();
        BigDecimal totalCompoundedInterest = interestCalculator.calculateInterest();
        System.out.println("Your total with compounded interest is: " + totalCompoundedInterest.toString());
    }
}
