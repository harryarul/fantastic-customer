package com.util.ms.model;

import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * Address
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-24T00:22:32.020Z")

public class Address   {
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

  @JsonProperty("country")
  private String country = null;

  public Address streetNo(Long streetNo) {
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

  public Address streeName(String streeName) {
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

  public Address streeType(String streeType) {
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

  public Address suburb(String suburb) {
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

  public Address postCode(Long postCode) {
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

  public Address city(String city) {
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

  public Address country(String country) {
    this.country = country;
    return this;
  }

  /**
   * Get country
   * @return country
  **/
  @ApiModelProperty(value = "")


  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Address address = (Address) o;
    return Objects.equals(this.streetNo, address.streetNo) &&
        Objects.equals(this.streeName, address.streeName) &&
        Objects.equals(this.streeType, address.streeType) &&
        Objects.equals(this.suburb, address.suburb) &&
        Objects.equals(this.postCode, address.postCode) &&
        Objects.equals(this.city, address.city) &&
        Objects.equals(this.country, address.country);
  }

  @Override
  public int hashCode() {
    return Objects.hash(streetNo, streeName, streeType, suburb, postCode, city, country);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Address {\n");
    
    sb.append("    streetNo: ").append(toIndentedString(streetNo)).append("\n");
    sb.append("    streeName: ").append(toIndentedString(streeName)).append("\n");
    sb.append("    streeType: ").append(toIndentedString(streeType)).append("\n");
    sb.append("    suburb: ").append(toIndentedString(suburb)).append("\n");
    sb.append("    postCode: ").append(toIndentedString(postCode)).append("\n");
    sb.append("    city: ").append(toIndentedString(city)).append("\n");
    sb.append("    country: ").append(toIndentedString(country)).append("\n");
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

