package test;

import static org.junit.Assert.*;
import org.junit.Test;

import biginteger.BigIntegerEngine;
import biginteger.BigIntegerEngineImpl;
public class BigIntegerTest {
	@Test
	public void test() {
		String sName = "";
		sName = utils.MyUtils.getNameFromStudent();
		utils.MyUtils.printTimeStamp("begins for " + sName);
		operandTests();
		System.out.println("SUCCESS  Operand Tests COMPLETE");
		getSum1Tests();
		System.out.println("SUCCESS  getSum1Tests COMPLETE");
		getSum2Tests();
		System.out.println("SUCCESS  getSum2Tests COMPLETE");
		getSumMultipleTests();
		System.out.println("SUCCESS  getSumMultiple COMPLETE");
		utils.MyUtils.printTimeStamp("ends for " + sName);
	}
		
	public void operandTests() {
		System.out.println("Begin operands tests");
			BigIntegerEngine engine = new BigIntegerEngineImpl();
			String out = engine.toString();
			assertTrue(out.equals("0\n0\n0\n0\n"));
			for(int i=0; i<BigIntegerEngine.MAX_OPERANDS; i++)
			{
				assertEquals("0", engine.getOperand(i+1));
			}
			assertTrue(engine.setOperand(1, "1"));
			assertTrue(engine.setOperand(2, "2"));
			assertTrue(engine.setOperand(3, "3"));
			assertTrue(engine.setOperand(4, "4"));
			assertTrue(engine.toString().equals("1\n2\n3\n4\n"));
			System.out.println("SUCCESS, first sets work and so does default constructor");
			assertEquals("1", engine.getOperand(1) );
			assertEquals("2", engine.getOperand(2));
			assertEquals("3", engine.getOperand(3));
			assertEquals("4",engine.getOperand(4));
			assertEquals("", engine.getOperand(0));
			assertEquals("", engine.getOperand(5));
			System.out.println("SUCCESS, getOperand working");
			assertTrue(engine.setOperand(1,"1234567890123456789"));
			assertEquals( "1234567890123456789", engine.getOperand(1));
			assertTrue(engine.setOperand(2,  "444444444455555555556666666666777777777788888888889999999999"));
			assertEquals("444444444455555555556666666666777777777788888888889999999999", engine.getOperand(2));
			assertTrue(engine.setOperand(1, "0"));
			assertEquals(engine.getOperand(1), "0");
			assertEquals(engine.getOperand(-1), "");
			assertFalse(engine.setOperand(5, "5"));
			assertFalse(engine.setOperand(0,  "33"));
			assertFalse(engine.setOperand(1, "-1"));
			assertFalse(engine.setOperand(1, ""));
			assertFalse(engine.setOperand(4, "-+42;"));
			assertFalse(engine.setOperand(2, "h^9"));
			assertFalse(engine.setOperand(5, ";;3320234=2-20-30-04$$$$$"));
			assertFalse(engine.setOperand(-2, "1"));
			assertFalse(engine.setOperand(-6, "1"));
			assertFalse(engine.setOperand(BigIntegerEngine.MAX_OPERANDS+1, ""));
			engine.clearOperands();
			assertEquals("0", engine.getOperand(1));
			assertEquals("0", engine.getOperand(2));
			assertEquals("0", engine.getOperand(3));
			assertEquals("0", engine.getOperand(4));
			assertTrue(engine.setOperand(1, "1"));
			assertTrue(engine.setOperand(2, "2"));
			assertTrue(engine.setOperand(3, "3"));
			assertTrue(engine.setOperand(4, "4"));
			assertEquals("1", engine.getOperand(1));
			assertEquals("2", engine.getOperand(2));
			assertEquals("3", engine.getOperand(3));
			assertEquals("4", engine.getOperand(4));
			assertEquals("", engine.getOperand(0));
			assertEquals("", engine.getOperand(5));
			assertTrue(engine.toString().equals("1\n2\n3\n4\n"));
			engine.clearOperands();
			assertEquals("0", engine.getOperand(1));
			assertEquals("0", engine.getOperand(2));
			assertEquals("0", engine.getOperand(3));
			assertEquals("0", engine.getOperand(4));
			assertTrue(engine.toString().equals("0\n0\n0\n0\n"));
			System.out.println("SUCCESS, clearOperands working.");
			System.out.println("*****SUCCESS,  End of operand tests *****");
	}
	
	public void getSum1Tests()
	{
		System.out.println("Begin sum1 Testing ");
		BigIntegerEngine engine = new BigIntegerEngineImpl();
		String answer = engine.getSum();
		assertEquals("0", answer);
		engine.setOperand(1,"1");
		answer = engine.getSum();
		assertEquals("1", answer);
		engine.setOperand(1, "9");
		answer = engine.getSum();
		assertEquals("9", answer);
		engine.setOperand(1, "999");  
		answer = engine.getSum();
		assertEquals("999", answer);
		engine.clearOperands();
		assertEquals(engine.getOperand(1),"0");
		assertEquals(engine.getOperand(2),"0");
		assertEquals(engine.getOperand(3),"0");
		assertEquals(engine.getOperand(4),"0");
		answer = engine.getSum();
		assertEquals(answer, "0");
		engine.setOperand(4,  "111111111122222222223333333333444444444455555555556666666666777777777788888888889999999990000000000");
		answer = engine.getSum();
		assertEquals( "111111111122222222223333333333444444444455555555556666666666777777777788888888889999999990000000000", answer);
		engine.clearOperands();
		engine.setOperand(3,  "111111111122222222223333333333444444444455555555556666666666777777777788888888889999999990000000000");
		answer = engine.getSum();
		assertEquals( "111111111122222222223333333333444444444455555555556666666666777777777788888888889999999990000000000", answer);
		engine.clearOperands();
		engine.setOperand(2,  "111111111122222222223333333333444444444455555555556666666666777777777788888888889999999990000000000");
		answer = engine.getSum();
		assertEquals("111111111122222222223333333333444444444455555555556666666666777777777788888888889999999990000000000", answer);
		System.out.println("*****SUCCESS, getSum1Tests() completed *******");
		
	}
	
