package transaction;

import java.io.PrintWriter;
import java.util.Scanner;

public class TransactionUtilsImpl {
	//tries to read one Transaction derived item from file, if successful, creates Transaction-derived instance, populates it, returns it, assumes data in order described
	  //receives: inFile -- open and ready to read from
	  // returns a Transaction derived instance of appropriate type according to what is read
	public static Transaction readFromScanner(Scanner inFile)
	{
		String id = "";
		String date ="";
		double amt = 0.0;
		int checkNum = 0;
		String recp = "";
		String place ="";
		String transType ="";
		if(inFile.hasNext())
		{
			transType = inFile.next();
		}
		else
		{
			return null;
		}
		if(inFile.hasNext())
		{
			 id = inFile.next();
		}
		else
		{
			return null;
		}
		if(inFile.hasNext())
		{
			date = inFile.next();
		}
		else
		{
			return null;
		}
		if(inFile.hasNextDouble())
		{
			amt = inFile.nextDouble();
		}
		else
		{
			return null;
		}
		if(transType.equals("CHECK"))
		{
			if(inFile.hasNextInt())
			{
				checkNum = inFile.nextInt();
			}
			else
			{
				return null;
			}
			if(inFile.hasNext())
			{
				recp = inFile.nextLine().trim();
			}
			else
			{
				return null;
			}
			Check myCheck = new Check(id, date, amt, checkNum, recp);
			return myCheck;
		}
		if(transType.equals("DEPOSIT"))
		{
			Deposit myDeposit = new Deposit(id,date,amt);
			return myDeposit;
		}
		else if(transType.equals("DEBIT"))
		{
			if(inFile.hasNext())
			{
				place = inFile.nextLine().trim();
			}
			else
			{
				return null;
			}
			DebitCard myDebit = new DebitCard(id,date,amt,place);
			return myDebit;
		}
		else
		{
			return null;
		}
	}

	//writes given trans to file in same format as read in with label on line describing which type of transaction is on the line
	  // receives: outFile -- ready to print to
	  //           trans - a Transaction derived type, determining what is written
	public static void writeToFile(PrintWriter outFile, Transaction trans)
	{
		if(trans instanceof Deposit)
		{
			outFile.println("DEPOSIT ");
			Deposit deposit = (Deposit) trans;
			outFile.print(deposit.getTransactionId()+ " "+ deposit.getDateString() + " " + deposit.getAmount() + "\n");
		}
		else if(trans instanceof Check)
		{
			outFile.println("CHECK ");
			Check check = (Check) trans;
			outFile.print(check.getTransactionId()+ " "+ check.getDateString() + " " + check.getAmount() + " " + check.getCheckNumber() + " " + check.getRecipient() + "\n");
		}
		else if(trans instanceof DebitCard)
		{
			outFile.println("DEBIT ");
			DebitCard debit = (DebitCard) trans;
			outFile.print(debit.getTransactionId()+ " "+ debit.getDateString() + " " + debit.getAmount() + " " + debit.getPurchaseLocation()+ "\n");
		}
	}
}
