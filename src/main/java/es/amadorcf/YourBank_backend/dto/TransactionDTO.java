package es.amadorcf.YourBank_backend.dto;

import es.amadorcf.YourBank_backend.entity.TransactionType;

import java.util.Date;

public class TransactionDTO {
    private Long id; 
    private double amount;
    private TransactionType transaction_type;
	private String description;
    private Date transaction_date;
    private String sourceAccountNumber;
    private String targetAccountNumber;

	// getters and setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public TransactionType getTransaction_type() {
		return transaction_type;
	}
	public void setTransaction_type(TransactionType transaction_type) {
		this.transaction_type = transaction_type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getTransaction_date() {
		return transaction_date;
	}
	public void setTransaction_date(Date transaction_date) {
		this.transaction_date = transaction_date;
	}
	public String getSourceAccountNumber() {
		return sourceAccountNumber;
	}
	public void setSourceAccountNumber(String sourceAccountNumber) {
		this.sourceAccountNumber = sourceAccountNumber;
	}
	public String getTargetAccountNumber() {
		return targetAccountNumber;
	}
	public void setTargetAccountNumber(String targetAccountNumber) {
		this.targetAccountNumber = targetAccountNumber;
	}
	


}