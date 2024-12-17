public class PersonalMortgage extends Mortgage {



    public PersonalMortgage(String mortgageNumber, String customerName, double amount, int term, double primeRate) {

        super(mortgageNumber, customerName, amount, term, primeRate);


        this._interestRate = primeRate + 2.0; // 2% over prime rate
    }

    @Override
    public void getMortgageInfo() {


        System.out.println("Personal Mortgage Details:");
        System.out.println("Mortgage Number: " + _mortgageNumber);
        System.out.println("Customer Name: " + _customerName);
        System.out.println("Amount:$" + _amount);
        System.out.println("Interest Rate: " + _interestRate + "%");
        System.out.println("Term: " + _term + " years");

    }
}
