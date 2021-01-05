package asg5;

public class BankAccount {
	public final static String DEFAULT_ACCOUNT_NUMBER = "xxxxxx";
	public final static String DEFAULT_NAME = "$$$$";
	private String lastName;
	private String firstName;
	private String accountNumber;
	private double balance;
	private AccountType accountType;
	private BusinessType businessType;
	// default constructor, creates a default BankAccount instance
    // account number: xxxxxx, first and last names: $$$$, account type: CHECKING,
    // business type: PERSONAL
	public BankAccount()
	{
		this.setAccountNumber(DEFAULT_ACCOUNT_NUMBER);
		this.setFirstName("$$$$");
		this.setLastName("$$$$");
		this.setAccountType(AccountType.CHECKING);
		this.setBusinessType(BusinessType.PERSONAL);
	}
	 // creates BankAccount instance with given data, if any received data is invalid
     // puts default value into field (name: $$$$, accountnumber: xxxxxx)
	 public BankAccount(String aAccountNumber, String aLastName, String aFirstName,AccountType aAccountType, BusinessType aBusinessType, double aBalance)
	 {
		this.setAccountNumber(aAccountNumber);
		this.setFirstName(aFirstName);
		this.setLastName(aLastName);
		this.setAccountType(aAccountType);
		this.setBusinessType(aBusinessType);
		this.setBalance(aBalance);
	 }
	 public String getFirstName()// returns the first name of this BankAccount
	 {
		 return this.firstName;
	 }
	 public String getLastName()// returns the last name of this BankAccount
	 {
		 return this.lastName;
	 }
	 public String getAccountNumber() // returns the account number of this BankAccount
	 {
		 return this.accountNumber;
	 }
	 public double getBalance() // returns the balance of this BankAccount
	 {
		 return this.balance;
	 }
	 public AccountType  getAccountType() // returns the account type of this BankAccount
	 {
		 return this.accountType;
	 }
	 public BusinessType getBusinessType() // returns the business type  of this BankAccount
	 {
		 return this.businessType;
	 }
	 public void setLastName(String aName) //sets this BankAccount's last name to aName AFTER calling
     // utils.MyUtils.properFormat() method on it remember no empty  names allowed
	 {
		 int count = 0;
		 String temp = "";
		 temp = utils.MyUtils.properFormat(aName);
		 temp = temp.toLowerCase();
		 for (int index = 0; index<temp.length(); index++)
			{
				char ch = temp.charAt(index);
				if(Character.isLetter(ch))
				{
					count += 1;
				}
				
			}
		 if(count < 1 || temp.isEmpty())
		 {
			 this.lastName = DEFAULT_NAME;
		 }
		 else {
			 String temp2 ="";
			 String temp3 = "";
			 temp2+= temp.charAt(0);
			 temp2 = temp2.toUpperCase();
			 for(int index= 1; index<temp.length(); index++)
			 {
				 char ch2 = temp.charAt(index);
				 if(ch2 == ' ')
				 {
					 temp3 += temp.charAt(index+1);
					 temp3 = temp3.toUpperCase();
					 temp2 += " " + temp3;
					 index++;
				 }
				 else
				 {
					 temp2 += ch2;
				 }
			 }
			 this.lastName = temp2;
		 }
		
	 }
	 public void setFirstName(String aName) //sets this BankAccount's first name to aName AFTER calling
     // utils.MyUtils.properFormat() method on it remember no empty  names allowed
	 {
		 int count = 0;
		 String temp = "";
		 temp = utils.MyUtils.properFormat(aName);
		 temp = temp.toLowerCase();
		 for (int index = 0; index<temp.length(); index++)
			{
				char ch = temp.charAt(index);
				if(Character.isLetter(ch))
				{
					count += 1;
				}
				
			}
		 if(count < 1 || temp.isEmpty())
		 {
			 this.firstName = DEFAULT_NAME;
			 return;
		 }
		 else {
			 String temp2 ="";
			 String temp3 = "";
			 temp2+= temp.charAt(0);
			 temp2 = temp2.toUpperCase();
			 for(int index= 1; index<temp.length(); index++)
			 {
				 char ch2 = temp.charAt(index);
				 if(ch2 == ' ')
				 {
					 temp3 += temp.charAt(index+1);
					 temp3 = temp3.toUpperCase();
					 temp2 += " " + temp3;
					 index++;
				 }
				 else
				 {
					 temp2 += ch2;
				 }
			 }
			 this.firstName = temp2;
		 }
	 }
	 public void setAccountNumber(String aAccountNumber) // sets account number to received value or default
            // if received value is invalid (must be 6 lowercaseletters and digits only).
	 {
		 int count = 0;
		 for(int index =0; index<aAccountNumber.length();index++)
		 {
			 char ch = aAccountNumber.charAt(index);
			 if(Character.isLetter(ch) || Character.isDigit(ch))
			 {
				 count += 1;
			 }
		 }
		 if(count!= 6 || aAccountNumber.isEmpty())
		 {
			 this.accountNumber = DEFAULT_ACCOUNT_NUMBER;
			 return;
		 }
		 else
		 {
			 aAccountNumber = aAccountNumber.toLowerCase();
			 this.accountNumber = aAccountNumber;
		 }
	 }
	 public void setBalance(double aBalance) // sets this BankAccount's balance to received balance
	 {
		 this.balance = aBalance;
	 }
	 public void setAccountType(AccountType aType)  //sets this BankAccount's account type to the received enum value
	 {
		 this.accountType = aType;
	 }
	 public void setBusinessType(BusinessType aType) // sets this BankAccount's business type to the received enum value
	 {
		 this.businessType = aType;
	 }
	 public boolean equals(Object obj)
	 {
		 if(this == obj)
		 {
			 return true;
		 }
		 if(obj==null) {
			 return false;
		 }
		 if(!(obj instanceof BankAccount))
		 {
			 return false;
		 }
		 BankAccount bankAccount = (BankAccount)obj;
		 if(!(this.getAccountNumber().equals(bankAccount.getAccountNumber())))
		 {
			 return false;
		 }
		 if(!(this.getLastName().equals(bankAccount.getLastName())))
		 {
			 return false;
		 }
		 if(!(this.getFirstName().equals(bankAccount.getFirstName())))
		 {
			 return false;
		 }
		 if(!(this.getAccountType().equals(bankAccount.getAccountType())))
		 {
			 return false;
		 }
		 if(!(this.getBusinessType().equals(bankAccount.getBusinessType())))
		 {
			 return false;
		 }
		 return true;
	 }
	 public int hashCode()
	 {
		 int mult = 31;
		 int result = 133;
		 result = result *mult + this.getAccountNumber().hashCode();
		 result = result *mult + this.getFirstName().hashCode();
		 result = result *mult + this.getLastName().hashCode();
		 result = result *mult + this.getAccountType().hashCode();
		 result = result *mult + this.getBusinessType().hashCode();
		 return result;
	 }
	 public String toString() // returns a nicely formatted String of this BankAccount on same line
	 {
		 String temp = "";
		 temp += "FIRST NAME: "+this.getFirstName();
		 temp += " LAST NAME: "+this.getLastName();
		 temp += " ACCOUNT NUMBER: "+ this.getAccountNumber();
		 temp += " BALANCE: "+ this.getBalance();
		 temp += " ACCOUNT TYPE: "+ this.getAccountType();
		 temp += " BUSINESS TYPE: "+ this.getBusinessType();
		 return temp;
	 }
}
