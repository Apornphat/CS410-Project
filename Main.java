import java.util.Scanner;

/**
 * CS 410 Final Project
 * Java Implementation: Simple Calculator
 * Demonstrating Static Typing and Imperative Control Flow
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== CS 410 Final Project: Java Implementation ===");
        System.out.println("จัดทำโดย: กัญญาณัฐ, จตุพร, อาภรณ์ภัทร์, กษิรา");
        System.out.println("-----------------------------------------------");
        
        try {
            System.out.print("Enter first number: ");
            double num1 = scanner.nextDouble();
            
            System.out.print("Enter operator (+, -, *, /): ");
            char op = scanner.next().charAt(0);
            
            System.out.print("Enter second number: ");
            double num2 = scanner.nextDouble();
            
            double result = calculate(num1, num2, op);
            System.out.println("-----------------------------------------------");
            System.out.println("RESULT: " + num1 + " " + op + " " + num2 + " = " + result);
        } catch (Exception e) {
            System.out.println("Error: Invalid input. Please enter numbers correctly.");[cite: 4]
        } finally {
            scanner.close();[cite: 4]
        }
    }

    /**
     * การใช้ Switch Case และ Explicit Typing ตามคุณสมบัติของ Java[cite: 1]
     */
    public static double calculate(double a, double b, char op) {
        switch (op) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/': 
                if (b == 0) {
                    System.out.println("Error: Cannot divide by zero.");
                    return 0;
                }
                return a / b;
            default:
                System.out.println("Invalid Operator!");
                return 0;
        }
    }
}