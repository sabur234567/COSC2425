package test;

import java.util.Scanner;

import asg2.Asg2Methods;
// test for Assignment #2
public class Asg2Test {
	public static void main(String[] args) 
	{
		String yourName = "";
		Scanner in = new Scanner(System.in);
		System.out.println("Enter your name: ");
		yourName = in.nextLine();
		System.out.println("Testing for " + yourName);
		testComputeDiscountRate();
		testSillyString();
		testIsValid();
		testRemoveSpaces();
		testGetFirstLast();
		testToCelsius();
		testGetLetterGrade();
		testGetWeatherMessage();
		System.out.println("\nEnd of Testing for " + yourName);
	}

	//receives: nothing
	// returns: nothing
	// tests for computeDiscountRate() method
	public static void testComputeDiscountRate()
	{
		System.out.println("*****Now testing computeDiscountRate method*****");
		char code = 'K';
		double retPrice = 0.00;
		double expPrice = 0.10;
		retPrice = Asg2Methods.computeDiscountRate(code);
		if(retPrice < expPrice || retPrice > expPrice)
			System.out.println("FAILURE expected discount rate to be: " + expPrice + " instead was " + retPrice);
		else
			System.out.println("SUCCESS expected discount rate was: " + retPrice);
		code = 'k';

		expPrice = 0.10;
		retPrice = Asg2Methods.computeDiscountRate(code);
		if(retPrice < expPrice || retPrice > expPrice)
			System.out.println("FAILURE expected discount rate to be: " + expPrice + " instead was " + retPrice);
		else
			System.out.println("SUCCESS expected discount rate was: " + retPrice);
		code = 'G';

		expPrice = 0.25;
		retPrice = Asg2Methods.computeDiscountRate(code);
		if(retPrice < expPrice || retPrice > expPrice)
			System.out.println("FAILURE expected discount rate to be: " + expPrice + " instead was " + retPrice);
		else
			System.out.println("SUCCESS expected discount rate was: " + retPrice);
		code = 'g';

		expPrice = 0.25;
		retPrice = Asg2Methods.computeDiscountRate(code);
		if(retPrice < expPrice || retPrice > expPrice)
			System.out.println("FAILURE expected discount rate to be: " + expPrice + " instead was " + retPrice);
		else
			System.out.println("SUCCESS expected discount rate was: " + retPrice);
		code = 'G';
		expPrice = 0.25;
		retPrice = Asg2Methods.computeDiscountRate(code);
		if(retPrice < expPrice || retPrice > expPrice)
			System.out.println("FAILURE expected discount rate to be: " + expPrice + " instead was " + retPrice);
		else
			System.out.println("SUCCESS expected discount rate was: " + retPrice);

		code = 'z';

		expPrice = 0.40;
		retPrice = Asg2Methods.computeDiscountRate(code);
		if(retPrice < expPrice || retPrice > expPrice)
			System.out.println("FAILURE expected discount rate to be: " + expPrice + " instead was " + retPrice);
		else
			System.out.println("SUCCESS expected discount rate was: " + retPrice);
		code = 'Z';

		expPrice = 0.40;
		retPrice = Asg2Methods.computeDiscountRate(code);
		if(retPrice < expPrice || retPrice > expPrice)
			System.out.println("FAILURE expected discount rate to be: " + expPrice + " instead was " + retPrice);
		else
			System.out.println("SUCCESS expected discount rate was: " + retPrice);
		code = ';';

		expPrice = 0.0;
		retPrice = Asg2Methods.computeDiscountRate(code);
		if(retPrice < expPrice || retPrice > expPrice)
			System.out.println("FAILURE expected discount rate to be: " + expPrice + " instead was " + retPrice);
		else
			System.out.println("SUCCESS expected discount rate was: " + retPrice);
		code = 'B';

		expPrice = 0.00;
		retPrice = Asg2Methods.computeDiscountRate(code);
		if(retPrice < expPrice || retPrice > expPrice)
			System.out.println("FAILURE expected discount rate to be: " + expPrice + " instead was " + retPrice);
		else
			System.out.println("SUCCESS expected discount rate was: " + retPrice);
		code = '$';

		expPrice = 0.00;
		retPrice = Asg2Methods.computeDiscountRate(code);
		if(retPrice < expPrice || retPrice > expPrice)
			System.out.println("FAILURE expected discount rate to be: " + expPrice + " instead was " + retPrice);
		else
			System.out.println("SUCCESS expected discount rate was: " + retPrice);
	}
	//receives: nothing
	// returns: nothing
	// tests for sillyString() method
	public static void testSillyString()
	{
		System.out.println("***** Now testing sillyString() method*****");
		String orgString ="";
		String retString ="";
		String expString="";
		orgString ="zoo Loos";
		expString = "z@@ l@@$";
		retString=Asg2Methods.sillyString(orgString);
		if(retString.equals(expString))
			System.out.println("SUCCESS  expected:" + expString + " received " + retString);
		else
			System.out.println("FAILURE expected:" + expString + " WRONGLY received " + retString);
		orgString ="Lots of Vowels here haaaaaaaaa";
		expString = "l@t$ @f v@wel$ here haaaaaaaaa";
		retString=Asg2Methods.sillyString(orgString);
		if(retString.equals(expString))
			System.out.println("SUCCESS  expected:" + expString + " received " + retString);
		else
			System.out.println("FAILURE expected:" + expString + " WRONGLY received " + retString);
		orgString = "PTs SJK ROT ";
		expString = "pt$ $jk r@t ";
		retString=Asg2Methods.sillyString(orgString);
		if(retString.equals(expString))
			System.out.println("SUCCESS  expected:" + expString + " received " + retString);
		else
			System.out.println("FAILURE expected:" + expString + " WRONGLY received " + retString);
		orgString = "";
		expString = "";
		retString=Asg2Methods.sillyString(orgString);
		if(retString.equals(expString))
			System.out.println("SUCCESS  expected:" + expString + " (empty string) received " + retString);
		else
			System.out.println("FAILURE expected:" + expString + " (empty string) WRONGLY received " + retString);
		orgString = ";**&&%$#@ ";
		expString = ";**&&%$#@ ";
		retString=Asg2Methods.sillyString(orgString);
		if(retString.equals(expString))
			System.out.println("SUCCESS  expected:" + expString + " received " + retString);
		else
			System.out.println("FAILURE expected:" + expString + " WRONGLY received " + retString);
		orgString = "Oh WOW silly String";
		expString = "@h w@w $illy $tring";
		retString=Asg2Methods.sillyString(orgString);
		if(retString.equals(expString))
			System.out.println("SUCCESS  expected:" + expString + " received " + retString);
		else
			System.out.println("FAILURE expected:" + expString + " WRONGLY received " + retString);
	}

