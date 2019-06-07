package com.example.generated.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * PaymentResponse
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-06-03T12:16:04.101+02:00")

public class PaymentResponse   {
  @JsonProperty("transactionHash")
  private String transactionHash = null;

  @JsonProperty("blocknumber")
  private Long blocknumber = null;

  @JsonProperty("timestamp")
  private Long timestamp = null;

  public PaymentResponse transactionHash(String transactionHash) {
    this.transactionHash = transactionHash;
    return this;
  }

   /**
   * Get transactionHash
   * @return transactionHash
  **/
  @ApiModelProperty(value = "")


  public String getTransactionHash() {
    return transactionHash;
  }

  public void setTransactionHash(String transactionHash) {
    this.transactionHash = transactionHash;
  }

  public PaymentResponse blocknumber(Long blocknumber) {
    this.blocknumber = blocknumber;
    return this;
  }

   /**
   * Get blocknumber
   * @return blocknumber
  **/
  @ApiModelProperty(value = "")


  public Long getBlocknumber() {
    return blocknumber;
  }

  public void setBlocknumber(Long blocknumber) {
    this.blocknumber = blocknumber;
  }

  public PaymentResponse timestamp(Long timestamp) {
    this.timestamp = timestamp;
    return this;
  }

   /**
   * Get timestamp
   * @return timestamp
  **/
  @ApiModelProperty(value = "")


  public Long getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(Long timestamp) {
    this.timestamp = timestamp;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PaymentResponse paymentResponse = (PaymentResponse) o;
    return Objects.equals(this.transactionHash, paymentResponse.transactionHash) &&
        Objects.equals(this.blocknumber, paymentResponse.blocknumber) &&
        Objects.equals(this.timestamp, paymentResponse.timestamp);
  }

  @Override
  public int hashCode() {
    return Objects.hash(transactionHash, blocknumber, timestamp);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PaymentResponse {\n");
    
    sb.append("    transactionHash: ").append(toIndentedString(transactionHash)).append("\n");
    sb.append("    blocknumber: ").append(toIndentedString(blocknumber)).append("\n");
    sb.append("    timestamp: ").append(toIndentedString(timestamp)).append("\n");
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

