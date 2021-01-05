package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import myarrays.ArrayExamples;

class Asg4Test {
	static String sName = "";  // used for student name
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		sName = utils.MyUtils.getNameFromStudent();
		System.out.println("Test for " + sName + " self-certified by " + sName);
		System.out.println("Testing for " + sName + " begins..");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {

		System.out.println("End of certified testing for " + sName + " .......");
	}
	@Test
	public void test()
	{
		testFindMaxAndMin();
		testComputeAvg();
		testReverseArray();
		testCountMatches();
		testResetArray();
		testLettersAndSum();

	}

	public void testFindMaxAndMin()
	{
		System.out.println("***Test of findMax and findMin***"); 
		int [] list1 = {122,22,333,43,100,200,300,400,-1, 35};
		int [] list1a = {100};
		int [] list2= {};

		int expInt =0, actInt=0;
		double expD=0.0, actD=0.0, allowDiff = 0.0005, diff = 0;

		System.out.println("**** Now testing findMax *****");
		System.out.println("Integer Array list2:");

		utils.MyUtils.showIntArray(list2, list2.length);
		expInt = 0;
		actInt = ArrayExamples.findMax(list2, list2.length);
		assertEquals(expInt, actInt);
		System.out.println("findMax returns: " + actInt);
		expInt = 0;
		actInt = ArrayExamples.findMin(list2, list2.length);
		assertEquals(expInt, actInt);
		System.out.println("findMin returns: " + actInt);
		System.out.println("Integer Array list2, first 3 values:");
		utils.MyUtils.showIntArray(list1, 3);
		expInt = 333;
		actInt = ArrayExamples.findMax(list1, 3);
		assertEquals(expInt, actInt);
		System.out.println("findMax returns: " + actInt);
		expInt = 22;
		actInt = ArrayExamples.findMin(list1, 3);
		assertEquals(expInt, actInt);
		System.out.println("findMin returns: " + actInt);


		System.out.println("Integer Array list1:");

		utils.MyUtils.showIntArray(list1, list1.length);
		expInt = 400;
		actInt = ArrayExamples.findMax(list1, list1.length);
		assertEquals(expInt, actInt);
		System.out.println("findMax returns: " + actInt);
		expInt = -1;
		actInt = ArrayExamples.findMin(list1, list1.length);
		assertEquals(expInt, actInt);
		System.out.println("findMin returns: " + actInt);
		list1[0]=1000;
		list1[list1.length-1] = -100;

		System.out.println("Integer Array:");
		utils.MyUtils.showIntArray(list1, list1.length);
		actInt = ArrayExamples.findMax(list1, list1.length);
		expInt = 1000;
		assertEquals(expInt, actInt);
		System.out.println("findMax returns: " + actInt);
		actInt = ArrayExamples.findMin(list1, list1.length);
		expInt = -100;
		assertEquals(expInt, actInt);
		System.out.println("findMin() returns: " + actInt);
		list1[list1.length-1]=1000;
		list1[0] = -200;
		System.out.println("Integer Array:");
		utils.MyUtils.showIntArray(list1, list1.length);
		expInt = 1000;
		actInt = ArrayExamples.findMax(list1, list1.length);
		assertEquals(expInt, actInt);
		System.out.println("findMax() returns: " + actInt);
		expInt = -200;
		actInt = ArrayExamples.findMin(list1, list1.length);
		assertEquals(expInt, actInt);
		System.out.println("findMin() returns: " + actInt);
		expD = 219.7;
		utils.MyUtils.showIntArray(list1, list1.length);
		actD = ArrayExamples.computeAverage(list1, list1.length);
		System.out.println(actD);
		diff = Math.abs(actD-expD);
		assertTrue(diff<= allowDiff);
		System.out.println("computeAverage() returns: " + actD);
		expD = 219.7;

		System.out.println("Integer Array:");
		utils.MyUtils.showIntArray(list1a, list1a.length);
		actInt = ArrayExamples.findMax(list1a, list1a.length);
		expInt = 100;
		assertEquals(expInt, actInt);
		System.out.println("findMax() returns: " + actInt);
		actInt = ArrayExamples.findMin(list1a, list1a.length);
		expInt = 100;
		assertEquals(expInt, actInt);
		System.out.println("findMin () returns: " + actInt);
		System.out.println("***End of Testing of findMax and findMin***"); 
	}

