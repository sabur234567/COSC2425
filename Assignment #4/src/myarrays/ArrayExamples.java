package myarrays;

public class ArrayExamples {
	// finds and returns largest value in the array list.	  
    // precondition: numElementsInArray >=0  and list.length >= 0
    // if NumElements is 0, returns 0 as largest value.
   // receives: list - an array of ints, numElementsInArray - current number of elements stored in list
   // Example call #1:   int theMax = ArrayExamples.findMax(someArrayOfInts, size);
   // Example call #2:   int biggest  = ArrayExamples.findMax(myList, 10);
   // Example call #3:   int aMax = ArrayExamples.findMax(yourList, 25);
   public static int findMax(int [] list, int numElementsInArray)
   {
	   int max =0;
	   if(numElementsInArray>0 && list.length >=0)
	   {
		   max = list[0];
		   for(int index=0; index<numElementsInArray; index++)
		   {
			   if (list[index]> max)
			   {
				   max = list[index];
			   }
		   }
	   }
	   else
	   {
		   return 0;
	   }
	   return max;
   }
   // finds and returns the smallest value in the array list.
   // precondition: numElementsInArray >= 0  and list.length >= 0
   //  if numElements is 0, returns 0 as the smallest value.
  // receives: list - an array of ints, numElementsInArray - current number of elements stored in list
  // Example call #1: int aMin = ArrayExamples.findMin(list1, 5);
  // Example call #2: int minimum = ArrayExamples.findMin(list, 10);
  // Example call #3: int min = ArrayExamples.findMin(yourList, 25);
  public static int findMin(int [] list, int numElementsInArray)
  {
	   int min = 0;
	   if(numElementsInArray>0 && list.length >=0)
	   {
		   min = list[0];
		   for(int index=0; index<numElementsInArray; index++)
		   {
			   if (list[index]< min)
			   {
				   min = list[index];
			   }
		   }
	   }
	   else
	   {
		   min= 0;
	   }
	   return min;
  }
  //computes and returns average of all values in array list
  //  computes the average as a double
  // precondition:  numElementsInArray >=0  and list.length >=0
  // returns 0 if numElements is 0.
  // receives: list - an array of ints, numElementsInArray - current number of elements stored in list
  // Example call #1:  double avg = ArrayExamples.computeAverage(yourList, 25);
  // Example call #2: double avg1 = ArrayExamples.computeAverage(list1, 5);
  // Example call #3: double avg2 = ArrayExamples.computeAverage(list2, 15); 
  public static double computeAverage(int [] list, int numElementsInArray)
  {
	  double avg =0;
	  if(numElementsInArray >0 && list.length >=0)
	   {
		  for(int index=0;index<numElementsInArray;index++)
		  {
			  avg +=list[index];
		  }
		  avg = avg/numElementsInArray;
	   }
	  else
	  {
		  return 0;
	  }
	  return avg;
  }
  //reverses the array elements, so first element becomes last, last becomes first etc.
  //  the array has numElementsInArray values stored in it currently
  //  
  // precondition:  numElementsInArray >=0  and list.length >= 0 and numElementsInArray <= list.length 
  // receives: list - an array of ints, numElementsInArray - current number of elements stored in list
  // so if list1 has 3 values in it:  4, 15, 34, 200    list1 becomes 200, 34, 15, 4 after it is reversed
  // Example call #1: ArrayExamples.reverseArray(yourList, 25);   
  // Example call #2: ArrayExamples.reverseArray(list1, 20);   
  // Example call #3: ArrayExamples.reverseArray(listTwo, 5);   
  public static void reverseArray(int [] list, int numElementsInArray) 
  {
	  if(numElementsInArray<=list.length && numElementsInArray>0 && list.length >=0)
	  {
		  for(int i=0; i<numElementsInArray/2; i++)
		  {
			  int temp = list[i];
			  list[i] = list[numElementsInArray-i-1];
			  list[numElementsInArray-i-1] = temp;
		  }
	  }
	  
  }
  //counts the number of times the received String, valueToMatch, 
  //    appears in the String array list, ignores case.
  //    returns that count.  Matches case INSENSITIVE
  // receives: list - an array of Strings to examine, int numElementsInArray, and the String, valueToMatch
  // Example call #1: int match1 = ArrayExamples.countMatches(list2, 25, "hello"); 
  // Example call #2: int match2 = ArrayExamples.countMatches(list1, 15,"Welcomeee"); 
  // Example call #3: int match3 = ArrayExamples.countMatches(list4, 5, "Test");    
  public static int countMatches(String [] list, int numElementsInArray, String valueToMatch)
  {
	  int count = 0;
	  for(int i=0;i<numElementsInArray;i++)
	  {
		  list[i] = list[i].toLowerCase();
		  if(list[i].toLowerCase().equals(valueToMatch.toLowerCase()))
		  {
			  count +=1;
		  }
	  }
	  return count;
  }
  // populates received integer array with all zero values
  // precondition: 
  // receives: array of integers that will have all locations set to zero
  // Example call #1: ArrayExamples.resetArray(list2); 
  // Example call #2: ArrayExamples.resetArray(list1); 
  // Example call #3:  ArrayExamples.resetArray(list4); 
  public static void resetArray(int [] list)
  {	
	  if(list.length>0) {
		  for(int i=0; i<list.length;i++)
		  {
			  list[i] = 0;
		  }
	  }
  }
  //populates received integer array with count of each letter of alphabet in received String (case-insensitive)
  // size of int array is 26 exactly and is zeroed out.
  // receives: String to count letters in, and an array of integers of size 26
  //  Example :  given "cats and dogs"  as the String, list[0] = 2, list[1] = 0, list[2] = 1, list[3]=2 etc.
  //             each array location corresponds to a letter of the alphabet, 'a' is location 0, 'b' is location 1 etc.
  // Example call #1: ArrayExamples.countLetters("hello", list1); 
  // Example call #2: ArrayExamples.countLetters("hi", list2); 
  // Example call #3: ArrayExamples.countLetters("test", list);  
  public static void countLetters(String aString, int [] list)
  {
	   aString =  aString.toLowerCase();
	   String a = "abcdefghijklmnopqrstuvwxyz";
	   for(int index=0; index<a.length();index++)
	   {
		   for(int j = 0; j<aString.length();j++)
			   if(a.charAt(index) == aString.charAt(j))
			   {
				   list[index] +=1;
			   }
	   }
  }
  
