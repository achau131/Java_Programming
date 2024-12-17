abstract class GameTester {


    public String name;
    public boolean gameTesterType;
    public float salary;


    public GameTester(String name) {
        setName(name);

    }

    public String getName() {

        return name;
    }

    public float getSalary() {
        return salary;

    }

    public void setName(String name) {
        this.name = name;

    }

    public abstract float calculateSalary();
}

