package model.services;

public class BrazilInterestService implements InterestService {
	private Double interestRate;

	public BrazilInterestService() {
	}

	public BrazilInterestService(Double interestRate) {
		this.interestRate = interestRate;
	}

	@Override
	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(Double interestRate) {
		this.interestRate = interestRate;
	}
}
