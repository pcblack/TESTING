package bankingapp.test.bankingApp;

import static org.junit.Assert.*;

import bankingapp.src.bankingApp.*;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.rules.ExpectedException;

import javax.naming.NameNotFoundException;

public class BankTest {
	protected Currency CAD;
	protected Currency HKD;
	protected Bank RBC;
	protected Bank TD;
	protected Bank HSBC;
	protected Money MN1000,MN100;
	public ExpectedException thrown = ExpectedException.none();


	@Before
	public void setUp() throws Exception {
		
		// setup some test currencies
		this.HKD = new Currency("HKD", 0.13);
		this.CAD = new Currency("CAD", 0.75);
		
		// setup test banks
		this.RBC = new Bank("Royal Bank of Canada", CAD);
		this.TD = new Bank("TD Bank", CAD);
		this.HSBC = new Bank("Hong Kong Shanghai Banking Corporation", HKD);
		
		// add sample customers to the banks
		MN1000 = new Money(1000,CAD);
		MN100 = new Money(100,CAD);
		
		// HINT:  uncomment these lines AFTER you test the openAccount() function
		// You can quickly uncomment / comment by highlighting the lines of code and pressing 
		// CTRL + / on your keyboard  (or CMD + / for Macs)
		//this.RBC.openAccount("Marcos");
		//this.RBC.openAccount("Albert");
		this.TD.openAccount("Jigesha");
		this.TD.openAccount("David");
		this.HSBC.openAccount("Pritesh");
	}

	@Test
	public void testGetName() {

		assertEquals("TD Bank",TD.getName());
		assertEquals("Royal Bank of Canada",RBC.getName());
		assertEquals("Hong Kong Shanghai Banking Corporation",HSBC.getName());

		//fail("Write test case here");
	}

	@Test
	public void testGetCurrency() {


		assertEquals(this.CAD,TD.getCurrency());
		assertEquals(this.CAD,RBC.getCurrency());
		assertEquals(this.HKD,HSBC.getCurrency());

		//fail("Write test case here");
	}

	@Test
	public void testOpenAccount() throws AccountExistsException, AccountDoesNotExistException {
		// If the function throws an exception, you should also test
		// that the exception gets called properly.
		// See the example in class notes for testing exceptions.

		RBC.openAccount("Hello");


		//RBC.openAccount("Hello");

		//RBC.openAccount("Marcos");

		//this.RBC.openAccount("Albert");
		//thrown.expect(AccountExistsException.class);
		//thrown.expectMessage(is("Account exists"));


		//fail("Write test case here");
	}

	@Test
	public void testDeposit() throws AccountDoesNotExistException {
		// If the function throws an exception, you should also test
		// that the exception gets called properly.
		
		// See the example in class notes for testing exceptions.
		TD.deposit("Jigesha",MN1000);
		HSBC.deposit("Pritesh",MN1000);

		thrown.expect(AccountDoesNotExistException.class);
		thrown.expectMessage(is("Account does not exists!"));
		//fail("Write test case here");
	}

	@Test
	public void testWithdraw() throws AccountDoesNotExistException {
		// If the function throws an exception, you should also test
		// that the exception gets called properly.
		TD.withdraw("Jigesha",MN100);
		HSBC.withdraw("Pritesh",MN100);
		// See the example in class notes for testing exceptions.
		
		//fail("Write test case here");
	}
	
	@Test
	public void testGetBalance() throws AccountDoesNotExistException {
		// If the function throws an exception, you should also test
		// that the exception gets called properly.
		TD.deposit("Jigesha",MN1000);
		assertEquals(1000,TD.getBalance("Jigesha"));
		// See the example in class notes for testing exceptions.
		
		//fail("Write test case here");
	}
	
	@Test
	public void testTransfer() throws AccountDoesNotExistException {
		// Note: You should test both types of transfers:
		// 1. Transfer from account to account
		// 2. Transfer between banks
		// See the Bank.java file for more details on Transfers

		TD.transfer("Jigesha","David",MN100);
		TD.transfer("David","Jigesha",MN100);


		//fail("Write test case here");
	}
	
}
