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
import asg5.BankAccountList;
import asg5.BankAccountListImpl;
import asg5.BankAccountListUtilsImpl;
import asg5.BankAccountUtilsImpl;
import asg5.BusinessType;

class Asg5Part2Test {

	static String sName = "";  // used for student name
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		sName = utils.MyUtils.getNameFromStudent();
		System.out.println("Test Assignment #5 Part 2 for " + sName + " self-certified by " + sName);
		System.out.println("Testing for " + sName + " begins..");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {

		System.out.println("End of Asg#5 Part 2 certified testing for " + sName + " .......");
	}
	@Test
	public void test()
	{
		testConstructors();
		testToString();
		testSetters();
		testEquals();
		testIOUtils();

		testListConstructorsAndtoString();
		testListContainsGetFind();
		testListCriteriaGetters();
		testListRemove();
		testListSortClear();

	}
	public void testListConstructorsAndtoString() {
		System.out.println("\n***** testing constructors and getters *****");
		BankAccountList list1 = new BankAccountListImpl();
		BankAccountList list2 = new BankAccountListImpl("bankaccount1.txt");
		BankAccountList list3 = new BankAccountListImpl("bankaccount.txt");
		BankAccountList list4 = new BankAccountListImpl("bankaccountExtra.txt");


		int expSize=0;
		int retSize=0;
		System.out.println("**** Testing getSize() **** ");
		retSize = list1.getSize();
		expSize=0;
		assertEquals(retSize, expSize);
		retSize = list2.getSize();
		expSize=1;
		assertEquals(expSize, retSize);
		retSize = list3.getSize();
		expSize=5;
		assertEquals(expSize, retSize);
		retSize = list4.getSize();
		expSize=15;
		assertEquals(expSize, retSize);

		String retString="", expString="";

		System.out.println("****Testing toString()****");
		System.out.println("Here is list1:  should be empty\n" + list1);
		expSize=0;
		retString = list1.toString();
		retSize=utils.MyUtils.numberLines(retString);
		assertEquals(expSize, retSize);
		System.out.println("Here is list2:  should have 1 account \n" + list2);
		expSize=1;
		retString = list2.toString();
		retSize=utils.MyUtils.numberLines(retString);
		assertEquals(expSize, retSize);
		System.out.println("Here is list3:  should have 5 accounts \n" + list3);
		expSize=5;
		retString = list3.toString();
		retSize=utils.MyUtils.numberLines(retString);
		expString = "pzg400";
		assertTrue(retString.contains(expString));
		expString = "Speith";
		assertTrue(retString.contains(expString));
		expString = "Martinez";
		assertTrue(retString.contains(expString));
		expString = "MONEY_MARKET";
		assertTrue(retString.contains(expString));
		expString = "Linda Marie";
		assertTrue(retString.contains(expString));
		expString = "1000";
		assertTrue(retString.contains(expString));

		System.out.println("Here is list4:  should have 15 (MAX_SIZE) accounts \n" + list4);
		expSize=15;
		retString = list4.toString();
		retSize=utils.MyUtils.numberLines(retString);
		assertEquals(expSize, retSize);

		System.out.println("**** End of testConstructorsAndtoString()****");
	}
	public void testListCriteriaGetters()
	{
		System.out.println("\n***** testing list criteria getters() *****");

		BankAccountList list1 = new BankAccountListImpl();
		BankAccountList list2 = new BankAccountListImpl("bankaccount1.txt");
		BankAccountList list3 = new BankAccountListImpl("bankaccount.txt");
		BankAccountList list4 = new BankAccountListImpl("bankaccountExtra.txt");
		AccountType actualActType = AccountType.CHECKING;


		BankAccount b5 = new BankAccount();
		b5.setAccountNumber("300rre");

		String retString = "";
		String expString = "";
		String actString = "";

		System.out.println("****Testing getAccountsDeficient() ****");
		expString = list1.getBankAccountsDeficient();
		assertEquals(0, utils.MyUtils.numberLines(expString), "list1 should be an empty list");
		assertEquals("", expString);
		expString = list2.getBankAccountsDeficient();
		assertEquals(0, utils.MyUtils.numberLines(expString), "list2 should not have any deficient accounts ");
		assertEquals("", expString);
		expString = list3.getBankAccountsDeficient();
		System.out.println("Here are the deficient accounts in list3:\n" + expString);
		expString = list4.getBankAccountsDeficient();
		assertEquals(3, utils.MyUtils.numberLines(expString), "list4 should have 3 deficient accounts");
		System.out.println("Here are the deficient accounts in list4:\n" + expString);
		System.out.println("****Testing getBankAccountsDeficient()****");
		retString = list1.getBankAccountsDeficient();
		assertEquals(0, utils.MyUtils.numberLines(retString));
		retString = list2.getBankAccountsDeficient();
		assertEquals(0, utils.MyUtils.numberLines(retString));
		retString = list3.getBankAccountsDeficient();
		assertEquals(1, utils.MyUtils.numberLines(retString));
		retString = list4.getBankAccountsDeficient();
		assertEquals(3, utils.MyUtils.numberLines(retString));

		System.out.println("****Testing getAccountsWithMatchingName() ****");
		actString = "GARcia";
		expString = list1.getBankAccountsWithMatchingLastName(actString);
		assertEquals(0, utils.MyUtils.numberLines(expString));
		expString = list2.getBankAccountsWithMatchingLastName(actString);
		assertEquals(0, utils.MyUtils.numberLines(expString));
		expString = list3.getBankAccountsWithMatchingLastName(actString);
		assertEquals(0, utils.MyUtils.numberLines(expString));
		expString = list4.getBankAccountsWithMatchingLastName(actString);
		assertEquals(2, utils.MyUtils.numberLines(expString));
		actString = "   howard   ";
		expString = list1.getBankAccountsWithMatchingLastName(actString);
		assertEquals(0, utils.MyUtils.numberLines(expString));
		expString = list2.getBankAccountsWithMatchingLastName(actString);
		assertEquals(0, utils.MyUtils.numberLines(expString));
		expString = list3.getBankAccountsWithMatchingLastName(actString);
		assertEquals(1, utils.MyUtils.numberLines(expString));
		expString = list4.getBankAccountsWithMatchingLastName(actString);
		assertEquals(2, utils.MyUtils.numberLines(expString));

		System.out.println("****Testing getAccountsWithAccountType() ****");
		actualActType = AccountType.CHECKING;
		expString = list1.getBankAccountsWithAccountType(actualActType);
		assertEquals(0, utils.MyUtils.numberLines(expString));
		expString = list2.getBankAccountsWithAccountType(actualActType);
		assertEquals(1, utils.MyUtils.numberLines(expString));
		expString = list3.getBankAccountsWithAccountType(actualActType);
		assertEquals(2, utils.MyUtils.numberLines(expString));
		expString = list4.getBankAccountsWithAccountType(actualActType);
		assertEquals(6, utils.MyUtils.numberLines(expString));
		actualActType = AccountType.SAVINGS;
		expString = list1.getBankAccountsWithAccountType(actualActType);
		assertEquals(0, utils.MyUtils.numberLines(expString));
		expString = list2.getBankAccountsWithAccountType(actualActType);
		assertEquals(0, utils.MyUtils.numberLines(expString));
		expString = list3.getBankAccountsWithAccountType(actualActType);
		assertEquals(2, utils.MyUtils.numberLines(expString));
		expString = list4.getBankAccountsWithAccountType(actualActType);
		assertEquals(6, utils.MyUtils.numberLines(expString));	
		System.out.println("****End of test list criteria Getters()****");
	}

