package model.services;

public class UsaInterestService implements InterestService {
	private Double interestRate;

	public UsaInterestService() {
	}

	public UsaInterestService(Double interestRate) {
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
