package com.util.ms.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * This class relates to role and the concerned party involves
 * 
 * @author arul
 *
 */
public class PartyRoleInvolves {
	
	private Long assocTypeId;
	private Long fromPartyRoleId;
	private Long toPartyRoleId;
	private PartyRole childPartyRole;
	
	public PartyRoleInvolves() {}

	/**
	 * 
	 * 
	 * @param assocTypeId
	 * @param fromPartyRoleId
	 * @param toPartyRoleId
	 */
	public PartyRoleInvolves(Long assocTypeId, Long fromPartyRoleId, Long toPartyRoleId) {
		this.assocTypeId = assocTypeId;
		this.fromPartyRoleId = fromPartyRoleId;
		this.toPartyRoleId = toPartyRoleId;
	}

	public Long getAssocTypeId() {
		return assocTypeId;
	}

	public void setAssocTypeId(Long assocTypeId) {
		this.assocTypeId = assocTypeId;
	}

	@JsonIgnore
	public Long getFromPartyRoleId() {
		return fromPartyRoleId;
	}

	public void setFromPartyRoleId(Long fromPartyRoleId) {
		this.fromPartyRoleId = fromPartyRoleId;
	}

	@JsonIgnore
	public Long getToPartyRoleId() {
		return toPartyRoleId;
	}

	public void setToPartyRoleId(Long toPartyRoleId) {
		this.toPartyRoleId = toPartyRoleId;
	}

	public PartyRole getChildPartyRole() {
		return childPartyRole;
	}

	public void setChildPartyRole(PartyRole childPartyRole) {
		this.childPartyRole = childPartyRole;
	}

}