	public void testComputeAvg()
	{
		System.out.println("***Test of computeAverage***"); 
		int [] list1 = {1,2};
		int [] list2 = {2,3,4,5};
		//double [] list3 = { 100.0, 200.0, 100.0, -50.75, 1000.0, 0.05 };
		//double [] list4 = { -1.5 };
		int []list7 = {};
		double expD=0.0, actD=0.0, allowDiff = 0.0005, diff = 0;

		System.out.println("Integer Array:");
		utils.MyUtils.showIntArray(list2, 2);
		expD = 2.5;
		actD = ArrayExamples.computeAverage(list2, 2);
		diff = Math.abs(actD-expD);
		assertTrue(diff<= allowDiff);
		System.out.println("computeAverage() returns: " + actD);

		System.out.println("Integer Array:");
		utils.MyUtils.showIntArray(list7, list7.length);
		expD = 0.0;
		actD = ArrayExamples.computeAverage(list7, list7.length);
		diff = Math.abs(actD-expD);
		assertTrue(diff<= allowDiff);
		System.out.println("computeAverage() returns: " + actD);
		expD = 2.5;
		actD = ArrayExamples.computeAverage(list2, 2);
		diff = Math.abs(actD-expD);
		assertTrue(diff<= allowDiff);
		System.out.println("computeAverage() returns: " + actD);
		System.out.println("Integer Array:");
		utils.MyUtils.showIntArray(list1, list1.length);
		expD = 1.5;
		actD = ArrayExamples.computeAverage(list1, list1.length);
		diff = Math.abs(actD-expD);
		assertTrue(diff<= allowDiff);
		System.out.println("computeAverage() returns: " + actD);
		expD = 2.5;
		actD = ArrayExamples.computeAverage(list2, 2);
		diff = Math.abs(actD-expD);
		assertTrue(diff<= allowDiff);
		System.out.println("computeAverage() returns: " + actD);
		expD = 3.5;
		actD = ArrayExamples.computeAverage(list2, list2.length);
		diff = Math.abs(actD-expD);
		assertTrue(diff<= allowDiff);
		System.out.println("computeAverage() returns: " + actD);
		System.out.println("***End of Test of findMax and findMin***"); 
	}

	public void testReverseArray()
	{
		System.out.println("***Test of reverseArray ***"); 

		int [] list1 = {1,2};
		int [] list2 = {2,3,4};
		int [] list3 = {};

		utils.MyUtils.showIntArray(list1, list1.length);
		ArrayExamples.reverseArray(list1, list1.length);
		assertEquals(2,list1[0]);
		assertEquals(1,list1[1]);
		ArrayExamples.reverseArray(list1, 1);
		assertEquals(1,list1[1]);
		assertEquals(2,list1[0]);
		utils.MyUtils.showIntArray(list2, list2.length);
		ArrayExamples.reverseArray(list2, list2.length);
		assertEquals(4,list2[0]);
		assertEquals(3,list2[1]);
		assertEquals(2,list2[2]);
		utils.MyUtils.showIntArray(list2, list2.length);
		ArrayExamples.reverseArray(list2, 2);
		assertEquals(3,list2[0]);
		assertEquals(4,list2[1]);
		utils.MyUtils.showIntArray(list2, list2.length);
		ArrayExamples.reverseArray(list2, 0);
		assertEquals(3, list2[0]);
		assertEquals(4,list2[1]);
		utils.MyUtils.showIntArray(list2, 2);
		ArrayExamples.reverseArray(list2, 2);
		assertEquals(4, list2[0]);
		assertEquals(3,list2[1]);
		utils.MyUtils.showIntArray(list2, list2.length);
		ArrayExamples.reverseArray(list3,  0);
		System.out.println("Reverse works on an empty array ...");
		System.out.println("**END of testing reverseArray() **");
	}

