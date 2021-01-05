package asg1;

import java.util.Scanner;

public class Asg1Part3 {
	public static boolean isOdd (int number)
	{
		boolean isItOdd = false;
		if(number%2==0)
		{
			isItOdd = true;
		}
		return isItOdd;
	}
	public static String getCategory(double aValue)
	{
		String over = "Over";
		String avg = "Average";
		String below = "Below";
		if (aValue > 100)
		{
			return over;
		}
		else if (aValue <= 100 && aValue >= 25)
		{
			return avg;
		}
		else
		{
			return below;
		}
	}
	public static void main(String[] args)
	{
		int number2 = 0;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the number you want to test that is even or odd.");
		number2 = scanner.nextInt();
		isOdd(number2);
		if(isOdd(number2) == false)
		{
			System.out.println("ODD");
		}
		else
		{
			System.out.println("EVEN");
		}
		System.out.println(getCategory(100.1));
		System.out.println(getCategory(25.0));
		System.out.println(getCategory(24.5));
		System.out.println(getCategory(100.0));
	
	}
}		