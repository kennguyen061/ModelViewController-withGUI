/*
    Kenny Nguyen
    Zack Mcgeehan
 */

package cpsc2150.mortgages;



import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.*;
import javax.swing.border.Border;

public class MortgageView extends JFrame implements IMortgageView, ActionListener {


    private IMortgageController cont;
    private JLabel message;
    private JButton submit;
    private JTextArea nameTxt;
    private JTextArea incomeTxt;
    private JTextArea debtTxt;
    private JTextArea creditScoreTxt;
    private JTextArea houseCostTxt;
    private JTextArea dpTxt;
    private JComboBox yearsCb;
    private JTextArea approvedTxt;
    private JTextArea rateTxt;
    private JTextArea paymentTxt;

    private JLabel nameLbl;
    private JLabel incomeLbl;
    private JLabel debtLbl;
    private JLabel creditScoreLbl;
    private JLabel houseCostLbl;
    private JLabel dpLbl;
    private JLabel yearsLbl;
    private JLabel approvedLbl;
    private JLabel rateLbl;
    private JLabel paymentLbl;

    private JPanel namePnl;
    private JPanel incomePnl;
    private JPanel debtPnl;
    private JPanel creditPnl;
    private JPanel houseCostPnl;
    private JPanel dpPnl;
    private JPanel yearsPnl;
    private JPanel approvedPnl;
    private JPanel ratePnl;
    private JPanel paymentPnl;

    private String [] posYears = {"5", "10", "15", "20", "25", "30"};

    private final int ROWS_IN_GRID = 12;





