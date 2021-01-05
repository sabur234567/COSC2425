package asg5;

import java.io.PrintWriter;
import java.util.Scanner;


public class BankAccountUtilsImpl
{
 // receives:  inFile - a Scanner instance that is open and ready to read data from
 //     file format: account number {newline} last name {newline} first name {newline},
 //                  account type {space} business type {newLine} balance {newline}
 // returns:  a single populated BankAccount instance with data from inFile if all data is there,
 //      returns null if no data found (end of input) for a bank account or if
 //     any mismatch of data or missing expected data
	public static BankAccount readFromScanner(Scanner inFile)
	{
		String firstName ="";
		String lastName ="";
		String accountNumber ="";
		double balance = 0;
		String accountType = "";
		String businessType = "";
		if(inFile.hasNext())
		{
			accountNumber = inFile.nextLine();
		}
		else
		{
			return null;
		}
		if(inFile.hasNext())
		{
			lastName = inFile.nextLine();
		}
		else
		{
			return null;
		}
		if(inFile.hasNext())
		{
			firstName = inFile.nextLine();
		}
		else
		{
			return null;
		}
		if(inFile.hasNext())
		{
			accountType = inFile.next();
		}
		else
		{
			return null;
		}
		if(inFile.hasNext())
		{
			businessType = inFile.next();
		}
		else
		{
			return null;
		}
		if(inFile.hasNextDouble())
		{
			balance = inFile.nextDouble();
			inFile.nextLine();
			
		}
		else
		{
			return null;
		}
		AccountType newAccount = AccountType.valueOf(accountType);
		BusinessType newBusinessType = BusinessType.valueOf(businessType);
		BankAccount bankAccount = new BankAccount(accountNumber, lastName, firstName, newAccount, newBusinessType, balance );
		return bankAccount;
	}

 // receives: outFile- a PrintWriter instance that is already open and ready to receive output
 //           bankAccount - the instance of a bankAccount that is to be written to the output
 // task: received bankAccount is written to outFile in  readable format by readFromScanner method
 //       (so that it could be read back in later)
 //writes in exact same order and format as readFromScanner uses:
 //    file format:  account number {newline} 
 //                  last name {newline} 
 //                  first name {newline},
 //                  account type {space} business type {newLine} 
 //                  balance {newline} 
	public static void writeToFile(PrintWriter outFile, BankAccount bankAccount)
	{
		outFile.println(bankAccount.getAccountNumber());
		outFile.println(bankAccount.getLastName());
		outFile.println(bankAccount.getFirstName());
		outFile.println(bankAccount.getAccountType()+" "+bankAccount.getBusinessType());
		outFile.println(bankAccount.getBalance());
	}
}
