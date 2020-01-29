import java.util.Random;

/**
 * @author (@00533641 Plamen Savchev Group 1.1) 
 * 
 * @version (1.0 18/11/19)
 * 
 * Class Browser adds the functionality to create browsers object which represent potential
 * customers for the Website object. The class contain 5 variables for ID, email, 
 * yearOfBirth, isBuyer, wineCase, website. The value of the ID is generated with
 * the help of the Random class. While the second 2 variables receive their values from the 
 * constructor, the last 2 wineCase and website receive their values from the WineCase
 * and Website object respectively.
 * 
 * There are 3 constructors, first of which is default and is hard-coded while
 * the following 2 expecting values for email, yearOfBirth and iD just for the last
 * one.
 * 
 * There are 5 accessor method that return for the iD, email, yearOfBirth, isBuyer
 * and wineCase fields.
 * 
 * There are 6 mutator method within this class, first of which allow us to amend 
 * the iD of the browser. The second method allow us to switch the isBuyer value.
 * The following method editDetails it wasn't requested, however, I found it helpful
 * while testing the age restriction and seems logical browser to be able to amend 
 * its details, therefore I decide to leave it as it is. The next mutator method is
 * the selectWineCase which allow the browser to select object from the WineCase 
 * class it browser is buyer and print message in the terminal window. Next method
 * payForWine call the checkout method from the Website object which is followed
 * by a thank you message in the terminal window. This method also call the newSale 
 * method from the Website object to amend the sales total. Last but not least, the 
 * setWebsite method is accessed from the Website object to amend the value of the 
 * website field.
 * */
 
public class Browser
{
    private int iD;                        //Browser's ID
    
    private String email;                  //Browser's email
    
    private int yearOfBirth;               //Browser's year of birth
    
    private boolean isBuyer;               //Have browser been logged in
    
    private WineCase wineCase;             //Hold value for WineCase object selection
    
    private Website website;               //Hold value for the website browser is using

    /**
     * Default hard-coded constructor for objects of class Browser
     */
    
    public Browser()
    {
        iD = 0;
        email = "defaultEmail@hotmail.com";
        yearOfBirth = 1999;
        isBuyer = false;
        wineCase = null;
        website = null;
    }
    
    /**
     * Constructor for objects of class Browser which expect entries
     * for variables email and yearOfBirth.
     */
    
    public Browser(String email,int yearOfBirth)
    {
        iD = 0;
        this.email = email;
        this.yearOfBirth = yearOfBirth;
        isBuyer = false;
        wineCase = null;
        website = null;
    }
    
    /**
     * Constructor for objects of class Browser which expect entries
     * for variables iD, email and yearOfBirth.
     */
    
    public Browser(int iD,String email,int yearOfBirth)
    {
        this.iD = iD;
        this.email = email;
        this.yearOfBirth = yearOfBirth;
        isBuyer = true;
        wineCase = null;
        website = null;
    }
    
    /**
     * Accessor method that return the iD of the browser object
     */
    
    public int getID()
    {
        return iD;
    }

    /**
     * Accessor method that return the email of the browser object
     */
    
    public String getEmail()
    {
        return email;
    }
    
    /**
     * Accessor method that return the yearOfBirth of the browser object
     */
    
    public int getYearOfBirth()
    {
        return yearOfBirth;
    }
    
    /**
     * Accessor method that return the isBuyer status of the browser object
     */
    
    public boolean getIsBuyer()
    {
        return isBuyer;
    }
    
    /**
     * Accessor method that return the value of wineCase field of the browser object
     */
    
    public WineCase getWineCase()
    {
        return wineCase;
    }
    
    /**
     * This mutator method is used within the Website object to generate and amend 
     * an ID by the Random class for a new buyers.
     */
    
    public void setID(int iD)
    {
        this.iD = iD;
    }
    
    /**
     * This mutator method is used to mark browser as a buyer once logged in. 
     */
    
    public void setBuyerStatus()
    {
        if (isBuyer == false)
        isBuyer = true;
    }
    
    /**
     * This mutator method allow to amend the details of a browser
     */
    
    public void editDetails(String email,int yearOfBirth)
    {
        this.email = email;
        this.yearOfBirth = yearOfBirth;
    }
    
    /**
     * This mutator method allows logged in browsers to select object from the 
     * WineCase class and store its values in the wineCase field. Also, the 
     * selected product will be printed in the terminal window.
     */
    
    public void selectWineCase(WineCase wineCase)
    {
        if (isBuyer == true)
        {
            this.wineCase = wineCase;
            System.out.print('\u000C');
            System.out.println("Buyer " + getID());
            System.out.println("has selected product No: " + wineCase.getRefNo());
            System.out.println("a case of " + wineCase.getDescription());
            System.out.println("with " + wineCase.getNoOfBottles() + " bottles");
            System.out.println("at the price of £" + wineCase.getPrice());
        }
        else
        {
            System.out.print('\u000C');
            System.out.println("Please login into your account!");
        }
    }
    
    /**
     * This mutator method calls the checkout method from the Website object
     * and print thank you message in the tarminal window afterwords. Also, 
     * salesTotal field is amended with the correct amount after the new sale.
     */
    
    public void payForWine()
    {
        website.checkout(this);
        System.out.println("*********************************");
        System.out.println("Thank you for your purchase!");
        if (website.checkHitDiscount())
        {
            website.newSale(website.getSalesTotal() + wineCase.getPrice() * 0.9);
            wineCase = null;
        }
        else
        {
            website.newSale(website.getSalesTotal() + wineCase.getPrice());
            wineCase = null;
        }
    }
    
    /**
     * This mutator method is used through self-reference in the website object to
     * amend the website field in browser.
     */
    
    public void setWebsite(Website website)
    {
         this.website = website;
    }
}
