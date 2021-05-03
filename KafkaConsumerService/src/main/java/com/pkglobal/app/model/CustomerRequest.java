package com.pkglobal.app.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * CustomerRequest
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-04-26T14:41:51.027Z")
public class CustomerRequest {

	@JsonProperty("customerNumber")

	private String customerNumber = null;

	@JsonProperty("firstName")
	private String firstName = null;

	@JsonProperty("lastName")

	private String lastName = null;

	@JsonProperty("birthDate")
	private String birthDate = null;

	@JsonProperty("country")
	private String country = null;

	@JsonProperty("countryCode")
	private String countryCode = null;

	@JsonProperty("mobileNumber")
	private String mobileNumber = null;

	@JsonProperty("email")
	private String email = null;
	@JsonProperty("customerStatus")
	private String customerStatus;

	@JsonProperty("customerAddress")
	private CustomerAddress customerAddress = null;

	public CustomerRequest customerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
		return this;
	}

	/**
	 * Customer Number
	 * 
	 * @return customerNumber
	 **/
	@ApiModelProperty(required = true, value = "Customer Number")
	public String getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}

	public CustomerRequest firstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	/**
	 * Customer First Name
	 * 
	 * @return firstName
	 **/
	@ApiModelProperty(required = true, value = "Customer First Name")

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public CustomerRequest lastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	/**
	 * Customer Last Name
	 * 
	 * @return lastName
	 **/
	@ApiModelProperty(required = true, value = "Customer Last Name")
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public CustomerRequest birthDate(String birthDate) {
		this.birthDate = birthDate;
		return this;
	}

	/**
	 * Customer Date of Birth
	 * 
	 * @return birthDate
	 **/
	@ApiModelProperty(required = true, value = "Customer Date of Birth")
	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public CustomerRequest country(String country) {
		this.country = country;
		return this;
	}

	/**
	 * Customer Country Name
	 * 
	 * @return country
	 **/
	@ApiModelProperty(required = true, value = "Customer Country Name")
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public CustomerRequest countryCode(String countryCode) {
		this.countryCode = countryCode;
		return this;
	}

	/**
	 * Customer Country Code
	 * 
	 * @return countryCode
	 **/
	@ApiModelProperty(required = true, value = "Customer Country Code")
	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public CustomerRequest mobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
		return this;
	}

	/**
	 * Customer Mobile Number
	 * 
	 * @return mobileNumber
	 **/
	@ApiModelProperty(required = true, value = "Customer Mobile Number")
	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public CustomerRequest email(String email) {
		this.email = email;
		return this;
	}

	/**
	 * Customer Email
	 * 
	 * @return email
	 **/
	@ApiModelProperty(required = true, value = "Customer Email ")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public CustomerRequest customerAddress(CustomerAddress customerAddress) {
		this.customerAddress = customerAddress;
		return this;
	}

	public String getCustomerStatus() {
		return customerStatus;
	}

	public void setCustomerStatus(String customerStatus) {
		this.customerStatus = customerStatus;
	}

	/**
	 * Get customerAddress
	 * 
	 * @return customerAddress
	 **/
	@ApiModelProperty(required = true, value = "")
	public CustomerAddress getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(CustomerAddress customerAddress) {
		this.customerAddress = customerAddress;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		CustomerRequest customerRequest = (CustomerRequest) o;
		return Objects.equals(this.customerNumber, customerRequest.customerNumber)
				&& Objects.equals(this.firstName, customerRequest.firstName)
				&& Objects.equals(this.lastName, customerRequest.lastName)
				&& Objects.equals(this.birthDate, customerRequest.birthDate)
				&& Objects.equals(this.country, customerRequest.country)
				&& Objects.equals(this.countryCode, customerRequest.countryCode)
				&& Objects.equals(this.mobileNumber, customerRequest.mobileNumber)
				&& Objects.equals(this.email, customerRequest.email)
				&& Objects.equals(this.customerStatus, customerRequest.customerStatus)
				&& Objects.equals(this.customerAddress, customerRequest.customerAddress);
	}

	@Override
	public int hashCode() {
		return Objects.hash(customerNumber, firstName, lastName, birthDate, country, countryCode, mobileNumber, email,
				customerStatus, customerAddress);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class CustomerRequest {\n");

		sb.append("    customerNumber: ").append(toIndentedString(customerNumber)).append("\n");
		sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
		sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
		sb.append("    birthDate: ").append(toIndentedString(birthDate)).append("\n");
		sb.append("    country: ").append(toIndentedString(country)).append("\n");
		sb.append("    countryCode: ").append(toIndentedString(countryCode)).append("\n");
		sb.append("    mobileNumber: ").append(toIndentedString(mobileNumber)).append("\n");
		sb.append("    email: ").append(toIndentedString(email)).append("\n");
		sb.append("    customerStatus: ").append(toIndentedString(customerStatus)).append("\n");
		sb.append("    customerAddress: ").append(toIndentedString(customerAddress)).append("\n");
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
