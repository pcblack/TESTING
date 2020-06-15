package bankingapp.src.bankingApp;

public class Money implements Comparable {
	private double amount;
	private Currency currency;

	/**
	 * New bankingApp.Money
	 * @param amount	The amount of money
	 * @param currency	The currency of the money
	 */
	public Money(double amount, Currency currency) {
		this.amount = amount;
		this.currency = currency;
	}

	/**
	 * Return the amount of money.
	 * @return Amount of money as an double type.
	 */
	public double getAmount() {
		// @TODO:  Fill in the code for this
		return amount;

	}

	/**
	 * Returns the currency of this bankingApp.Money.
	 * @return bankingApp.Currency object representing the currency of this bankingApp.Money
	 */
	public Currency getCurrency() {
		// @TODO:  Fill in the code for this
		return currency;

	}

	/**
	 * Returns the amount of the money in the string form "(amount) (currencyname)", e.g. "10.5 CAD".
	 *  @return String representing the amount of bankingApp.Money.
	 */
	public String toString() {
		// @TODO:  Fill in the code for this
		String samount = String.valueOf(amount);
		String value = samount + currency.getName();
		return value;
	}

	/**
	 * Gets the universal value of the bankingApp.Money, according the rate of its bankingApp.Currency.
	 * @return The value of the bankingApp.Money in the "universal currency". (USD)
	 */
	public double getUniversalValue() {
		// @TODO:  Fill in the code for this
		return amount*currency.getRate();

	}

	/**
	 * Check to see if the value of this money is equal to the value of another bankingApp.Money of some other bankingApp.Currency.
	 * @param other The other bankingApp.Money that is being compared to this bankingApp.Money.
	 * @return A Boolean indicating if the two monies are equal.
	 */
	public boolean equals(Money other) {
		// @TODO:  Fill in the code for this
		Double oldmoney,newmoney =0.0;
		oldmoney = getUniversalValue();
		newmoney = other.getUniversalValue();
		if (oldmoney.equals(newmoney))
		{
			return true;
		}
		else
			return false;
	}

	/**
	 * Adds a bankingApp.Money to this bankingApp.Money, regardless of the bankingApp.Currency of the other bankingApp.Money.
	 * @param other The bankingApp.Money that is being added to this bankingApp.Money.
	 * @return A new bankingApp.Money with the same bankingApp.Currency as this bankingApp.Money, representing the added value of the two.
	 * (Remember to convert the other bankingApp.Money before adding the amounts)
	 */
	public Money add(Money other) {
		// @TODO:  Fill in the code for this
		double othermoney,presentmoney,addedmoney,amount=0.0;
		Currency Presentcurrency = this.currency;
		othermoney= other.getUniversalValue();
		presentmoney = getUniversalValue();
		addedmoney = othermoney+presentmoney;
		amount = addedmoney/(this.currency.getRate());
		Money AddedMoney = new Money(amount,Presentcurrency);
		return AddedMoney;





	}

	/**
	 * Subtracts a bankingApp.Money from this bankingApp.Money, regardless of the bankingApp.Currency of the other bankingApp.Money.
	 * @param other The money that is being subtracted from this bankingApp.Money.
	 * @return A new bankingApp.Money with the same bankingApp.Currency as this bankingApp.Money, representing the subtracted value.
	 * (Again, remember converting the value of the other bankingApp.Money to this bankingApp.Currency)
	 */
	public Money subtract(Money other) {
		// @TODO:  Fill in the code for this
		double othermoney,presentmoney,subtractedMoney,amount=0.0;
		Currency Presentcurrency = this.currency;
		othermoney= other.getUniversalValue();
		presentmoney = getUniversalValue();
		subtractedMoney = Math.abs(othermoney-presentmoney);
		amount = subtractedMoney/(this.currency.getRate());
		Money SubtractedMoney = new Money(amount,Presentcurrency);
		return SubtractedMoney;

	}

	/**
	 * Check to see if the amount of this bankingApp.Money is zero or not
	 * @return True if the amount of this bankingApp.Money is equal to 0.0, False otherwise
	 */
	public boolean isZero() {
		// @TODO:  Fill in the code for this
		if(this.amount==0)
		{
			return true;
		}
		else
			return false;

	}
	/**
	 * Negate the amount of money, i.e. if the amount is 10.0 CAD the negation returns -10.0 CAD
	 * @return A new instance of the money class initialized with the new negated money amount.
	 */
	public Money negate() {
		// @TODO:  Fill in the code for this
		Double negativeAmount = 0.0;
		Currency presentCurrency = this.currency;
		negativeAmount = -(this.amount);
		Money negativeMoney = new Money(negativeAmount,presentCurrency);
		return negativeMoney;


	}

	/**
	 * Compare two bankingApp.Money objects.
	 * compareTo is required because the class implements the Comparable interface.
	 * (Remember the universalValue method, and that Integers already implement Comparable).
	 * Also, since compareTo must take an Object, you will have to explicitly downcast it to a bankingApp.Money.
	 * @return 0 if the values of the two money are equal.
	 * A negative integer if this bankingApp.Money is less valuable than the other bankingApp.Money.
	 * A positive integer if this bankingApp.Money is more valuable than the other bankingApp.Money.
	 */
	public int compareTo(Object other) {
		// @TODO:  Fill in the code for this
		double value=0.0;
		double othervalue = 0.0;
		Money otherCompareMoney = (Money)other;
		value =	getUniversalValue();
		othervalue = otherCompareMoney.getUniversalValue();
		if (value==othervalue)
		{
			return 0;
		}
		else if (value<othervalue)
		{
			return -1;
		}
		else
			return 1;



	}
}