public class BusinessMortgage extends Mortgage {



    public BusinessMortgage(String mortgageNumber, String customerName, double amount, int term, double primeRate)
    {

        super(mortgageNumber, customerName, amount, term, primeRate);

        this._interestRate = primeRate + 1.0;
    }



    @Override
    public void getMortgageInfo() {

        System.out.println("Business Mortgage Details:");
        System.out.println("Mortgage Number: " + _mortgageNumber);
        System.out.println("Customer Name: " + _customerName);
        System.out.println("Amount: $" + _amount);
        System.out.println("Interest Rate: " + _interestRate + "%");
        System.out.println("Term: " + _term + " years");

    }
}
