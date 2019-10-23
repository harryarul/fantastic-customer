package com.util.ms.model;

import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * 
 * @author arul
 *
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-22T02:04:45.001Z")

public class Customer   {
  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("cname")
  private String cname = null;

  @JsonProperty("firstName")
  private String firstName = null;

  @JsonProperty("lastName")
  private String lastName = null;

  @JsonProperty("email")
  private String email = null;

  @JsonProperty("password")
  private String password = null;

  @JsonProperty("phone")
  private String phone = null;

  @JsonProperty("customerStatus")
  private Integer customerStatus = null;

  @JsonProperty("streetNo")
  private Long streetNo = null;

  @JsonProperty("streeName")
  private String streeName = null;

  @JsonProperty("streeType")
  private String streeType = null;

  @JsonProperty("suburb")
  private String suburb = null;

  @JsonProperty("postCode")
  private Long postCode = null;

  @JsonProperty("city")
  private String city = null;

  @JsonProperty("county")
  private String county = null;

  public Customer id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(value = "")


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Customer cname(String cname) {
    this.cname = cname;
    return this;
  }

  /**
   * Get cname
   * @return cname
  **/
  @ApiModelProperty(value = "")


  public String getCname() {
    return cname;
  }

  public void setCname(String cname) {
    this.cname = cname;
  }

  public Customer firstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  /**
   * Get firstName
   * @return firstName
  **/
  @ApiModelProperty(value = "")


  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public Customer lastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  /**
   * Get lastName
   * @return lastName
  **/
  @ApiModelProperty(value = "")


  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public Customer email(String email) {
    this.email = email;
    return this;
  }

  /**
   * Get email
   * @return email
  **/
  @ApiModelProperty(value = "")


  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Customer password(String password) {
    this.password = password;
    return this;
  }

  /**
   * Get password
   * @return password
  **/
  @ApiModelProperty(value = "")


  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Customer phone(String phone) {
    this.phone = phone;
    return this;
  }

  /**
   * Get phone
   * @return phone
  **/
  @ApiModelProperty(value = "")


  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public Customer customerStatus(Integer customerStatus) {
    this.customerStatus = customerStatus;
    return this;
  }

  /**
   * Customer Status
   * @return customerStatus
  **/
  @ApiModelProperty(value = "Customer Status")


  public Integer getCustomerStatus() {
    return customerStatus;
  }

  public void setCustomerStatus(Integer customerStatus) {
    this.customerStatus = customerStatus;
  }

  public Customer streetNo(Long streetNo) {
    this.streetNo = streetNo;
    return this;
  }

  /**
   * Get streetNo
   * @return streetNo
  **/
  @ApiModelProperty(value = "")


  public Long getStreetNo() {
    return streetNo;
  }

  public void setStreetNo(Long streetNo) {
    this.streetNo = streetNo;
  }

  public Customer streeName(String streeName) {
    this.streeName = streeName;
    return this;
  }

  /**
   * Get streeName
   * @return streeName
  **/
  @ApiModelProperty(value = "")


  public String getStreeName() {
    return streeName;
  }

  public void setStreeName(String streeName) {
    this.streeName = streeName;
  }

  public Customer streeType(String streeType) {
    this.streeType = streeType;
    return this;
  }

  /**
   * Get streeType
   * @return streeType
  **/
  @ApiModelProperty(value = "")


  public String getStreeType() {
    return streeType;
  }

  public void setStreeType(String streeType) {
    this.streeType = streeType;
  }

  public Customer suburb(String suburb) {
    this.suburb = suburb;
    return this;
  }

  /**
   * Get suburb
   * @return suburb
  **/
  @ApiModelProperty(value = "")


  public String getSuburb() {
    return suburb;
  }

  public void setSuburb(String suburb) {
    this.suburb = suburb;
  }

  public Customer postCode(Long postCode) {
    this.postCode = postCode;
    return this;
  }

  /**
   * Get postCode
   * @return postCode
  **/
  @ApiModelProperty(value = "")


  public Long getPostCode() {
    return postCode;
  }

  public void setPostCode(Long postCode) {
    this.postCode = postCode;
  }

  public Customer city(String city) {
    this.city = city;
    return this;
  }

  /**
   * Get city
   * @return city
  **/
  @ApiModelProperty(value = "")


  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public Customer county(String county) {
    this.county = county;
    return this;
  }

  /**
   * Get county
   * @return county
  **/
  @ApiModelProperty(value = "")


  public String getCounty() {
    return county;
  }

  public void setCounty(String county) {
    this.county = county;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Customer customer = (Customer) o;
    return Objects.equals(this.id, customer.id) &&
        Objects.equals(this.cname, customer.cname) &&
        Objects.equals(this.firstName, customer.firstName) &&
        Objects.equals(this.lastName, customer.lastName) &&
        Objects.equals(this.email, customer.email) &&
        Objects.equals(this.password, customer.password) &&
        Objects.equals(this.phone, customer.phone) &&
        Objects.equals(this.customerStatus, customer.customerStatus) &&
        Objects.equals(this.streetNo, customer.streetNo) &&
        Objects.equals(this.streeName, customer.streeName) &&
        Objects.equals(this.streeType, customer.streeType) &&
        Objects.equals(this.suburb, customer.suburb) &&
        Objects.equals(this.postCode, customer.postCode) &&
        Objects.equals(this.city, customer.city) &&
        Objects.equals(this.county, customer.county);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, cname, firstName, lastName, email, password, phone, customerStatus, streetNo, streeName, streeType, suburb, postCode, city, county);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Customer {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    cname: ").append(toIndentedString(cname)).append("\n");
    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
    sb.append("    phone: ").append(toIndentedString(phone)).append("\n");
    sb.append("    customerStatus: ").append(toIndentedString(customerStatus)).append("\n");
    sb.append("    streetNo: ").append(toIndentedString(streetNo)).append("\n");
    sb.append("    streeName: ").append(toIndentedString(streeName)).append("\n");
    sb.append("    streeType: ").append(toIndentedString(streeType)).append("\n");
    sb.append("    suburb: ").append(toIndentedString(suburb)).append("\n");
    sb.append("    postCode: ").append(toIndentedString(postCode)).append("\n");
    sb.append("    city: ").append(toIndentedString(city)).append("\n");
    sb.append("    county: ").append(toIndentedString(county)).append("\n");
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

