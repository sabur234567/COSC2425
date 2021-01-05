package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.StringTokenizer;

import org.junit.jupiter.api.Test;

import stack.StackList;
import stack.StackListArrayListImpl;
import stack.StackListLinkedListImpl;
import utils.MyUtils;

class StackTest {
	String sName="$$$$";
	@Test
	public void test() {
		sName = utils.MyUtils.getNameFromStudent();
		MyUtils.printTimeStamp("begins for " + sName);
		stackLinkedListTest();
		System.out.println("\n-----SUCCESS Stack Linked List Testing Complete -----\n");
		stackArrayListTest();
		System.out.println("\n-----SUCCESS Stack Array List Testing Complete -----\n");
		MyUtils.printTimeStamp("ends for " + sName);
	}

	public void stackLinkedListTest()
	{
		
		final int OVER_LARGEST = 100009;
		String pushString="";
		int pushInt = 0;
		StackList <String> s1 = new StackListLinkedListImpl<String>(3);
		StackList<Integer> s2 = new StackListLinkedListImpl<Integer>(2);
		StackList<String> s3 = new StackListLinkedListImpl<String>();
		StackList<String> s4 = new StackListLinkedListImpl<String>(-2);
		StackList<String> s5 = new StackListLinkedListImpl<String>(StackList.LARGEST);
		StackList<String> s6 = new StackListLinkedListImpl<String>(OVER_LARGEST);
		assertTrue(s5.getMaxSize()==StackList.LARGEST);
		assertTrue(s6.getMaxSize() == StackList.DEFAULT_MAX_SIZE);
		assertTrue(s4.getMaxSize() == StackList.DEFAULT_MAX_SIZE);
		assertTrue(s3.getMaxSize()==StackList.DEFAULT_MAX_SIZE);
		assertTrue(s1.getMaxSize()==3);
		assertTrue(s2.getMaxSize()==2);
		assertTrue(s1.isEmpty());
		assertTrue(s2.isEmpty());
		pushString="first";
		s1.push(pushString);
		assertTrue(s1.peek().equals(pushString));
		assertTrue(s1.getSize() == 1);
		assertTrue(!s1.isFull());
		assertTrue(!s1.isEmpty());
		pushString="second";
		s1.push(pushString);
		assertTrue(s1.peek().equals(pushString));
		assertTrue(s1.getSize() == 2);
		assertTrue(!s1.isFull());
		assertTrue(!s1.isEmpty());
		pushString="third";
		s1.push(pushString);
		assertTrue(s1.peek().equals(pushString));
		assertTrue(s1.getSize() == 3);
		assertTrue(s1.isFull());
		assertTrue(!s1.isEmpty());
		pushString="fourth";
		try {
			s1.push(pushString);
			System.out.println("FAILURE, push should throw a RuntimeException on a full stack");
		}catch(RuntimeException e) 
		{
			System.out.println("SUCCESS, push should throw a RuntimeException on a full stack\n" + e);
		}
		// new test toString()
		String str = s1.toString();
		assertEquals("third\nsecond\nfirst\n", str);
		StringTokenizer tokenizer = new StringTokenizer(str,"\n");
		String token = tokenizer.nextToken();
		assertTrue(token.equals("third"));
		token = tokenizer.nextToken();
		assertTrue(token.equals("second"));
		token = tokenizer.nextToken();
		assertTrue(token.equals("first"));
		assertEquals(3, utils.MyUtils.numberLines(str));
		assertEquals("third\nsecond\nfirst\n", str);
		System.out.println("*****\ntoString() of s1: \n" + str + "*****");
		assertTrue(s1.pop().equals("third"));
		assertTrue(s1.pop().equals("second"));
		assertTrue(s1.pop().equals("first"));
		assertTrue(s1.isEmpty());
		assertTrue(s1.getSize()==0);
		try {
			s1.pop();
			
			System.out.println("FAILURE, pop should throw a RuntimeException on an empty stack");
		}catch (RuntimeException e) 
		{
			System.out.println("SUCCESS, pop throws a RuntimeException on an empty stack\n" + e);
		}
		pushString="one";
		s1.push(pushString);
		assertTrue(s1.getSize() ==1);
		assertTrue(s1.pop().equals(pushString));
		assertTrue(s1.getSize() ==0 );
		assertTrue(s1.isEmpty());
		assertFalse(s1.isFull());
		
	    // now test Stack of Integer
		System.out.println("****  Now testing Stack<Integer>****");
		pushInt=1;
		s2.push(pushInt);
		assertTrue(s2.peek()==(pushInt));
		assertTrue(s2.getSize() == 1);
		assertTrue(!s2.isFull());
		assertTrue(!s2.isEmpty());
		pushInt = 2;
		s2.push(pushInt);
		assertTrue(s2.peek()==(pushInt));
		assertTrue(s2.getSize() == 2);
		assertTrue(s2.isFull());
		assertTrue(!s2.isEmpty());
		pushInt = 3;
		try {
			s2.push(pushInt);
			System.out.println("FAILURE, push should throw a RuntimeException on a full stack");
		}catch(RuntimeException e) 
		{
			System.out.println("SUCCESS, push should throw a RuntimeException on a full stack\n" + e);
		}
		assertTrue(s2.pop() == 2);
		assertTrue(s2.pop()==1);
		assertTrue(s2.isEmpty());
		assertTrue(s2.getSize()==0);
		try {
			s2.pop();
			
			System.out.println("FAILURE, pop should throw a RuntimeException on an empty stack");
			assertFalse(true);
		}catch (RuntimeException e) 
		{
			System.out.println("SUCCESS, pop throws a RuntimeException on an empty stack\n" + e);
		}
		try {
			s2.peek();
			
			System.out.println("FAILURE, peek should throw a RuntimeException on an empty stack");
			assertFalse(true);
		}catch (RuntimeException e) 
		{
			System.out.println("SUCCESS, peek throws a RuntimeException on an empty stack\n" + e);
		}
		s2.clear();
	    assertTrue(s2.getSize() == 0);
	    s2.clear();
	    assertTrue(s2.getSize() == 0);
	    pushInt=1;
		s2.push(pushInt);
		assertTrue(s2.peek()==(pushInt));
		assertTrue(s2.getSize() == 1);
		assertTrue(!s2.isFull());
		assertTrue(!s2.isEmpty());
		assertTrue(s2.getSize() ==1);
		assertTrue(s2.pop() == pushInt);
		assertTrue(s1.getSize() ==0 );
		assertTrue(s1.isEmpty());
		assertFalse(s1.isFull());
		s2.clear();
	    assertTrue(s2.getSize() == 0);
	    pushInt = 1;
	    s2.push(pushInt);
	    pushInt = 2;
	    s2.push(pushInt);
	    String retStr = s2.toString();
	    assertEquals("2\n1\n", retStr);
	    int numLines = utils.MyUtils.numberLines(retStr);
	    assertEquals(2,numLines);
	    s2.clear();
	    retStr = s2.toString();
	    numLines = utils.MyUtils.numberLines(retStr);
	    assertEquals("", retStr);
	    assertEquals(0,numLines);
	    s2.push(pushInt);
	    pushInt = 2;
	    s2.push(pushInt);
	    retStr = s2.toString();
	    numLines = utils.MyUtils.numberLines(retStr);
	    assertEquals(2,numLines);
	    
		System.out.println("SUCCESS StackTesting PASSES");
	    s2.clear();
	    assertTrue(s2.getSize() == 0);
	    assertTrue(s2.getMaxSize() == 2);
	    s2.clear();
	    assertTrue(s2.getSize() == 0);
	    assertTrue(s2.getMaxSize() == 2);
	}
		
