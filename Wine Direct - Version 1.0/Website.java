import java.util.Random;

/**
 * @author (@00533641 Plamen Savchev Group 1.1) 
 * 
 * @version (1.0 18/11/19)
 * 
 * Class Website simulates the attempt by cooperative to sell their wines to the public.
 * The class have hard-coded constructor and second one that expects entry for the name.
 * Both construston contain int variable counting the people that login to the website
 * and double variable calculating the sales made by the website.
 * 
 * There is 1 accessor methods first of which is return the salesTotal and will be
 * used by the browser object from the Browser class to add to it if browser use the 
 * payForWine method.
 * 
 * There are 5 mutator methods first of which is newSale. That method allows us to
 * amend the salesTotol from the browser object once the visitor decide to pay for the 
 * wine. The following method buyerLogin allow existing browser to login to the website
 * and ammend the hits field within website and isBuyer,website fields in the browser 
 * class. The next mutator method is becomeBuyer. The fucntion of this method is to 
 * determine if the browser is old enough to register and if he is a new user. Once the 
 * age and acount check are complieted, the method calls the previous method buyerLogin.
 * Last but not least, we have the checkout() mutator method which contain a nested
 * if statement. The method checks if browser is a buyer(logged in) and if there is 
 * anything in your shopping cart. If that's the case the second if statemnt is to 
 * determine if the browser is eligible for discount. Last but not least, CheckHitDescount 
 * method which allows the website to determine if the browser is eligible for discount. 
 * The second method is used whithin this and the brawser class.
 * 
 */

public class Website
{
    private String name;              //Name of the website
    
    private int hits;                 //How many browser have logged in to the website
    
    private double salesTotal;        //Total profit made by th website

    /**
     * Default hard-coded constructor to create objects of class Website.
     */
    
    public Website()
    {
        name = "Wine Direct";
        hits = 0;
        salesTotal = 0.0;
    }

    /**
     * Constructor for objects of class Website which expect entry for the name.
     */
    
    public Website(String name)
    {
       this.name = name;
       hits = 0;
       salesTotal = 0.0;
    }
    
    /**
     * Accessor method that returns sales made by the website. Needed within the
     * browser object in order to amend the amount once theForWine method is used.
     */
    
    public double getSalesTotal()
    {
        return salesTotal;
    }
    
    /**
     * Mutator method that update the salesTotal field. Needed by the 
     * browser object in order to amend the amount once theForWine method is used.
     */
    
    public void newSale(double salesTotal)
    {
        this.salesTotal = salesTotal;
    }
    
    /**
     * Mutator moethod allowing only existing browser to log in. If that is the case
     * the method add a hit to the count.Furthermore, amend the boolean isBuyer to true
     * and the self-reference Website object to the website field within the Browser object.
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
            System.out.println("Wine Direct welcomes " + browser.getEmail() + ", you are now logged in");
            browser.setBuyerStatus();
            browser.setWebsite(this);
            hits++;
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
            System.out.println("This acount already exists. Please log in!");
        }
    }
    
    /**
     * Mutator method allows the browser to see the selected product at the checkout.
     * There is a creation of a local variable within this class to allow us to 
     * access the information stored in the wineCase field in the browser class.
     * The method also use a nested if statement. The first if statement is to 
     * determine if the browser is logged in the website and if there is any product
     * selected by the browser. The second if statement is to determine if the browser 
     * is eligible for discount.
     */
    
    public void checkout(Browser browser)
    {
        WineCase wineCase = browser.getWineCase();         
        
        if (browser.getIsBuyer() == false)
        {
            System.out.print('\u000C');
            System.out.println("Please login or register to preceed to the checkout!");
        }
        else if (wineCase == null)
        {
            System.out.print('\u000C');
            System.out.println("Your shopping cart is empty. Please select a product!");
        }
        else
        {
            if (checkHitDiscount())
            {
                System.out.print('\u000C');
                System.out.println("Congratiolation! You are entitled to 10% discount on your purchase!");
                System.out.println("Product: " + wineCase.getRefNo());
                System.out.println("Descpription: " + wineCase.getDescription());
                System.out.println("Number of bottles: " + wineCase.getNoOfBottles());
                System.out.println("The current price of £" + wineCase.getPrice() + " has been reduced to £" + wineCase.getPrice() * 0.9);
                System.out.println("Total: £" + wineCase.getPrice() * 0.9);
            }
            else
            {
                System.out.print('\u000C');
                System.out.println("Product: " + wineCase.getRefNo());
                System.out.println("Descpription: " + wineCase.getDescription());
                System.out.println("Number of bottles: " + wineCase.getNoOfBottles());
                System.out.println("Total: £" + wineCase.getPrice());
            }
        }
    }
    
    /**
     * This method helps the website to determine which browsers are eligible for
     * discount. The method returns a boolean value which returns true if the browsers
     * login hit divided by 10 does NOT have a reminder.
     */
    
    public boolean checkHitDiscount()
    {
        if (hits % 10 == 0) 
        {
            return true;
        }
        else
        {
            return false;
        }
        
    }
}
