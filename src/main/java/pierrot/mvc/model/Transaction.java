package pierrot.mvc.model;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

@Entity
@XmlRootElement
@Table(name = "T_ACCOUNT_TRANSACTION")
public class Transaction {
	
	@Id
	@JsonIgnore
	@Column(name = "ID")
	private Integer entityId;

	@Column(name = "NAME")
	private String accountName;

	@Column(name = "CODE")
	private String bankCode;

	@Column(name = "NUMBER")
	private String accountNumber;

	@Embedded
	@JsonUnwrapped
	@AttributeOverride(name="value", column=@Column(name="AMOUNT"))
	private MonetaryAmount amount;

	@SuppressWarnings("unused")
	private Transaction() {
	}

	Transaction(String accountName, String accountNumber, String bankCode, MonetaryAmount amount) {
		this.accountName = accountName;
		this.accountNumber = accountNumber;
		this.bankCode = bankCode;
		this.amount = amount;
	}


	/**
	 * Returns the name of the beneficiary.
	 * 
	 * @return the name
	 */
//	@XmlAttribute
	public String getAccountName() {
		return accountName;
	}

	/**
	 * Returns the name of the beneficiary.
	 * 
	 * @return the name
	 */
//	@XmlAttribute
	public String getAccountNumber() {
		return accountNumber;
	}

	/**
	 * Returns the name of the beneficiary.
	 * 
	 * @return the name
	 */
//	@XmlAttribute
	public String getBankCode() {
		return bankCode;
	}

	/**
	 * Returns the total savings accrued by this beneficiary.
	 * 
	 * @return the total savings
	 */
//	@XmlAttribute
	public MonetaryAmount getAmount() {
		return amount;
	}

	public String toString() {
		return "[Transfer " + amount + " to " + accountName + " (" + bankCode + "/" + accountNumber + ")]";
	}

}
