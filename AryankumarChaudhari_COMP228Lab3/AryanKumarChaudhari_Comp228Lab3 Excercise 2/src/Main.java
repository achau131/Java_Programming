import java.util.Scanner;



public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Choose Game Tester Type (full-time or part-time): ");
        String gameTesterType = scanner.nextLine();

        GameTester tester;

        if (gameTesterType.equals("full-time")){
            tester = new FullTimeGameTester("Manthan");
        }

        else {
            System.out.print("Enter the number of hours: ");
            float numberOfHours = scanner.nextFloat();
            System.out.print("Enter the hourly rate: ");
            float hourlyRate = scanner.nextFloat();
            tester = new PartTimeGameTester("Aryan", numberOfHours, hourlyRate);
        }

        tester.calculateSalary();

        System.out.println("Tester Name: " + tester.getName() + "\n" +
                "Tester Monthly Pay: $" + tester.getSalary());
}

}