	public void getSum2Tests()
	{
		System.out.println("****begin getSum2 Testing");
		BigIntegerEngine engine = new BigIntegerEngineImpl();
		String answer="";
		engine.setOperand(3, "19");
		engine.setOperand(4, "0");
		answer = engine.getSum();
		assertEquals("19", answer);
		engine.clearOperands();
		answer = engine.getSum();
		assertEquals( "0", answer);
		engine.setOperand(1, "1");
		answer = engine.getSum();
		assertEquals("1", answer);
		engine.setOperand(2, "9");
		answer = engine.getSum();
		assertEquals("10", answer);
		engine.setOperand(2, "999");  
		answer = engine.getSum();
		assertEquals("1000", answer);
		engine.setOperand(1,"0");
		engine.setOperand(2, "0");
		engine.setOperand(3, "1");
		engine.setOperand(4, "2");
		answer = engine.getSum();
		assertEquals("3", answer);
		engine.setOperand(3,"333");
		answer = engine.getSum();
		assertEquals( "335", answer);
		engine.setOperand(4, "111");
		answer = engine.getSum();
		assertEquals("444", answer);
		engine.setOperand(3, "8");
		engine.setOperand(4, "1111");
		answer = engine.getSum();
		assertEquals("1119", answer);
		engine.setOperand(3, "0");
		engine.setOperand(4, "19");
		answer = engine.getSum();
		assertEquals("19", answer);
		engine.setOperand(3, "19");
		engine.setOperand(4, "0");
		answer = engine.getSum();
		assertEquals("19", answer);
		engine.clearOperands();
		engine.setOperand(2, "3");
		engine.setOperand(3, "7");
		answer = engine.getSum();
		assertEquals("10", answer);
		engine.clearOperands();
		engine.setOperand(2, "3333333333333333333333333333333333333333");
		engine.setOperand(3, "7888888888888888888888888888888888888888");
		answer = engine.getSum();
		assertEquals("11222222222222222222222222222222222222221", answer);	
		engine.clearOperands();
		engine.setOperand(1, "3333333333333333333333333333333333333333");
		engine.setOperand(4, "7888888888888888888888888888888888888888");
		answer = engine.getSum();
		assertEquals("11222222222222222222222222222222222222221", answer);	
		System.out.println("******SUCCESS, getSum2Tests Completed");
	}
	
	public void getSumMultipleTests()
	{
		System.out.println("******Begin sum of multiples ******");
		BigIntegerEngine engine = new BigIntegerEngineImpl();
		String answer="";
		answer = engine.getSum();
		assertEquals("0", answer);
		for(int i=0; i< BigIntegerEngine.MAX_OPERANDS; i++)
		{
			engine.setOperand(i+1, "5");
		}
		answer = engine.getSum();
		assertEquals("20", answer);
		engine.setOperand(1, "1000000000000000");
		answer = engine.getSum();
		assertEquals(answer, "1000000000000015");
		engine.clearOperands();
		engine.setOperand( BigIntegerEngine.MAX_OPERANDS, "10000000000");
		answer = engine.getSum();
		assertEquals( "10000000000", answer);
		engine.setOperand(1,"9");
		engine.setOperand(2, "99");
		engine.setOperand(3, "999");
		engine.setOperand(4, "9999");
		answer = engine.getSum();
		assertEquals( "11106", answer);
		engine.setOperand(1, "1");
		engine.setOperand(2, "10");
		engine.setOperand(3, "100");
		engine.setOperand(4, "1000");
		answer = engine.getSum();
		assertEquals("1111", answer);
		engine.clearOperands();
		answer = engine.getSum();
		assertEquals( "0", answer);
		engine.setOperand(1, "888");
		engine.setOperand(4, "9");
		answer = engine.getSum();
		assertEquals( "897", answer);
		engine.setOperand(3, "111");
		answer = engine.getSum();
		assertEquals( "1008", answer);
		engine.setOperand(2, "999");
		answer = engine.getSum();
		assertEquals("2007", answer);
		engine.setOperand(2, "3333333333333333333333333333333333333333");
		engine.setOperand(3, "7888888888888888888888888888888888888888");
		engine.setOperand(1, "3333333333333333333333333333333333333333");
		engine.setOperand(4, "7888888888888888888888888888888888888888");
		answer=engine.getSum();
		assertEquals("22444444444444444444444444444444444444442", answer);
		System.out.println("******SUCCESS, add MultipleTests completed ******");
	}
}