  //returns a String in described format of current letters in array
  // receives the int array of letter counts
  // Example: Assume: letterCount[1] = 4, letterCount[5] = 2,letterCount[6] = 3, with 0's all other locations returns: "[bbbbffggg]"
  // Example call #1: String test = ArrayExamples.getLetters(list1); 
  // Example call #2: String test1 = ArrayExamples.getLetters(list2); 
  // Example call #3:  String test2 = ArrayExamples.getLetters(list3); 
  public static String getLetters(int []letterCount)
  {
	  String temp ="[";
	  String a = "abcdefghijklmnopqrstuvwxyz";
	  for(int index=0;index<letterCount.length;index++)
	  {
		  char ch = a.charAt(index);
		  int i = letterCount[index];
		  for(int j = 0; j<i; j++)
		  {
			  temp+=ch;
		  }
	  }
	  temp += "]";
	  return temp;
  }
  //Gets value in a "letterCount" array in which each index corresponds to a letter of the alphabet, case-insensitive
  //  so the letterCount array has 26 indexes, 0 to 25.
  // receives: letterCount array and specific letter 
  // returns: count of corresponding letter
  // if invalid (non-letter) character received, returns 0.
  // int test10 = ArrayExamples.getCount(list1,'e'); 
  // int test50 = ArrayExamples.getCount(list2,'g'); 
  // int test5 =ArrayExamples.getCount(list3,'h'); 
  public static int getCount(int []countArray, char ch)
  {
	  int index = ((int) ch) -97;
	  if(index>= 0 && index<=26)
	  {
		  return countArray[index];
	  }
	  else
	  {
		  return 0;
	  }
  }
  //Adds contents of 2 int arrays received, returns an array with sum of each corresponding row.
  // receives: 2 integer arrays of same length which is >=0
  // returns an integer array with the sum of both array values per row.
  // precondition: both arrays are same length, if not returns an array of length 0
  // note:  here is how to create an int [] array of length 0:
  //          int [] retValue = new int [0];
  // Example call #1: int test5= ArrayExamples.getArraySum(list1,list5); 
  // Example call #2: int test70= ArrayExamples.getArraySum(list1,list2); 
  // Example call #3: int i = ArrayExamples.getArraySum(list1,list8); 
  public static int [] getArraySum(int [] array1, int []array2)
  {
	 
	  if(array1.length >0 && array2.length>0 && array1.length == array2.length)
	  {
		  int [] retValue = new int[array1.length];
		  for(int index=0;index<array1.length;index++)
		  {
			  retValue[index] = array1[index] + array2[index];
		  }
		  return retValue;
	  }
	  int [] retValue = new int[0];
	  return retValue;
  }
 
      
}