	public void testContainsAndAdd()
	{
		System.out.println("\n***** testing contains() and add() *****");
		BankAccountList list1 = new BankAccountListImpl();
		BankAccountList list2 = new BankAccountListImpl("bankaccount1.txt");
		BankAccountList list3 = new BankAccountListImpl("bankaccount.txt");
		BankAccountList list4 = new BankAccountListImpl("bankaccountExtra.txt");

		BankAccount b1 = new BankAccount("jk3499", " woods", "Alan D  ", AccountType.SAVINGS, BusinessType.LLC, 1430.0);
		BankAccount b2 = new BankAccount("mr34xv"," Lopez GarzA ", "Mary ", AccountType.CHECKING, BusinessType.PERSONAL, -500.0);
		BankAccount b3 = new BankAccount("y200cs"," Jones", "linda marie  ", AccountType.SAVINGS, BusinessType.LLC, 1255.0);
		BankAccount b3New = new BankAccount("ge3343"," Anthony ", "linda marie  ", AccountType.SAVINGS, BusinessType.LLC, 1255.0);
		BankAccount b4 = new BankAccount("300rre", "martinez gOMEz",  "anna LISA  MaRIA", AccountType.CHECKING, BusinessType.CORPORATE, -300.00);
		BankAccount b5 = new BankAccount();
		b5.setAccountNumber("300rre");
		BankAccount b1Duplicate = new BankAccount("jk3499", " woods", "Alan D  ", AccountType.SAVINGS, BusinessType.LLC, 1430.0);
		assertEquals(b1, b1Duplicate);
		assertEquals(b1Duplicate, b1);
		assertEquals(b1.hashCode(), b1Duplicate.hashCode());
		assertFalse(b5.hashCode()== b4.hashCode());
		assertFalse(b1.hashCode()== b4.hashCode());
		b1Duplicate.setAccountNumber(b2.getAccountNumber());
		b1Duplicate.setLastName(b2.getLastName());
		b1Duplicate.setFirstName(b2.getFirstName());
		b1Duplicate.setAccountType(b2.getAccountType());
		b1Duplicate.setBusinessType(b2.getBusinessType());
		assertEquals(b2, b1Duplicate);
		assertEquals(b1Duplicate,b2);
		System.out.println("Account b2 and b1Duplicate match: " + ((b2.equals(b1Duplicate))? " -- YES " : " -- NO "));

		b5.setAccountNumber("300rre");

		assertFalse(list1.contains(b1));
		assertTrue(list2.contains(b4));
		assertFalse(list2.contains(b5));
		assertFalse(list3.contains(b5));
		assertTrue(list3.contains(b3));
		assertTrue(list4.contains(b4));
		assertFalse(list4.contains(b5));
		b5.setAccountNumber("a500bc");
		assertFalse(list4.contains(b5));
		System.out.println("\n***** testing contains() completed *****");

		assertTrue(list1.add(b1));
		assertTrue(list1.getSize() == 1);
		assertTrue(list1.add(b2));
		assertTrue(list1.getSize() ==2);
		assertFalse(list1.add(b1), "Should not be able to add same account again");
		assertFalse(list1.add(b2), "Should not be able to add same account again");
		assertTrue(list1.getSize() ==2);
		assertTrue(list4.getSize() == BankAccountList.MAX_SIZE);
		assertFalse(list4.add(b4), "Should not be able to add same account again");
		assertTrue(list4.getSize() == BankAccountList.MAX_SIZE);
		assertTrue(list3.add(b3New));
		assertFalse(list3.add(b4));
		assertTrue(list3.getSize() == 6);
		assertTrue(list3.contains(b3));
		assertTrue(list3.contains(b4));
		assertFalse(list3.add(b4));
		assertTrue(list3.getSize() == 6);
		System.out.println("Size: " + list1.getSize() + " expected(2)  list1: \n" + list1);
		System.out.println("Size: " + list2.getSize() + " expected(1) list2: \n" + list2);
		System.out.println("Size: " + list3.getSize() + " expected(6) list3: \n" + list3);
		System.out.println("Size: " + list4.getSize() + " expected(15) list4: \n" + list4);
		System.out.println("\n***** testing add() and contains() completed *****");	
	}	

