package transaction;

public class Deposit extends Transaction{
	public Deposit() // constructs with DEFAULT_ID, DEFAULT_DATE, and 0.00
	{
		super();
	}
	public Deposit(String aDate, double aAmt) // constructs a deposit with a generated transaction id and received date and amount
	{
		super(aDate, aAmt);
	}
	public Deposit(String aId, String aDate, double aAmt) // constructs a deposit with received values assuming all are valid
	{
		super(aId, aDate, aAmt);
	}
	  // toString override
	public String toString()
	{
		String temp = "";
		temp += "Deposit: ";
		temp += super.toString();
		return temp;
	}
}