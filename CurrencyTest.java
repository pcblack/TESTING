package bankingapp.test.bankingApp;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import bankingapp.src.bankingApp.Currency;
import org.junit.Before;
import org.junit.Test;

import bankingapp.src.bankingApp.Currency;

public class CurrencyTest {
	
	/* Example currencies: 
	 * 	CAD = Canadian dollar
	 * 	EUR = Euros
	 * 	GBP = Great British Pounds
	 * 	HKD = Hong Kong Dollars
	 */
	public Currency CAD, EUR, GBP, HKD;
	
	@Before
	public void setUp() throws Exception {
		// Setup some test currencies to use in the below test cases
		CAD = new Currency("CAD", 0.75);
		EUR = new Currency("EUR", 1.14);
		HKD = new Currency("HKD", 0.13);
	}

	@Test
	public void testGetName() {
		// Write the test case for testing the getName() function
		assertEquals("CAD",CAD.getName());
		assertEquals("EUR",EUR.getName());
		assertEquals("HKD",HKD.getName());
		//assertEquals("GBP",GBP.getName());
		//fail("GBP");
	}
	
	@Test
	public void testGetRate() {
		// @TODO: Write the test case for testing the getRate() function
		assertEquals(0.75,CAD.getRate());
		assertEquals(1.14,EUR.getRate());
		assertEquals(0.13,HKD.getRate());

		//fail("GBP");
	}
	
	@Test
	public void testSetRate() {
		// @TODO: Write the test case for testing the setRate() function
		assertEquals(0.13,HKD.getRate());
		HKD.setRate(0.17);
		assertEquals(0.17,HKD.getRate());

		assertEquals(0.75,CAD.getRate());
		CAD.setRate(0.80);
		assertEquals(0.80,CAD.getRate());

		assertEquals(1.14,EUR.getRate());
		EUR.setRate(1.17);
		assertEquals(1.17,EUR.getRate());
		// For this function, you should do:
		// 1. Assert that the oldRate is correct
		// 2. Change the rate
		// 3. Assert that the newRate is correct
		// You will end up with 2 assert() statements in this function.
		//fail("Write test case here");
	}
	
	@Test
	public void testValueInUSD() {
		// @TODO: Write the test case for testing the valueInUSD() function
		assertEquals(2.6,HKD.valueInUSD(20));
		assertEquals(7.5,CAD.valueInUSD(10));
		assertEquals(228.0,EUR.valueInUSD(200));
		//fail("Write test case here");


	}
	
	@Test
	public void testValueInThisCurrency() {
		// @TODO: Write the test case for testing the valueInThisCurrency() function

		assertEquals(3.47,HKD.valueInThisCurrency(20,CAD));

		assertEquals(2.28,HKD.valueInThisCurrency(20,EUR));

		assertEquals(576.92,CAD.valueInThisCurrency(100,HKD));

		assertEquals(164.47,CAD.valueInThisCurrency(250,EUR));

		assertEquals(302.48,EUR.valueInThisCurrency(199,CAD));

		assertEquals(8769.23,EUR.valueInThisCurrency(1000,HKD));
		// For this function, you should:
		// 1. Assert the value of the "other" currency
		// 2. Get the value in "this" currency
		// 3. Assert that the value in "this" currency is correct
		// You will end up with 2 assert() statements in this function.
		//fail("Write test case here");
	}

}
