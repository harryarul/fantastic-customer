package com.util.ms.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class PartyRole {
	
	private Long partyRoleId;
	private Long roleId;
	private Long partyId;
	private List<PartyRoleInvolves> partyRoleInvolves;
	
	// transient
	private boolean isRoot = true;
	
	public PartyRole() {}

	public PartyRole(Long partyRoleId, Long roleId, Long partyId) {
		this.partyRoleId = partyRoleId;
		this.roleId = roleId;
		this.partyId = partyId;
	}

	public Long getPartyRoleId() {
		return partyRoleId;
	}

	public void setPartyRoleId(Long partyRoleId) {
		this.partyRoleId = partyRoleId;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public Long getPartyId() {
		return partyId;
	}

	public void setPartyId(Long partyId) {
		this.partyId = partyId;
	}

	public List<PartyRoleInvolves> getPartyRoleInvolves() {
		if (partyRoleInvolves == null) {
			partyRoleInvolves = new ArrayList<>();
		}
		return partyRoleInvolves;
	}

	public void setPartyRoleInvolves(List<PartyRoleInvolves> partyRoleInvolves) {
		this.partyRoleInvolves = partyRoleInvolves;
	}

	@JsonIgnore
	public boolean isRoot() {
		return isRoot;
	}

	public void setRoot(boolean isRoot) {
		this.isRoot = isRoot;
	}
	
}
