package bankingapp.test.bankingApp;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import bankingapp.src.bankingApp.Currency;
import bankingapp.src.bankingApp.Money;

public class MoneyTest {
	protected Currency CAD, HKD, NOK, EUR;
	protected Money CAD100, EUR10, CAD200, EUR20, CAD0, EUR0, CADnegative100,CAD300,CAD86;

	@Before
	public void setUp() throws Exception {
		// setup sample currencies
		CAD = new Currency("CAD", 0.75);
		HKD = new Currency("HKD", 0.13);
		EUR = new Currency("EUR", 1.14);

		// setup sample money amounts
		CAD100 = new Money(100, CAD);

		EUR10 = new Money(10, EUR);
		CAD200 = new Money(200, CAD);
		EUR20 = new Money(20, EUR);
		CAD0 = new Money(0, CAD);
		EUR0 = new Money(0, EUR);
		CADnegative100 = new Money(-100, CAD);

		CAD300 = new Money(300,CAD);
		CAD86 = new Money(115.2,CAD);
	}

	@Test
	public void testGetAmount() {

		assertEquals(100,
				CAD100.getAmount(),0.001);
		assertEquals(200,
				CAD200.getAmount(),0.001);
		assertEquals(20,
				EUR20.getAmount(),0.001);
		assertEquals(10,
				EUR10.getAmount(),0.001);

		assertEquals(0,
				CAD0.getAmount(),0.001);
		assertEquals(0,
				EUR0.getAmount(),0.001);
		assertEquals(-100,
				CADnegative100.getAmount(),0.001);


		//fail("Write test case here");
	}

	@Test
	public void testGetCurrency() {
		assertEquals(CAD,CAD100.getCurrency());
		assertEquals(CAD,CAD200.getCurrency());
		assertEquals(EUR,EUR10.getCurrency());
		assertEquals(EUR,EUR20.getCurrency());
		assertEquals(CAD,CAD0.getCurrency());
		assertEquals(EUR,EUR0.getCurrency());
		assertEquals(CAD,CADnegative100.getCurrency());


		//fail("Write test case here");
	}

	@Test
	public void testToString() {

		assertEquals("100.0CAD",CAD100.toString());
		assertEquals("200.0CAD",CAD200.toString());
		assertEquals("0.0CAD",CAD0.toString());
		assertEquals("-100.0CAD",CADnegative100.toString());
		assertEquals("10.0EUR",EUR10.toString());
		assertEquals("20.0EUR",EUR20.toString());
		assertEquals("0.0EUR",EUR0.toString());



		//fail("Write test case here");
	}

	@Test
	public void testGetUniversalValue() {

		assertEquals(75,CAD100.getUniversalValue(),0.001);
		assertEquals(150,CAD200.getUniversalValue(),0.001);
		assertEquals(0,CAD0.getUniversalValue(),0.001);
		assertEquals(-75.0,CADnegative100.getUniversalValue(),0.001);
		assertEquals(11.4,EUR10.getUniversalValue(),0.001);
		assertEquals(22.8,EUR20.getUniversalValue(),0.001);
		assertEquals(0,EUR0.getUniversalValue(),0.001);




		//fail("Write test case here");
	}

	@Test
	public void testEqualsMoney() {

		assertTrue(CAD100.equals(CAD100));
		assertFalse(EUR10.equals(CAD100));
		assertFalse(EUR20.equals(CAD100));
		assertFalse(EUR0.equals(CAD100));
		assertFalse(EUR10.equals(CAD200));
		assertFalse(EUR20.equals(CAD200));
		assertFalse(EUR0.equals(CAD200));
		assertTrue(EUR10.equals(EUR10));




		//fail("Write test case here");
	}

	@Test
	public void testAdd() {

		assertEquals(300,(CAD100.add(CAD200)).getAmount(),0.001);
		assertEquals(CAD300.getCurrency(),(CAD100.add(CAD200).getCurrency()));
		assertEquals(115.2,(CAD100.add(EUR10)).getAmount(),0.001);
		assertEquals(CAD86.getCurrency(),(CAD100.add(EUR10)).getCurrency());

		//fail("Write test case here");
	}

	@Test
	public void testSubtract() {

		assertEquals(100,(CAD100.subtract(CAD200)).getAmount(),0.001);
		assertEquals(CAD100.getCurrency(),(CAD100.subtract(CAD200)).getCurrency());
		assertEquals(84.8,(CAD100.subtract(EUR10)).getAmount(),0.001);
		assertEquals(CAD86.getCurrency(),(CAD100.add(EUR10)).getCurrency());


		//fail("Write test case here");
	}

	@Test
	public void testIsZero() {

		assertFalse(CAD300.isZero());
		assertTrue(CAD0.isZero());
		//fail("Write test case here");
	}

	@Test
	public void testNegate() {

		assertEquals(-300,CAD300.negate().getAmount(),0.001);
		assertEquals(-100,CAD100.negate().getAmount(),0.001);
		assertEquals(100,CADnegative100.negate().getAmount(),0.001);
		//fail("Write test case here");
	}

	@Test
	public void testCompareTo() {

		assertEquals(0,CAD100.compareTo(CAD100));
		assertEquals(1,CAD200.compareTo(EUR10));
		assertEquals(-1,EUR10.compareTo(EUR20));


		//fail("Write test case here");
	}
}