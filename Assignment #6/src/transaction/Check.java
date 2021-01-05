package transaction;

public class Check extends Transaction {
	public static final String DEFAULT_RECIPIENT = "$$$$";
	public static final int MAX_NUMBER = 9999;
	private int checkNum;
	private String recipient;
	public Check() // default constructor
	{
		super();
		this.setRecipient(DEFAULT_RECIPIENT);
		this.setCheckNumber(0);
	}
	public Check(String transactionId, String date, double amount, int checkNum, String recipient)// uses received data if valid
	{
		super(transactionId, date, amount);
		this.setCheckNumber(checkNum);
		this.setRecipient(recipient);
	}
	public Check(String date, double amount, int number, String recip) // generates transaction id uses received data
	{
		super(date, amount);
		this.setCheckNumber(number);
		this.setRecipient(recip);
	}
	public void setCheckNumber(int number) //valid checking number
	{
		if(number<0 || number>MAX_NUMBER)
		{
			this.checkNum = 0;
		}
		else {
			this.checkNum = number;
		}
	}
	public void setRecipient(String recip) //setting recip
	{
		recip = utils.MyUtils.properFormat(recip);
		if(recip.equals(""))
		{
			this.recipient = DEFAULT_RECIPIENT;
		}
		else
		{
			this.recipient = recip;
		}
	}
	public int getCheckNumber() //getters
	{
		return this.checkNum;
	}
	public String getRecipient()
	{
		return this.recipient;
	}
	public String toString() // toString
	{
		String temp = "";
		temp += "Check: ";
		temp += super.toString() + " " + this.getCheckNumber() +" " + this.getRecipient();
		return temp;
	}
	
}