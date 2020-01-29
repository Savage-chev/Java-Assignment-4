import java.util.Random;
import java.util.ArrayList;

/**
 * @author (@00533641 Plamen Savchev Group 1.1) 
 * 
 * @version (5.2 06/12/19)
 * 
 * Class Website simulates the attempt by cooperative to sell their wines to the public. 
 */

public class Website
{
    private String name;                         //Name of the website
    
    private int hits;                            //How many browser have logged in to the website
    
    private double salesTotal;                   //Total profit made by th website
    
    private int maxNumberOfWineCases;            //Max cases that the basket can hold
    
    private ArrayList<Browser> currentVisitors;  //Field holding browsers collection

    /**
     * Default hard-coded constructor to create objects of class Website.
     * Initiating Browser collection.
     */
    
    public Website()
    {
        name = "Wine Direct";
        hits = 0;
        salesTotal = 0.0;
        maxNumberOfWineCases = 10;
        currentVisitors = new ArrayList<>();
    }

    /**
     * Constructor for objects of class Website which expect entry for the name.
     * Initiating Browser collection.
     */
    
    public Website(String name)
    {
       this.name = name;
       hits = 0;
       salesTotal = 0.0;
       maxNumberOfWineCases = 10;
       currentVisitors = new ArrayList<>();
    }
    
    /**
     * Accessor method that returns sales made by the website.
     */
    
    public double getSalesTotal()
    {
        return salesTotal;
    }
    
    /**
     * Accessor method that returns the hits on the website.
     */
    
    public int getHits()
    {
        return hits;
    }
    
    /**
     * Mutator method that add to sales total.
     */
    
    public void addToSalesTotal(double newSale)
    {
        salesTotal = newSale + salesTotal;
    }
    
    /**
     * Boolean to determine if basket is overloaded depending on the limit.
     */
    
    private boolean basketOverFull(ArrayList<WineCase> basket)
    {
        return basket.size() >= maxNumberOfWineCases;
    }
    
    /**
     * Method which if condition covered print out the content of the
     * Browser collection with the help of a while loop.
     */
    
    public void showVisitors()
    {
        if (currentVisitors.size() < 1)
        {
            System.out.print('\u000C');
            System.out.println("You don't have any visitors at the moment.");
        }
        else
        {
            int index = 0;
            System.out.print('\u000C');
            System.out.println("Visitors list:");
            while(index < currentVisitors.size())
            {
                Browser visitors = currentVisitors.get(index);
                System.out.println("(" + index +") " + visitors);
                index++;
            }
        }
    }
    
    /**
     * Mutator moethod allowing only existing browser to log in. If that is the case
     * the method add a hit to the count.Furthermore, amend the boolean isBuyer to true
     * and the self-reference Website object to the website field within the Browser object.
     * Last,adding new browser details to the browser collection.
     */
    
    public void buyerLogin(Browser browser)
    {
        if (browser.getID() == 0)
        {
            System.out.print('\u000C');
            System.out.println("Please register your account!");
        }
        else
        {
            System.out.print('\u000C');
            System.out.println("Wine Direct welcomes " + browser.getID() + ", you are now logged in");
            browser.setBuyerStatus();
            browser.setWebsite(this);
            currentVisitors.add(browser);
            hits++;
        }
    }
    
    /**
     * Mutator method allowing only browser that is logged in to log out. If that is the case
     * amend the boolean isBuyer and String website to false and null respectively. Also, remove
     * the browser from the Browser collection. Last, print a thank you message in the terminal window.
     */
    
    public void buyerLogout(Browser browser)
    {
        if (browser.getIsBuyer() == true)
        {
            System.out.println("Thank you for your visit. You are now logged out.");
            browser.setBuyerStatus();
            browser.setWebsite(null);
            currentVisitors.remove(browser);
            browser.setID(0);
        }
        else
        {
            System.out.println("You are not logged in!");
        }
    }
    
    /**
     * This mutator method allow new browser to become buyers if they pass the age 
     * and existing customer check. If that is the case, the new buyer will be
     * generated ID which will be associated with their details. The ID generatoion
     * is achieved with the use of an object from the Rendom class. The class is called 
     * within the method to generate number within the bounderies of 1-1000. Once done,
     * the previous mutator mathod buyerLogin is called to login the new browser.
     */
    
    public void becomeBuyer(Browser browser)
    {
        if (2019 - browser.getYearOfBirth() >= 18 && browser.getID() == 0)
        {
           System.out.print('\u000C');
           System.out.println("You are old enough!");
           Random idGenerator = new Random();
           browser.setID(1+idGenerator.nextInt(1000));
           buyerLogin(browser);
        }
        else if (2019 - browser.getYearOfBirth() <= 18)
        {
            System.out.print('\u000C');
            System.out.println("We are sorry! You need to be at least 18 years old in order to register!");
        }
        else if (browser.getID() != 0)
        {
            System.out.print('\u000C');
            System.out.println("This account already exists. Please log in!");
        }
    }
    
    /**
     * Mutator method allows the browser to see the selected product at the checkout.
     * There is a creation of a local variable within this class to allow us to 
     * access the information stored in the basket field/WineCase collection in the 
     * browser class. The method also use a nested if statement. The first if statement
     * is to determine if the browser is logged in the website, basket in not over 
     * limit and if there is any product at all selected by the browser. The second if 
     * statement is to determine if the browser is eligible for discount. The object 
     * from the WineCase collection are printed with the a for-each loop.
     */
    
    public void checkout(Browser browser)
    {
        ArrayList<WineCase> basket = browser.getBasket();
        double runningTotal = 0.0;

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
        else if (basketOverFull(basket) == true)
        {
            System.out.print('\u000C');
            System.out.println("Basket overload! Please remove product.");
        }
        else
        {
            System.out.print('\u000C');
            System.out.println("Wine Direct: Serving customer " + browser.getID());
            System.out.println("    Your basket contains:");
            for(WineCase wineCase : basket)
            {
                System.out.printf("       %s \t\t £%.2f\n",wineCase.getDescription(), wineCase.getPrice());
                runningTotal = runningTotal + wineCase.getPrice();
            }
            if (basket.size() >= 5)
                {
                    runningTotal = runningTotal * 0.9;
                    System.out.println("Congratulation! You are entitled to 10% discount on your purchase!");
                    System.out.println("The Total cost is £" + runningTotal);
                    salesTotal += runningTotal;
                }
                else
                {
                    System.out.println("The Total cost is £" + runningTotal);
                    salesTotal += runningTotal;
                }
        }
    }
}
