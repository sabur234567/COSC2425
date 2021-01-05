package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import asg5.AccountType;
import asg5.BankAccount;
import asg5.BankAccountUtilsImpl;
import asg5.BusinessType;

class Asg5Part1Test {
	static String sName = "";  // used for student name
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		sName = utils.MyUtils.getNameFromStudent();
		System.out.println("Test Assignment #5 Part 1 for " + sName + " self-certified by " + sName);
		System.out.println("Testing for " + sName + " begins..");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {

		System.out.println("End of Asg#5 Part 1 certified testing for " + sName + " .......");
	}
	@Test
	public void test()
	{
		testConstructors();
		testToString();
		testSetters();
		testEquals();
		testIOUtils();
	}
	void testIOUtils()
	{
		//expString =
		int expCount =0, count = 0;
		System.out.println("\n********Now Testing BankAccountUtilsImpl********");
		Scanner in = new Scanner(System.in);
		String fileName = "";
		Scanner inFile = null;
		fileName= "bankaccountShort.txt";
		try 
		{
			inFile = new Scanner(new File(fileName));
			System.out.println("****Output of " + fileName + ":");
		}
		catch(FileNotFoundException e)
		{
			System.out.println("error, cannot open file: " + fileName +
					" now exiting....");
			return;
		}
		count = 0;
		while(inFile.hasNext())
		{
			BankAccount b2 = BankAccountUtilsImpl.readFromScanner(inFile);
			if(b2 != null)
			{
				System.out.println("bank account:  " + b2);
				count ++;
			}

		}//end while
		expCount = 0;
		assertEquals(expCount, count);
		inFile.close();

		fileName= "bankaccount1.txt";
		try 
		{
			inFile = new Scanner(new File(fileName));
			System.out.println("****Output of " + fileName + ":");
		}
		catch(FileNotFoundException e)
		{
			System.out.println("error, cannot open file: " + fileName +
					" now exiting....");
			return;
		}
		count = 0;
		while(inFile.hasNext())
		{
			BankAccount b2 = BankAccountUtilsImpl.readFromScanner(inFile);
			if(b2 != null)
			{
				System.out.println("bank account:  " + b2);
				count ++;
			}
		}//end while
		inFile.close();
		expCount = 1;
		assertEquals(expCount, count);


		fileName= "bankaccount.txt";
		try 
		{
			inFile = new Scanner(new File(fileName));
			System.out.println("****Output of " + fileName + ":");
		}
		catch(FileNotFoundException e)
		{
			System.out.println("error, cannot open file: " + fileName +
					" now exiting....");
			return;
		}
		PrintWriter outFile = null;
		fileName = "out1.txt";
		try {
			outFile = new PrintWriter(new File(fileName));
		} catch (FileNotFoundException e) {
			System.out.println("FAILURE Error, cannot open file " + fileName + " for writing");
			return;
		}
		count = 0;
		while(inFile.hasNext())
		{
			BankAccount b2 = BankAccountUtilsImpl.readFromScanner(inFile);
			if(b2 != null)
			{
				System.out.println("bank account:  " + b2);
				BankAccountUtilsImpl.writeToFile(outFile,  b2);
				count ++;
			}
		}//end while
		inFile.close();
		outFile.close();
		expCount = 5;
		assertEquals(expCount, count);
		System.out.println("\n*******Now testing that writeToFile method worked...********");
		fileName = "out1.txt";
		try 
		{
			inFile = new Scanner(new File(fileName));
			System.out.println("****Output of " + fileName + " should be a copy of bankaccount.txt:****");

		}
		catch(FileNotFoundException e)
		{
			System.out.println("error, cannot open file: " + fileName +
					" now exiting....");
			return;
		}
		count = 0;
		while(inFile.hasNext())
		{
			BankAccount b2 = BankAccountUtilsImpl.readFromScanner(inFile);
			if(b2 != null)
			{
				System.out.println("bank account:  " + b2);
				count ++;
			}
		}//end while
		expCount = 5;
		assertEquals(expCount, count);
		fileName= "bankaccountError.txt";
		try 
		{
			inFile = new Scanner(new File(fileName));
			System.out.println("****Output of " + fileName + ":");
		}
		catch(FileNotFoundException e)
		{
			System.out.println("error, cannot open file: " + fileName +
					" now exiting....");
			return;
		}

		while(inFile.hasNext())
		{
			BankAccount b2 = BankAccountUtilsImpl.readFromScanner(inFile);
			assertEquals(b2, null);

		}//end while
		inFile.close();

		System.out.println("Ending IO Utils testing for: " + sName);
		utils.MyUtils.printTimeStamp("End");

	}



