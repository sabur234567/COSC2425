package test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.GregorianCalendar;
import java.util.Scanner;

import org.junit.Test;

import transaction.Check;
import transaction.DebitCard;
import transaction.Deposit;
import transaction.Transaction;
import transaction.TransactionUtilsImpl;
import transactionlist.TransactionList;
import transactionlist.TransactionListLinkedListImpl;
import transactionlist.TransactionListUtilsImpl;


public class Asg6Test
{

	@Test
	public void test() {
		String sName = "";
		sName = utils.MyUtils.getNameFromStudent();
		utils.MyUtils.printTimeStamp("BEGINS" + " for " + sName);
		testTransaction();
		testTransactionUtils();
		testGetFindContains();
		testAddRemoveClear();
		testByDate();
		testListUtils();
		utils.MyUtils.printTimeStamp("ENDS" + " for " + sName);
	}

	public void testTransaction()
	{
		System.out.println("Testing Transaction derived classes...");
		GregorianCalendar defaultDate = new GregorianCalendar(2000, 0, 1);
		double allowDiff = 0.005;
		double diff = 0.0;
		String res = "";
		
		Deposit dep = new Deposit("400, 3, 2019", 100.00); 
		assertEquals(defaultDate, dep.getDateCalendar());
		diff = dep.getAmount()-100.00;
		assertTrue(Math.abs(diff) < allowDiff);
		dep = new Deposit("12/32/2019", 500.99);
		assertEquals(defaultDate, dep.getDateCalendar());
		diff = dep.getAmount() - 500.99;
		assertTrue(Math.abs(diff) < allowDiff);
		dep = new Deposit("1/13/2031",0.03);
		assertEquals(defaultDate, dep.getDateCalendar());
		diff = dep.getAmount() - 0.03;
		assertTrue(Math.abs(diff) < allowDiff);
		
		
		Deposit d1 = new Deposit("12/32/2019", 500.00);
		res = d1.toString();
		assertTrue(res.contains("1/1/2000"));
		assertTrue(res.contains("500"));
		
		Deposit d2 = new Deposit();
	
		d2.setDate("8/12/2019");
		d2.setAmount(1000.00);
		res = d2.toString();
		assertTrue(res.contains("8/12/2019"));
		assertTrue(res.contains("1000"));
		

		Deposit d3 = new Deposit("9/3/2019", 200.00);
		Deposit d4 = new Deposit("8/14/2019", 874.00);
		Deposit d5 = new Deposit("14/63/2019", -1000.0);
		 diff = d5.getAmount() - 0.0;
		assertTrue(Math.abs(diff) < allowDiff);
		assertEquals(d5.getDateCalendar(), defaultDate);
		
		
		System.out.println("to String() d5 using 14/63/2019: \n" + d5);
		System.out.println("to String() of 4 deposits: \n" + d1 + "\n" + d2 + "\n" + d3 +"\n" + d4 + "\n");
		assertTrue(d3.getDateString().equals("9/3/2019"));
		assertTrue(d3.getDateCalendar().equals(new GregorianCalendar(2019, 8, 3)));
		assertTrue(Math.abs(d3.getAmount() - 200.00) <= allowDiff);
		assertFalse(d3.getDateCalendar().equals(defaultDate));
		

		DebitCard dc1 = new DebitCard();
		assertEquals(defaultDate,dc1.getDateCalendar());
		dc1.setAmount(400.00);
		diff = dc1.getAmount() - 400.00;
		assertTrue(Math.abs(diff) < allowDiff);
		dc1.setPurchaseLocation("   Diane  FlacK furnITURE  ");
	
		assertTrue(dc1.getPurchaseLocation().equals("Diane Flack Furniture"));
		assertTrue(dc1.toString().contains("Diane Flack Furniture"));
		System.out.println("toString() of Debit Card: " + dc1);
		dc1.setPurchaseLocation("    ");
		assertTrue(dc1.getPurchaseLocation().equals(DebitCard.DEFAULT_LOCATION));
		dc1.setPurchaseLocation(" somewhere  over the rainBOW ");
		assertTrue(dc1.getPurchaseLocation().equals("Somewhere Over The Rainbow"));
		dc1.setPurchaseLocation("");
		assertTrue(dc1.getPurchaseLocation().equals(DebitCard.DEFAULT_LOCATION));
		dc1.setPurchaseLocation(" somewhere  over the rainBOW ");
		assertEquals(defaultDate, dc1.getDateCalendar());
		System.out.println("toString() of Debit Card: " + dc1);
		dc1 = new DebitCard("4d2f", "10/1/2040", 100.00, "  shell   staTION   ");
		System.out.println("toString() of Debit Card: " + dc1);
		assertEquals(dc1.getTransactionId(), "4d2f" );
		assertEquals(defaultDate, dc1.getDateCalendar());
		assertEquals("Shell Station", dc1.getPurchaseLocation());
		res = dc1.toString();
		assertTrue(res.contains("Shell Station"));
		assertTrue(res.contains("4d2f"));
		assertTrue(res.contains("1/1/2000"));

		Check c1 = new Check();
		double allowable = 0.0001;
		double actDiff = Math.abs(c1.getAmount()-0.00);
		assertTrue(actDiff<=allowable);
		assertFalse(c1.getAmount() > 0.0);
		assertFalse(c1.getAmount() < 0.0);
		assertTrue(c1.getCheckNumber() == 0);
		assertTrue(c1.getRecipient().equals("$$$$"));
		assertTrue(c1.toString().contains("$$$$"));
		
		c1.setRecipient("The Old Spa at new BraunFels");
		assertTrue(c1.getRecipient().equals("The Old Spa At New Braunfels"));
		System.out.println("toString() of Check: " + c1);
		c1.setRecipient("  ");
		assertTrue(c1.getRecipient().equals("$$$$"));
		c1.setAmount(200.00);
		assertTrue(c1.getCheckNumber()==0);
		c1.setCheckNumber(-5);
		assertTrue(c1.getCheckNumber()==0);
		c1.setCheckNumber(Check.MAX_NUMBER);
		assertEquals(Check.MAX_NUMBER, c1.getCheckNumber());
		c1.setCheckNumber(Check.MAX_NUMBER+1);
		assertEquals(0, c1.getCheckNumber());

		actDiff = Math.abs(c1.getAmount()-200.00);
		assertTrue(actDiff<=allowable);
		assertTrue(c1.getDateCalendar().equals(defaultDate));//default date is Jan. 1, 2000
		System.out.println("toString() of Check: " + c1);
		res = c1.toString().toLowerCase();
		assertTrue(res.contains("check"));
		assertTrue(res.contains("0"));
		
		Check c2 = new Check("10/18/2019", 40.00, 2345, "Austin Energy cooperative");
		assertTrue(c2.getCheckNumber()==2345);
		c2.setCheckNumber(1119999);
		assertTrue(c2.getCheckNumber() == 0);
		res = c2.toString();
		System.out.println("Check c2: " + res);
		assertTrue(c2.getRecipient().equals("Austin Energy Cooperative"));
		assertTrue(res.contains("10/18/2019"));
		c2.setDate("300/100/2019");
		assertTrue(c2.getDateString().equals("1/1/2000"));
		
		assertTrue(utils.MyUtils.numberLines(res)==0);
		System.out.println("End of Testing Transaction derived classes...");

	}
	public void testTransactionUtils()
	{
		System.out.println("\n------------------------------------------------------");
		System.out.println("\n**** Now testing TransactionUtilsImpl methods ****");
		String fileName="";
		Scanner inFile = null;
		PrintWriter outFile = null;

		int count = 0;
		fileName= "transactionEmpty.txt";
		try 
		{
			inFile = new Scanner(new File(fileName));
			System.out.println("****Output of " + fileName + ":");
		}
		catch(FileNotFoundException e)
		{
			System.out.println("FAILURE error, cannot open file: " + fileName +
					" now exiting....");
			return;
		}
		fileName="transactionEmptyOut.txt";
		try {
			outFile = new PrintWriter(new File(fileName));
		} catch (FileNotFoundException e) {
			System.out.println("FAILURE Error, cannot open file " + fileName + " for writing");
			return;
		}
		count = 0;
		while(inFile.hasNext())
		{
			Transaction trans = TransactionUtilsImpl.readFromScanner(inFile);
			if(trans != null)
			{
				count++;
				System.out.println("Just read: " + trans);
				TransactionUtilsImpl.writeToFile(outFile, trans);
			}
		}
		assertEquals(count, 0);
		fileName= "transactionEmptyOut.txt";
		try 
		{
			inFile = new Scanner(new File(fileName));
			System.out.println("****Output of " + fileName + ":");
		}
		catch(FileNotFoundException e)
		{
			System.out.println("FAILURE error, cannot open file: " + fileName +
					" now exiting....");
			return;
		}

		count = 0;
		while(inFile.hasNext())
		{
			Transaction trans = TransactionUtilsImpl.readFromScanner(inFile);
			if(trans != null)
			{
				count++;
				System.out.println("Just read: " + trans);
			}
		}
		assertEquals(count, 0);
		inFile.close();
		count = 0;
		fileName= "transaction1.txt";
		try 
		{
			inFile = new Scanner(new File(fileName));
			System.out.println("****Output of " + fileName + ":");
		}
		catch(FileNotFoundException e)
		{
			System.out.println("FAILURE error, cannot open file: " + fileName +
					" now exiting....");
			return;
		}
		fileName="transaction1Out.txt";
		try {
			outFile = new PrintWriter(new File(fileName));
		} catch (FileNotFoundException e) {
			System.out.println("FAILURE Error, cannot open file " + fileName + " for writing");
			return;
		}
		count = 0;
		while(inFile.hasNext())
		{
			Transaction trans = TransactionUtilsImpl.readFromScanner(inFile);
			if(trans != null)
			{
				count++;
				System.out.println("Just read: " + trans);
				TransactionUtilsImpl.writeToFile(outFile, trans);
			}
		}
		outFile.close();
		assertEquals(count, 1);
		fileName= "transaction1Out.txt";
		try 
		{
			inFile = new Scanner(new File(fileName));
			System.out.println("****Output of " + fileName + ":");
		}
		catch(FileNotFoundException e)
		{
			System.out.println("FAILURE error, cannot open file: " + fileName +
					" now exiting....");
			return;
		}

		count = 0;
		while(inFile.hasNext())
		{
			Transaction trans = TransactionUtilsImpl.readFromScanner(inFile);
			if(trans != null)
			{
				count++;
				System.out.println("Just read: " + trans);
			}
		}
		assertEquals(count, 1);
		inFile.close();
		count = 0;
		fileName= "transaction3.txt";
		try 
		{
			inFile = new Scanner(new File(fileName));
			System.out.println("****Output of " + fileName + ":");
		}
		catch(FileNotFoundException e)
		{
			System.out.println("FAILURE error, cannot open file: " + fileName +
					" now exiting....");
			return;
		}
		fileName="transaction3Out.txt";
		try {
			outFile = new PrintWriter(new File(fileName));
		} catch (FileNotFoundException e) {
			System.out.println("FAILURE Error, cannot open file " + fileName + " for writing");
			return;
		}
		count = 0;
		while(inFile.hasNext())
		{
			Transaction trans = TransactionUtilsImpl.readFromScanner(inFile);
			if(trans != null)
			{
				count++;
				System.out.println("Just read: " + trans);
				if(count == 1)
				{
					Check check = (Check) trans;
					assertEquals(check.getRecipient(), "Austin Energy");
				}

				TransactionUtilsImpl.writeToFile(outFile, trans);
			}
		}
		outFile.close();
		assertEquals(count, 3);
		fileName= "transaction3Out.txt";
		try 
		{
			inFile = new Scanner(new File(fileName));
			System.out.println("****Output of " + fileName + ":");
		}
		catch(FileNotFoundException e)
		{
			System.out.println("FAILURE error, cannot open file: " + fileName +
					" now exiting....");
			return;
		}

		count = 0;
		while(inFile.hasNext())
		{
			Transaction trans = TransactionUtilsImpl.readFromScanner(inFile);
			if(trans != null)
			{
				count++;
				System.out.println("Just read: " + trans);
			}
		}
		assertEquals(count, 3);
		inFile.close();
		count = 0;
		fileName= "transaction12.txt";
		try 
		{
			inFile = new Scanner(new File(fileName));
			System.out.println("****Output of " + fileName + ":");
		}
		catch(FileNotFoundException e)
		{
			System.out.println("FAILURE error, cannot open file: " + fileName +
					" now exiting....");
			return;
		}
		fileName="transaction12Out.txt";
		try {
			outFile = new PrintWriter(new File(fileName));
		} catch (FileNotFoundException e) {
			System.out.println("FAILURE Error, cannot open file " + fileName + " for writing");
			return;
		}
		count = 0;
		while(inFile.hasNext())
		{
			Transaction trans = TransactionUtilsImpl.readFromScanner(inFile);
			if(trans != null)
			{
				count++;
				System.out.println("Just read: " + trans);
				TransactionUtilsImpl.writeToFile(outFile, trans);
			}
		}
		outFile.close();
		assertEquals(count, 12);
		fileName= "transaction12Out.txt";
		try 
		{
			inFile = new Scanner(new File(fileName));
			System.out.println("****Output of " + fileName + ":");
		}
		catch(FileNotFoundException e)
		{
			System.out.println("FAILURE error, cannot open file: " + fileName +
					" now exiting....");
			return;
		}

		count = 0;
		while(inFile.hasNext())
		{
			Transaction trans = TransactionUtilsImpl.readFromScanner(inFile);
			if(trans != null)
			{
				count++;
				if(count == 4)
				{
					DebitCard deb = (DebitCard) trans;
					assertEquals(deb.getPurchaseLocation(), "Diamond Shamrock Station");
				}
				System.out.println("Just read: " + trans);
			}
		}
		assertEquals(count, 12);
		inFile.close();
		System.out.println("**** End of testTransactionUtils() **** \n");

	}

