package ru.job4j.kiss.fool;

import java.util.Scanner;

public class Fool {
    public static void main(String[] args) {
        System.out.println("Игра FizzBuzz");
        var startAt = 1;
        var input = new Scanner(System.in);
        while (startAt < 100) {
            System.out.println(check(startAt));
            startAt++;
            String answer = input.nextLine();
            if (!check(startAt).equals(answer)) {
                System.out.println("Ошибка. Начинай снова.");
                startAt = 0;
            }
            startAt++;
        }
    }

    public static String check(int startAt) {
        String result = String.valueOf(startAt);
        if (startAt % 3 == 0 && startAt % 5 == 0) {
            result = "FizzBuzz";
        } else if (startAt % 3 == 0) {
            result = "Fizz";
        } else if (startAt % 5 == 0) {
            result = "Buzz";
        }
        return result;
    }
}
