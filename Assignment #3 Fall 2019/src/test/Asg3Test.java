package test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import asg3.GenderType;
import asg3.PetType;
import asg3.HousePet;
import asg3.HousePetUtilsImpl;

public class Asg3Test {
	public static void main(String []args)
	{
		String sName = utils.MyUtils.getNameFromStudent();
		System.out.println("Begin Testing of Asg #3 for " + sName + "\n");
		testConstructors();
		testAccessors();
		testModifiers();
		System.out.println("\nEnd Testing of Asg #3 for " + sName);

	}
	public static void testFileIO()
	{
		HousePet pet1 = new HousePet();
		HousePet pet2 = new HousePet();
		HousePet pet3 = new HousePet("  Shirley   ann MARIE ", 2011, GenderType.FEMALE, PetType.CAT);
		HousePet pet4 = new HousePet(" ", 0, GenderType.MALE, PetType.BIRD);
		Scanner inputFile = null;
		PrintWriter outputFile = null;
		int successCount=0;
		int failureCount=0;

		String filename = "housepet.txt";
		try {
			inputFile = new Scanner(new File(filename));
			successCount++;
			System.out.println("SUCCESS opened file: " + filename + " for input");
		}catch(FileNotFoundException e) {
			System.out.println("FAILURE cannot open file: " + filename + " for input" +
					" EXIT ON FAILURE TO OPEN FILE.");
			System.exit(0);
		}
		int petCount = 0;
		while(inputFile.hasNext()){
			pet1 = HousePetUtilsImpl.readFromScanner(inputFile);
			petCount ++;
			System.out.println("Just read: " + pet1);
		}
		inputFile.close();
		if(petCount == 6)
			System.out.println("SUCCESS read " + petCount + " pets from " + filename);
		else
			System.out.println("FAILURE should have read " + petCount + " pets from " + filename);

		System.out.println("********Now Testing writeToFile...");
		filename = "housepetEmpty.txt";
		try {
			outputFile = new PrintWriter(new FileWriter(new File(filename)));
			successCount++;
		}catch (IOException e) {
			failureCount++;
			System.out.println("FAILURE, cannot open file " + filename + " for output, EXITING on FAILURE");
			System.exit(0);	
		}
		outputFile.close();
		try {
			inputFile = new Scanner(new File(filename));
			successCount++;
			System.out.println("SUCCESS opened file: " + filename + " for input");
		}catch(FileNotFoundException e) {
			System.out.println("FAILURE cannot open file: " + filename + " for input" +
					" EXIT ON FAILURE TO OPEN FILE.");
			System.exit(0);
		}
		petCount = 0;
		while(inputFile.hasNext()){
			pet1 = HousePetUtilsImpl.readFromScanner(inputFile);
			petCount ++;
			System.out.println("Just read: " + pet1);
		}
		inputFile.close();
		if(petCount == 0)
			System.out.println("SUCCESS read " + petCount + " pets from " + filename);
		else
			System.out.println("FAILURE should have read " + petCount + " pet(s) from " + filename);
		// now write 1 pet to file
		filename = "housepetOne.txt";
		try {
			outputFile = new PrintWriter(new FileWriter(new File(filename)));
			successCount++;
		}catch (IOException e) {
			failureCount++;
			System.out.println("FAILURE, cannot open file " + filename + " for output, EXITING on FAILURE");
			System.exit(0);	
		}
		HousePetUtilsImpl.writeToFile(outputFile, pet1);
		outputFile.close();
		try {
			inputFile = new Scanner(new File(filename));
			successCount++;
			System.out.println("SUCCESS opened file: " + filename + " for input");
		}catch(FileNotFoundException e) {
			System.out.println("FAILURE cannot open file: " + filename + " for input" +
					" EXIT ON FAILURE TO OPEN FILE.");
			System.exit(0);
		}
		petCount = 0;
		while(inputFile.hasNext()){
			pet1 = HousePetUtilsImpl.readFromScanner(inputFile);
			petCount ++;
			System.out.println("Just read: " + pet1);
		}
		inputFile.close();
		if(petCount == 1)
			System.out.println("SUCCESS read " + petCount + " pets from " + filename);
		else
			System.out.println("FAILURE should have read " + petCount + " pet(s) from " + filename);


		// now write 4 pets to file
		filename = "housepetFourWrite.txt";
		try {
			outputFile = new PrintWriter(new FileWriter(new File(filename)));
			successCount++;
		}catch (IOException e) {
			failureCount++;
			System.out.println("FAILURE, cannot open file " + filename + " for output, EXITING on FAILURE");
			System.exit(0);	
		}
		System.out.println("Now writing 4 pets: \n" + 
				pet1 + "\n" +
				pet2 + "\n" +
				pet3 + "\n" +
				pet4 );

		HousePetUtilsImpl.writeToFile(outputFile, pet1);
		HousePetUtilsImpl.writeToFile(outputFile, pet2);
		HousePetUtilsImpl.writeToFile(outputFile, pet3);
		HousePetUtilsImpl.writeToFile(outputFile, pet4);
		outputFile.close();

		filename = "housepetFourWrite.txt";
		try {
			inputFile = new Scanner(new File(filename));
			successCount++;
			System.out.println("SUCCESS opened file: " + filename + " for input");
		}catch(FileNotFoundException e) {
			System.out.println("FAILURE cannot open file: " + filename + " for input" +
					" EXIT ON FAILURE TO OPEN FILE.");
			System.exit(0);
		}
		petCount = 0;
		while(inputFile.hasNext()){
			pet1 = HousePetUtilsImpl.readFromScanner(inputFile);
			if(pet1 != null)
				petCount ++;
			System.out.println("Just read: " + pet1);
		}
		inputFile.close();
		int expCount = 4;
		if(petCount == expCount)
			System.out.println("SUCCESS read " + petCount + " pets from " + filename);
		else
			System.out.println("FAILURE should have read " + expCount + " pet(s) from " + filename +
					" instead read: " + petCount + " pets.");
		try {
			inputFile = new Scanner(new File(filename));
			successCount++;
			System.out.println("SUCCESS opened file: " + filename + " for input");
		}catch(FileNotFoundException e) {
			System.out.println("FAILURE cannot open file: " + filename + " for input" +
					" EXIT ON FAILURE TO OPEN FILE.");
			System.exit(0);
		}
		petCount = 0;
		while(inputFile.hasNext()){
			pet1 = HousePetUtilsImpl.readFromScanner(inputFile);
			petCount ++;
			System.out.println("Just read: " + pet1);
		}
		inputFile.close();
		String expString = HousePet.DEFAULT_NAME;
		String retString = pet1.getPetName();
		if(retString.equals(expString))
			System.out.println("SUCCESS last pet name read was " + expString);
		else
			System.out.println("FAILURE last pet name read should have been " + expString + 
					" but was instead named: " + retString);
		expString = "0";
		retString = pet1.toString();
		if(retString.indexOf(expString) != -1)
			System.out.println("SUCCESS last pet age  was " + expString);
		else
			System.out.println("FAILURE last pet age  should have been " + expString + 
					" but was not part of pet's toString()");
		expString = "BIRD";
		retString = pet1.getPetType().toString();
		if(retString.equals(expString) )
			System.out.println("SUCCESS last pet type  was " + expString);
		else
			System.out.println("FAILURE last pet type  should have been " + expString + 
					" but was instead: " + retString);
		expString = "MALE";
		retString = pet1.getGender().toString();
		if(retString.equals(expString))
			System.out.println("SUCCESS last pet gender was " + expString);
		else
			System.out.println("FAILURE last pet gender  should have been " + expString + 
					" but was instead: " + retString);
		if(petCount == 4)
			System.out.println("SUCCESS read " + petCount + " pets from " + filename);
		else
			System.out.println("FAILURE should have read " + petCount + " pet(s) from " + filename);
	}
	public static void testAccessors()
	{
		HousePet pet1 = new HousePet();
		HousePet pet2 = new HousePet();
		HousePet pet3 = new HousePet("  Shirley   ann MARIE ", 2011, GenderType.FEMALE, PetType.CAT);
		HousePet pet4 = new HousePet(" ", 0, GenderType.MALE, PetType.BIRD);;

		System.out.println("********Now testing set/get for gender ");
		System.out.println("Pet 1: " + pet1);
		System.out.println("Pet 2: " + pet2);
		System.out.println("Pet 3: " + pet3);
		System.out.println("Pet 4: " + pet4);

		GenderType expGender=GenderType.MALE;
		GenderType retGender=pet4.getGender();
		if(retGender == expGender)
		{
			System.out.println("SUCCESS expected " + expGender);
		}
		else
		{
			System.out.println("FAILURE expected " + expGender + " instead got: " + retGender);
		}
		expGender=GenderType.UNKNOWN;
		retGender=pet1.getGender();
		if(retGender == expGender)
		{
			System.out.println("SUCCESS expected " + expGender);
		}
		else
		{
			System.out.println("FAILURE expected " + expGender + " instead got: " + retGender);
		}

		expGender=GenderType.UNKNOWN;
		retGender=pet2.getGender();
		if(retGender == expGender)
		{
			System.out.println("SUCCESS expected " + expGender);
		}
		else
		{
			System.out.println("FAILURE expected " + expGender + " instead got: " + retGender);
		}
		pet1.setGender(GenderType.MALE);
		expGender=GenderType.MALE;
		retGender=pet1.getGender();
		if(retGender == expGender)
		{
			System.out.println("SUCCESS expected " + expGender);
		}
		else
		{
			System.out.println("FAILURE expected " + expGender + " instead got: " + retGender);
		}
		pet2.setGender(GenderType.FEMALE);
		expGender=GenderType.FEMALE;
		retGender=pet2.getGender();
		if(retGender == expGender)
		{
			System.out.println("SUCCESS expected " + expGender);
		}
		else
		{
			System.out.println("FAILURE expected " + expGender + " instead got: " + retGender);
		}
	}
	public static void testConstructors()
	{

		HousePet pet1 = new HousePet();
		HousePet pet2 = new HousePet();
		HousePet pet3 = new HousePet("  Shirley   ann MARIE ", 2011, GenderType.FEMALE, PetType.CAT);
		HousePet pet4 = new HousePet(" ", 0, GenderType.UNKNOWN, PetType.UNKNOWN);
		System.out.println("*********Now testing constructors for HousePet instances");
		String expName = HousePet.DEFAULT_NAME;
		String retName = pet1.getPetName();
		if(retName.equals(expName))
		{
			System.out.println("SUCCESS expected " + expName + " for HousePet");
		}
		else
		{
			System.out.println("FAILURE expected " + expName + " instead got: " + retName);
		}
		expName = HousePet.DEFAULT_NAME;
		retName = pet2.getPetName();
		if(retName.equals(expName))
		{
			System.out.println("SUCCESS expected " + expName);
		}
		else
		{
			System.out.println("FAILURE expected " + expName + " instead got: " + retName);
		}
		expName = "Shirley Ann Marie";
		retName = pet3.getPetName();
		if(retName.equals(expName))
		{
			System.out.println("SUCCESS expected " + expName);
		}
		else
		{
			System.out.println("FAILURE expected " + expName + " instead got: " + retName);
		}
		expName = HousePet.DEFAULT_NAME;
		retName = pet4.getPetName();
		if(retName.equals(expName))
		{
			System.out.println("SUCCESS expected " + expName);
		}
		else
		{
			System.out.println("FAILURE expected " + expName + " instead got: " + retName);
		}
		int expYear = HousePet.DEFAULT_YEARBORN;
		int retYear = pet1.getYearBorn();
		if(retYear == expYear)
		{
			System.out.println("SUCCESS expected " + expYear + " for HousePet");
		}
		else
		{
			System.out.println("FAILURE expected " + expYear + " instead got: " + retYear);
		}
		expYear = HousePet.DEFAULT_YEARBORN;
		retYear = pet2.getYearBorn();
		if(retYear == expYear)
		{
			System.out.println("SUCCESS expected " + expYear + " for HousePet");
		}
		else
		{
			System.out.println("FAILURE expected " + expYear + " instead got: " + retYear);
		}

		expYear = 2011;
		retYear = pet3.getYearBorn();
		if(retYear == expYear)
		{
			System.out.println("SUCCESS expected " + expYear + " for HousePet");
		}
		else
		{
			System.out.println("FAILURE expected " + expYear + " instead got: " + retYear);
		}
		expYear = HousePet.DEFAULT_YEARBORN;
		retYear = pet4.getYearBorn();
		if(retYear == expYear)
		{
			System.out.println("SUCCESS expected " + expYear + " for HousePet");
		}
		else
		{
			System.out.println("FAILURE expected " + expYear + " instead got: " + retYear);
		}

	}
	public static void testModifiers()
	{
		HousePet pet1 = new HousePet();
		HousePet pet2 = new HousePet();
		HousePet pet3 = new HousePet("  Shirley   ann MARIE ", 2011, GenderType.FEMALE, PetType.CAT);
		HousePet pet4 = new HousePet(" ", 0, GenderType.MALE, PetType.BIRD);;

		System.out.println("Now testing setter/getter for petName");
		pet1.setPetName(" QUeEn   AnnE  MARGARET ");
		String expName = "Queen Anne Margaret";
		String retName = pet1.getPetName();
		if(retName.equals(expName))
		{
			System.out.println("SUCCESS expected " + expName);
		}
		else
		{
			System.out.println("FAILURE expected " + expName + " instead got: " + retName);
		}
		pet2.setPetName(" \n");
		expName = HousePet.DEFAULT_NAME;
		retName = pet2.getPetName();
		if(retName.equals(expName))
		{
			System.out.println("SUCCESS expected " + expName);
		}
		else
		{
			System.out.println("FAILURE expected " + expName + " instead got: " + retName);
		}
		pet2.setPetName("\t/@$%^&*()");
		expName = HousePet.DEFAULT_NAME;
		retName = pet2.getPetName();
		if(retName.equals(expName))
		{
			System.out.println("SUCCESS expected " + expName);
		}
		else
		{
			System.out.println("FAILURE expected " + expName + " instead got: " + retName);
		}
		pet2.setPetName("\nA");
		expName = HousePet.DEFAULT_NAME;
		retName = pet2.getPetName();
		if(retName.equals(expName))
		{
			System.out.println("SUCCESS expected " + expName);
		}
		else
		{
			System.out.println("FAILURE expected " + expName + " instead got: " + retName);
		}
		pet2.setPetName("$%^&*KK"); // should work, has 2 letters.
		expName = "$%^&*kk";
		retName = pet2.getPetName();
		if(retName.equals(expName))
		{
			System.out.println("SUCCESS expected " + expName);
		}
		else
		{
			System.out.println("FAILURE expected " + expName + " instead got: " + retName);
		}
		pet2.setPetName("$   ABB"); // should work, has 2 letters.
		expName = "$ Abb";
		retName = pet2.getPetName();
		if(retName.equals(expName))
		{
			System.out.println("SUCCESS expected " + expName);
		}
		else
		{
			System.out.println("FAILURE expected " + expName + " instead got: " + retName);
		}
		pet2.setPetName("$%^&* ");
		expName = HousePet.DEFAULT_NAME;
		retName = pet2.getPetName();
		if(retName.equals(expName))
		{
			System.out.println("SUCCESS expected " + expName);
		}
		else
		{
			System.out.println("FAILURE expected " + expName + " instead got: " + retName);
		}
		pet4.setPetName("  KinG   GEORgE  ");
		expName = "King George";
		retName = pet4.getPetName();
		if(retName.equals(expName))
		{
			System.out.println("SUCCESS expected " + expName);
		}
		else
		{
			System.out.println("FAILURE expected " + expName + " instead got: " + retName);
		}

		expName = "Shirley Ann Marie";
		retName = pet3.getPetName();
		if(retName.equals(expName))
		{
			System.out.println("SUCCESS expected " + expName);
		}
		else
		{
			System.out.println("FAILURE expected " + expName + " instead got: " + retName);
		}
		System.out.println("Now testing setter/getter for yearBorn");
		int myYear = 0;
		pet1.setYearBorn(myYear);
		int expYear = HousePet.DEFAULT_YEARBORN;
		int retYear = pet2.getYearBorn();
		if(retYear == expYear)
		{
			System.out.println("SUCCESS expected " + expYear + " for year born");
		}
		else
		{
			System.out.println("FAILURE expected " + expYear + " for year born instead got: " + retYear);
		}
		myYear = 1899;
		pet1.setYearBorn(myYear);
		expYear = HousePet.DEFAULT_YEARBORN;
		retYear = pet1.getYearBorn();
		if(retYear == expYear)
		{
			System.out.println("SUCCESS expected " + expYear + " for year born");
		}
		else
		{
			System.out.println("FAILURE expected " + expYear + " for year born instead got: " + retYear);
		}
		myYear = 1900;
		pet1.setYearBorn(myYear);
		expYear = myYear;
		retYear = pet1.getYearBorn();
		if(retYear == expYear)
		{
			System.out.println("SUCCESS expected " + expYear + " for year born");
		}
		else
		{
			System.out.println("FAILURE expected " + expYear + " for year born instead got: " + retYear);
		}
		myYear = 2019;
		pet1.setYearBorn(myYear);
		expYear = myYear;
		retYear = pet1.getYearBorn();
		if(retYear == expYear)
		{
			System.out.println("SUCCESS expected " + expYear + " for year born");
		}
		else
		{
			System.out.println("FAILURE expected " + expYear + " for year born instead got: " + retYear);
		}
		myYear = 2020;
		pet1.setYearBorn(myYear);
		expYear = HousePet.DEFAULT_YEARBORN;
		retYear = pet1.getYearBorn();
		if(retYear == expYear)
		{
			System.out.println("SUCCESS expected " + expYear + " for year born");
		}
		else
		{
			System.out.println("FAILURE expected " + expYear + " for year born instead got: " + retYear);
		}
		myYear = 2008;
		pet1.setYearBorn(myYear);
		expYear = myYear;
		retYear = pet1.getYearBorn();
		if(retYear == expYear)
		{
			System.out.println("SUCCESS expected " + expYear + " for year born");
		}
		else
		{
			System.out.println("FAILURE expected " + expYear + " for year born instead got: " + retYear);
		}


		System.out.println("********* Now testing toString() on all 4 pets, each output line should be " +
				"\n*********   neat and easy to read with proper spacing.");
		System.out.println("Pet 1: " + pet1);
		System.out.println("Pet 2: " + pet2);
		System.out.println("Pet 3: " + pet3);
		System.out.println("Pet 4: " + pet4);

		String expStr = "11";
		String retStr = pet1.toString();
		if(retStr.contains(expStr))
		{
			System.out.println("SUCCESS expected " + expStr + " to be part of toString(): " + retStr);
		}
		else
		{
			System.out.println("FAILURE expected " + expStr + " to be part of toString instead got: " + retStr);
		}
		expStr = "Queen Anne Margaret";
		retStr = pet1.toString();
		if(retStr.contains(expStr))
		{
			System.out.println("SUCCESS expected " + expStr + " to be part of toString(): " + retStr);
		}
		else
		{
			System.out.println("FAILURE expected " + expStr + " to be part of toString instead got: " + retStr);
		}
		expStr = "8";
		retStr = pet3.toString();
		if(retStr.contains(expStr))
		{
			System.out.println("SUCCESS expected " + expStr + " to be part of toString(): " + retStr);
		}
		else
		{
			System.out.println("FAILURE expected " + expStr + " to be part of toString instead got: " + retStr);
		}
		expStr = "King George";
		retStr = pet4.toString();
		if(retStr.contains(expStr))
		{
			System.out.println("SUCCESS expected " + expStr + " to be part of toString(): " + retStr);
		}
		else
		{
			System.out.println("FAILURE expected " + expStr + " to be part of toString instead got: " + retStr);
		}
		expStr = "0";
		retStr = pet4.toString();
		if(retStr.contains(expStr))
		{
			System.out.println("SUCCESS expected " + expStr + " to be part of toString(): " + retStr);
		}
		else
		{
			System.out.println("FAILURE expected " + expStr + " to be part of toString instead got: " + retStr);
		}
		System.out.println("********Now testing set/get for gender ");
		System.out.println("Pet 1: " + pet1);
		System.out.println("Pet 2: " + pet2);
		System.out.println("Pet 3: " + pet3);
		System.out.println("Pet 4: " + pet4);

		GenderType expGender=GenderType.MALE;
		GenderType retGender=pet4.getGender();
		if(retGender == expGender)
		{
			System.out.println("SUCCESS expected " + expGender);
		}
		else
		{
			System.out.println("FAILURE expected " + expGender + " instead got: " + retGender);
		}
		expGender=GenderType.UNKNOWN;
		retGender=pet1.getGender();
		if(retGender == expGender)
		{
			System.out.println("SUCCESS expected " + expGender);
		}
		else
		{
			System.out.println("FAILURE expected " + expGender + " instead got: " + retGender);
		}

		expGender=GenderType.UNKNOWN;
		retGender=pet2.getGender();
		if(retGender == expGender)
		{
			System.out.println("SUCCESS expected " + expGender);
		}
		else
		{
			System.out.println("FAILURE expected " + expGender + " instead got: " + retGender);
		}
		pet1.setGender(GenderType.MALE);
		expGender=GenderType.MALE;
		retGender=pet1.getGender();
		if(retGender == expGender)
		{
			System.out.println("SUCCESS expected " + expGender);
		}
		else
		{
			System.out.println("FAILURE expected " + expGender + " instead got: " + retGender);
		}
		pet2.setGender(GenderType.FEMALE);
		expGender=GenderType.FEMALE;
		retGender=pet2.getGender();
		if(retGender == expGender)
		{
			System.out.println("SUCCESS expected " + expGender);
		}
		else
		{
			System.out.println("FAILURE expected " + expGender + " instead got: " + retGender);
		}
		System.out.println("********Now testing set/get for pet type ");
		System.out.println("Pet 1: " + pet1);
		System.out.println("Pet 2: " + pet2);
		System.out.println("Pet 3: " + pet3);
		System.out.println("Pet 4: " + pet4);
		PetType expType=PetType.UNKNOWN;
		PetType retType = pet1.getPetType();
		if(retType == expType)
		{
			System.out.println("SUCCESS expected " + expType);
		}
		else
		{
			System.out.println("FAILURE expected " + expType + " instead got: " + retType);
		}
		expType=PetType.CAT;
		retType = pet3.getPetType();
		if(retType == expType)
		{
			System.out.println("SUCCESS expected " + expType);
		}
		else
		{
			System.out.println("FAILURE expected " + expType + " instead got: " + retType);
		}
		expType=PetType.BIRD;
		retType = pet4.getPetType();
		if(retType == expType)
		{
			System.out.println("SUCCESS expected " + expType);
		}
		else
		{
			System.out.println("FAILURE expected " + expType + " instead got: " + retType);
		}
		pet1.setPetType(PetType.DOG);
		expType=PetType.DOG;
		retType = pet1.getPetType();
		if(retType == expType)
		{
			System.out.println("SUCCESS expected " + expType);
		}
		else
		{
			System.out.println("FAILURE expected " + expType + " instead got: " + retType);
		}

		pet2.setPetType(PetType.GERBIL);
		expType=PetType.GERBIL;
		retType = pet2.getPetType();
		if(retType == expType)
		{
			System.out.println("SUCCESS expected " + expType);
		}
		else
		{
			System.out.println("FAILURE expected " + expType + " instead got: " + retType);
		}
		System.out.println("********* Now testing toString() on all 4 pets, each output line should be " +
				"\n*********   neat and easy to read with proper spacing.");
		System.out.println("Pet 1: " + pet1);
		System.out.println("Pet 2: " + pet2);
		System.out.println("Pet 3: " + pet3);
		System.out.println("Pet 4: " + pet4);

		expStr = "11"; // note should have age as 11 in toString
		retStr = pet1.toString();
		if(retStr.contains(expStr))
		{
			System.out.println("SUCCESS expected " + expStr + " to be part of toString(): " + retStr);
		}
		else
		{
			System.out.println("FAILURE expected " + expStr + " to be part of toString instead got: " + retStr);
		}
		expStr = "MALE"; // note should have gender in toString
		retStr = pet1.toString();
		if(retStr.contains(expStr))
		{
			System.out.println("SUCCESS expected " + expStr + " to be part of toString(): " + retStr);
		}
		else
		{
			System.out.println("FAILURE expected " + expStr + " to be part of toString instead got: " + retStr);
		}
		expStr = "DOG"; // note should have petType in toString
		retStr = pet1.toString();
		if(retStr.contains(expStr))
		{
			System.out.println("SUCCESS expected " + expStr + " to be part of toString(): " + retStr);
		}
		else
		{
			System.out.println("FAILURE expected " + expStr + " to be part of toString instead got: " + retStr);
		}
		expStr = "Queen Anne Margaret";
		retStr = pet1.toString();
		if(retStr.contains(expStr))
		{
			System.out.println("SUCCESS expected " + expStr + " to be part of toString(): " + retStr);
		}
		else
		{
			System.out.println("FAILURE expected " + expStr + " to be part of toString instead got: " + retStr);
		}
		expStr = "8";
		retStr = pet3.toString();
		if(retStr.contains(expStr))
		{
			System.out.println("SUCCESS expected " + expStr + " to be part of toString(): " + retStr);
		}
		else
		{
			System.out.println("FAILURE expected " + expStr + " to be part of toString instead got: " + retStr);
		}
		expStr = "FEMALE"; // note should have gender in toString
		retStr = pet3.toString();
		if(retStr.contains(expStr))
		{
			System.out.println("SUCCESS expected " + expStr + " to be part of toString(): " + retStr);
		}
		else
		{
			System.out.println("FAILURE expected " + expStr + " to be part of toString instead got: " + retStr);
		}
		expStr = "CAT"; // note should have petType in toString
		retStr = pet3.toString();
		if(retStr.contains(expStr))
		{
			System.out.println("SUCCESS expected " + expStr + " to be part of toString(): " + retStr);
		}
		else
		{
			System.out.println("FAILURE expected " + expStr + " to be part of toString instead got: " + retStr);
		}
		expStr = "BIRD"; // note should have petType in toString
		retStr = pet4.toString();
		if(retStr.contains(expStr))
		{
			System.out.println("SUCCESS expected " + expStr + " to be part of toString(): " + retStr);
		}
		else
		{
			System.out.println("FAILURE expected " + expStr + " to be part of toString instead got: " + retStr);
		}
		expStr = "King George";
		retStr = pet4.toString();
		if(retStr.contains(expStr))
		{
			System.out.println("SUCCESS expected " + expStr + " to be part of toString(): " + retStr);
		}
		else
		{
			System.out.println("FAILURE expected " + expStr + " to be part of toString instead got: " + retStr);
		}
		expStr = "0";
		retStr = pet4.toString();
		if(retStr.contains(expStr))
		{
			System.out.println("SUCCESS expected " + expStr + " to be part of toString(): " + retStr);
		}
		else
		{
			System.out.println("FAILURE expected " + expStr + " to be part of toString instead got: " + retStr);
		}
		expStr = HousePet.DEFAULT_NAME; // note should have default name in toString
		retStr = pet2.toString();
		if(retStr.contains(expStr))
		{
			System.out.println("SUCCESS expected " + expStr + " to be part of toString(): " + retStr);
		}
		else
		{
			System.out.println("FAILURE expected " + expStr + " to be part of toString instead got: " + retStr);
		}
		expStr = "GERBIL";
		retStr = pet2.toString();
		if(retStr.contains(expStr))
		{
			System.out.println("SUCCESS expected " + expStr + " to be part of toString(): " + retStr);
		}
		else
		{
			System.out.println("FAILURE expected " + expStr + " to be part of toString instead got: " + retStr);
		}
		expStr = "FEMALE";
		retStr = pet2.toString();
		if(retStr.contains(expStr))
		{
			System.out.println("SUCCESS expected " + expStr + " to be part of toString(): " + retStr);
		}
		else
		{
			System.out.println("FAILURE expected " + expStr + " to be part of toString instead got: " + retStr);
		}

		System.out.println("********Now testing that toString() produces no new line chars in returned String for HousePet");
		int expLines=0;
		int retLines = utils.MyUtils.numberLines(pet1.toString());
		if(retLines == expLines)
			System.out.println("SUCCESS expected " + expLines + " new line chars.");
		else
			System.out.println("FAILURE expected: " + expLines + " line(s) instead got " + retLines + " new line chars.");
		expLines=0;
		retLines = utils.MyUtils.numberLines(pet2.toString());
		if(retLines == expLines)
			System.out.println("SUCCESS expected " + expLines + " new line chars.");
		else
			System.out.println("FAILURE expected: " + expLines + " line(s) instead got " + retLines + " new line chars.");
		expLines=0;
		retLines = utils.MyUtils.numberLines(pet3.toString());
		if(retLines == expLines)
			System.out.println("SUCCESS expected " + expLines + " new line chars.");
		else
			System.out.println("FAILURE expected: " + expLines + " line(s) instead got " + retLines + " new line chars.");
		expLines=0;
		retLines = utils.MyUtils.numberLines(pet4.toString());
		if(retLines == expLines)
			System.out.println("SUCCESS expected " + expLines + " new line chars.");
		else
			System.out.println("FAILURE expected: " + expLines + " line(s) instead got " + retLines + " new line chars.");
	}
}