	public void testCountMatches()
	{
		System.out.println("Testing countMatches()");
		int expInt=0,actInt=0;
		String  matchString="";
		String [] list5= { "appLE","APPle","apple", "orange", "banana"};
		String [] list6 = { "silly cat", "Big Cat", "Little cat", "crazY caT"};
		String [] list7= {};
		matchString = "APPle";
		actInt = ArrayExamples.countMatches(list7, list7.length, matchString);
		expInt = 0;
		assertEquals(expInt, actInt);
		System.out.println( matchString + " appears " + actInt + " time(s) "+ " expected: " + expInt );

		matchString = "APPle";
		actInt = ArrayExamples.countMatches(list5, list5.length, matchString);
		expInt = 3;
		assertEquals(expInt, actInt);
		System.out.println( matchString + " appears " + actInt + " time(s) "+ " expected: " + expInt );
		matchString = "oranGE";
		actInt = ArrayExamples.countMatches(list5, 3, matchString);
		expInt = 0;
		assertEquals(expInt, actInt);
		System.out.println( matchString + " appears " + actInt + " time(s) "+ " expected: " + expInt );

		matchString = "ORangE";
		actInt = ArrayExamples.countMatches(list5, list5.length, matchString);
		expInt = 1;
		assertEquals(expInt, actInt);
		System.out.println( matchString + " appears " + actInt + " time(s) "+ " expected: " + expInt );
		matchString = "bandana";
		actInt = ArrayExamples.countMatches(list5, list5.length, matchString);
		expInt = 0;
		assertEquals(expInt, actInt);
		System.out.println( matchString + " appears " + actInt + " time(s) "+ " expected: " + expInt );
		matchString = "banana";
		actInt = ArrayExamples.countMatches(list5, list5.length, matchString);
		expInt = 1;
		assertEquals(expInt, actInt);
		System.out.println( matchString + " appears " + actInt + " time(s) "+ " expected: " + expInt );
		matchString = "apple";
		actInt = ArrayExamples.countMatches(list5, 0, matchString);
		expInt = 0;
		assertEquals(expInt, actInt);
		System.out.println( matchString + " appears " + actInt + " time(s) "+ " expected: " + expInt );
		matchString = "crazy CAt";
		actInt = ArrayExamples.countMatches(list6, list6.length, matchString);
		expInt = 1;
		assertEquals(expInt, actInt);
		System.out.println( matchString + " appears " + actInt + " time(s) "+ " expected: " + expInt );
		matchString = "crazy CAt";
		actInt = ArrayExamples.countMatches(list6, list6.length, matchString);
		expInt = 1;
		assertEquals(expInt, actInt);
		matchString = "cr CAt";
		actInt = ArrayExamples.countMatches(list6, list6.length, matchString);
		expInt = 0;
		assertEquals(expInt, actInt);
		System.out.println( matchString + " appears " + actInt + " time(s) "+ " expected: " + expInt );
		matchString = "crazy CAt";
		actInt = ArrayExamples.countMatches(list6, 3, matchString);
		expInt = 0;
		assertEquals(expInt, actInt);
		System.out.println( matchString + " appears " + actInt + " time(s) "+ " expected: " + expInt );
		System.out.println("END Testing countMatches()");
	}

	public void testResetArray()
	{
		System.out.println("Testing resetArray()");
		int [] list1 = {1,2};
		int [] list2 = {2,3,4,5};
		int [] list3 = new int[100];
		int [] list7 = {};

		ArrayExamples.resetArray(list1);
		for(int i=0; i<list1.length; i++)
		{
			assertEquals(0, list1[i]);
		}
		ArrayExamples.resetArray(list7);
		for(int i=0; i<list7.length; i++)
		{
			assertEquals(0, list7[i]);
		}

		ArrayExamples.resetArray(list2);
		for(int i=0; i<list2.length; i++)
		{
			assertEquals(0, list2[i]);
		}
		utils.MyUtils.showIntArray(list2, list2.length);
		ArrayExamples.resetArray(list3);
		for(int i=0; i<list3.length; i++)
		{
			assertEquals(0, list3[i]);
		}
		System.out.println("END Testing resetArray()");
	}