	void testEquals()
	{
		utils.MyUtils.printTimeStamp("Begin Testing Override of equals");
		BankAccount b1 = new BankAccount();
		BankAccount b2 = new BankAccount();
		assertEquals(b1, b2);
		assertEquals(b1.hashCode(), b2.hashCode());
		System.out.println("hashCode for b1: " + b1.hashCode() + " == " + b2.hashCode());
		b1.setFirstName("Joe DaVID");
		assertFalse(b1.equals(b2));
		assertFalse(b1.hashCode() == b2.hashCode());
		System.out.println("hashCode for b1: " + b1.hashCode() + " != " + b2.hashCode());
		b1.setFirstName(BankAccount.DEFAULT_NAME);
		b1.setLastName("Lawrence  ");
		assertFalse(b1.equals(b2));
		assertFalse(b1.hashCode() == b2.hashCode());
		System.out.println("hashCode for b1: " + b1.hashCode() + " != " + b2.hashCode());
		b1.setLastName(BankAccount.DEFAULT_NAME);
		assertEquals(b1.hashCode(), b2.hashCode());
		b1.setAccountNumber("kdk222");
		assertFalse(b1.equals(b2));
		assertFalse(b1.hashCode() == b2.hashCode());
		System.out.println("hashCode for b1: " + b1.hashCode() + " != " + b2.hashCode());
		b1.setAccountNumber(BankAccount.DEFAULT_ACCOUNT_NUMBER);
		b1.setAccountType(AccountType.MONEY_MARKET);
		assertFalse(b1.equals(b2));
		assertFalse(b1.hashCode() == b2.hashCode());
		System.out.println("hashCode for b1: " + b1.hashCode() + " != " + b2.hashCode());
		b1 = new BankAccount();
		b1.setBusinessType(BusinessType.LLC);
		assertFalse(b1.equals(b2));
		assertFalse(b1.hashCode() == b2.hashCode());
		System.out.println("hashCode for b1: " + b1.hashCode() + " != " + b2.hashCode());
		System.out.println("End of testing equals() override");
	}
	void testConstructors() {

		String expString="";
		String retString="";
		double expBalance=0.0;
		double actualBalance = 0.0;
		double diff = 0.0;
		double allowDiff = 0.0005;

		AccountType expActType = AccountType.CHECKING;
		BusinessType expBusType = BusinessType.PERSONAL;
		AccountType actualActType = AccountType.CHECKING;
		BusinessType actualBusType = BusinessType.PERSONAL;
		BankAccount b1 = new BankAccount();
		utils.MyUtils.printTimeStamp("Begin Testing Constructors");
		expString = BankAccount.DEFAULT_ACCOUNT_NUMBER;
		retString = b1.getAccountNumber();
		assertEquals(expString, retString,"Expected default account number");
		expString = BankAccount.DEFAULT_NAME;
		retString = b1.getLastName();
		assertEquals(expString, retString, "Expected default name");

		expString = BankAccount.DEFAULT_NAME;
		retString = b1.getFirstName();
		assertEquals(expString, retString, "Expected default name");
		expActType = AccountType.CHECKING;
		actualActType = b1.getAccountType();
		assertEquals(expActType, actualActType,"Expected CHECKING as account type");
		expBusType = BusinessType.PERSONAL;
		actualBusType = b1.getBusinessType();
		assertEquals(expBusType, actualBusType, "Expected PERSONAL as business type");
		b1 = new BankAccount("kkdd22"," joNes  ", "matthew DAvid ", AccountType.CHECKING, BusinessType.PERSONAL, 100.0);
		expString = "kkdd22";
		retString = b1.getAccountNumber();
		assertEquals(expString, retString, "Expected: "+expString);

		expString = "Jones";
		retString = b1.getLastName();
		assertEquals(expString, retString, "expected: " + expString);	
		retString = b1.getFirstName();
		expString = "Matthew David";
		assertEquals(expString, retString);
		expActType = AccountType.CHECKING;
		actualActType = b1.getAccountType();
		assertEquals(expActType, actualActType);		
		expBusType = BusinessType.PERSONAL;
		actualBusType = b1.getBusinessType();
		assertEquals(expBusType, actualBusType);

		b1  = new BankAccount("111111", "  LopeZ  garza", "SusaN ", AccountType.SAVINGS, BusinessType.LLC, 50.0);
		expString = "111111";
		retString = b1.getAccountNumber();
		assertEquals(expString, retString);
		expString = "Lopez Garza";
		retString = b1.getLastName();
		assertEquals(expString, retString);	
		expString = "Susan";
		retString = b1.getFirstName();
		assertEquals(expString, retString);
		expActType = AccountType.SAVINGS;
		actualActType = b1.getAccountType();
		assertEquals(expActType, actualActType);
		expBusType = BusinessType.LLC;
		actualBusType = b1.getBusinessType();
		assertEquals(expBusType, actualBusType);
		expBalance = 50.0;
		diff = 0.0;
		actualBalance = b1.getBalance();
		diff = Math.abs(actualBalance-expBalance);
		assertTrue(diff < allowDiff);
		BankAccount act1 = new BankAccount("8899DF","JONES SMILEY", "AMY",  AccountType.MONEY_MARKET, BusinessType.CORPORATE, 100.00);
		expString = "Jones Smiley";
		retString = act1.getLastName();
		assertEquals(expString, retString);
		expString = "Amy";
		retString = act1.getFirstName();
		assertEquals(expString, retString);
		expString = "8899df";
		retString = act1.getAccountNumber();
		assertEquals(expString, retString);	expBalance = 100.0;
		actualBalance = act1.getBalance();
		diff = Math.abs(expBalance-actualBalance);
		assertTrue(diff<allowDiff);
		expBusType = BusinessType.CORPORATE;
		actualBusType = act1.getBusinessType();
		assertEquals(expBusType, actualBusType);
		expActType = AccountType.MONEY_MARKET;
		actualActType = act1.getAccountType();
		assertEquals(expActType, actualActType);
		act1 = new BankAccount(";*ffff"," ", "Kim ANN  ",  AccountType.SAVINGS, BusinessType.LLC, -100.00);
		expString = BankAccount.DEFAULT_NAME;
		retString = act1.getLastName();
		assertEquals(expString, retString);
		expString = "Kim Ann";
		retString = act1.getFirstName();
		assertEquals(expString, retString);	expString = BankAccount.DEFAULT_ACCOUNT_NUMBER;
		retString = act1.getAccountNumber();
		assertEquals(expString, retString);
		expBalance = -100.0;
		actualBalance = act1.getBalance();
		diff = Math.abs(expBalance-actualBalance);
		assertTrue(diff<= allowDiff);
		expBusType = BusinessType.LLC;
		actualBusType = act1.getBusinessType();
		assertEquals(expBusType, actualBusType);	
		expActType = AccountType.SAVINGS;
		actualActType = act1.getAccountType();
		assertEquals(expActType, actualActType);
	}

