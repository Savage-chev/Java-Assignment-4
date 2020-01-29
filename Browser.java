import java.util.Random;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author (@00533641 Plamen Savchev Group 1.1) 
 * 
 * @version (5.2 06/12/19)
 * 
 * Class Browser adds the functionality to create browsers object which represent potential
 * customers for the Website object. 
 * 
 * */
 
public class Browser
{
    private int iD;                        //Browser's ID
    
    private String email;                  //Browser's email
    
    private int yearOfBirth;               //Browser's year of birth
    
    private boolean isBuyer;               //Have browser been logged in
    
    private Website website;               //Hold value for the website browser is using
    
    private ArrayList<WineCase> basket;      //Filed holding WineCase collection

    /**
     * Default hard-coded constructor for objects of class Browser.Initiating WineCase collection.
     */
    
    public Browser()
    {
        basket = new ArrayList<>();
        iD = 0;
        email = "defaultEmail@hotmail.com";
        yearOfBirth = 1999;
        isBuyer = false;
        website = null;
    }
    
    /**
     * Constructor for objects of class Browser which expect entries
     * for variables email and yearOfBirth. Initiating WineCase collection.
     */
    
    public Browser(String email,int yearOfBirth)
    {
        basket = new ArrayList<>();
        iD = 0;
        this.email = email;
        this.yearOfBirth = yearOfBirth;
        isBuyer = false;
        website = null;
    }
    
    /**
     * Constructor for objects of class Browser which expect entries
     * for variables iD, email and yearOfBirth. Initiating WineCase collection.
     */
    
    public Browser(int iD,String email,int yearOfBirth)
    {
        basket = new ArrayList<>();
        this.iD = iD;
        this.email = email;
        this.yearOfBirth = yearOfBirth;
        isBuyer = true;
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
     * Accessor method that return the value of basket field
     */
    
    public ArrayList<WineCase> getBasket()
    {
        return basket;
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
     * This mutator method is used to mark browser as a buyer once logged in and
     * switch to false if log out.
     */
    
    public void setBuyerStatus()
    {
        if (isBuyer == false)
        {
            isBuyer = true;
        }
        else
        {
            isBuyer = false;
        }
    }
    
    /**
     * This mutator method allow to amend the details of a browser
     */
    
    public void setDetails(String email,int yearOfBirth)
    {
        this.email = email;
        this.yearOfBirth = yearOfBirth;
    }
    
    /**
     * This mutator method is used through self-reference in the website object to
     * amend the website field in browser.
     */
    
    public void setWebsite(Website website)
    {
         this.website = website;
    }
    
    /**
     * Return A string representation of this Browser details.
     */
    
    public String toString()
    {
        String details = "ID: " + iD + ", EMAIL: " + email;
        return details;
    }
    
    /**
     * This mutator method allows logged in browsers to select object from the 
     * WineCase class and store its values in the basket field which holds an 
     * array list and allow more than one object to be stored. Also, the selected
     * product will be printed in the terminal window.
     */
    
    public void selectWineCase(WineCase wineCase)
    {
        if (isBuyer == true)
        {
            basket.add(wineCase);
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
     * Method which if all conditions covered print out the content of the
     * wineCase collection with the help of a while loop.
     */
    
    public void showBasket()
    {
        if (getIsBuyer() == false)
        {
            System.out.print('\u000C');
            System.out.println("Please login or register to preceed to the checkout!");
        }
        else if (basket.size() < 1)
        {
            System.out.print('\u000C');
            System.out.println("Your basket is empty!");
        }
        else
        {
            int index = 0;
            System.out.print('\u000C');
            System.out.println("Your basket:");
            while(index < basket.size())
            {
                WineCase product = basket.get(index);
                System.out.println("(" + index +") " + product);
                index++;
            }
        }
    }
    
    /**
     * Remove a wineCase from the collection selected by index number
     */
    
    public void putWineCaseBack(int index)
    {
        if(index <= basket.size() && index > -1) {
            basket.remove(index);
        }
        showBasket();
        System.out.println("Product removed!");
    }
    
    /**
     * Remove a wineCase from the collection selected by string mathing refNo.
     * While loop with iterator been used.
     */
    
    public void putWineCaseBack(String refNumber)
    {
        Iterator<WineCase> it = basket.iterator();
        while (it.hasNext())
        {
            WineCase wc = it.next();
            String product = wc.getRefNo();
            if(product.equals(refNumber))
            {
                it.remove();
            }
        }
        showBasket();
        System.out.println("Product removed!");
    }
    
    
    /**
     * Remove all the wineCase from the collection with Price more than parameter.
     * While loop with iterator been used.
     */
    
    public void putExpensiveWineCasesBack(double priceLimit) 
    {
        Iterator<WineCase> it = basket.iterator();
        while (it.hasNext())
        {
            WineCase wc = it.next();
            double productPrice = wc.getPrice();
            if(productPrice >= priceLimit)
            {
                it.remove();
            }
        }
        showBasket();
        System.out.println("Product removed!");
    }
    
    /**
     * This mutator method calls the checkout method from the Website object and print 
     * thank you message in the tarminal window afterwords. Also, wineCase field is amended
     * back to null and WineCase collection is cleared.
     */
    
    public void payForWine()
    {
        website.checkout(this);
        System.out.println("*********************************");
        System.out.println("Thank you for your purchase!");
        website.buyerLogout(this);
        basket.clear();
    }
}