	public void testListSortClear()
	{
		System.out.println("\nTesting List sort() and clear() ");
		BankAccountList list1 = new BankAccountListImpl();
		BankAccountList list2 = new BankAccountListImpl("bankaccount.txt");


		BankAccount b1 = new BankAccount("dd623x", " woods", "Alan D  ", AccountType.SAVINGS, BusinessType.LLC, 1430.0);
		BankAccount b2 = new BankAccount("aabb22"," Lopez GarzA ", "Mary ", AccountType.CHECKING, BusinessType.PERSONAL, -500.0);
		BankAccount b3 = new BankAccount("aamf93"," Lopez GarzA ", "Mary ", AccountType.CHECKING, BusinessType.PERSONAL, 1255.0);
		BankAccount b4 = new BankAccount("300rre"," Martinez Gomez", "Anna Lisa Maria", AccountType.CHECKING, BusinessType.CORPORATE,300.00);
		BankAccount b5 = new BankAccount("y200cs", "Jones", "Linda Marie ", AccountType.SAVINGS,BusinessType.LLC,200.00);
		int expSize=0;
		int retSize=0;

		String expString="";
		String retString="";

		list1.clear();
		assertEquals(0, list1.getSize());

		list2.clear();
		assertEquals(0, list1.getSize());
		retString = list2.toString();
		assertEquals("", retString);
		list2 = new BankAccountListImpl("bankaccount.txt");
		list1 = new BankAccountListImpl();
		System.out.println("Before sort, default list:\n" + list1);
		list1.sort();
		System.out.println("After sort, " + list1.getSize() + " element list:\n" + list1);

		System.out.println("Before sort, " + list2.getSize() + " element list:\n" + list2);
		list2.sort();
		System.out.println("After sort, 5 element list:\n" + list2);
		assertEquals(list2.get(0),b4);
		assertEquals(list2.get(4), b5);

		list2 = new BankAccountListImpl();
		assertTrue(list2.add(b1));
		System.out.println("Before sort, " + list2.getSize() + " element list:\n" + list2);
		list2.sort();
		System.out.println("After sort, " + list2.getSize() + " element list:\n" + list2);
		assertEquals(list2.get(0), b1);
		list2.clear();
		assertEquals(0, list2.getSize());
		retString = list2.toString();
		assertEquals(0, utils.MyUtils.numberLines(retString));
		list2.add(b1);
		assertTrue(list2.add(b2));
		System.out.println("Before sort, " + list2.getSize() + " element list:\n" + list2);
		list2.sort();
		assertEquals(list2.get(0), b2);
		assertEquals(list2.get(1), b1);
		System.out.println("After sort, " + list2.getSize() + " element list:\n" + list2);
		list2.clear();
		assertEquals(0, list2.getSize());
		retString = list2.toString();
		assertEquals(0, utils.MyUtils.numberLines(retString));
		assertTrue(list2.add(b1));
		assertTrue(list2.add(b2));
		assertTrue(list2.add(b4));
		System.out.println("Before sort, " + list2.getSize() + " element list:\n" + list2);
		list2.sort();
		assertEquals(list2.get(0), b4);
		assertEquals(list2.get(1), b2);
		assertEquals(list2.get(2), b1);
		System.out.println("After sort, " + list2.getSize() + " element list:\n" + list2);
		list2.sort();
		assertEquals(list2.get(0), b4);
		assertEquals(list2.get(1), b2);
		assertEquals(list2.get(2), b1);
		System.out.println("After sorting the sorted list, " + list2.getSize() + " element list:\n" + list2);

		list2 = new BankAccountListImpl("bankaccountExtra.txt");
		System.out.println("Max size list: " + list2.getSize() + " accounts " + "\n" + list2);
		list2.sort();
		System.out.println("Max size list: " + list2.getSize() + " SORTED accounts " + "\n" + list2);
		b1 = list2.get(14);
		b2 = list2.get(0);
		assertEquals("y200cs", b1.getAccountNumber());
		assertEquals("300rre", b2.getAccountNumber());
		System.out.println("*** End of testing List sort() and clear() ");

	}

