package com.util.ms.model;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Party {
	private long partyId;
	private String partyType;
	private String partyName;
	private String partyDesc;
	private String domain;
	
	public Party() {};
	
	public Party(long partyId, String partyType, String partyName, String partyDesc) {
		this.partyId = partyId;
		this.partyType = partyType;
		this.partyName = partyName;
		this.partyDesc = partyDesc;
	}
	
	public Party(long partyId, String partyType, String partyName, String partyDesc, String domain) {
		this.partyId = partyId;
		this.partyType = partyType;
		this.partyName = partyName;
		this.partyDesc = partyDesc;
		this.domain = domain;
	}
	
	public Party(String partyType, String partyName, String partyDesc, String domain) {
		this.partyType = partyType;
		this.partyName = partyName;
		this.partyDesc = partyDesc;
		this.domain = domain;
	}
	/**
	 * @return the partyId
	 */
	public long getPartyId() {
		return partyId;
	}
	/**
	 * @param partyId the partyId to set
	 */
	public void setPartyId(long partyId) {
		this.partyId = partyId;
	}
	/**
	 * @return the partyType
	 */
	public String getPartyType() {
		return partyType;
	}
	/**
	 * @param partyType the partyType to set
	 */
	public void setPartyType(String partyType) {
		this.partyType = partyType;
	}
	/**
	 * @return the partyName
	 */
	public String getPartyName() {
		return partyName;
	}
	/**
	 * @param partyName the partyName to set
	 */
	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}
	/**
	 * @return the partyDesc
	 */
	public String getPartyDesc() {
		return partyDesc;
	}
	/**
	 * @param partyDesc the partyDesc to set
	 */
	public void setPartyDesc(String partyDesc) {
		this.partyDesc = partyDesc;
	}

	/**
	 * @return the domain
	 */
	public String getDomain() {
		return domain;
	}

	/**
	 * @param domain the domain to set
	 */
	public void setDomain(String domain) {
		this.domain = domain;
	}

}
