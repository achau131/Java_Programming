public class Health extends Insurance {


    public Health(String insuranceType, double monthlyCost) {
        super(insuranceType, monthlyCost);
    }

    @Override
    public void setInsuranceCost() {
        _monthlyCost = 200.0;
    }


    // Display insurance details
    @Override
    public void display() {
        System.out.println("Insurance Type: " + get_insuranceType());
        System.out.println("Monthly Cost: $" + get_monthlyCost());
    }
}
