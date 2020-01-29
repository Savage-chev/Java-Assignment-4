
/**
 * @author (@00533641 Plamen Savchev Group 1.1) 
 * 
 * @version (1.0 18/11/19)
 * 
 * Class WineCase adds functionality to create WineCase object which values might 
 * be inherited by the wineCase field in the Browser object by selecting the object
 * from the object bench after the selectWineCase method is called. The class contain
 * 4 variables for refNo, description, noOfBottles and price.
 * 
 * There are 2 constructor, first of which is default and is hard-coded while the
 * second constructor expect entries for all variables. 
 * 
 * 4 accessor methods allows the field values to be reach from other objects.
 */
public class WineCase
{
    private String refNo;                    //Reference number of the wine
    
    private String description;              //Descprition of the wine
    
    private int noOfBottles;                 //Number of bottles in the case
    
    private double price;                    //Price for the case of wine

    /**
     * Default hard-coded constructor for objects of class WineCase
     */
    
    public WineCase()
    {
        refNo = "W101";
        description = "Altos de Boroja Rioja";
        noOfBottles = 6;
        price = 30;
    }
    
    /**
     * Constructor for objects of class WineCase which expect entries
     * for variables refNo, description, noOfBottles and price.
     */
    
    public WineCase(String refNo, String description, int noOfBottles, double price)
    {
        this.refNo = refNo;
        this.description = description;
        this.noOfBottles = noOfBottles;
        this.price = price;
    }

    /**
     * Accessor method that return the refNo of the WineCase object
     */
    
    public String getRefNo()
    {
        return refNo;
    }
    
    /**
     * Accessor method that return the description of the WineCase object
     */
    
    public String getDescription()
    {
        return description;
    }
    
    /**
     * Accessor method that return the noOfBottles of the WineCase object
     */
    
    public int getNoOfBottles()
    {
        return noOfBottles;
    }
    
    /**
     * Accessor method that return the price of the WineCase object
     */
    
    public double getPrice()
    {
        return price;
    }
}
