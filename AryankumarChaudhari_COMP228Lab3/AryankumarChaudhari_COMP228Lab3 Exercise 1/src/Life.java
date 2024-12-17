public class Life extends Insurance {

    private double _monthlyCost;
    private String _insuranceType;

    public Life(String insuranceType, double monthlyCost) {
        super(insuranceType, monthlyCost);
    }

    @Override
    public void setInsuranceCost() {
        _monthlyCost = 100.0; // Example cost for Life insurance
    }

    // Display insurance details
    @Override
    public void display() {
        System.out.println("Insurance Type: " + _insuranceType); // Direct access to the protected field
        System.out.println("Monthly Cost: $" + _monthlyCost);     // Direct access to the protected field
    }
}
