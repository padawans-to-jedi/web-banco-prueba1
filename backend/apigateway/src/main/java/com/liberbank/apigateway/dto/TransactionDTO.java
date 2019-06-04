package com.liberbank.apigateway.dto;

import java.util.Objects;

import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

public class TransactionDTO {
	@JsonProperty("debitorID")
	  private Long debitorID = null;

	  @JsonProperty("amount")
	  private Long amount = null;

	  @JsonProperty("creditorID")
	  private Integer creditorID = null;

	  @JsonProperty("paymentID")
	  private Integer paymentID = null;

	  public TransactionDTO debitorID(Long debitorID) {
	    this.debitorID = debitorID;
	    return this;
	  }

	   /**
	   * Get debitorID
	   * minimum: 1
	   * @return debitorID
	  **/
	  @ApiModelProperty(value = "")

	 @Min(1)
	  public Long getDebitorID() {
	    return debitorID;
	  }

	  public void setDebitorID(Long debitorID) {
	    this.debitorID = debitorID;
	  }

	  public TransactionDTO amount(Long amount) {
	    this.amount = amount;
	    return this;
	  }

	   /**
	   * Get amount
	   * minimum: 1
	   * @return amount
	  **/
	  @ApiModelProperty(value = "")

	 @Min(1)
	  public Long getAmount() {
	    return amount;
	  }

	  public void setAmount(Long amount) {
	    this.amount = amount;
	  }

	  public TransactionDTO creditorID(Integer creditorID) {
	    this.creditorID = creditorID;
	    return this;
	  }

	   /**
	   * Get creditorID
	   * minimum: 1
	   * @return creditorID
	  **/
	  @ApiModelProperty(value = "")

	 @Min(1)
	  public Integer getCreditorID() {
	    return creditorID;
	  }

	  public void setCreditorID(Integer creditorID) {
	    this.creditorID = creditorID;
	  }

	  public TransactionDTO paymentID(Integer paymentID) {
	    this.paymentID = paymentID;
	    return this;
	  }

	   /**
	   * Get paymentID
	   * minimum: 1
	   * @return paymentID
	  **/
	  @ApiModelProperty(value = "")

	 @Min(1)
	  public Integer getPaymentID() {
	    return paymentID;
	  }

	  public void setPaymentID(Integer paymentID) {
	    this.paymentID = paymentID;
	  }


	  @Override
	  public boolean equals(java.lang.Object o) {
	    if (this == o) {
	      return true;
	    }
	    if (o == null || getClass() != o.getClass()) {
	      return false;
	    }
	    TransactionDTO transactionResponse = (TransactionDTO) o;
	    return Objects.equals(this.debitorID, transactionResponse.debitorID) &&
	        Objects.equals(this.amount, transactionResponse.amount) &&
	        Objects.equals(this.creditorID, transactionResponse.creditorID) &&
	        Objects.equals(this.paymentID, transactionResponse.paymentID);
	  }

	  @Override
	  public int hashCode() {
	    return Objects.hash(debitorID, amount, creditorID, paymentID);
	  }

	  @Override
	  public String toString() {
	    StringBuilder sb = new StringBuilder();
	    sb.append("class TransactionResponse {\n");
	    
	    sb.append("    debitorID: ").append(toIndentedString(debitorID)).append("\n");
	    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
	    sb.append("    creditorID: ").append(toIndentedString(creditorID)).append("\n");
	    sb.append("    paymentID: ").append(toIndentedString(paymentID)).append("\n");
	    sb.append("}");
	    return sb.toString();
	  }

	  /**
	   * Convert the given object to string with each line indented by 4 spaces
	   * (except the first line).
	   */
	  private String toIndentedString(java.lang.Object o) {
	    if (o == null) {
	      return "null";
	    }
	    return o.toString().replace("\n", "\n    ");
	  }
}
