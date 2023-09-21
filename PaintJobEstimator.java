import java.util.Scanner;

public class Main
{
   public static void main(String[] args)
   {
      int numRooms;           // Number of rooms
      double squareFeet;         // Total square feet
      double gallons;         // Gallons of paint needed
      double pricePerGallon;  // Paint price per gallon
      double hours;           // Hours of labor
      double paintCost;       // Total cost of paint
      double labor;           // Labor charges
      double total;          // Total job cost 

      // Get the number of rooms.
      numRooms = getRooms();

      // Get the total square feet.
      squareFeet = getSquareFeet(numRooms);
     
     //Calculate the total number of gallons of paint need.
     gallons = getGallons(squareFeet);

      // Get the total cost.
      total = getTotal(squareFeet);
     
     //Display the number of gallons needed for the work.
     System.out.printf("Number of gallons of paint needed for the work is %,.2f\n", gallons);

      // Display the total cost.
     System.out.printf(
                     "The total estimated cost is $%,.2f",
                     total);

   }

   /**
      The getRooms method prompts the user for the number
      of rooms.
      @return The value entered by the user.
   */

   public static int getRooms()
   {
     Scanner keyboard = new Scanner(System.in);
     int numRooms;
     System.out.println("How many rooms are to be painted?");
     numRooms = keyboard.nextInt();
     while (numRooms <= 0)
       {
         System.out.println("You have entered an invalid number. Number of rooms should be greater than Zero(0). Please, enter the number of rooms that are to be painted.");
       numRooms = keyboard.nextInt();
       }
     
     return numRooms;

   }

   /**
      The getSquareFeet method calculates the total square feet.
      @param rooms The number of rooms.
      @return The total square feet.
   */

   public static double getSquareFeet(int numRooms)
  {
     Scanner keyboard = new Scanner(System.in); 
     double totalSquareFeet = 0.0;
    for (int i = 1; i <= numRooms; i++)
      {
        double squareFeet;
        do
          {
        System.out.println("What is the square feet of wall space in room " + i +" ?");
     squareFeet = keyboard.nextDouble();
    
     if (squareFeet <= 0)
       {
       System.out.println("Please enter a valid number for the square feet of wall space in each room. Your entry should be greater than Zero(0)");
     squareFeet = keyboard.nextInt();
       }
            else
     {
       totalSquareFeet += squareFeet;
       break;
     }
          }
        while (true);
      }
        
        return totalSquareFeet;
     

   }

   /**
      The getTotal method calculates the total job estimate.
      @param squareFeet The total square feet.
      @return The estimated total.
   */

   public static double getTotal(double squareFeet)
   {
     double gallons = getGallons(squareFeet);
     double hours = getHours(squareFeet);
     double galPrice = getPricePerGallon();
     double paintCost = getPaintCost(squareFeet, galPrice);
     double labor = getLabor(hours);
     double total = labor + paintCost;

     return total;
 
   }

   /**
      The getPricePerGallon method prompts the user for the price
      of a gallon of paint.
      @return The value entered by the user.
   */

   public static double getPricePerGallon()
  {
    Scanner keyboard = new Scanner(System.in); 
     double pricePerGallon;
    do 
      {
     System.out.println("What is the price of paint per gallon?");
     pricePerGallon = keyboard.nextDouble();
    if (pricePerGallon <= 0)
    {
      System.out.println("You have made an invalid entry. Price of paint per gallon should be greater than Zero(0). Please enter a valid price.");
    }
      }
      while (pricePerGallon <= 0);
     
     return pricePerGallon;
     

   }

   /**
      The getPaintCost method calculates the total cost of paint.
      @param sqFeet The total square feet.
      @param pricePerGallon The price of a gallon of paint.
      @return The estimated total paint cost.
   */

   public static double getPaintCost(double sqFeet, double pricePerGallon)
   {
     double gallons = getGallons(sqFeet);
     double paintCost = gallons * pricePerGallon;
     System.out.printf("The estimated cost of paint to be used is $%,.2f\n", paintCost);
     return paintCost;

   }

   /**
      The getGallons method calculates the gallons of paint.
      @param sqFeet The total square feet.
      @return The estimated number of gallons.
   */

   public static double getGallons(double sqFeet)
   {
     double gallons = (sqFeet / 113.0);
     
     return gallons;
 
   }

   /**
      The getHours method calculates the number of labor hours.
      @param sqFeet The total square feet.
      @return The estimated number of labor hours.
   */

   public static double getHours(double squareFeet)
   {
     double hours = (squareFeet / 113.0) * 8.0;
     System.out.printf("The estimated hours of labor is %,.2f hours\n",hours);
     return hours;

   }

   /**
      The getLabor method calculates the total labor cost.
      @param hours The number of labor hours.
      @return The estimated cost of labor.
   */

   public static double getLabor(double hours)
   {
     double laborCostPerHour = 20.0;
     double labor = laborCostPerHour * hours;
     System.out.printf("The total labor cost is $%,.2f\n", labor);
     return labor;

   }
}

