package bankingapp.test.bankingApp;

import org.junit.Before;
import org.junit.Test;

import bankingapp.src.bankingApp.Account ;
import bankingapp.src.bankingApp.AccountDoesNotExistException;
import bankingapp.src.bankingApp.Bank;
import bankingapp.src.bankingApp.Currency;
import bankingapp.src.bankingApp.Money;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountTest {
	protected Currency CAD, HKD;
	protected Bank TD;
	protected Bank HSBC;
	protected Bank RBC;
	protected Account testAccount;
	protected Money LOL,LOL2,LOL3;

	@Before
	public void setUp() throws Exception {

		// setup test currencies
		CAD = new Currency("CAD", 0.75);
		RBC = new Bank("Royal bankingApp.Bank of Canada", CAD);

		//

		LOL = new Money(90,CAD);
		LOL2 = new Money(900,CAD);
		LOL3 = new Money(1000.0,CAD);


		// setup test accounts
		RBC.openAccount("Peter");
		testAccount = new Account("Albert", CAD);
		testAccount.deposit(new Money(100, CAD));

		// setup an initial deposit
		//RBC.deposit("Peter", new Money(500, CAD));
		//testAccount.deposit(LOL2);
	}

	@Test
	public void testAddWithdraw() {

		//testAccount.withdraw(new Money(100, CAD));

		testAccount.withdraw(LOL);



		// Something to consider - can you withdraw in a different currency?
		//fail("Write test case here");

	}

	@Test
	public void testGetBalance() {


	//assertEquals(new Money(100, CAD),testAccount.getBalance());


		//fail("Write test case here");

	}
}
