package fr.epita.bank.datamodel;

public class SavingsAccount extends Account {
	private double interrestRate;

	public void withDraw(double amount) throws Exception {
		System.out.println("TEst");
		if (amount < 0 ){
			throw new Exception("amount was negative");
		}
		this.setBalance(this.getBalance() - amount);

	}

}
