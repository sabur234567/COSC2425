/**
 * 
 */
package asg1;

import java.util.Scanner;

/**
 * @author Sabur Khan
 *
 */
public class Asg1Part1 {
	public static void main(String[] args)
	{
		int age = 0;
		double gpa = 0.0;
		String homeTown = "";
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter your age:");
		age = scanner.nextInt();		
		scanner.nextLine();				//throws away the enter key
		if (age >= 18)
		{		
			System.out.println("You are eligable to vote.");
		}
		if (age >= 35)
		{
			System.out.println("You are eligable to become the President of the United States.");
		}
		if (age>=65)
		{
			System.out.println("You are eligable to qualify for Medicare.");
		}
		if(age >= 16 && age <= 25)
		{
			System.out.println("You are paying extra for car insurance.");
		}
		System.out.println("Pleas enter your gpa:");
		gpa = scanner.nextDouble();
		scanner.nextLine();
		if(gpa<0.0 || gpa>4.00)
		{
			System.out.println("Invalid gpa.");
		}
		if(gpa>=3.25 && gpa <= 4.00)
		{
			System.out.println("Congratulations, you're eligable for the Dean's list.");
		}
		if(gpa<2.0 && gpa >= 0.00)	
		{
			System.out.println("Your gpa is causing probationary status.");
		}
		if(gpa>=2.5 && gpa <= 4.00)
		{
			System.out.println("Gpa is at least at satisfactory level.");
		}
		System.out.println("Please enter your hometown now:");
		homeTown = scanner.nextLine();
		System.out.println("Youre from, "+ homeTown + ". Welcome! Enjoy your time here.");
		System.out.println(homeTown.toUpperCase());
		System.out.println(homeTown.length());
	}	
}	
			