	public void testLettersAndSum()
	{
		System.out.println("Testing getLetters and getArraySum and resetArray");
		int [] letterCount = new int [26];  // 26 letters in the alphabet
		int [] myArray = new int[2];
		int expInt=0,actInt=0, count=0;
		ArrayExamples.resetArray(myArray); 
		assertEquals(0, myArray[0]);
		assertEquals(0, myArray[1]);
		ArrayExamples.resetArray(letterCount); 
		for(int i=0; i<letterCount.length; i++)
		{
			assertEquals(0, letterCount[i]);
		}

		String testString = "Welcome";
		ArrayExamples.countLetters(testString, letterCount); 
		String result = ArrayExamples.getLetters(letterCount); // result should be "[ceelomw]"
		String correct = "[ceelmow]";
		System.out.println("Here are the letters in " + testString + ": " + result);
		assertEquals(correct, result);
		count = ArrayExamples.getCount(letterCount, 'e');   // should be 2
		assertEquals(2, count);
		ArrayExamples.resetArray(letterCount);
		testString = "123#$%^&*(";
		ArrayExamples.countLetters(testString, letterCount);
		result = ArrayExamples.getLetters(letterCount); // result should be "[]"
		correct = "[]";
		System.out.println("Here are the letters in " + testString + ": " + result);
		assertEquals(correct, result);
		ArrayExamples.resetArray(letterCount);
		testString = "dogs and cats";
		ArrayExamples.countLetters(testString, letterCount);
		result = ArrayExamples.getLetters(letterCount); // result should be "[aacddgno]"
		correct = "[aacddgnosst]";
		System.out.println("Here are the letters in " + testString + ": " + result);
		assertEquals(correct, result);
		char testLetter = 'z';
		count = ArrayExamples.getCount(letterCount, testLetter) ;// should be 0 - z appears 0 times
		System.out.println("Testing for count of " + testLetter + " result: " + count);
		assertEquals(0, count);
		testLetter = 'a';
		count = ArrayExamples.getCount(letterCount, testLetter) ;// should be 2 - a appears 2 times
		System.out.println("Testing for count of " + testLetter + " result: " + count);
		assertEquals(2, count);
		testLetter = 't';
		count = ArrayExamples.getCount(letterCount, testLetter) ;// should be 1 - t appears 1 times
		System.out.println("Testing for count of " + testLetter + " result: " + count);
		assertEquals(1, count);
		testLetter = 's';
		count = ArrayExamples.getCount(letterCount, testLetter) ;// should be 2 - s appears 2 times
		System.out.println("Testing for count of " + testLetter + " result: " + count);
		assertEquals(2, count);
		testLetter = '&';
		count = ArrayExamples.getCount(letterCount, testLetter) ;// should be 0 - & appears 0 times
		System.out.println("Testing for count of " + testLetter + " result: " + count);
		assertEquals(0, count);
		testLetter = '4';
		count = ArrayExamples.getCount(letterCount, testLetter) ;// should be 0 - & appears 0 times
		System.out.println("Testing for count of " + testLetter + " result: " + count);
		assertEquals(0, count);

		int [] letterCount2 = new int [26];  // another array for counting letters
		ArrayExamples.resetArray(letterCount2);
		testString = "Welcome to computer science all !!";
		ArrayExamples.countLetters(testString, letterCount2);  // get a second letter count for a different string
		result = ArrayExamples.getLetters(letterCount2); // result should be "[acccceeeeeilllmmnoooprsttuw]"
		correct = "[acccceeeeeilllmmnoooprsttuw]";
		System.out.println("Here are the letters in " + testString + ": " + result);
		assertEquals(correct, result);

		System.out.println("Now testing getArraySum()");
		int [] list2 = {2,3,4,5};
		int [] list3 = {2,3,4,5};
		utils.MyUtils.showIntArray(list2, list2.length);
		System.out.println("Showing sum of previous array summed with itself: ");
		int []sumArray;

		sumArray = ArrayExamples.getArraySum(list2,  list3);
		for(int i=0; i< list2.length; i++)
		{
			assertEquals(sumArray[i], list2[i]+list3[i]);
		}
		utils.MyUtils.showIntArray(sumArray, sumArray.length);
		int [] list4 = {5};
		int [] list5 = {5,6};
		sumArray=ArrayExamples.getArraySum(list4,  list5);
		assertEquals(0, sumArray.length);
		utils.MyUtils.showIntArray(list4, list4.length);
		System.out.println("Now testing arrays of length 0");
		int [] list6 = {};
		int [] list7 = {};
		assertEquals(0,list6.length);
		assertEquals(0,list7.length);
		sumArray=ArrayExamples.getArraySum(list6,  list7);
		assertEquals(0,sumArray.length);
		int [] list8= {11};
		System.out.println("Now testing arrays of length 1");
		utils.MyUtils.showIntArray(list8, list8.length);
		sumArray=ArrayExamples.getArraySum(list8,  list8);
		assertEquals(1, sumArray.length);
		assertEquals(22, sumArray[0]);
		utils.MyUtils.showIntArray(sumArray, sumArray.length);
		System.out.println("END of testLettersAndSumArrays()");
	}

}
