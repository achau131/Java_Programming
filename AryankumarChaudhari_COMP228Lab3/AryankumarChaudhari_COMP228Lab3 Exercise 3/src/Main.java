import java.util.Scanner ;

public class Main {


    public static void main(String[] args) {



            Scanner scanner = new Scanner(System.in);
            Mortgage[] mortgages = new Mortgage[3];


            System.out.print("Enter the prime interest rate:");
            double primeRate = scanner.nextDouble();



            for (int i = 0; i < mortgages.length; i++) {

                System.out.println(".................................................................");
                System.out.println("Enter details for Mortgage no. " + (i + 1));

                System.out.print("Enter mortgage number: ");
                String mortgageNumber = scanner.next();

                System.out.print("Enter customer name: ");
                String customerName = scanner.next();

                System.out.print("Enter mortgage amount: ");
                double amount = scanner.nextDouble();

                System.out.print("Enter term [1 - short, 3 - medium, 5 - long]: ");
                int term = scanner.nextInt();

                System.out.print("Enter mortgage type [1 - Business, 2 - Personal ]: ");
                int type = scanner.nextInt();


                if (type == 1) {

                    mortgages[i] = new BusinessMortgage(mortgageNumber, customerName, amount, term, primeRate);
                } else if (type == 2) {

                    mortgages[i] = new PersonalMortgage(mortgageNumber, customerName, amount, term, primeRate);

                } else {

                    System.out.println("Invalid mortgage type. Skipped entry");
                }
            }


            System.out.println("\nAll Mortgages:\n\n");


        for (int i = 0; i < mortgages.length; i++) {if (mortgages[i] != null) {
                mortgages[i].getMortgageInfo();
            System.out.println("\n");
            }
        }

        scanner.close();
    }
}