    public MortgageView(){

        //call super constructor to create the window
        //Pass the title to be used in the top of the window
        super("Mortgage App");

        Border border = BorderFactory.createLineBorder(Color.BLACK);


        //A grid layout helps organize our screen
        this.setLayout(new GridLayout(ROWS_IN_GRID, 1));

        //Create our label that will be used for error messages
        message = new JLabel("Provide Customer and Mortgage information");
        //Add our label to the screen, it will go in the first row in our grid layout
        this.add(message);

        /*The other rows in our layouts will use panels. Our grid layout only has one column in it,but we can use
         a Panel to contain multiple items. That way we can have the label and the text area in the panel and
         essentially have two columns.

         For each row we need to
         initialize the panel
         set the layout for the panel
         initialize the label and text area
         Add the label and text area to the panel
         Add the panel to the screen


         */

        namePnl = new JPanel();
        namePnl.setLayout(new GridLayout(1, 2));
        nameLbl = new JLabel("Name: ");
        nameTxt = new JTextArea();
        nameTxt.setBorder(BorderFactory.createCompoundBorder(border,
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        namePnl.add(nameLbl);
        namePnl.add(nameTxt);
        this.add(namePnl);

        incomePnl = new JPanel();
        incomePnl.setLayout(new GridLayout(1, 2));
        incomeLbl = new JLabel("Yearly Income: ");
        incomeTxt = new JTextArea();
        incomeTxt.setBorder(BorderFactory.createCompoundBorder(border,
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        incomePnl.add(incomeLbl);
        incomePnl.add(incomeTxt);
        this.add(incomePnl);

        debtPnl = new JPanel();
        debtPnl.setLayout(new GridLayout(1, 2));
        debtLbl = new JLabel("Monthly Debt: ");
        debtTxt = new JTextArea();
        debtTxt.setBorder(BorderFactory.createCompoundBorder(border,
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        debtPnl.add(debtLbl);
        debtPnl.add(debtTxt);
        this.add(debtPnl);

        creditPnl = new JPanel();
        creditPnl.setLayout(new GridLayout(1, 2));
        creditScoreLbl = new JLabel("Credit Score: ");
        creditScoreTxt = new JTextArea();
        creditScoreTxt.setBorder(BorderFactory.createCompoundBorder(border,
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        creditPnl.add(creditScoreLbl);
        creditPnl.add(creditScoreTxt);
        this.add(creditPnl);

        houseCostPnl = new JPanel();
        houseCostPnl.setLayout(new GridLayout(1, 2));
        houseCostLbl = new JLabel("House Cost: ");
        houseCostTxt = new JTextArea();
        houseCostTxt.setBorder(BorderFactory.createCompoundBorder(border,
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        houseCostPnl.add(houseCostLbl);
        houseCostPnl.add(houseCostTxt);
        this.add(houseCostPnl);

        dpPnl = new JPanel();
        dpPnl.setLayout(new GridLayout(1, 2));
        dpLbl = new JLabel("Down Payment: ");
        dpTxt = new JTextArea();
        dpTxt.setBorder(BorderFactory.createCompoundBorder(border,
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        dpPnl.add(dpLbl);
        dpPnl.add(dpTxt);
        this.add(dpPnl);

        //Years has a combobox instead of a text area
        yearsPnl = new JPanel();
        yearsPnl.setLayout(new GridLayout(1, 2));
        yearsLbl = new JLabel("Years: ");
        yearsCb = new JComboBox(posYears);
        yearsPnl.add(yearsLbl);
        yearsPnl.add(yearsCb);
        this.add(yearsPnl);

        //Add submit button

        submit = new JButton("Submit");
        //register as observer for the button
        submit.addActionListener(this);
        this.add(submit);

        //output fields work the same, but text boxes are not enabled
        approvedPnl = new JPanel();
        approvedPnl.setLayout(new GridLayout(1, 2));
        approvedLbl = new JLabel("Loan Approved: ");
        approvedTxt = new JTextArea();
        approvedTxt.setBorder(BorderFactory.createCompoundBorder(border,
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        approvedTxt.setEditable(false);
        approvedPnl.add(approvedLbl);
        approvedPnl.add(approvedTxt);
        this.add(approvedPnl);

        ratePnl = new JPanel();
        ratePnl.setLayout(new GridLayout(1, 2));
        rateLbl = new JLabel("Interest Rate: ");
        rateTxt = new JTextArea();
        rateTxt.setBorder(BorderFactory.createCompoundBorder(border,
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        rateTxt.setEditable(false);
        ratePnl.add(rateLbl);
        ratePnl.add(rateTxt);
        this.add(ratePnl);

        paymentPnl = new JPanel();
        paymentPnl.setLayout(new GridLayout(1, 2));
        paymentLbl = new JLabel("Monthly Payment: ");
        paymentTxt = new JTextArea();
        paymentTxt.setBorder(BorderFactory.createCompoundBorder(border,
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        paymentTxt.setEditable(false);
        paymentPnl.add(paymentLbl);
        paymentPnl.add(paymentTxt);
        this.add(paymentPnl);

        //Open the screen
        this.pack();
        this.setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }

    /**
     *
     * @param event the event on the screen that is observed
     * @ensures button events will be sent to the controller
     */
    @Override
    public void actionPerformed(ActionEvent event) {
        /*
         * Set cursor to indicate computation on-going; this matters only if
         * processing the event might take a noticeable amount of time as seen
         * by the user
         */
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        /*
         * Determine which event has occurred that we are being notified of by
         * this callback; in this case, the source of the event (i.e, the widget
         * calling actionPerformed) is all we need because only buttons are
         * involved here, so the event must be a button press; in each case,
         * tell the controller to do whatever is needed to update the model and
         * to refresh the view
         */
        Object source = event.getSource();
        if(source.equals(submit))
        {
            cont.submitApplication();
        }



        /*
         * Set the cursor back to normal (because we changed it at the beginning
         * of the method body)
         */
        this.setCursor(Cursor.getDefaultCursor());
    }

    public void setController(IMortgageController c)
    {
        cont = c;
    }

    public double getHouseCost()
    {

        double cost = Double.parseDouble(houseCostTxt.getText());

        return cost;

    }

    public double getDownPayment()
    {


        double dp = Double.parseDouble(dpTxt.getText());

        return dp;
    }



    public int getYears()
    {

        int y = Integer.parseInt(yearsCb.getSelectedItem().toString());

        return y;
    }

    public double getMonthlyDebt()
    {

        double debt = Double.parseDouble(debtTxt.getText());

        return debt;
    }

    public double getYearlyIncome()
    {

        double income = Double.parseDouble(incomeTxt.getText());

        return income;
    }

    public int getCreditScore()
    {

        int cs = Integer.parseInt(creditScoreTxt.getText());

        return cs;
    }

    public String getName()
    {

        String name = nameTxt.getText();

        return name;
    }

    public void printToUser(String s)
    {
        message.setText(s);
    }

    public void displayPayment(double p)
    {
        paymentTxt.setText("$" + Double.toString(p));

    }

    public void displayRate(double r)
    {
        rateTxt.setText(Double.toString(r*100) + "% APR");
    }

    public void displayApproved(boolean a)
    {
        if(a)
        {
            approvedTxt.setText("Loan Approved");
        }
        else
        {
            approvedTxt.setText("Loan Denied");
        }
    }

    /*
    This method isn't really necessary, the user can just choose in the interface to change the customer info
    So for this interface, this method is always true
     */
    public boolean getAnotherCustomer()
    {
        return true;

    }

    /*
   This method isn't really necessary, the user can just choose in the interface to change the customer info
   So for this interface, this method is always true
    */
    public boolean getAnotherMortgage()
    {
        return true;
    }
}
