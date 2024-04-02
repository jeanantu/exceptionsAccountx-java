package model.entities;
import model.exceptions.DomainExceptionAccount;

public class Account {

	private Integer number;
	private String holder;
	private Double balance;
	private Double withDrawLimite;
	
	
	
	public Account() {
	}


	public Account(Integer number, String holder, Double balance, Double withDrawLimite) {
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withDrawLimite = withDrawLimite;
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

    
	
	public Double getWithDrawLimite() {
		return withDrawLimite;
	}

	public void deposit(Double amount) {
		this.balance = amount;
	}
	
	public void withDraw(Double amount) {
		//this.withDrawLimite = amount;
		valideWithDraw(amount);
		this.balance -= amount;
	}
	
	public void valideWithDraw(Double withDrawValue) {
		if(withDrawValue > getWithDrawLimite()) {
			throw new DomainExceptionAccount("The amount exceeds withdraw limit");
		}
		
		if(withDrawValue > getBalance()) {
			throw new DomainExceptionAccount("Not enough balance");
		}

	}
	
}
