import calculator.Calculator;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Running {


    public static void main(String[] args) {

        while (true) {
            System.out.println("**************************************************");

            Calculator calculator = new Calculator();
            double number1 = getNumber();
            char action = getAction();
            double number2 = getNumber();

            try {
                switch (action) {
                    case ('*'):
                        System.out.println(calculator.multiplication(number1, number2));
                        break;
                    case ('/'):
                        System.out.println(calculator.division(number1, number2));
                        break;
                    case ('+'):
                        System.out.println(calculator.sum(number1, number2));
                        break;
                    case ('-'):
                        System.out.println(calculator.dif(number1, number2));
                        break;
                    default:
                        System.out.println("вы ввели несуществующее действие");
                        break;
                }

            } catch (Exception e) {
                System.out.println("[ERROR] " + e.getMessage());
                System.out.println("Please try again");
            }
        }
    }


    static double getNumber() {
        double input = 0;
        boolean flag = true;

        while (flag) {
            try {
                System.out.println("Введите число. Делиметром числа должна быть точка :");
                input = new Scanner(System.in).nextDouble();
                if (input == Double.POSITIVE_INFINITY || input == Double.NEGATIVE_INFINITY) {
                    System.out.println("[ERROR] Вы ввели недопустимое значение. Попробуйте снова");
                    continue;
                }
            } catch (InputMismatchException e) {
                System.out.println("[ERROR] Вы ввели не число. Попробуйте снова.");
                continue;
            }
            flag = false;
        }

        return input;

    }

    static char getAction() {
        System.out.print("Введите действие: *, /, +, - : ");
        return new Scanner(System.in).next().charAt(0);
    }

}
