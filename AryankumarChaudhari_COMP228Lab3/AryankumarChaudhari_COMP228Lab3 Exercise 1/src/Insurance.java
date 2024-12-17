public abstract class Insurance {

    protected String _insuranceType;
    protected double _monthlyCost;

    // Constructor
    public Insurance(String insuranceType, double monthlyCost) {
        this._insuranceType = insuranceType;
        this._monthlyCost = monthlyCost;
    }

    // Getters
    public String getInsuranceType() {
        return _insuranceType;
    }

    public double getMonthlyCost() {
        return _monthlyCost;
    }

    // Abstract methods
    public abstract void setInsuranceCost();

    public abstract void display();
}
