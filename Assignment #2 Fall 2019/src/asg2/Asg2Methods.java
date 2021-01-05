package asg2;

public class Asg2Methods {

	public static double computeDiscountRate(char discountCode)
	{
		double discount = 0.10;
		double discount2 = 0.25;
		double discount3 = 0.40;
		
		if (discountCode == 'K' || discountCode =='k')
		{
			return discount;
		}
		if (discountCode == 'G' || discountCode == 'g')
		{
			return discount2;
		}
		if (discountCode == 'Z' || discountCode == 'z')
		{
			return discount3;
		}
		else
		{
			return 0.0;
		}

	}
	
	public static String sillyString(String aString)
	{
		String temp = "";
		for (int index = 0; index < aString.length(); index++) 
		{
			char ch = aString.charAt(index);
			ch = Character.toLowerCase(ch);
			if (ch == 's')
			{
				temp+='$';
			}
			else if (ch == 'o')
			{
				temp+='@';
			}
			else
			{
				temp+=ch;
			}
		}
		return temp;
	}
	public static boolean isValid(String aString)
	{
		boolean valid = false;
		for(int index = 0;index<aString.length();index++)
		{
			char ch = aString.charAt(index);
			if (Character.isDigit(ch) || Character.isLetter(ch))
			{
				valid = true;
			}
			else if(aString.length()==0)
			{
				valid = false;
			}
		}
		return valid;
	}
	
	public static String removeSpaces(String word)
	{
		String temp ="";
		for(int index=0;index<word.length();index++)
		{
			char ch = word.charAt(index);
			if (Character.isWhitespace(ch))
			{
				temp= temp + ""; 
			}
			else
			{
				temp = temp + ch;
			}
		}
		return temp;
	}
	
	public static double toCelsius(double temperature)
	{
		double newTemp = ((temperature - 32)*5)/9;
		return newTemp;
	}
	public static char getLetterGrade(double gradeAvg)
	{
		char grade =' ';
		if(gradeAvg >= 90.0 && gradeAvg<= 105.0)
		{
			grade = 'A';
		}
		else if(gradeAvg >= 80.0 && gradeAvg < 90.0)
		{
			grade = 'B';  
		}
		else if(gradeAvg >= 70.0 && gradeAvg < 80.0)
		{
			grade = 'C';
		}
		else if(gradeAvg >= 60.0 && gradeAvg < 70.0)
		{
			grade = 'D';
		}
		else if( gradeAvg < 60.0 && gradeAvg >= 0.0)
		{
			grade = 'F';
		}
		else
		{
			if(gradeAvg > 105.0 || gradeAvg < 0.0)
			{
				return grade = 'X';
			}
		}
		return grade;
		
	}
	public static String getFirstLast(String aString)
	{
		String temp ="";
		String newS = "";
		char first = ' ';
		char last = ' ';
		if (aString.length()==0)
		{
			temp = "";
		}
		else if(aString.length() > 0)
		{
			for(int index=0;index<aString.length();index++)
			{
				char ch = aString.charAt(index);
				if (Character.isWhitespace(ch))
				{
					temp= temp + ""; 
				}
				else
				{
					temp = temp + ch;
				}
			}
			if(temp.length()>0)
			{
				first = temp.charAt(0);
				last = temp.charAt(temp.length()-1);
				newS = Character.toString(first) + Character.toString(last);
			}
		}
		return newS;
	}
	public static int countNewLines(String someString)
	{
		int lines = 0;
		for (int index = 0; index< someString.length(); index++)
		{
			char ch = someString.charAt(index);
			if (ch == '\n')
			{
				lines++;
			}
		}
		return lines;
	}
	public static String getWeatherMessage(int temperature)
	{
		String temp = "";
		if (temperature < 10)
		{
			temp = "freezing";
		}	
		else if (temperature <= 30 && temperature >= 10)
		{
			temp ="Cold, very Cold";
		}
		else if (temperature >= 31 && temperature <= 51)
		{
			temp = "Chilly Chilly";
		}
		else if (temperature>= 51 && temperature <=70)
		{
			temp = "Warm";
		}
		else
		{
			if(temperature>70)
			{
				temp="Getting Hot";
			}
		}
		return "Temperature: " + temperature + " degrees " +temp;
	}
		
}