	public void testGetFindContains()
	{
		TransactionList list = null;
		list = new TransactionListLinkedListImpl("transactionEmpty.txt");
		assertEquals(0, list.getSize());
		assertEquals(null, list.get(0));
		assertEquals(null, list.get(100));
		assertEquals(null, list.get(-4));
		Deposit d1 = new Deposit("9/3/2019", 200.00);
		Deposit d2 = new Deposit("8/14/2019", 874.00);
		assertEquals(-1, list.find(d1));
		assertEquals(-1, list.find(d2));
		DebitCard dc1 = new DebitCard("3/4/2019", 200.00, "WalMart Super store");
		assertEquals(-1, list.find(dc1));
		Check c1 = new Check("9/12/2019", 150.00, 6703, "Austin electric energy");
		assertEquals(-1, list.find(c1));
		assertFalse(list.contains(c1));
		assertFalse(list.contains(dc1));
		assertFalse(list.contains(d1));

		list = new TransactionListLinkedListImpl("transaction1.txt");
		assertEquals(1, list.getSize());
		assertFalse(null==list.get(0));
		assertEquals(null, list.get(100));
		assertEquals(null, list.get(-4));
		d1 = new Deposit("9/3/2019", 200.00);
		d2 = new Deposit("8/14/2019", 874.00);
		assertEquals(-1, list.find(d1));
		assertEquals(-1, list.find(d2));
		dc1 = new DebitCard("3/4/2019", 200.00, "WalMart Super store");
		assertEquals(-1, list.find(dc1));
		c1 = new Check("9/12/2019", 150.00, 6703, "Austin electric energy");
		assertEquals(-1, list.find(c1));
		assertFalse(list.contains(c1));
		assertFalse(list.contains(dc1));
		assertFalse(list.contains(d1));
		DebitCard dc2 = new DebitCard("0ro3","9/4/2019",  83.45, "HEB");
		list.add(dc2);
		assertTrue(list.contains(dc2));
		assertTrue(list.find(dc2) == 0);
		String out = list.toString();
		System.out.println("current list:\n" + list);
		assertEquals(1, utils.MyUtils.numberLines(out));
		System.out.println("here is list with " + list.getSize() + ":\n" + list);

		list = new TransactionListLinkedListImpl("transaction6.txt");
		System.out.println("Transaction list of " + list.getSize() + " items\n" + list);
		assertEquals(6, list.getSize());
		assertFalse(null==list.get(0));
		assertEquals(null, list.get(100));
		assertEquals(null, list.get(-4));
		//CHECK j89k  9/10/2017  219.76  4105  Austin Energy
		c1 = new Check();
		c1.setTransactionId("j89k");
		c1.setDate("9/10/2019");
		assertTrue(list.get(2).equals(c1));
		Deposit dep = new Deposit("p8rQ", "9/1/2019", 549.00);
		assertEquals(dep, list.get(4));
		DebitCard deb = new DebitCard("0ro3", "9/4/2019", 83.45, "heb");
		assertEquals(deb, list.get(3));

		d1 = new Deposit("9/3/2019", 200.00);
		d2 = new Deposit("8/14/2019", 874.00);
		assertEquals(-1, list.find(d1));
		assertEquals(-1, list.find(d2));
		dc1 = new DebitCard("3/4/2019", 200.00, "WalMart Super store");
		assertEquals(-1, list.find(dc1));
		c1 = new Check("9/12/2019", 150.00, 6703, "Austin electric energy");
		assertEquals(-1, list.find(c1));
		assertFalse(list.contains(c1));
		assertFalse(list.contains(dc1));
		assertFalse(list.contains(d1));
		dc2 = new DebitCard("0ro3","9/4/2019",  83.45, "HEB");
		assertTrue(list.contains(dc2));
		assertEquals(3, list.find(dc2));
		Deposit d3 = new Deposit("p8rQ",  "9/1/2019",   549.00);
		Check c2 = new Check("j89k","9/10/2019",219.76, 4105, "Austin Energy "); 
		assertTrue(list.contains(d3));
		assertEquals(4, list.find(d3));
		assertTrue(list.contains(c2));
		assertEquals(2, list.find(c2));
		out = list.toString();
		assertEquals(6, list.getSize());
		assertEquals(list.getSize(), utils.MyUtils.numberLines(out));
		System.out.println("Transaction list of " + list.getSize() + " items\n" + list);
		
		list = new TransactionListLinkedListImpl("transaction12.txt");
		System.out.println("Transaction list of " + list.getSize() + " items\n" + list);
		
		assertEquals(12, list.getSize());
		assertFalse(null==list.get(0));
		assertEquals(null, list.get(100));
		assertEquals(null, list.get(-4));
		d1 = new Deposit("9/3/2019", 200.00);
		d2 = new Deposit("8/14/2019", 874.00);
		assertEquals(-1, list.find(d1));
		assertEquals(-1, list.find(d2));
		dc1 = new DebitCard("3/4/2019", 200.00, "WalMart Super store");
		assertEquals(-1, list.find(dc1));
		c1 = new Check("9/12/2019", 150.00, 6703, "Austin electric energy");
		assertEquals(-1, list.find(c1));
		assertFalse(list.contains(c1));
		assertFalse(list.contains(dc1));
		assertFalse(list.contains(d1));
		dc2 = new DebitCard("0ro3","9/4/2019",  83.45, "HEB");
		assertTrue(list.contains(dc2));
		assertEquals(6, list.find(dc2));
		d3 = new Deposit("p8rQ",  "9/1/2019",   549.00);
		c2 = new Check("j89k","9/10/2019",219.76, 4105, "Austin Energy "); 
		assertTrue(list.contains(d3));
		assertEquals(9, list.find(d3));
		assertTrue(list.contains(c2));
		assertEquals(5, list.find(c2));
		out = list.toString();
		assertEquals(12, utils.MyUtils.numberLines(out));
		System.out.println("here is list with 12:\n" + list);
	}
	public void testAddRemoveClear()
	{
		TransactionList list = new TransactionListLinkedListImpl("transaction1.txt");
		assertEquals(1, list.getSize());
		Deposit d1 = new Deposit("9/3/2019", 200.00);
		String id = d1.getTransactionId();
		Deposit d3 = new Deposit(id,"9/3/2019", 200.00);
		Deposit d2 = new Deposit("8/14/2019", 874.00);
		DebitCard dc1 = new DebitCard("3/4/2019", 200.00, "WalMart Super store");
		Check c1 = new Check("9/12/2019", 150.00, 6703, "Austin electric energy");
		DebitCard dc2 = new DebitCard("0ro3","9/4/2019",  83.45, "HEB");
		DebitCard dc3 = new DebitCard("0ro3","9/4/2019",  83.45, "HEB");
		Check c2 = new Check("j89k","9/10/2019",219.76, 4105, "Austin Energy "); 
		assertEquals(dc2, list.remove(dc3));
		assertEquals(0, list.getSize());
		assertFalse(list.contains(dc3));
		assertTrue(list.add(dc3));
		assertTrue(list.getSize()==1);
		assertFalse(list.add(dc2));
		assertTrue(list.getSize()==1);
		assertTrue(list.add(d1));
		assertTrue(list.contains(d1));
		assertTrue(list.getSize()==2);
		assertTrue(list.add(c2));
		assertTrue(list.getSize() ==3);
		System.out.println("list: \n" + list);
		assertEquals(c2, list.get(0));
		assertEquals(dc2, list.get(1));
		assertEquals(d1, list.get(2));
		assertEquals(dc2, list.remove(dc3));
		assertTrue(list.getSize()==2);
		assertEquals(d1, list.remove(d3));
		assertFalse(list.contains(d1));
		assertTrue(list.getSize()==1);
		assertEquals(c2, list.remove(c2));
		assertFalse(list.contains(c2));
		assertTrue(list.getSize()==0);
		assertTrue(list.add(dc3));
		assertTrue(list.getSize()==1);
		assertFalse(list.add(dc2));
		assertTrue(list.getSize()==1);
		assertTrue(list.add(d1));
		assertTrue(list.contains(d1));
		assertTrue(list.getSize()==2);
		assertTrue(list.add(c2));
		assertTrue(list.getSize() ==3);
		list.clear();
		assertTrue(list.getSize() == 0);
		assertFalse(list.contains(d1));
		assertFalse(list.contains(d2));
		assertEquals(list.remove(dc1), null);
	}
	public void testListUtils()
	{
		int size1=0, size2=0;
		Scanner inFile = null;
		PrintWriter outFile = null;
		String fileName= "transactionEmpty.txt";
		TransactionList list1 = new TransactionListLinkedListImpl();
		try 
		{
			inFile = new Scanner(new File(fileName));
			System.out.println("SUCCESS opened for reading: " + fileName );
		}
		catch(FileNotFoundException e)
		{
			System.out.println("FAILURE error, cannot open file: " + fileName +
					" for reading now exiting....");
			return;
		}
		TransactionListUtilsImpl.readFromScanner(inFile, list1);
		inFile.close();
		assertTrue(list1.getSize()==0);

		System.out.println("Contents of " + fileName + " after reading \n" + list1);
		fileName = "transactionEmptyOut.txt";
		try {
			outFile = new PrintWriter(new File(fileName));
		} catch (FileNotFoundException e) {
			System.out.println("FAILURE Error, cannot open file " + fileName + " for writing");
			return;
		}
		TransactionListUtilsImpl.writeToFile(outFile,  list1);
		outFile.close();
		list1.clear();
		assertTrue(list1.getSize() == 0);
		String expString = "";
		String actString = list1.toString();
		assertEquals(actString, expString);
		list1 = new TransactionListLinkedListImpl();
		try 
		{
			inFile = new Scanner(new File(fileName));
			System.out.println("SUCCESS opened file: " + fileName + " for reading...");
		}
		catch(FileNotFoundException e)
		{
			System.out.println("FAILURE error, cannot open file: " + fileName +
					" for reading now exiting....");
			return;
		}
		TransactionListUtilsImpl.readFromScanner(inFile, list1);
		inFile.close();
		size2=list1.getSize();
		assertTrue(size1 == size2 && size1 == 0);

		System.out.println("Contents of previously written file " + fileName + " after reading \n" + list1);

		fileName= "transaction1.txt";
		list1 = new TransactionListLinkedListImpl();
		try 
		{
			inFile = new Scanner(new File(fileName));
			System.out.println("SUCCESS opened for reading: " + fileName );
		}
		catch(FileNotFoundException e)
		{
			System.out.println("FAILURE error, cannot open file: " + fileName +
					" for reading now exiting....");
			return;
		}
		TransactionListUtilsImpl.readFromScanner(inFile, list1);
		inFile.close();
		assertTrue(list1.getSize()==1);
		size1 = list1.getSize();
		System.out.println("Contents of " + fileName + " after reading \n" + list1);
		fileName = "transaction1Out.txt";
		try {
			outFile = new PrintWriter(new File(fileName));
		} catch (FileNotFoundException e) {
			System.out.println("FAILURE Error, cannot open file " + fileName + " for writing");
			return;
		}
		TransactionListUtilsImpl.writeToFile(outFile,  list1);
		outFile.close();
		list1.clear();
		assertTrue(list1.getSize() == 0);
		expString = "";
		actString = list1.toString();
		assertEquals(0, utils.MyUtils.numberLines(actString));
		list1 = new TransactionListLinkedListImpl();
		try 
		{
			inFile = new Scanner(new File(fileName));
			System.out.println("SUCCESS opened file: " + fileName + " for reading...");
		}
		catch(FileNotFoundException e)
		{
			System.out.println("FAILURE error, cannot open file: " + fileName +
					" for reading now exiting....");
			return;
		}
		TransactionListUtilsImpl.readFromScanner(inFile, list1);
		inFile.close();
		size2=list1.getSize();
		assertTrue(size1 == size2 && size1 == 1);

		System.out.println("Contents of previously written file " + fileName + " after reading \n" + list1);
		fileName= "transaction12.txt";
		list1 = new TransactionListLinkedListImpl();
		try 
		{
			inFile = new Scanner(new File(fileName));
			System.out.println("SUCCESS opened for reading: " + fileName );
		}
		catch(FileNotFoundException e)
		{
			System.out.println("FAILURE error, cannot open file: " + fileName +
					" for reading now exiting....");
			return;
		}
		TransactionListUtilsImpl.readFromScanner(inFile, list1);
		inFile.close();
		assertTrue(list1.getSize()==12);
		size1 = list1.getSize();
		System.out.println("Contents of " + fileName + " after reading \n" + list1);
		fileName = "transaction12Out.txt";
		try {
			outFile = new PrintWriter(new File(fileName));
		} catch (FileNotFoundException e) {
			System.out.println("FAILURE Error, cannot open file " + fileName + " for writing");
			return;
		}
		TransactionListUtilsImpl.writeToFile(outFile,  list1);
		outFile.close();
		list1.clear();
		assertTrue(list1.getSize() == 0);
		expString = "";
		actString = list1.toString();
		assertEquals(0, utils.MyUtils.numberLines(actString));
		list1 = new TransactionListLinkedListImpl();
		try 
		{
			inFile = new Scanner(new File(fileName));
			System.out.println("SUCCESS opened file: " + fileName + " for reading...");
		}
		catch(FileNotFoundException e)
		{
			System.out.println("FAILURE error, cannot open file: " + fileName +
					" for reading now exiting....");
			return;
		}
		TransactionListUtilsImpl.readFromScanner(inFile, list1);
		inFile.close();
		size2=list1.getSize();
		assertTrue(size1 == size2 && size1 == 12);

		System.out.println("Contents of previously written file " + fileName + " after reading \n" + list1);
		System.out.println("**** End of testUtilsMethods() **** \n");
	}
	public void testByDate()
	{
		TransactionList list = new TransactionListLinkedListImpl("transaction1.txt");
		String result = list.getTransactionListByDate(new GregorianCalendar(2019,3,4));
		int exp = 0;
		assertEquals(exp, utils.MyUtils.numberLines(result));
		result = list.getTransactionListByDate(new GregorianCalendar(2019,8,4));
		exp = 1;
		assertEquals(exp, utils.MyUtils.numberLines(result));
		assertTrue(result.contains("9/4/2019"));
		result = list.getTransactionListByDate(new GregorianCalendar(2000,0,1));
		exp = 0;
		assertEquals(exp, utils.MyUtils.numberLines(result));
		list = new TransactionListLinkedListImpl("transaction12.txt");
		GregorianCalendar date = new GregorianCalendar(2019, 8,1); // 9/1/2019
		result = list.getTransactionListByDate(date);
		System.out.println("Dates 9/1/2019:\n" + result);
		exp = 2;
		assertEquals(exp, utils.MyUtils.numberLines(result));
		assertTrue(result.contains("p8rQ"));
		assertTrue(result.contains("4233"));
	}
}
