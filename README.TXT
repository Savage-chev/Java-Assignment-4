SOFTWARE: BlueJ(IDE)
BOOK: Object First with Java | Sixth Edition | Chapter 5
PROJECT TITLE: Wine Direct using Basket
PURPOSE OF PROJECT: University weekly assignment
VERSION or DATE: 13 December 2019
AUTHOR: Plamen Savchev 

ASSIGNMENT INSTRUCTIONS:

Individual Assessed Coursework 4
November 2019

Scenario: this homework extends the previous homework concerning Wine Direct, a cooperative which sells their wine directly to the public. It is therefore assumed that your model satisfies the requirements of the previous homework.

One of the deficiencies on the previous homework was the fact that your project only allowed one wine case at a time to be purchased each time that you shopped. You could not keep track of several wine cases at a time because you were not familiar with the ArrayList class which was introduced in Chapter 4 and which is most suitable for this purpose. 

It is important before you proceed that you have worked your way through both the Notebook class and the Zoo class examples (from the module book and the lectures respectively).

Your homework is to now enhance your existing model with the functionality detailed below. Steps 1, 2 and 3 are mainly concerned with transforming the code from your earlier homework to the new situation and have been described in some detail in order to help you. Step 4 requires you to add extra functionality whilst Step 5 gives you the opportunity to obtain higher grades with methods which "add extra value to" your code. You may choose other methods than the ones suggested if you wish.

Step 1:
Start with a project which you should call "Wine Direct using Basket Step 1".

Firstly, make sure that checkout() in WebSite only takes a single parameter as we spoke about in the workshop. 

The rest of this step is concerned with providing a Test class, similar to the example which Dr Newton went over in the workshops, to allow easy and quick testing of your code.  A very simple Test class is available on BlackBoard but it needs significant improvement if it is to confirm that your code works reliably in all circumstances.  Marks will be awarded for evidence of good testing of the software that you have developed.

For this step, add code to the Test class which tests that your Homework 3 works well. 

When you have successfully completed Step 1, save your project (using the Save As option) as Wine Direct using Basket Step 2 and continue to the next step.  Use the Save As option in a similar way at the end of each subsequent step. 

For each of the following steps, you should re-compile your project after making changes to your code and test by building up your Test class as you go along!

Step 2: Allow a browser with an ID to select multiple wine cases before going to the checkout
a)	In order to store wine cases selected by a buyer, introduce basket as a field in the Browser class. It should be declared to be an ArrayList collection class object and it should have a declaration similar to that of animalCollection in the Zoo class.  You will also need an import statement.  The field basket will eventually replace the wineCase field but do not remove the wineCase field at this point as otherwise your code will not compile.
b)	Modify the Browser class's selectWineCase() so that any wine case that is selected is added to the basket i.e. to the ArrayList object basket.
c)	Add a toString() method to the WineCase class if you do not already have one.  See the Animal class or the Lot class for similar methods.
d)	Using a while loop with a counter, write a new method showBasket() for the Browser class.  It should print out the details of each wine case in the shopping basket using the wine case's toString() method. 

Test your code by making sure that a browser can select wine cases and show the basket.  But do not proceed to the checkout -- the Website class also needs modifying .  

 
Step 3: Amend the checkout() method so that all the wine cases in a browser's basket are processed
a)	Introduce a getBasket() method in the Browser class -- it will eventually replace your getWineCase() method.  Note that this new method returns an ArrayList object.
b)	Modify the checkout() method in the Website class so that a call to the browser's getBasket() method is added.  Do not remove the original call to the getWineCase() method at the moment or your code will not compile but eventually it will be removed.
c)	Now, remove the field wineCase and the method getWineCase() (from the Browser class).  The project will (probably) not compile due to the code which works out the price of the wine. In which case, simply comment out this code temporarily. 
d)	The checkout() method will now need to process all of the wine cases in the basket. For this you will need a loop, a "running total" and each time round the loop you will "retrieve" a wine case from the basket.  A for-each loop should be used. For the moment, do not concern yourself with any discount as this will be dealt with in Part f) below. 

This method should also provide a receipt and an example of a receipt is shown below:
Wine Direct: Serving customer 4675
  Your basket contains:
    Chablis              £200
    NZ Sauvignon Blanc   £540

The total cost is        £740

-- you get better marks if you obtain neatly aligned columns . 
e)	If you haven't already done so, log the browser out of the website after a successful purchase and make sure that the shopping basket of that browser is emptied.  Look in the JDK documentation for the ArrayList in order to find a suitable method.
f)	Finally, change the discount available to give a 10% discount only if at least five cases of wine are purchased.

Don’t forget to re-compile after each of these parts and again build up your Test class as you go along.


Step 4: Allow a browser to "put back" wine cases
Methods to put back wine cases might be used because a browser changes their mind about a wine case or because they have insufficient money to pay when they go to the checkout.  Do not attempt to include these methods with the checkout process -- if a buyer has insufficient money to pay then they should simply use one or other of these methods to reduce the number of wine cases and then go to the checkout again.
a)	Write a method putWineCaseBack()for the Browser class which removes a wine case from the shopping basket.  It is passed an int parameter indicating the position in the list of the wine case you wish to remove.  The correct position can be determined by calling the method showBasket().
b)	Write a second method putWineCaseBack()for the Browser class that is passed a String parameter indicating the reference number of the wine case to be removed.  Note that this method has the same name as the method in Part a) but has a different signature. This method should use a while loop.
c)	Add a field maxMumberOfWineCases to the Website class that stores the maximum number of wine cases that the basket should hold and initialise it to a suitable value.  Next, write a method basketOverFull(), also for the Website class, that is passed an object representing the basket. The method should be called from checkout() and if the basket does not contain more than the limit then it returns false, otherwise it returns true.
d)	Write a method putExpensiveWineCasesBack()for the Browser class which removes wine cases with a price greater than or equal to a specified amount that is passed as a parameter.  Hint: Worksheet 4 explains the pitfalls of removing elements whilst in a loop: read this carefully. 


 
Step 5: 
The following are suggestions for other methods to obtain the higher marks and / or to enhance your code even further. These methods will be worth a maximum of 15% of the total marks for this homework.

a)	Write a method that shows the details of all those presently logged on to the website.  Before writing this method, you will need to add a new feature to the Website class. 

b)	Write an alternative checkout() method that keeps count of multiple wine cases and then prints out a receipt using this information.  For example:
Wine Direct: Serving customer 4675
  Your basket contains:
    2 cases of Chablis at £200 per case i.e. £400
    3 cases of NZ Sauvignon Blanc at £540 i.e. £1620

The total cost is £2020

Hint: to do this logically, you need to introduce a new class based extensively on one of your existing classes. However, this "new" class would still be a rather basic class.

c)	The company decides to expand utilising several websites. Write basic code to allow for this. 
You may, of course, decide to write other suitable methods of your own choice which enhance your code. 



Hand in details: 
•	You will need to submit a hard copy of the source code for your project.  Your name should be on the first page with your group number.  All work should be handed in inside a clear plastic wallet and should be handed in to Dr Newton by 12.00 on Friday December 6th 2019.

Note that by the act of following these instructions and handing your work in, it is deemed that you have read and understand the rules on plagiarism as written in your student handbook.


