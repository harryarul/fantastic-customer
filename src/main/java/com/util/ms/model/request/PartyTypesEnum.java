package com.util.ms.model.request;

public enum PartyTypesEnum {

	BRAND("BRAND"), 
	SERVICEPROV("SERVICEPROV"),
	IABG("IABG"), 
	BU("BU");
	
	
	private String partyType;
	
	private PartyTypesEnum(String partyType) {
		this.partyType = partyType;
	}
	
	public String toString() {
		return partyType;
	}

	/**
	 * 
	 * @param addressExtRefType
	 * @return
	 */
	public static String getPartyTypebyType(String partyType) {
		for (PartyTypesEnum pt : PartyTypesEnum.values()) {
			if (partyType.equalsIgnoreCase(pt.partyType))
				return pt.partyType;
		}
		return null;
	}
	
	public static boolean contains(String partyType) {
		for (PartyTypesEnum pt : PartyTypesEnum.values()) {
			if (pt.partyType.equalsIgnoreCase(partyType))
				return true;
		}
		return false;
	}
}
