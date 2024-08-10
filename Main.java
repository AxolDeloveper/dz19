import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите математическое выражение: ");
        String input = scanner.nextLine();


        try {
            int result = calculateExpression(input);
            System.out.println("Результат: " + result);
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: некорректное выражение!");
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    public static int calculateExpression(String expression) {

        expression = expression.replaceAll("\\s+", "");


        if (!expression.matches("[0-9+]+")) {
            throw new IllegalArgumentException("Выражение должно содержать только цифры и знак '+'!");
        }

        String[] numbers = expression.split("\\+");

        int sum = 0;
        for (String number : numbers) {
            sum += Integer.parseInt(number);
        }

        return sum;
    }
}
