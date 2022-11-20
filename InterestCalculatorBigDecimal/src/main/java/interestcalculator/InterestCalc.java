package interestcalculator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Scanner;

public class InterestCalc {
    final private Scanner scanner = new Scanner(System.in);

    public BigDecimal readBigDecimalInput(String message) {
        boolean isWrongInputValue = true;
        double val = 0.00;
        while (isWrongInputValue) {
            try {
                System.out.print(message + ": ");
                String inputAsString = scanner.nextLine();
                val = Double.parseDouble(inputAsString);
                isWrongInputValue = false;

            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please try again");
            }
        }
        return new BigDecimal(val);

    }

    public int readInt(String msgPrompt) {
        boolean invalidInput = true;
        int num = 0;
        while (invalidInput) {
            try {
                // print the message msgPrompt (ex: asking for the # of cats!)
                System.out.print(msgPrompt + ": ");
                String stringValue = scanner.nextLine();
                // Get the input line, and try and parse
                num = Integer.parseInt(stringValue); // if it's 'bob' it'll break
                invalidInput = false; // or you can use 'break;'
            } catch (NumberFormatException e) {
                // If it explodes, it'll go here and do this.
                System.out.println("Input error. Please try again.");
            }
        }
        return num;
    }

    public BigDecimal calculateInterest() {
        BigDecimal principal = readBigDecimalInput("Enter total principal (as a dollar amount) e.g. $XXXX.XX");
        BigDecimal rate = readBigDecimalInput("Enter interest rate (as a percentage) e.g. 5.25%, 3.00%");
        rate = rate.divide(new BigDecimal(100), 2, RoundingMode.HALF_UP);
        principal.setScale(2, RoundingMode.HALF_UP);
        int years = readInt("Enter total years (as an integer) e.g. 1-50");
        System.out.println("Calculating compound interest...");
        BigDecimal amount = BigDecimal.ZERO;
        for(int year = 1; year <= years; year++) {
            amount = principal.multiply(rate.add(BigDecimal.ONE).pow(year));
            amount.setScale(2, RoundingMode.HALF_UP);
            System.out.println("Year " + year + ": ");
            System.out.println("Total: " + amount.setScale(2, RoundingMode.HALF_UP));

            // display the year and the amount
            System.out.printf("%4d%20s%n", year,
                    NumberFormat.getCurrencyInstance().format(amount));
        }
        return amount.setScale(2, RoundingMode.HALF_UP);
    }
}
