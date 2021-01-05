package transaction;

public class DebitCard extends Transaction{
	public static final String DEFAULT_LOCATION = "$$$$";
	private String placeOfPurchase;
	public DebitCard() // default constructor
	{
		super();
		this.setPurchaseLocation(DEFAULT_LOCATION);
	}
	public DebitCard(String transactionId, String date, double amount, String placeOfPurchase)// uses received data if valid
	{
		super(transactionId, date, amount);
		this.setPurchaseLocation(placeOfPurchase);
	}
	public DebitCard(String date, double amount, String theLocation) // generates transaction id uses received data
	{
		super(date, amount);
		this.setPurchaseLocation(theLocation);
	}
	public void setPurchaseLocation(String location)
	{
		location = utils.MyUtils.properFormat(location);
		if(location.equals(""))
		{
			this.placeOfPurchase = DEFAULT_LOCATION;
		}
		else
		{
			this.placeOfPurchase = location;
		}
	}
	public String getPurchaseLocation()
	{
		return this.placeOfPurchase;
	}
	public String toString()
	{
		String temp = "";
		temp += "DebitCard: ";
		temp += super.toString() + " "+this.getPurchaseLocation();
		return temp;
	}
}