	public void testListRemove()
	{

		System.out.println("\n***** Add() Remove() Testing *****");
		BankAccountList list1 = new BankAccountListImpl();
		BankAccountList list2 = new BankAccountListImpl();


		BankAccount b1 = new BankAccount("dd623x", " woods", "Alan D  ", AccountType.SAVINGS, BusinessType.LLC, 1430.0);
		BankAccount b2 = new BankAccount("aabb22"," Lopez GarzA ", "Mary ", AccountType.CHECKING, BusinessType.PERSONAL, -500.0);
		BankAccount b3 = new BankAccount("aamf93"," Lopez GarzA ", "Mary ", AccountType.CHECKING, BusinessType.PERSONAL, 1255.0);

		int expSize=0;
		int retSize=0;
		int loc = 0, retLoc = 0;

		String expString="";
		String retString="";
		loc = list1.find(b1);
		assertEquals(-1, loc);
		loc = list1.find(b2);
		assertEquals(-1, loc);
		BankAccount remAct = list1.remove(b2);
		assertEquals(null, remAct);

		assertTrue(list1.add(b1));
		loc = list1.find(b1);
		assertEquals(0, loc);
		loc = list1.find(b2);
		assertEquals(-1, loc);

		remAct = list1.remove(b1);
		assertEquals(b1, remAct);
		assertEquals(0, list1.getSize());

		assertTrue(list1.add(b1));
		assertTrue(list1.add(b2));
		list1.sort();
		loc = list1.find(b2);
		assertEquals(0, loc);
		assertFalse(list1.add(b2)); // duplicate not allowed

		remAct = list1.remove(b2);
		assertEquals(remAct, b2);

		remAct = list1.remove(b2);
		assertEquals(null, remAct);

		remAct = list1.remove(b3);
		assertEquals(null, remAct);

		remAct = list1.remove(b1);
		assertEquals(remAct, b1);

		remAct = list1.remove(b1);
		assertEquals(null, remAct);
		assertEquals(0,  list1.getSize());
		assertTrue(list1.add(b1));
		assertTrue(list1.add(b3));
		assertTrue(list1.add(b2));
		assertEquals(b1, list1.remove(b1));
		assertEquals(null, list1.remove(b1));

		assertEquals(b3, list1.remove(b3));
		assertEquals(null, list1.remove(b3));

		assertEquals(b2, list1.remove(b2));
		assertEquals(null, list1.remove(b2));

		System.out.println("**** end of list remove testing ");
	}
	public void testListContainsGetFind() 
	{
		System.out.println("\n***** contains() get() find() Testing *****");
		BankAccountList list1 = new BankAccountListImpl();
		BankAccountList list2 = new BankAccountListImpl();


		BankAccount b1 = new BankAccount("dd623x", " woods", "Alan D  ", AccountType.SAVINGS, BusinessType.LLC, 1430.0);
		BankAccount b2 = new BankAccount("aabb22"," Lopez GarzA ", "Mary ", AccountType.CHECKING, BusinessType.PERSONAL, -500.0);
		BankAccount b3 = new BankAccount("aamf93"," Lopez GarzA ", "Mary ", AccountType.CHECKING, BusinessType.PERSONAL, 1255.0);
		BankAccount b4 = new BankAccount("vbtr45", " GARCIA ", "JOHN ", AccountType.MONEY_MARKET, BusinessType.CORPORATE, 900.00);

		int expSize=0;
		int retSize=0;

		String expString="";
		String retString="";

		System.out.println("**** Testing getSize() **** ");
		retSize = list1.getSize();
		expSize=0;
		assertEquals(expSize, retSize);
		System.out.println("**** Testing contains() **** ");
		boolean expBool = false;
		boolean retBool = list1.contains(b1);
		assertEquals(expBool, retBool);
		expBool=false;
		retBool = list2.contains(b2);
		assertEquals(expBool, retBool);	
		list1.add(b1);
		expBool=true;
		retBool = list1.contains(b1);
		assertEquals(expBool, retBool);
		expSize=1;
		retSize = list1.getSize();
		assertEquals(expSize, retSize);
		assertTrue(list1.add(b2));
		assertEquals(2, list1.getSize());

		System.out.println("**** Testing find() **** ");
		int retLoc = list1.find(b1);
		int expLoc = 0;
		assertEquals(expLoc, retLoc);
		retLoc = list1.find(b2);
		expLoc = 1;
		assertEquals(expLoc, retLoc);
		retLoc = list1.find(b4);
		assertEquals(-1, retLoc);
		retLoc = list1.find(b3);
		assertEquals(-1, retLoc);
		assertTrue(list1.add(b3));
		retLoc = list1.find(b3);
		expLoc = 2;
		assertEquals(expLoc, retLoc);
		retLoc = list1.find(b4);
		expLoc = -1;
		assertEquals(expLoc, retLoc);
		expBool = true;
		retBool = list1.add(b4);
		assertEquals(expLoc, retLoc);		
		expBool = true;
		retBool = list1.contains(b4);
		assertEquals(expLoc, retLoc);
		retLoc = list1.find(b4);
		expLoc = 3;
		assertEquals(expLoc, retLoc);
		expSize=4;
		retSize = list1.getSize();
		assertEquals(expSize, retSize);
		System.out.println("**** Testing get() **** ");

		BankAccount retAct = list1.get(0);
		BankAccount expAct = b1;
		assertEquals(expAct, retAct);
		retAct = list1.get(1);
		expAct = b2;
		assertEquals(expAct, retAct);
		retAct = list1.get(2);
		expAct = b3;
		assertEquals(expAct, retAct);
		retAct = list1.get(3);
		expAct = b4;
		assertEquals(expAct, retAct);
		BankAccount b5 = new BankAccount("yy492x", " RogersStein", "MaRCOs", AccountType.CHECKING, BusinessType.CORPORATE, 3000.0);
		retAct = list1.get(-2);
		expAct = null;
		assertEquals(expAct, retAct);
		retAct = list1.get(4);
		expAct = null;
		assertEquals(expAct, retAct);
		retAct = list1.get(100);
		expAct = null;
		assertEquals(expAct, retAct);
		retAct = list1.get(-5);
		expAct = null;
		assertEquals(expAct, retAct);
		list2 = new BankAccountListImpl();
		retAct = list2.get(0);
		expAct = null;
		assertEquals(expAct, retAct);


		System.out.println("Current List of BankAccounts: should be  4\n" + list1);
		expBool = true;
		retBool = list1.add(b5);
		assertEquals(expBool, retBool);
		System.out.println("Current List of Bank Accounts: should be 5\n" + list1);



		System.out.println("\n***** end of testing contains() get() find()   *****");
	}

