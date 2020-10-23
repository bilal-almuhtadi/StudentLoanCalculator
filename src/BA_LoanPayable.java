/**
 * program name: BA_LoanPayable.java
 * Purpose: 
 * Coder: Bilal Al-Muhtadi
 * Date: Apr. 4, 2020
 */

public interface BA_LoanPayable
{
final double ANNUAL_RATE_TO_MONTHLY_RATE = 1.00/1200.00;

/*
 * Method Name: calculateLoanPayment()
 * Purpose: will calculate the loan payment amount
 * Accepts: double representing the OSL or CSL principal amount, a double representing the annual prime interest rate, 
 * 					and an int value that represents the amortization period in months.
 * Returns: double that represents the loan payment amount
 * Date: Apr 12, 2020
 */
public double calculateLoanPayment(double loanAmount, double primeAnualInterestRate, int months);
}
//end class