/*
    Kenny Nguyen
    Zack Mcgeehan
 */


package cpsc2150.mortgages;

import javax.swing.*;

public class Mortgage extends AbsMortgage {

    private double principal;
    private int years;
    private double APR;
    private double percentDown;
    private ICustomer cust;


    /**
     *
     * @param cost cost of the house
     * @param down down payment on the house
     * @param y how many years the loan is for
     * @param customer the customer applying for the loan
     * @requires y >= MIN_YEARS and down > 0 and cost > 0
     * @ensures principal = cost and percentDown = down / cost and years = y and cust = customer
     */
    Mortgage(double cost, double down, int y, ICustomer customer){

        APR = IMortgage.BASERATE;
        years = y;
        principal = cost - down;
        percentDown = down / cost;
        cust = customer;

        if(y >= MAX_YEARS){
            APR += IMortgage.NORMALRATEADD;
        }else{
            APR += IMortgage.GOODRATEADD;
        }

        if(percentDown < IMortgage.PREFERRED_PERCENT_DOWN){
            APR += IMortgage.GOODRATEADD;
        }

        if(customer.getCreditScore() < IMortgage.BADCREDIT){
            APR += IMortgage.VERYBADRATEADD;
        }else if(customer.getCreditScore() >= IMortgage.BADCREDIT && customer.getCreditScore() < IMortgage.FAIRCREDIT){
            APR += IMortgage.BADRATEADD;
        }else if(customer.getCreditScore() >= IMortgage.FAIRCREDIT && customer.getCreditScore() < IMortgage.GOODCREDIT){
            APR += IMortgage.NORMALRATEADD;
        }else if(customer.getCreditScore() >= IMortgage.GOODCREDIT && customer.getCreditScore() < IMortgage.GREATCREDIT) {
            APR += IMortgage.GOODRATEADD;
        }

    }

    private double debtToInc(ICustomer customer){
        double monthlyIncome = customer.getIncome() / 12;
        double monthlyDebt = customer.getMonthlyDebtPayments();
        double monthlyLoanPayment = this.getPayment();

        return (monthlyDebt + monthlyLoanPayment) / monthlyIncome;
    }
    @Override
    public boolean loanApproved() {
        if(this.APR >= IMortgage.RATETOOHIGH){
            return false;
        }
        if(this.percentDown <= IMortgage.MIN_PERCENT_DOWN){
            return false;
        }
        if(this.debtToInc(this.cust) > IMortgage.DTOITOOHIGH){
            return false;
        }
        return true;
    }

    @Override
    public double getPayment() {

        return ((this.APR / 12) * this.principal) / (1 - Math.pow((1 + (this.APR / 12)), -(this.years * 12)));
    }

    @Override
    public double getRate() {
        return this.APR;
    }

    @Override
    public double getPrincipal() {
        return this.principal;
    }

    @Override
    public int getYears() {
        return this.years;
    }
}
