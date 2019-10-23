package com.util.ms.model.request;

import javax.validation.constraints.NotNull;

import com.util.ms.model.BaseModel;

public class AddPartyRequest extends BaseModel {
	
	@NotNull(message="partyType is required")
	private String partyType;
	
	@NotNull(message="name is required")	
	private String name;
	
	@NotNull(message="desc is required")
	private String desc;
	
	private String domain;
	
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the desc
	 */
	public String getDesc() {
		return desc;
	}
	/**
	 * @param desc the desc to set
	 */
	public void setDesc(String desc) {
		this.desc = desc;
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
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UpdatePartyRequest [partyType=" + partyType + ", name=" + name + ", desc=" + desc + ", domain=" + domain
				+ "]";
	}
	

}