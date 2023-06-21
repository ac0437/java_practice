import java.util.Scanner;
import java.text.NumberFormat;

public class Mortgage {
  public static void main(String[] args) {
    final int MONTHLY = 12;
    final int PERCENT = 100;
    Scanner scanner = new Scanner(System.in);
    int principle = 0;
    float interestRate = 0.0F;
    int years = 0;
    boolean valid = false;

    System.out.print("Principle($1K-$1M): ");

    while (!valid) {
      if (scanner.hasNextInt()) {
        principle = scanner.nextInt();
        if (principle < 1000 || principle > 1000000) {
          System.out.print("Enter number between $1K and $1M: ");
        } else {
          valid = true;
        }
      } else {
        System.out.println("Please enter a number: ");
        scanner.next();
      }
    }

    valid = false;
    System.out.print("Interest Rate: ");
    while (!valid) {
      if (scanner.hasNextFloat()) {
        interestRate = scanner.nextFloat();
        if (interestRate < 0.0 || interestRate > 30) {
          System.out.print("Enter float between 0.0 and 30.0: ");
        } else {
          valid = true;
        }
      } else {
        System.out.println("Please enter a float: ");
        scanner.next();
      }
    }

    valid = false;
    System.out.print("Years: ");
    while (!valid) {
      if (scanner.hasNextInt()) {
        years = scanner.nextInt();
        if (years < 0 || years > 30) {
          System.out.print("Enter float between 1 and 30: ");
        } else {
          valid = true;
        }
      } else {
        System.out.println("Please enter a number: ");
        scanner.next();
      }
    }

    double mortgage = principle
        * ((interestRate / MONTHLY / PERCENT) * Math.pow((1 + (interestRate / MONTHLY / PERCENT)), (years * MONTHLY))
            / (Math.pow((1 +
                (interestRate / MONTHLY / PERCENT)), (years * MONTHLY)) - 1));
    NumberFormat amountToPay = NumberFormat.getCurrencyInstance();

    System.out.println("Mortgage: " + amountToPay.format(mortgage));
    scanner.close();
  }
}
