package bankingapp.src.bankingApp;

import java.math.BigDecimal;
import java.math.RoundingMode;


public class Currency {
	private String name;
	private double rate;

	/**
	 * Create a new currency object.
	 *
	 * The name argument the 3-letter code that represents the currency.
	 * The rate argument of each currency indicates that bankingApp.Currency's exchange rate relative to USD.
	 *
	 * Example: Suppose you are creating a currency for Canadian Dollars.
	 * 	- The name - CAD
	 *  - The rate = 0.75  (1 CAD = 0.75 USD)
	 *
	 * @param //name The 3-letter code of this bankingApp.Currency
	 * @param rate The exchange rate of this bankingApp.Currency
	 */
	public Currency(String currencyCode, double rate) {
		this.name = currencyCode;
		this.rate = rate;
	}

	/**
	 * Convert an amount of this bankingApp.Currency to its value in USD
	 * (As mentioned in the documentation of the bankingApp.Currency constructor)
	 *
	 * @param amount An amount of cash of this currency.
	 * @return The value of amount in the "universal currency" (USD)
	 */
	public double valueInUSD(double amount) {
		// @TODO:  Fill in the code for this
		// Round your final answer to 2 decimal points. See round() function.
		return round(amount*rate,2);

	}

	/**
	 * Get the name of this bankingApp.Currency.
	 * @return name of bankingApp.Currency
	 */
	public String getName() {
		// @TODO:  Fill in the code for this
		return name;

	}

	/**
	 * Get the rate of this bankingApp.Currency.
	 *
	 * @return rate of this bankingApp.Currency
	 */
	public double getRate() {
		// @TODO:  Fill in the code for this
		return rate;
	}

	/**
	 *  Set the rate of this currency.
	 *
	 * @param rate New rate for this bankingApp.Currency
	 */
	public void setRate(Double rate) {
		// @TODO:  Fill in the code for this
		this.rate=rate;
	}

	/**
	 * Convert an amount from another bankingApp.Currency to an amount in this bankingApp.Currency
	 * Do not convert according to real-life
	 * Example - do NOT do this:  1 CAD = 2.84 BRL, therefore 10 CAD = 28.34 BRL
	 *
	 * Instead, you should perform your calculations relative to the universal USD currency.
	 *
	 * Example: Convert 10 CAD to BRL.
	 *   - 1 CAD = 0.75 USD
	 *   - 1 BRL = 0.27 USD
	 *   - So:   		10 CAD = 7.5 USD
	 *   - And: 		7.5 USD = 27.78 BRL
	 *   - Therefore:   10 CAD = 27.78 BRL
	 * @param amount Amount of the other bankingApp.Currency
	 * @param othercurrency The other bankingApp.Currency
	 */
	public double valueInThisCurrency(double amount, Currency othercurrency) {
		// @TODO:  Fill in the code for this
		double usd,newcurrencyrate =0.0;
		String newcurrencyname;
		// Round all final results to 2 decimal points. See round() function.
		usd = valueInUSD(amount);
		newcurrencyrate=othercurrency.getRate();
		return round((usd/newcurrencyrate),2);


	}

	public static double round(double value, int places) {
		if (places < 0) throw new IllegalArgumentException();

		BigDecimal bd = new BigDecimal(value);
		bd = bd.setScale(places, RoundingMode.HALF_UP);
		return bd.doubleValue();
	}
}
