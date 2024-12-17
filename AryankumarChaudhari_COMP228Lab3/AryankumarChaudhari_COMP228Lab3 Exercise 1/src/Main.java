import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Insurance> insuranceList = new ArrayList<>();

        System.out.println("Enter the type of insurance: Life");
        Life lifeInsurance = new Life("Life", 0.0); // Monthly cost will be set later
        lifeInsurance.setInsuranceCost();
        insuranceList.add(lifeInsurance);

        System.out.println("Enter the type of insurance: Health");
        Health healthInsurance = new Health("Health", 0.0); // Monthly cost will be set later
        healthInsurance.setInsuranceCost();
        insuranceList.add(healthInsurance);

        // Loop through the list and display the details
        for (Insurance insurance : insuranceList) {
            insurance.display();
        }

        sc.close();
    }
}
