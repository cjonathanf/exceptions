package model.entities;

import model.exception.DomainException;

public class Account {

	private Integer number;
	private String holder;
	private Double balance;
	private Double withdrawLimite;

	public Account() {

	}

	public Account(Integer number, String holder, Double balance, Double withdrawLimite) {
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withdrawLimite = withdrawLimite;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public Double getBalance() {
		return balance;
	}

	public Double getWithdrawLimite() {
		return withdrawLimite;
	}

	public void setWithdrawLimite(Double withdrawLimite) {
		this.withdrawLimite = withdrawLimite;
	}

	public Double deposit(Double amount) {
		return balance += amount;
	}

	public Double withdraw(Double amount) {
		validateWithdraw(amount);
		return balance -= amount;
	}

	private void validateWithdraw(Double amount) {
		if (amount > withdrawLimite) {
			throw new DomainException("The amount exceeds withdraw limit");
		} else if (balance < withdrawLimite) {
			throw new DomainException("Not enough balance");

		}
	}

}
