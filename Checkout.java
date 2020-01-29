import java.util.ArrayList;

/**
 * @author (@00533641 Plamen Savchev Group 1.1) 
 * 
 * @version (5.2 06/12/19)
 * 
 * Sub-class of the Website class with the solo purpose to add to prject
 * alternative checkout.
 * 
 * As you can see I didn't had enough time to finish this class. I mean the objects
 * works but the receipt is not as requested on the homework sheet YET! :)
 */
public class Checkout extends Website
{
    /**
     * Constructor for objects of class Checkout2
     */
    public Checkout()
    {
       super();
    }
    
    /**
     * Alternative mutator method to the checkout() in the parent class
     */
    
    public void checkout2(Browser browser)
    {
        ArrayList<WineCase> basket = browser.getBasket(); 
        double runningTotal = 0.0;
        int riojaCount = 0;
        int otherCount = 0;
        
        if (browser.getIsBuyer() == false)
        {
            System.out.print('\u000C');
            System.out.println("Please login or register to preceed to the checkout!");
        }
        else if (basket.size() < 1)
        {
            System.out.print('\u000C');
            System.out.println("Your shopping cart is empty. Please select a product!");
        }
        else
        {
            System.out.print('\u000C');
            System.out.println("Wine Direct: Serving customer " + browser.getID());
            System.out.println("    Your basket contains:");
            for(WineCase wineCase : basket)
            {
                if(wineCase.getRefNo().equalsIgnoreCase("W101"))
                {
                    riojaCount++;
                    runningTotal = runningTotal + wineCase.getPrice();
                }
                else
                {
                    otherCount++;
                    runningTotal = runningTotal + wineCase.getPrice();
                }
            }
            System.out.println("       "+riojaCount+" cases of Rioja");
            System.out.println("       "+otherCount+" cases of other wine");
            if (basket.size() >= 5)
                {
                    runningTotal = runningTotal * 0.9;
                    System.out.println("Congratulation! You are entitled to 10% discount on your purchase!");
                    System.out.println("The Total cost is £" + runningTotal);
                    super.addToSalesTotal(runningTotal);
                }
                else
                {
                    System.out.println("The Total cost is £" + runningTotal);
                    super.addToSalesTotal(runningTotal);
                }
        }
    }
}
