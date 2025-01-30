package es.amadorcf.YourBank_backend.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private double amount;
	
	@Enumerated(EnumType.STRING)
	private TransactionType transactionType;

	@Column(length = 150)
	private String description;

	private Date transaction_date;

	@ManyToOne
	@JoinColumn(name = "source_account_id")
	private Account sourceAccount;

	@ManyToOne
	@JoinColumn(name = "target_account_id")
	private Account targetAccount;

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
	
	public TransactionType getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}

	public Date getTransaction_date() {
		return transaction_date;
	}

	public void setTransaction_date(Date transaction_date) {
		this.transaction_date = transaction_date;
	}

	public Account getSourceAccount() {
		return sourceAccount;
	}

	public void setSourceAccount(Account sourceAccount) {
		this.sourceAccount = sourceAccount;
	}

	public Account getTargetAccount() {
		return targetAccount;
	}

	public void setTargetAccount(Account targetAccount) {
		this.targetAccount = targetAccount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		System.out.println("Transaction [id=" + id + ", amount=" + amount + ", transactionType=" + transactionType
				+ ", description=" + description + ", transaction_date=" + transaction_date
				+ ", sourceAccount=" + sourceAccount + ", targetAccount=" + targetAccount + "]");
		return "Transaction [id=" + id + ", amount=" + amount + ", transactionType=" + transactionType
				+ ", description=" + description + ", transaction_date=" + transaction_date
				+ ", sourceAccount=" + sourceAccount + ", targetAccount=" + targetAccount + "]";
	}


}
