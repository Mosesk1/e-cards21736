package rw.ecards.domain;

import java.time.LocalDate;


public class AtmCard {

	private String cardNumber;
	private String cardType;
	private String CustomerNames;
	private LocalDate issueDate;
	private LocalDate validUntil;
	private String status;
	
	public AtmCard() {
		super();
	}



	public AtmCard(String cardNumber, String cardType, String customerNames, LocalDate issueDate, LocalDate validUntil,
			String status) {
		super();
		this.cardNumber = cardNumber;
		this.cardType = cardType;
		CustomerNames = customerNames;
		this.issueDate = issueDate;
		this.validUntil = validUntil;
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getCustomerNames() {
		return CustomerNames;
	}

	public void setCustomerNames(String customerNames) {
		CustomerNames = customerNames;
	}

	public LocalDate getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(LocalDate issueDate) {
		this.issueDate = issueDate;
	}

	public LocalDate getValidUntil() {
		return validUntil;
	}

	public void setValidUntil(LocalDate validUntil) {
		this.validUntil = validUntil;
	}

	@Override
	public String toString() {
		return "AtmCard [cardNumber=" + cardNumber + ", cardType=" + cardType + ", CustomerNames=" + CustomerNames
				+ ", issueDate=" + issueDate + ", validUntil=" + validUntil + "]";
	}
	
}
