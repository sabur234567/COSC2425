package transactionlist;

import java.io.PrintWriter;
import java.util.Scanner;

import transaction.Transaction;
import transaction.TransactionUtilsImpl;

public class TransactionListUtilsImpl {
	// reads from inFile as many transactions as it can, puts each one into transList
	//receives: inFile -- open and ready to read from
	//returns :  nothing
	// task: all transactions found on inFile are added to transList acc'd to rules of add
	public static void readFromScanner(Scanner inFile, TransactionList transList)
	{
		while(inFile.hasNext())
		{
			Transaction trans = TransactionUtilsImpl.readFromScanner(inFile);
			if(trans!= null)
			{
				transList.add(trans);
			}
		}
	}


	//writes given transList to file in same format as read in with label on each line describing which type of transaction is on the line
	// receives: outFile-  open and ready to print to
	// returns:  nothing
	//  task:  outFile contains entire contents of list written in same format
//	       as input
	public static void writeToFile(PrintWriter outFile, TransactionList transList)
	{
		for (int i = 0; i < transList.getSize(); i++) {
			Transaction myTrans = transList.get(i);
			TransactionUtilsImpl.writeToFile(outFile, myTrans);
		}
	}
}
