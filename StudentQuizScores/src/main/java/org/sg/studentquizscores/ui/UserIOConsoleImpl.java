package org.sg.studentquizscores.ui;

import java.util.Scanner;

public class UserIOConsoleImpl implements UserIO {
    static Scanner scanner = new Scanner(System.in);
    @Override
    public void print(String message) {
        System.out.println(message);
    }

    @Override
    public String readString(String prompt) {
        System.out.println(prompt + " ");
        String message = scanner.nextLine();
        return message;
    }

    @Override
    public int readInt(String prompt) {
        System.out.print(prompt);
        int value = Integer.parseInt(scanner.nextLine());
        return value;
    }

    @Override
    public int readInt(String prompt, int min, int max) {
        System.out.println(prompt);
        int value = Integer.parseInt(scanner.nextLine());
        while (value < min && value > max) {
            System.out.println("Enter a valid number within range " + min + " - " + max);
            value = Integer.parseInt(scanner.nextLine());

        }
        return value;
    }

    @Override
    public double readDouble(String prompt) {
        System.out.println(prompt);
        double value = scanner.nextInt();
        return value;
    }

    @Override
    public double readDouble(String prompt, double min, double max) {
        System.out.println(prompt);
        double value = scanner.nextDouble();
        while (value < min && value > max) {
            System.out.println("Enter a valid number within range " + min + " - " + max);
            value = scanner.nextInt();
        }
        return value;
    }

    @Override
    public float readFloat(String prompt) {
        System.out.println(prompt);
        float value = scanner.nextFloat();
        return value;
    }

    @Override
    public float readFloat(String prompt, float min, float max) {
        System.out.println(prompt);
        float value = scanner.nextFloat();
        while (value < min && value > max) {
            System.out.println("Enter a valid number within range " + min + " - " + max);
            value = scanner.nextInt();
        }
        return value;
    }

    @Override
    public long readLong(String prompt) {
        System.out.println(prompt);
        long value = scanner.nextLong();
        return value;
    }

    @Override
    public long readLong(String prompt, long min, long max) {
        System.out.println(prompt);
        long value = scanner.nextLong();
        while (value < min && value > max) {
            System.out.println("Enter a valid number within range " + min + " - " + max);
            value = scanner.nextInt();
        }
        return value;
    }
}
