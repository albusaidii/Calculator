import java.util.Scanner;
import java.util.InputMismatchException;

public class Calculator {

    // Main Method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            displayMenu();

            System.out.print("Choose an option: ");
            int choice;

            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a number.");
                scanner.nextLine();
                continue;
            }

            if (choice == 13) {
                System.out.println("Exiting calculator...");
                break;
            }

            switch (choice) {
                case 1 -> performAddition(scanner);
                case 2 -> performSubtraction(scanner);
                case 3 -> performMultiplication(scanner);
                case 4 -> performDivision(scanner);
                case 5 -> performSquareRoot(scanner);
                case 6 -> performPower(scanner);
                case 7 -> performSine(scanner);
                case 8 -> performCosine(scanner);
                case 9 -> performTangent(scanner);
                case 10 -> performLog(scanner);
                case 11 -> performLog10(scanner);
                case 12 -> performAbsolute(scanner);
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    // Menu Display Method
    public static void displayMenu() {
        System.out.println("\n--- Scientific Calculator Menu ---");
        System.out.println("1. Add");
        System.out.println("2. Subtract");
        System.out.println("3. Multiply");
        System.out.println("4. Divide");
        System.out.println("5. Square Root");
        System.out.println("6. Power (x^y)");
        System.out.println("7. Sine");
        System.out.println("8. Cosine");
        System.out.println("9. Tangent");
        System.out.println("10. Natural Logarithm (ln)");
        System.out.println("11. Logarithm Base 10");
        System.out.println("12. Absolute Value");
        System.out.println("13. Exit");
    }

    // --- Basic Arithmetic Methods ---
    public static double add(double num1, double num2) {
        return num1 + num2;
    }

    public static double subtract(double num1, double num2) {
        return num1 - num2;
    }

    public static double multiply(double num1, double num2) {
        return num1 * num2;
    }

    public static double divide(double num1, double num2) {
        if (num2 == 0) {
            System.out.println("Error: Division by zero.");
            return Double.NaN;
        }
        return num1 / num2;
    }

    //  Scientific Math Methods
    public static double calculateSquareRoot(double num) {
        if (num < 0) {
            System.out.println("Error: Negative input.");
            return Double.NaN;
        }
        return Math.sqrt(num);
    }

    public static double calculatePower(double base, double exponent) {
        return Math.pow(base, exponent);
    }

    public static double calculateSine(double degrees) {
        return Math.sin(Math.toRadians(degrees));
    }

    public static double calculateCosine(double degrees) {
        return Math.cos(Math.toRadians(degrees));
    }

    public static double calculateTangent(double degrees) {
        return Math.tan(Math.toRadians(degrees));
    }

    public static double calculateNaturalLog(double num) {
        if (num <= 0) {
            System.out.println("Error: Non-positive input.");
            return Double.NaN;
        }
        return Math.log(num);
    }

    public static double calculateLogBase10(double num) {
        if (num <= 0) {
            System.out.println("Error: Non-positive input.");
            return Double.NaN;
        }
        return Math.log10(num);
    }

    public static double calculateAbsolute(double num) {
        return Math.abs(num);
    }

    // Helper Method
    private static void performAddition(Scanner scanner) {
        double num1 = getInput(scanner, "Enter first number: ");
        double num2 = getInput(scanner, "Enter second number: ");
        System.out.println("Result: " + add(num1, num2));
    }

    private static void performSubtraction(Scanner scanner) {
        double num1 = getInput(scanner, "Enter first number: ");
        double num2 = getInput(scanner, "Enter second number: ");
        System.out.println("Result: " + subtract(num1, num2));
    }

    private static void performMultiplication(Scanner scanner) {
        double num1 = getInput(scanner, "Enter first number: ");
        double num2 = getInput(scanner, "Enter second number: ");
        System.out.println("Result: " + multiply(num1, num2));
    }

    private static void performDivision(Scanner scanner) {
        double num1 = getInput(scanner, "Enter dividend: ");
        double num2 = getInput(scanner, "Enter divisor: ");
        System.out.println("Result: " + divide(num1, num2));
    }

    private static void performSquareRoot(Scanner scanner) {
        double num = getInput(scanner, "Enter number: ");
        System.out.println("Square Root: " + calculateSquareRoot(num));
    }

    private static void performPower(Scanner scanner) {
        double base = getInput(scanner, "Enter base: ");
        double exponent = getInput(scanner, "Enter exponent: ");
        System.out.println("Power: " + calculatePower(base, exponent));
    }

    private static void performSine(Scanner scanner) {
        double degrees = getInput(scanner, "Enter angle in degrees: ");
        System.out.println("Sine: " + calculateSine(degrees));
    }

    private static void performCosine(Scanner scanner) {
        double degrees = getInput(scanner, "Enter angle in degrees: ");
        System.out.println("Cosine: " + calculateCosine(degrees));
    }

    private static void performTangent(Scanner scanner) {
        double degrees = getInput(scanner, "Enter angle in degrees: ");
        System.out.println("Tangent: " + calculateTangent(degrees));
    }

    private static void performLog(Scanner scanner) {
        double num = getInput(scanner, "Enter number: ");
        System.out.println("Natural Logarithm (ln): " + calculateNaturalLog(num));
    }

    private static void performLog10(Scanner scanner) {
        double num = getInput(scanner, "Enter number: ");
        System.out.println("Logarithm Base 10: " + calculateLogBase10(num));
    }

    private static void performAbsolute(Scanner scanner) {
        double num = getInput(scanner, "Enter number: ");
        System.out.println("Absolute Value: " + calculateAbsolute(num));
    }

    // Utility Method
    private static double getInput(Scanner scanner, String prompt) {
        System.out.print(prompt);
        while (true) {
            try {
                return scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.print("Invalid input. Please enter a number: ");
                scanner.next();
            }
        }
    }
}
