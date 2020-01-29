/**
 * @author (@00533641 Plamen Savchev Group 1.1) 
 * 
 * @version (5.2 06/12/19)
 * 
 * This class solo function is to test the methods from the Browser, Website 
 * and WineCase objects. NOTE! As requested at the end I added all the external 
 * method calls to the constructor and commented them,however, I have method call
 * within a separete methods which I prefered to use while working.
 */

public class Test
{
    public Browser browser;    //Hold information for the browser object
    
    public Website website;    //Hold information for the website object
    
    public WineCase wineCase;  //Hold information for the winecase object
    
    public Checkout checkout;  //Hold information for the checkout object

    /**
     * Constructor for objects of class Test. Because I have default constructor
     * in every class I don't need to pass any parameters to create objects.
     */
    
    public Test()
    {
        //STEP 1 CHECKING
        
        browser = new Browser();  //Creating new object of the type browser
        
        //browser.setBuyerStatus(); //Boolean to change buyer status
        
        //browser.selectWineCase(wineCase); //Saves WineCase object to wineCase field
        
        //browser.payForWine();  //Calling checkout method from website object
        
        //browser.showBasket();  //print the information from baasket array list
        
        //browser.putWineCaseBack(0);  //return the wine selected by integer parameter
        
        //browser.putWineCaseBack("W101");  //return the wine selected by string parameter
        
        //browser.putExpensiveWineCasesBack(31.0);  //retrun all wines with price more than parameter
        
        //STEP 2 CHECKING
        
        website = new Website();  //Creating new object of the type website
        
        //website.buyerLogin(browser); //Changing id, buyer stat and add visitor
        
        //website.buyerLogout(browser); //Changing id, buyer stat and remove visitor
        
        //website.becomeBuyer(browser); //Gen ID and call buyer login method
        
        //website.checkout(browser); //if all if condition covered print products
        
        //website.showVisitors(); //shows current visitors to the website
        
        //website.basketOverFull(); //boolean to determine in basket over limit
        
        //STEP 3 CHECKING
        
        wineCase = new WineCase();  //Creating new object of the type winecase
        
        //STEP 4 CHECKING
        
        checkout = new Checkout();  //Creating new object of the type checkout
        
        //checkout.checkout2(browser);  //if all if condition covered print products
    }
    
    public void checkSetBuyerStatus()
    {
        browser.setBuyerStatus();
    }

    public void checkLogin()
    {
        website.buyerLogin(browser);
    }
    
    public void checkLogout()
    {
        website.buyerLogout(browser);
    }
    
    public void checkBecomeBuyer()
    {
        website.becomeBuyer(browser);
    }
    
    public void checkCheckout()
    {
        website.checkout(browser);
    }
    
    public void checkSelectWineCase()
    {
        browser.selectWineCase(wineCase);
    }
    
    public void checkPayForWine()
    {
        browser.payForWine();
    }
    
    public void checkShowBasket()
    {
        browser.showBasket();
    }
    
    public void checkShowVisitors()
    {
        website.showVisitors();
    }
    
    public void checkPutWineCaseBack1()
    {
        browser.putWineCaseBack(0);
    }
    
    public void checkPutWineCaseBack2()
    {
        browser.putWineCaseBack("W101");
    }
    
    public void checkPutExpensiveWineCasesBack()
    {
        browser.putExpensiveWineCasesBack(31.0);
    }
    
    public void checkCheckout2()
    {
        checkout.checkout2(browser);
    }
}
