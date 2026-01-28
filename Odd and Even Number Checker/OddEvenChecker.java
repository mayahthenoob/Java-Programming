import java.util.Scanner;

public class OddEvenChecker {
    public static void main(String[] args) {
        Scanner oddeven = new Scanner(System.in);

    System.out.print("Enter number: ");
        int number = oddeven.nextInt();

        if (number % 2 == 0) {
            System.out.println(number + " is Even.");
        } else {
            System.out.println(number + " is Odd.");
        }
        oddeven.close(); 
    }
}

