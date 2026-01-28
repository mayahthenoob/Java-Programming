import java.util.Scanner;

public class OEChecker {
    public static void main(String[] args) {
        Scanner oddeven = new Scanner(System.in);

        System.out.print("Enter number: ");
        try {
            // Read user input
            int number = oddeven.nextInt();

            // Check if the number is even or odd
            if (number % 2 == 0) {
                System.out.println(number + " is Even.");
            } else {
                System.out.println(number + " is Odd.");
            }
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter a valid integer.");
        } finally {
            oddeven.close(); 
        }
    }
}

