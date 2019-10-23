package com.util.ms.model;

import java.util.List;

public class PartyRoleHierarchyResponse {
	
	private List<PartyRole> partyRole;
	
	public PartyRoleHierarchyResponse() {}

	public PartyRoleHierarchyResponse(List<PartyRole> partyRole) {
		super();
		this.partyRole = partyRole;
	}

	public List<PartyRole> getPartyRole() {
		return partyRole;
	}

	public void setPartyRole(List<PartyRole> partyRole) {
		this.partyRole = partyRole;
	}

}
