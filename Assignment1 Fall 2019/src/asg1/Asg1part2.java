package asg1;

public class Asg1part2 {
	public static void main(String[] args)
	{
		int sum = 0;
		for (int i = 1; i < 101;i++)
		{
			sum += i;
		}
		System.out.println("The sum of the numbers 1-100 is: " + sum);
		int sum2 = 0;
		for (int index2 = 1; index2 < 2001; index2++)
		{
			if (index2 % 13 == 0)
			{
				sum2 += index2;
			}
		}
		System.out.println("The sum of the numbers 1-2000 that are divisable by 13 is: "+ sum2);
		int sum3 = 0;
		for (int index3 = 1; index3<51; index3++)
		{
			sum3 = sum3 + (index3*index3);
		}
		System.out.println("The sum of squares from numbers 1-50 is: "+ sum3);	
	}
}