	public void stackArrayListTest()
	{
		
		final int OVER_LARGEST = 100009;
		String pushString="";
		int pushInt = 0;
		StackList <String> s1 = new StackListArrayListImpl<String>(3);
		StackList<Integer> s2 = new StackListArrayListImpl<Integer>(2);
		StackList<String> s3 = new StackListArrayListImpl<String>();
		StackList<String> s4 = new StackListArrayListImpl<String>(-2);
		StackList<String> s5 = new StackListArrayListImpl<String>(StackList.LARGEST);
		StackList<String> s6 = new StackListArrayListImpl<String>(OVER_LARGEST);
		assertTrue(s5.getMaxSize()==StackList.LARGEST);
		assertTrue(s6.getMaxSize() == StackList.DEFAULT_MAX_SIZE);
		assertTrue(s4.getMaxSize() == StackList.DEFAULT_MAX_SIZE);
		assertTrue(s3.getMaxSize()==StackList.DEFAULT_MAX_SIZE);
		assertTrue(s1.getMaxSize()==3);
		assertTrue(s2.getMaxSize()==2);
		assertTrue(s1.isEmpty());
		assertTrue(s2.isEmpty());
		pushString="first";
		s1.push(pushString);
		assertTrue(s1.peek().equals(pushString));
		assertTrue(s1.getSize() == 1);
		assertTrue(!s1.isFull());
		assertTrue(!s1.isEmpty());
		pushString="second";
		s1.push(pushString);
		assertTrue(s1.peek().equals(pushString));
		assertTrue(s1.getSize() == 2);
		assertTrue(!s1.isFull());
		assertTrue(!s1.isEmpty());
		pushString="third";
		s1.push(pushString);
		assertTrue(s1.peek().equals(pushString));
		assertTrue(s1.getSize() == 3);
		assertTrue(s1.isFull());
		assertTrue(!s1.isEmpty());
		pushString="fourth";
		try {
			s1.push(pushString);
			System.out.println("FAILURE, push should throw a RuntimeException on a full stack");
		}catch(RuntimeException e) 
		{
			System.out.println("SUCCESS, push should throw a RuntimeException on a full stack\n" + e);
		}
		// new test toString()
		String str = s1.toString();
		assertEquals("third\nsecond\nfirst\n", str);
		StringTokenizer tokenizer = new StringTokenizer(str,"\n");
		String token = tokenizer.nextToken();
		assertTrue(token.equals("third"));
		token = tokenizer.nextToken();
		assertTrue(token.equals("second"));
		token = tokenizer.nextToken();
		assertTrue(token.equals("first"));
		assertEquals(3, utils.MyUtils.numberLines(str));
		System.out.println("*****\ntoString() of s1: \n" + str + "*****");
		assertTrue(s1.pop().equals("third"));
		assertTrue(s1.pop().equals("second"));
		assertTrue(s1.pop().equals("first"));
		assertTrue(s1.isEmpty());
		assertTrue(s1.getSize()==0);
		try {
			s1.pop();
			
			System.out.println("FAILURE, pop should throw a RuntimeException on an empty stack");
		}catch (RuntimeException e) 
		{
			System.out.println("SUCCESS, pop throws a RuntimeException on an empty stack\n" + e);
		}
		pushString="one";
		s1.push(pushString);
		assertTrue(s1.getSize() ==1);
		assertTrue(s1.pop().equals(pushString));
		assertTrue(s1.getSize() ==0 );
		assertTrue(s1.isEmpty());
		assertFalse(s1.isFull());
		
	    // now test Stack of Integer
		System.out.println("****  Now testing Stack<Integer>****");
		pushInt=1;
		s2.push(pushInt);
		assertTrue(s2.peek()==(pushInt));
		assertTrue(s2.getSize() == 1);
		assertTrue(!s2.isFull());
		assertTrue(!s2.isEmpty());
		pushInt = 2;
		s2.push(pushInt);
		assertTrue(s2.peek()==(pushInt));
		assertTrue(s2.getSize() == 2);
		assertTrue(s2.isFull());
		assertTrue(!s2.isEmpty());
		pushInt = 3;
		try {
			s2.push(pushInt);
			System.out.println("FAILURE, push should throw a RuntimeException on a full stack");
		}catch(RuntimeException e) 
		{
			System.out.println("SUCCESS, push should throw a RuntimeException on a full stack\n" + e);
		}
		assertTrue(s2.pop() == 2);
		assertTrue(s2.pop()==1);
		assertTrue(s2.isEmpty());
		assertTrue(s2.getSize()==0);
		try {
			s2.pop();
			
			System.out.println("FAILURE, pop should throw a RuntimeException on an empty stack");
			assertFalse(true);
		}catch (RuntimeException e) 
		{
			System.out.println("SUCCESS, pop throws a RuntimeException on an empty stack\n" + e);
		}
		try {
			s2.peek();
			
			System.out.println("FAILURE, peek should throw a RuntimeException on an empty stack");
			assertFalse(true);
		}catch (RuntimeException e) 
		{
			System.out.println("SUCCESS, peek throws a RuntimeException on an empty stack\n" + e);
		}
		s2.clear();
	    assertTrue(s2.getSize() == 0);
	    s2.clear();
	    assertTrue(s2.getSize() == 0);
	    pushInt=1;
		s2.push(pushInt);
		assertTrue(s2.peek()==(pushInt));
		assertTrue(s2.getSize() == 1);
		assertTrue(!s2.isFull());
		assertTrue(!s2.isEmpty());
		assertTrue(s2.getSize() ==1);
		assertTrue(s2.pop() == pushInt);
		assertTrue(s1.getSize() ==0 );
		assertTrue(s1.isEmpty());
		assertFalse(s1.isFull());
		s2.clear();
	    assertTrue(s2.getSize() == 0);
		System.out.println("SUCCESS StackTesting PASSES");
	    s2.clear();
	    assertTrue(s2.getSize() == 0);
	    assertTrue(s2.getMaxSize() == 2);
	    s2.clear();
	    assertTrue(s2.getSize() == 0);
	    assertTrue(s2.getMaxSize() == 2);
	    pushInt = 1;
	    s2.push(pushInt);
	    pushInt = 2;
	    s2.push(pushInt);
	    String retStr = s2.toString();
	    int numLines = utils.MyUtils.numberLines(retStr);
	    assertEquals(2,numLines);
	    s2.clear();
	    retStr = s2.toString();
	    numLines = utils.MyUtils.numberLines(retStr);
	    assertEquals(0,numLines);
	    s2.push(pushInt);
	    pushInt = 2;
	    s2.push(pushInt);
	    retStr = s2.toString();
	    numLines = utils.MyUtils.numberLines(retStr);
	    assertEquals(2,numLines);
	   
	}


}