	public void testUtilsMethods()
	{
		BankAccountList list1 = new BankAccountListImpl();

		System.out.println("\n------------------------------------------------------");
		System.out.println("\n**** Now testing BankAccountListUtilsImpl methods ****");
		String fileName="";
		Scanner inFile = null;
		PrintWriter outFile = null;
		fileName= "bankaccountEmpty.txt";
		list1 = new BankAccountListImpl();
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
		BankAccountListUtilsImpl.readFromScanner(inFile, list1);
		int size1 = list1.getSize();
		assertEquals(size1, 0);
		inFile.close();
		System.out.println("Contents of " + fileName + " after reading \n" + list1);
		fileName = "bankaccount1.txt";
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
		BankAccountListUtilsImpl.readFromScanner(inFile, list1);
		size1 = list1.getSize();
		assertEquals(size1, 1);
		fileName="bankaccount1out.txt";
		try {
			outFile = new PrintWriter(new File(fileName));
		} catch (FileNotFoundException e) {
			System.out.println("FAILURE Error, cannot open file " + fileName + " for writing");
			return;
		}
		BankAccountListUtilsImpl.writeToFile(outFile,  list1);
		outFile.close();
		list1.clear();
		assertTrue(list1.getSize() == 0);
		list1 = new BankAccountListImpl();
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
		BankAccountListUtilsImpl.readFromScanner(inFile, list1);
		int size2=list1.getSize();
		assertTrue(size1 == size2 && size1 != 0);

		System.out.println("Contents of previously written file: " + fileName + "\n" + list1);
		System.out.println("**** Now testing several accounts on a file - read and write ****");
		fileName= "bankaccount.txt";
		list1 = new BankAccountListImpl();
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
		BankAccountListUtilsImpl.readFromScanner(inFile, list1);
		inFile.close();
		size1=list1.getSize();
		System.out.println("Contents of " + fileName + " after reading \n" + list1);
		fileName = "bankaccountout.txt";
		try {
			outFile = new PrintWriter(new File(fileName));
		} catch (FileNotFoundException e) {
			System.out.println("FAILURE Error, cannot open file " + fileName + " for writing");
			return;
		}
		BankAccountListUtilsImpl.writeToFile(outFile,  list1);
		outFile.close();
		list1.clear();
		assertTrue(list1.getSize() == 0);
		list1 = new BankAccountListImpl();
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
		BankAccountListUtilsImpl.readFromScanner(inFile, list1);
		inFile.close();
		size2=list1.getSize();
		assertTrue(size1 == size2 && size1 != 0);	
		System.out.println("Contents of previously written file " + fileName + " after reading \n" + list1);
		fileName= "bankaccountExtra.txt";
		list1 = new BankAccountListImpl();
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
		BankAccountListUtilsImpl.readFromScanner(inFile, list1);
		inFile.close();
		size1=list1.getSize();
		assertTrue(size1==BankAccountList.MAX_SIZE);
		System.out.println("Contents of " + fileName + " after reading \n" + list1);
		fileName = "bankaccountExtraout.txt";
		try {
			outFile = new PrintWriter(new File(fileName));
		} catch (FileNotFoundException e) {
			System.out.println("FAILURE Error, cannot open file " + fileName + " for writing");
			return;
		}
		BankAccountListUtilsImpl.writeToFile(outFile,  list1);
		outFile.close();
		list1.clear();
		assertTrue(list1.getSize() == 0);
		String expString = "";
		String actString = list1.toString();
		assertEquals(actString, expString);
		list1 = new BankAccountListImpl();
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
		BankAccountListUtilsImpl.readFromScanner(inFile, list1);
		inFile.close();
		size2=list1.getSize();
		assertTrue(size1 == size2 && size1 != 0);

		System.out.println("Contents of previously written file " + fileName + " after reading \n" + list1);
		System.out.println("**** End of testUtilsMethods() **** \n");

	}

	void testEquals()
	{
		utils.MyUtils.printTimeStamp("Begin Testing Override of equals");

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

	}

}