	//receives: nothing
	// returns: nothing
	// tests for isValid() method
	public static void testIsValid()
	{
		System.out.println("*****Now testing isValid()*****");	
		String string = "";
		boolean expBool = false;
		boolean retBool = Asg2Methods.isValid(string);
		if(retBool == expBool)
			System.out.println("SUCCESS expected returned value to be: " + retBool );
		else
			System.out.println("FAILURE expected returned value to be: " + expBool + " instead was: " + retBool);
		string = "thisIsAValid233String999";
		expBool = true;
		retBool = Asg2Methods.isValid(string);
		if(retBool == expBool)
			System.out.println("SUCCESS expected returned value to be: " + retBool );
		else
			System.out.println("FAILURE expected returned value to be: " + expBool + " instead was: " + retBool);
		string = "12345678900";
		expBool = true;
		retBool = Asg2Methods.isValid(string);
		if(retBool == expBool)
			System.out.println("SUCCESS expected returned value to be: " + retBool );
		else
			System.out.println("FAILURE expected returned value to be: " + expBool + " instead was: " + retBool);
		string = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		expBool = true;
		retBool = Asg2Methods.isValid(string);
		if(retBool == expBool)
			System.out.println("SUCCESS expected returned value to be: " + retBool );
		else
			System.out.println("FAILURE expected returned value to be: " + expBool + " instead was: " + retBool);
		string = "ABCDEaabb FGHIJ22K33 ddLMNOPQRSTUVWXYZ";
		expBool = false;
		retBool = Asg2Methods.isValid(string);
		if(retBool == expBool)
			System.out.println("SUCCESS expected returned value to be: " + retBool );
		else
			System.out.println("FAILURE expected returned value to be: " + expBool + " instead was: " + retBool);
		string="";
		expBool = false;
		retBool = Asg2Methods.isValid(string);
		if(retBool == expBool)
			System.out.println("SUCCESS expected returned value to be: " + retBool );
		else
			System.out.println("FAILURE expected returned value to be: " + expBool + " instead was: " + retBool);
		System.out.println("***** Now testing countNewLines() *****");
		string ="Hello there!!!";
		int expVal = 0;
		int retVal = Asg2Methods.countNewLines(string);
		if(retVal == expVal)
			System.out.println("SUCCESS expected returned value to be: " + retVal);
		else
			System.out.println("FAILURE expected returned value to be: " + expVal + " instead was: " + retVal);
		string ="";
		expVal = 0;
		retVal = Asg2Methods.countNewLines(string);
		if(retVal == expVal)
			System.out.println("SUCCESS expected returned value to be: " + retVal);
		else
			System.out.println("FAILURE expected returned value to be: " + expVal + " instead was: " + retVal);
		string ="\n\n \n ee \n\n\n";
		expVal = 6;
		retVal = Asg2Methods.countNewLines(string);
		if(retVal == expVal)
			System.out.println("SUCCESS expected returned value to be: " + retVal);
		else
			System.out.println("FAILURE expected returned value to be: " + expVal + " instead was: " + retVal); 
		string ="\ntestingtestingtesting";
		expVal = 1;
		retVal = Asg2Methods.countNewLines(string);
		if(retVal == expVal)
			System.out.println("SUCCESS expected returned value to be: " + retVal);
		else
			System.out.println("FAILURE expected returned value to be: " + expVal + " instead was: " + retVal);
	}
	//receives: nothing
	// returns: nothing
	// tests for removeSpaces() method
	public static void testRemoveSpaces()
	{

		System.out.println("*****Now testing removeSpaces()*****");
		String orgString ="   Lots of Vowels here haaaaaaaaa    ";
		String expString = "LotsofVowelsherehaaaaaaaaa";
		String retString=Asg2Methods.removeSpaces(orgString);
		if(retString.equals(expString))
			System.out.println("SUCCESS  expected:" + expString + " received " + retString);
		else
			System.out.println("FAILURE expected:" + expString + " WRONGLY received " + retString);
		orgString ="     ";
		expString = "";
		retString=Asg2Methods.removeSpaces(orgString);
		if(retString.equals(expString))
			System.out.println("SUCCESS  expected:" + expString + " received " + retString);
		else
			System.out.println("FAILURE expected:" + expString + " WRONGLY received " + retString);
		orgString =" ";
		expString = "";
		retString=Asg2Methods.removeSpaces(orgString);
		if(retString.equals(expString))
			System.out.println("SUCCESS  expected:" + expString + " received " + retString);
		else
			System.out.println("FAILURE expected:" + expString + " WRONGLY received " + retString);
		orgString ="\t\t  \t\n\n\n  \n\n\n";
		expString = "";
		retString=Asg2Methods.removeSpaces(orgString);
		if(retString.equals(expString))
			System.out.println("SUCCESS  expected:" + expString + " received " + retString);
		else
			System.out.println("FAILURE expected:" + expString + " WRONGLY received " + retString);

		orgString ="test  \t\n\n\ntest  \n\n\n";
		expString = "testtest";
		retString=Asg2Methods.removeSpaces(orgString);
		if(retString.equals(expString))
			System.out.println("SUCCESS  expected:" + expString + " received " + retString);
		else
			System.out.println("FAILURE expected:" + expString + " WRONGLY received " + retString);
		orgString ="test3";
		expString = "test3";
		retString=Asg2Methods.removeSpaces(orgString);
		if(retString.equals(expString))
			System.out.println("SUCCESS  expected:" + expString + " received " + retString);
		else
			System.out.println("FAILURE expected:" + expString + " WRONGLY received " + retString);
		orgString ="   \n\n\ntest4";
		expString = "test4";
		retString=Asg2Methods.removeSpaces(orgString);
		if(retString.equals(expString))
			System.out.println("SUCCESS  expected:" + expString + " received " + retString);
		else
			System.out.println("FAILURE expected:" + expString + " WRONGLY received " + retString);

		orgString ="Test2\t  \t\n\n\n  \n\n\n";
		expString = "Test2";
		retString=Asg2Methods.removeSpaces(orgString);
		if(retString.equals(expString))
			System.out.println("SUCCESS  expected:" + expString + " received " + retString);
		else
			System.out.println("FAILURE expected:" + expString + " WRONGLY received " + retString);
	}
	//receives: nothing
	// returns: nothing
	// tests for getFirstLast() method
	public static void testGetFirstLast()
	{
		System.out.println("*****Now testing getFirstLast()*****");
		String orgString ="Lots of Vowels here haaaaaaaaa";
		String expString = "La";
		String retString=Asg2Methods.getFirstLast(orgString);
		if(retString.equals(expString))
			System.out.println("SUCCESS  expected:" + expString + " received " + retString);
		else
			System.out.println("FAILURE expected:" + expString + " WRONGLY received " + retString);
		orgString =" St. Edward's University";
		expString = "Sy";
		retString=Asg2Methods.getFirstLast(orgString);
		if(retString.equals(expString))
			System.out.println("SUCCESS  expected:" + expString + " received " + retString);
		else
			System.out.println("FAILURE expected:" + expString + " WRONGLY received " + retString);

		orgString ="aba ";
		expString = "aa";
		retString=Asg2Methods.getFirstLast(orgString);
		if(retString.equals(expString))
			System.out.println("SUCCESS  expected:" + expString + " received " + retString);
		else
			System.out.println("FAILURE expected:" + expString + " WRONGLY received " + retString);

		orgString ="ab";
		expString = "ab";
		retString=Asg2Methods.getFirstLast(orgString);
		if(retString.equals(expString))
			System.out.println("SUCCESS  expected:" + expString + " received " + retString);
		else
			System.out.println("FAILURE expected:" + expString + " WRONGLY received " + retString);
		orgString =" K ";
		expString = "K";
		retString=Asg2Methods.getFirstLast(orgString);
		if(retString.equals(expString))
			System.out.println("SUCCESS  expected:" + expString + " received " + retString);
		else
			System.out.println("FAILURE expected:" + expString + " WRONGLY received " + retString);
		orgString ="";
		expString = "";
		retString=Asg2Methods.getFirstLast(orgString);
		if(retString.equals(expString))
			System.out.println("SUCCESS  expected:" + expString + " received " + retString);
		else
			System.out.println("FAILURE expected:" + expString + " WRONGLY received " + retString);

		orgString ="1aaKaa1";
		expString = "11";
		retString=Asg2Methods.getFirstLast(orgString);
		if(retString.equals(expString))
			System.out.println("SUCCESS  expected:" + expString + " received " + retString);
		else
			System.out.println("FAILURE expected:" + expString + " WRONGLY received " + retString);
		orgString ="   1  Kaa1  ";
		expString = "11";
		retString=Asg2Methods.getFirstLast(orgString);
		if(retString.equals(expString))
			System.out.println("SUCCESS  expected:" + expString + " received " + retString);
		else
			System.out.println("FAILURE expected:" + expString + " WRONGLY received " + retString);
		orgString ="        a    ";
		expString = "a";
		retString=Asg2Methods.getFirstLast(orgString);
		if(retString.equals(expString))
			System.out.println("SUCCESS  expected:" + expString + " received " + retString);
		else
			System.out.println("FAILURE expected:" + expString + " WRONGLY received " + retString);
		orgString ="      ";
		expString = "";
		retString=Asg2Methods.getFirstLast(orgString);
		if(retString.equals(expString))
			System.out.println("SUCCESS  expected:" + expString + " received " + retString);
		else
			System.out.println("FAILURE expected:" + expString + " WRONGLY received " + retString);
	}
	//receives: nothing
	// returns: nothing
	// tests for toCelsius() method
	public static void testToCelsius()
	{
		System.out.println("*****Now testing toCelsius()*****");
		double expDouble=0.0;
		double retDouble = 0.0;
		double orgDouble = 0.0; 
		orgDouble = 212.0;
		expDouble = 100.0;
		retDouble = Asg2Methods.toCelsius(orgDouble);
		double diff = 0.0;
		double allowableDiff = 0.0001;  // if we are within 1/10000 we'll accept...
		diff = Math.abs(retDouble-expDouble);
		if(diff>allowableDiff)
			System.out.println("FAILURE expected:" + expDouble + " WRONGLY received: " + retDouble);
		else	
			System.out.println("SUCCESS  expected: " + expDouble + " received: " + retDouble);

		orgDouble = 32.0;
		expDouble = 0.0;
		retDouble = Asg2Methods.toCelsius(orgDouble);
		diff = Math.abs(retDouble-expDouble);
		if(diff>allowableDiff)
			System.out.println("FAILURE expected:" + expDouble + " WRONGLY received: " + retDouble);
		else	
			System.out.println("SUCCESS  expected: " + expDouble + " received: " + retDouble);
		orgDouble = 100.0;
		expDouble = 37.77777777777778;
		retDouble = Asg2Methods.toCelsius(orgDouble);
		diff = Math.abs(retDouble-expDouble);
		if(diff>allowableDiff)
			System.out.println("FAILURE expected:" + expDouble + " WRONGLY received: " + retDouble);
		else	
			System.out.println("SUCCESS  expected: " + expDouble + " received: " + retDouble);
		orgDouble = -100.0;
		expDouble = -73.33333333333334;
		retDouble = Asg2Methods.toCelsius(orgDouble);
		diff = Math.abs(retDouble-expDouble);
		if(diff>allowableDiff)
			System.out.println("FAILURE expected:" + expDouble + " WRONGLY received: " + retDouble);
		else	
			System.out.println("SUCCESS  expected: " + expDouble + " received: " + retDouble);
	}
	//receives: nothing
	// returns: nothing
	// tests for getLetterGrade() method
	public static void testGetLetterGrade()
	{
		System.out.println("****Now testing getLetterGrade()****");
		char expChar = 'A';
		char retChar='A';
		double orgDouble=89.9999;
		expChar = 'B';
		retChar = Asg2Methods.getLetterGrade(orgDouble);
		if(retChar == expChar)
			System.out.println("SUCCESS  expected:" + expChar + " received " + retChar);
		else
			System.out.println("FAILURE expected:" + expChar + " WRONGLY received " + retChar);
		orgDouble=104.0;
		expChar = 'A';
		retChar = Asg2Methods.getLetterGrade(orgDouble);
		if(retChar == expChar)
			System.out.println("SUCCESS  expected:" + expChar + " received " + retChar);
		else
			System.out.println("FAILURE expected:" + expChar + " WRONGLY received " + retChar);
		orgDouble=105.01;
		expChar = 'X';
		retChar = Asg2Methods.getLetterGrade(orgDouble);
		if(retChar == expChar)
			System.out.println("SUCCESS  expected:" + expChar + " received " + retChar);
		else
			System.out.println("FAILURE expected:" + expChar + " WRONGLY received " + retChar);
		orgDouble=111.9999;
		expChar = 'X';
		retChar = Asg2Methods.getLetterGrade(orgDouble);
		if(retChar == expChar)
			System.out.println("SUCCESS  expected:" + expChar + " received " + retChar);
		else
			System.out.println("FAILURE expected:" + expChar + " WRONGLY received " + retChar);
		orgDouble=-100.0;
		expChar = 'X';
		retChar = Asg2Methods.getLetterGrade(orgDouble);
		if(retChar == expChar)
			System.out.println("SUCCESS  expected:" + expChar + " received " + retChar);
		else
			System.out.println("FAILURE expected:" + expChar + " WRONGLY received " + retChar);
		orgDouble=79.9999;
		expChar = 'C';
		retChar = Asg2Methods.getLetterGrade(orgDouble);
		if(retChar == expChar)
			System.out.println("SUCCESS  expected:" + expChar + " received " + retChar);
		else
			System.out.println("FAILURE expected:" + expChar + " WRONGLY received " + retChar);
		orgDouble=80.0;
		expChar = 'B';
		retChar = Asg2Methods.getLetterGrade(orgDouble);
		if(retChar == expChar)
			System.out.println("SUCCESS  expected:" + expChar + " received " + retChar);
		else
			System.out.println("FAILURE expected:" + expChar + " WRONGLY received " + retChar);
		orgDouble=59.9999;
		expChar = 'F';
		retChar = Asg2Methods.getLetterGrade(orgDouble);
		if(retChar == expChar)
			System.out.println("SUCCESS  expected:" + expChar + " received " + retChar);
		else
			System.out.println("FAILURE expected:" + expChar + " WRONGLY received " + retChar);
		orgDouble=69.9999;
		expChar = 'D';
		retChar = Asg2Methods.getLetterGrade(orgDouble);
		if(retChar == expChar)
			System.out.println("SUCCESS  expected:" + expChar + " received " + retChar);
		else
			System.out.println("FAILURE expected:" + expChar + " WRONGLY received " + retChar);
		orgDouble=77.7777;
		expChar = 'C';
		retChar = Asg2Methods.getLetterGrade(orgDouble);
		if(retChar == expChar)
			System.out.println("SUCCESS  expected:" + expChar + " received " + retChar);
		else
			System.out.println("FAILURE expected:" + expChar + " WRONGLY received " + retChar);
		orgDouble=99.9999;
		expChar = 'A';
		retChar = Asg2Methods.getLetterGrade(orgDouble);
		if(retChar == expChar)
			System.out.println("SUCCESS  expected:" + expChar + " received " + retChar);
		else
			System.out.println("FAILURE expected:" + expChar + " WRONGLY received " + retChar);
	}
	//receives: nothing
	// returns: nothing
	// tests for getWeatherMessage() method
	public static void testGetWeatherMessage()
	{
		System.out.println("Now Testing getWeatherMessage() " );
		String result = "";
		int temp = -3;
		String retString = Asg2Methods.getWeatherMessage(temp);
		result = "FREEZING";

		if(retString.toUpperCase().contains(result))
		{
			System.out.println("SUCCESS expected " + result + " to be in result for temperature: " + temp);
		}
		else 
		{
			System.out.println("FAILURE expected " + result + " to be in the result for temperature: " + temp);
		}
		temp = 9;
		retString = Asg2Methods.getWeatherMessage(temp);
		result = "FREEZING";
		if(retString.toUpperCase().contains(result))
		{
			System.out.println("SUCCESS expected " + result + " to be in result for temperature: " + temp);
		}
		else 
		{
			System.out.println("FAILURE expected " + result + "  to be in the result for temperature: " + temp);
		}
		temp = 10;
		retString = Asg2Methods.getWeatherMessage(temp);
		result = "COLD";
		if(retString.toUpperCase().contains(result))
		{
			System.out.println("SUCCESS expected " + result + " to be in result for temperature: " + temp);
		}
		else 
		{
			System.out.println("FAILURE expected " + result + "  to be in the result for temperature: " + temp);
		}
		temp = 30;
		retString = Asg2Methods.getWeatherMessage(temp);
		result = "COLD";
		if(retString.toUpperCase().contains(result))
		{
			System.out.println("SUCCESS expected " + result + " to be in result for temperature: " + temp);
		}
		else 
		{
			System.out.println("FAILURE expected " + result + "  to be in the result for temperature: " + temp);
		}
		temp = 50;
		retString = Asg2Methods.getWeatherMessage(temp);
		result = "CHILLY";
		if(retString.toUpperCase().contains(result))
		{
			System.out.println("SUCCESS expected " + result + " to be in result for temperature: " + temp);
		}
		else 
		{
			System.out.println("FAILURE expected " + result + "  to be in the result for temperature: " + temp);
		}
		temp = 70;
		retString = Asg2Methods.getWeatherMessage(temp);
		result = "WARM";
		if(retString.toUpperCase().contains(result))
		{
			System.out.println("SUCCESS expected " + result + " to be in result for temperature: " + temp);
		}
		else 
		{
			System.out.println("FAILURE expected " + result + "  to be in the result for temperature: " + temp);
		}
		temp = 100;
		retString = Asg2Methods.getWeatherMessage(temp);
		result = "HOT";
		if(retString.toUpperCase().contains(result))
		{
			System.out.println("SUCCESS expected " + result + " to be in result for temperature: " + temp);
		}
		else 
		{
			System.out.println("FAILURE expected " + result + "  to be in the result for temperature: " + temp);
		}

	}
}
