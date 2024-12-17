class PartTimeGameTester extends GameTester {
    public float numberOfHours;
    public float hourlyRate;

    public PartTimeGameTester(String name, float hours, float rate) {
        super(name);
        numberOfHours = hours;
        hourlyRate = rate;
    }

    public float calculateSalary() {
        salary = numberOfHours * hourlyRate;
        return salary;
    }
}
