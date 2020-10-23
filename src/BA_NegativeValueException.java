/**
 * program name: BA_NegativeValueException.java
 * Purpose: handle exception of negative value in the loan text box
 * Coder: Bilal Al-Muhtadi
 * Date: Apr. 4, 2020
 */

public class BA_NegativeValueException extends Exception {

  // constructor
  public BA_NegativeValueException()
  {
      super("Negative value exception triggered");
  }

  /*
   * Method Name: checkLoan()
   * Purpose: method to check if the loan amount is positive
   * Accepts: double
   * Returns: void
   * Date: Apr 12, 2020
   */
  public static void checkLoan(double amount) throws BA_NegativeValueException
  {
      if(amount < 0)
      {
      	throw new BA_NegativeValueException();
      }
          
  }


}//end of class
	

