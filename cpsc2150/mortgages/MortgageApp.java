/*
    Kenny Nguyen
    Zack Mcgeehan
 */

package cpsc2150.mortgages;

public class MortgageApp {
    public static void main(String[] args){
        IMortgageView view = new MortgageView();
        IMortgageController controller = new MortgageController(view);
        view.setController(controller);
    }
}
