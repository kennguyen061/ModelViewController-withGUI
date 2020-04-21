/*
    Kenny Nguyen
    Zack Mcgeehan
 */


package cpsc2150.mortgages;

public class MortgageController implements IMortgageController {
    private IMortgageView view;

    MortgageController(IMortgageView v){
        view = v;
    }


    @Override
    public void submitApplication() {

        ICustomer customer;

        //Get the customer's name
        String name = view.getName();
        //Get the customer's yearly income
        double income = view.getYearlyIncome();
        //If income is less than or equal to 0 say income must be greater than 0
        if(income <= 0) {
            view.printToUser("Income must be greater than 0");
        }


        //Get customer's monthly debt payments
        double monthlyDebtPayments = view.getMonthlyDebt();
        //If monthly debt is less than 0 print error to customer and get input again
        if(monthlyDebtPayments < 0) {
            view.printToUser("Debt must be greater than or equal to 0");
        }


        //Get customer's credit score
        int creditScore = view.getCreditScore();
        //If credit is less than 0 or greater than max print that and get input again
        if(creditScore < 0 || creditScore > ICustomer.MAX_CREDIT_SCORE) {
            view.printToUser("Credit score must be greater than 0 and less than " + ICustomer.MAX_CREDIT_SCORE);
        }


        //Call customer constructor with given inputs
        customer = new Customer(monthlyDebtPayments, income, creditScore, name);
        //Get cost of the house
        double cost = view.getHouseCost();
        //If house costs less than 0 print error
        if(cost < 0) {
            view.printToUser("Cost must be greater than 0");
        }

        //Get down payment on house
        double down = view.getDownPayment();
        //If down is greater than cost of house or less than 0 print error message
        if(down < 0 || down > cost) {
            view.printToUser("Down payment must be greater than 0 and less than the cost of the house");
        }

        //Get years for mortgage
        int years = view.getYears();

        //If meet all requirements apply for loan and display results
        if(income > 0 && monthlyDebtPayments > 0 && creditScore > 0 && creditScore < ICustomer.MAX_CREDIT_SCORE && cost > 0 && down > 0 && down < cost) {
            view.displayApproved(customer.applyForLoan(down, cost, years));
            view.displayRate(customer.getRate());
            view.displayPayment(customer.getMonthlyPay());
            view.printToUser("Provide Customer and Mortgage information");
        }

    }
}