	void testToString()
	{
		System.out.println("\n***** now testing toString(); ");
		BankAccount someAct = new BankAccount("AAbb12", "LAWREnCE ", " BoB", AccountType.CHECKING, BusinessType.LLC, 100.00);
		String retString = someAct.toString();
		System.out.println("toString() of someAct: " + retString);
		String expString = "aabb12";
		assertTrue(retString.contains(expString));
		expString = "Bob";
		assertTrue(retString.contains(expString));
		expString = "Lawrence";
		assertTrue(retString.contains(expString));
		expString = "100.";
		assertTrue(retString.contains(expString));
		expString = "CHECKING";
		assertTrue(retString.contains(expString));
		expString = "LLC";
		assertTrue(retString.contains(expString));
		int numLines = utils.MyUtils.numberLines(retString);
		int expLines = 0;
		assertEquals(expLines,numLines);

		BankAccount act = new BankAccount();
		retString = act.toString();
		expString = BankAccount.DEFAULT_ACCOUNT_NUMBER;
		assertTrue(retString.contains(expString));
		expString = BankAccount.DEFAULT_NAME;
		assertTrue(retString.contains(expString));
		expString = "0";
		assertTrue(retString.contains(expString));


		System.out.println("End of testToString()");
	}

	void testSetters()
	{
		System.out.println("Now testing setters for " + sName + " ...");
		String expString="";
		String retString="";
		double expBalance=0.0;
		double actualBalance = 0.0;
		double diff = 0.0;
		double allowDiff = 0.0005;

		AccountType expActType = AccountType.CHECKING;
		BusinessType expBusType = BusinessType.PERSONAL;
		AccountType actualActType = AccountType.CHECKING;
		BusinessType actualBusType = BusinessType.PERSONAL;
		BankAccount b1 = new BankAccount();

		b1.setAccountNumber("KKK222");
		expString = "kkk222";
		retString = b1.getAccountNumber();
		assertEquals(expString, retString);	
		b1.setAccountNumber("hhh9;2");
		expString = BankAccount.DEFAULT_ACCOUNT_NUMBER;
		retString = b1.getAccountNumber();
		assertEquals(expString, retString);

		b1.setAccountNumber("bbbcccddd");
		expString = BankAccount.DEFAULT_ACCOUNT_NUMBER;
		retString = b1.getAccountNumber();
		assertEquals(expString, retString);
		b1.setLastName("  LoPez MarTIN  ");
		expString = "Lopez Martin";
		retString = b1.getLastName();
		assertEquals(expString, retString);
		b1.setLastName("    ");
		expString = BankAccount.DEFAULT_NAME;
		retString = b1.getLastName();
		assertEquals(expString, retString);
		b1.setLastName("");
		expString = BankAccount.DEFAULT_NAME;
		retString = b1.getLastName();
		assertEquals(expString, retString);
		b1.setFirstName("");
		expString = BankAccount.DEFAULT_NAME;
		retString = b1.getFirstName();
		assertEquals(expString, retString);
		b1.setFirstName(" aNN       MarIE    ");
		expString = "Ann Marie";
		retString = b1.getFirstName();
		assertEquals(expString, retString);
		b1.setFirstName("  ");
		expString = BankAccount.DEFAULT_NAME;
		retString = b1.getFirstName();
		assertEquals(expString, retString);
		b1.setFirstName("  SammY");
		expString = "Sammy";
		retString = b1.getFirstName();
		assertEquals(expString, retString);
		b1.setAccountType(AccountType.SAVINGS);
		expActType = AccountType.SAVINGS;
		actualActType = b1.getAccountType();
		assertEquals(expActType, actualActType);
		b1.setAccountType(AccountType.MONEY_MARKET);
		expActType = AccountType.MONEY_MARKET;
		actualActType = b1.getAccountType();
		assertEquals(expActType, actualActType);
		b1.setBusinessType(BusinessType.CORPORATE);
		expBusType = BusinessType.CORPORATE;
		actualBusType = b1.getBusinessType();
		assertEquals(expBusType, actualBusType);
		b1.setBusinessType(BusinessType.LLC);
		expBusType = BusinessType.LLC;
		actualBusType = b1.getBusinessType();
		assertEquals(expBusType, actualBusType);
		b1.setBusinessType(BusinessType.PERSONAL);
		expBusType = BusinessType.PERSONAL;
		actualBusType = b1.getBusinessType();
		assertEquals(expBusType, actualBusType);
		b1.setBalance(100.00);
		expBalance = 100.0;
		actualBalance = b1.getBalance();
		diff = Math.abs(expBalance-actualBalance);
		assertTrue(diff < allowDiff);
		b1.setBalance(0.00);
		expBalance = 0.0;
		actualBalance = b1.getBalance();
		diff = Math.abs(expBalance-actualBalance);
		assertTrue(diff < allowDiff);
		b1.setBalance(-100.00);
		expBalance = -100.0;
		actualBalance = b1.getBalance();
		diff = Math.abs(expBalance-actualBalance);
		assertEquals(expBusType, actualBusType);
		retString = b1.toString();
		int actualCount = utils.MyUtils.numberLines(retString);
		int expCount = 0;
		assertEquals(expCount, actualCount);
		System.out.println("toString() of b1: " + b1.toString());


		System.out.println("\n********Now Testing readFromScanner in BankAccountUtilsImpl********");
		Scanner in = new Scanner(System.in);
		String fileName = "";
		Scanner inFile = null;
		fileName= "bankaccountEmpty.txt";
		try 
		{
			inFile = new Scanner(new File(fileName));
			System.out.println("****Output of " + fileName + ":");
		}
		catch(FileNotFoundException e)
		{
			System.out.println("error, cannot open file: " + fileName +
					" now exiting....");
			return;
		}
		while(inFile.hasNext())
		{
			BankAccount b2 = BankAccountUtilsImpl.readFromScanner(inFile);
			if(b2 != null)
				System.out.println("bank account:  " + b2);
		}//end while
		inFile.close();

		fileName= "bankaccount1.txt";
		try 
		{
			inFile = new Scanner(new File(fileName));
			System.out.println("****Output of " + fileName + ":");
		}
		catch(FileNotFoundException e)
		{
			System.out.println("error, cannot open file: " + fileName +
					" now exiting....");
			return;
		}
		while(inFile.hasNext())
		{
			BankAccount b2 = BankAccountUtilsImpl.readFromScanner(inFile);
			if(b2 != null)
				System.out.println("bank account:  " + b2);
		}//end while
		inFile.close();

		fileName= "bankaccount.txt";
		try 
		{
			inFile = new Scanner(new File(fileName));
			System.out.println("****Output of " + fileName + ":");
		}
		catch(FileNotFoundException e)
		{
			System.out.println("error, cannot open file: " + fileName +
					" now exiting....");
			return;
		}
		PrintWriter outFile = null;
		fileName = "out1.txt";
		try {
			outFile = new PrintWriter(new File(fileName));
		} catch (FileNotFoundException e) {
			System.out.println("FAILURE Error, cannot open file " + fileName + " for writing");
			return;
		}
		while(inFile.hasNext())
		{
			BankAccount b2 = BankAccountUtilsImpl.readFromScanner(inFile);
			if(b2 != null)
				System.out.println("bank account:  " + b2);
			BankAccountUtilsImpl.writeToFile(outFile,  b2);
		}//end while
		inFile.close();
		outFile.close();
		System.out.println("\n*******Now testing that writeToFile method worked...********");
		fileName = "out1.txt";
		try 
		{
			inFile = new Scanner(new File(fileName));
			System.out.println("****Output of " + fileName + " should be a copy of bankaccount.txt:****");

		}
		catch(FileNotFoundException e)
		{
			System.out.println("error, cannot open file: " + fileName +
					" now exiting....");
			return;
		}
		while(inFile.hasNext())
		{
			BankAccount b2 = BankAccountUtilsImpl.readFromScanner(inFile);
			if(b2 != null)
				System.out.println("bank account:  " + b2);
		}//end while

		fileName= "bankaccountError.txt";
		try 
		{
			inFile = new Scanner(new File(fileName));
			System.out.println("****Output of " + fileName + ":");
		}
		catch(FileNotFoundException e)
		{
			System.out.println("error, cannot open file: " + fileName +
					" now exiting....");
			return;
		}

		while(inFile.hasNext())
		{
			BankAccount b2 = BankAccountUtilsImpl.readFromScanner(inFile);
			if(b2 != null)
				System.out.println("FAILURE should not correctly read:  " + b2 + " from " + fileName);
			else
				System.out.println("SUCCESS -- Correctly finding error in file: " + fileName);
		}//end while
		inFile.close();

		System.out.println("Ending Bank Account Test for: " + sName);
		utils.MyUtils.printTimeStamp("End");

	}

}


