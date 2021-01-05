package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.StringTokenizer;

import org.junit.jupiter.api.Test;

import queue.QueueList;
import queue.QueueListLinkedListImpl;
import utils.MyUtils;

class QueueTest {

	final int OVER_LARGEST = 100001;
	@Test
	public void test() {
		String sName = utils.MyUtils.getNameFromStudent();
		MyUtils.printTimeStamp(sName + " begins");
		queueTest();
		System.out.println("SUCCESS Queue Testing Complete");
		MyUtils.printTimeStamp(sName + " ends");
		
	}
	public void queueTest()
	{
		String pushString="";
		int pushInt = 0;
		QueueList <String> q1 = new QueueListLinkedListImpl<String>(3);
		QueueList<Integer> q2 = new QueueListLinkedListImpl<Integer>(2);
		QueueList <String> q3 = new QueueListLinkedListImpl<String>();
		QueueList <String> q4 = new QueueListLinkedListImpl<String>(-3);
		QueueList<String> s5 = new QueueListLinkedListImpl<String>(QueueList.LARGEST);
		QueueList<String> s6 = new QueueListLinkedListImpl<String>(OVER_LARGEST);
		assertTrue(s5.getMaxSize()==QueueList.LARGEST);
		assertTrue(s6.getMaxSize() == QueueList.DEFAULT_MAX_SIZE);
		assertTrue(q3.getMaxSize() == QueueList.DEFAULT_MAX_SIZE);
		assertTrue(q4.getMaxSize() == QueueList.DEFAULT_MAX_SIZE);
		assertTrue(q1.getMaxSize()==3);
		assertTrue(q2.getMaxSize()==2);
		assertTrue(q1.isEmpty());
		assertTrue(q2.isEmpty());
		pushString = "first";
		q1.add(pushString);
		assertTrue(q1.getSize() == 1);
		assertFalse(q1.isEmpty());
		assertFalse(q1.isFull());
		assertTrue(q1.getFront().equals(pushString));
		assertTrue(q1.getRear().equals(pushString));
		String res = q1.remove();
		assertTrue(q1.isEmpty());
		res = q1.toString();
		int numLines = utils.MyUtils.numberLines(res);
		assertEquals(0, numLines);
		q1.add(pushString);
		pushString = "second";
		q1.add(pushString);
		assertTrue(q1.getSize() == 2);
		assertFalse(q1.isEmpty());
		assertFalse(q1.isFull());
		assertTrue(q1.getFront().equals("first"));
		assertTrue(q1.getRear().equals(pushString));
		pushString = "third";
		q1.add(pushString);
		assertTrue(q1.getSize() == 3);
		assertFalse(q1.isEmpty());
		assertTrue(q1.isFull());
		assertTrue(q1.getFront().equals("first"));
		assertTrue(q1.getRear().equals(pushString));
		System.out.println("Now testing toString() for QueueListImpl");
		String out = q1.toString();
		System.out.println("****\n" + "toString()\n" + out + "****");
		numLines = utils.MyUtils.numberLines(out);
		assertTrue(numLines == 3);
		assertEquals("first\nsecond\nthird\n", out);
		StringTokenizer tokenizer = new StringTokenizer(out);
		String token = tokenizer.nextToken();
		assertTrue(token.equals("first"));
		token = tokenizer.nextToken();
		assertTrue(token.equals("second"));
		token = tokenizer.nextToken();
		assertTrue(token.equals("third"));

		pushString = "fourth";
		try {
			q1.add(pushString);

			System.out.println("FAILURE, add should throw a RuntimeException on a FULL QUEUE");
		}catch (RuntimeException e) 
		{
			System.out.println("SUCCESS, add throws a RuntimeException on a FULL QUEUE\n" + e);
		}
		assertTrue(q1.remove().equals("first"));
		out = q1.toString();
		numLines = utils.MyUtils.numberLines(out);
		assertTrue(numLines == 2);

		assertTrue(q1.getSize()==2);
		assertFalse(q1.isEmpty());
		assertFalse(q1.isFull());
		assertTrue(q1.remove().equals("second"));
		assertTrue(q1.getSize()==1);
		assertFalse(q1.isEmpty());
		assertFalse(q1.isFull());
		assertTrue(q1.remove().equals("third"));
		assertTrue(q1.getSize()==0);
		assertTrue(q1.isEmpty());
		assertFalse(q1.isFull());
		try {
			q1.getFront();

			System.out.println("FAILURE, getFront() should throw a RuntimeException on an EMPTY QUEUE");
			assertFalse(true);
		}catch (RuntimeException e) 
		{
			System.out.println("SUCCESS, getFront() throws a RuntimeException on an EMPTY QUEUE\n" + e);
			
		}
		try {
			q1.getRear();
			System.out.println("FAILURE, getRear() should throw a RuntimeException on an EMPTY QUEUE");
			assertFalse(true);
		}catch (RuntimeException e) 
		{
			System.out.println("SUCCESS, getRear() throws a RuntimeException on and EMPTY QUEUE\n" + e);
		}
		try {
			q1.remove();
			System.out.println("FAILURE, remove() should throw a RuntimeException on an EMPTY QUEUE");
			assertFalse(true);
		}catch (RuntimeException e) 
		{
			System.out.println("SUCCESS, remove() throws a RuntimeException on an EMPTY QUEUE\n" + e);
		}
		pushString = "first";
		q1.add(pushString);
		assertTrue(q1.getSize() == 1);
		assertFalse(q1.isEmpty());
		assertFalse(q1.isFull());
		assertTrue(q1.getFront().equals(pushString));
		assertTrue(q1.getRear().equals(pushString));
		String remResult = q1.remove();
		assertTrue(remResult.equals(pushString));
		assertTrue(q1.getSize() == 0);
		assertTrue(q1.isEmpty());
		assertFalse(q1.isFull());
		try {
			q1.remove();
			System.out.println("FAILURE, remove() should throw a RuntimeException on an EMPTY QUEUE");
			assertFalse(true);
		}catch (RuntimeException e) 
		{
			System.out.println("SUCCESS, remove() throws a RuntimeException on an EMPTY QUEUE\n" + e);
		}
		System.out.println("****  Now testing QueueList of Integer ****");
		pushInt = 1;
		q2.add(pushInt);
		assertTrue(q2.getSize() == 1);
		assertFalse(q2.isEmpty());
		assertFalse(q2.isFull());
		assertTrue(q2.getFront()==(pushInt));
		assertTrue(q2.getRear()==(pushInt));
		pushInt = 2;
		q2.add(pushInt);
		assertTrue(q2.getSize() == 2);
		assertFalse(q2.isEmpty());
		assertTrue(q2.isFull());
		assertTrue(q2.getFront()==(1));
		assertTrue(q2.getRear()==pushInt);
		pushInt = 3;
		try {
			q2.add(pushInt);
			System.out.println("FAILURE, add() should throw a RuntimeException on a FULL QUEUE");
			assertFalse(true);
		}catch (RuntimeException e) 
		{
			System.out.println("SUCCESS, add() throws a RuntimeException on a FULL QUEUE\n" + e);
		}
		assertTrue(q2.isFull());
		assertTrue(q2.getSize() == 2);
		int remInt =0;
		remInt = q2.remove();
		assertTrue(remInt == 1);
		assertTrue(q2.getSize() == 1);
		assertTrue(q2.getFront() == 2);
		assertTrue(q2.getRear() == 2);
		remInt = q2.remove();
		assertTrue(remInt == 2);
		assertTrue(q2.isEmpty());
		assertFalse(q2.isFull());
		assertTrue(q2.getSize() == 0);
		try {
			q2.remove();
			System.out.println("FAILURE, remove() should throw a RuntimeException on an EMPTY QUEUE");
			assertFalse(true);
		}catch (RuntimeException e) 
		{
			System.out.println("SUCCESS, remove() throws a RuntimeException on an EMPTY QUEUE\n" + e);
		}
		try {
			q2.getRear();
			System.out.println("FAILURE, getRear() should throw a RuntimeException on an EMPTY QUEUE");
			assertFalse(true);
		}catch (RuntimeException e) 
		{
			System.out.println("SUCCESS, getRear() throws a RuntimeException on and EMPTY QUEUE\n" + e);
		}
		try {
			q2.remove();
			System.out.println("FAILURE, remove() should throw a RuntimeException on an EMPTY QUEUE");
			assertFalse(true);
		}catch (RuntimeException e) 
		{
			System.out.println("SUCCESS, remove() throws a RuntimeException on an EMPTY QUEUE\n" + e);
		}
		pushInt = 1;
		q2.add(pushInt);
		assertTrue(q2.getSize() == 1);
		assertFalse(q2.isEmpty());
		assertFalse(q2.isFull());
		assertTrue(q2.getFront()==(pushInt));
		assertTrue(q2.getRear()==(pushInt));
		remInt = q2.remove();
		assertTrue(remInt == pushInt);
		assertTrue(q2.isEmpty());
		assertFalse(q2.isFull());
		assertTrue(q2.getSize() == 0);
		try {
			q2.remove();
			System.out.println("FAILURE, remove() should throw a RuntimeException on an EMPTY QUEUE");
			assertFalse(true);
		}catch (RuntimeException e) 
		{
			System.out.println("SUCCESS, remove() throws a RuntimeException on an EMPTY QUEUE\n" + e);
		}
		try {
			q2.getRear();
			System.out.println("FAILURE, getRear() should throw a RuntimeException on an EMPTY QUEUE");
			assertFalse(true);
		}catch (RuntimeException e) 
		{
			System.out.println("SUCCESS, getRear() throws a RuntimeException on and EMPTY QUEUE\n" + e);
		}
		try {
			q2.remove();
			System.out.println("FAILURE, remove() should throw a RuntimeException on an EMPTY QUEUE");
			assertFalse(true);
		}catch (RuntimeException e) 
		{
			System.out.println("SUCCESS, remove() throws a RuntimeException on an EMPTY QUEUE\n" + e);
		}
		//testing toString()
		System.out.println("Testing toString()");
		q1.clear();
		q1.add("1");
		q1.add("2");
		q1.add("3");
		q1.remove();
		q1.add("4");
		res = q1.toString();
		assertEquals(3, utils.MyUtils.numberLines(res));
		StringTokenizer tk = new StringTokenizer(res);
		assertEquals("2", tk.nextToken(), " should be 2 then 3 then 4");
		assertEquals("3", tk.nextToken());
		assertEquals("4", tk.nextToken());
		q1.remove();
		q1.add("1");
		res = q1.toString();
		tk = new StringTokenizer(res);  
		assertEquals("3", tk.nextToken(), " should be 3 then 4 then 1 ");
		assertEquals("4", tk.nextToken());
		assertEquals("1", tk.nextToken());
		q1.remove();
		res = q1.toString();
		tk = new StringTokenizer(res);  
		assertEquals("4", tk.nextToken(), " should be 4 then 1");
		assertEquals("1", tk.nextToken());
		q1.remove();
		res = q1.toString();
		tk = new StringTokenizer(res);  
		assertEquals("1", tk.nextToken(), " should be 1");
		q1.remove();
		res = q1.toString();
		assertEquals("", res);
		

		//testing clear()
		pushInt = 1;
		q2.add(pushInt);
		assertTrue(q2.getSize()==1);
		q2.clear();
		assertTrue(q2.getSize() ==0);
		q2.add(pushInt);
		assertTrue(q2.getSize()==1);
		assertTrue(q2.getFront() == pushInt);
		assertTrue(q2.getRear() == pushInt);
		pushInt = 2;
		q2.add(pushInt);
		assertTrue(q2.getSize()==2);
		assertTrue(q2.getFront() == 1);
		assertTrue(q2.getRear() == pushInt);
		assertTrue(q2.isFull());
		q2.clear();
		String retStr = q2.toString();
		numLines = utils.MyUtils.numberLines(retStr);
		assertEquals(0, numLines);
		assertTrue(q2.isEmpty());
		System.out.println("SUCCESS QueueTesting PASSES");
	}

}