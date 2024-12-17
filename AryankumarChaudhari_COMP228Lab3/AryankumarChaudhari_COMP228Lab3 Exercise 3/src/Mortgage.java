public abstract class Mortgage implements MortgageConstants {


    protected String _mortgageNumber;
    protected String _customerName;
    protected double _amount;
    protected double _interestRate;
    protected int _term;



    public Mortgage(String _mortgageNumber, String customerName, double amount, int term, double primeRate) {

        this._mortgageNumber = _mortgageNumber;

        this._customerName = customerName;

        if (amount > MAX_MORTGAGE_AMOUNT) {

            this._amount = MAX_MORTGAGE_AMOUNT;
        } else {

            this._amount = amount;
        }

        if (term != SHORT_TERM && term != MEDIUM_TERM && term != LONG_TERM) {

            this._term = SHORT_TERM;
        }
        else {

            this._term = term;
        }
    }


    public abstract void getMortgageInfo();
}
