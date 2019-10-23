package com.util.ms.model;

public class AssociationType {
	
	private Long assocTypeId;
	private String name;
	
	public AssociationType() {}

	public AssociationType(Long assocTypeId, String name) {
		this.assocTypeId = assocTypeId;
		this.name = name;
	}

	public Long getAssocTypeId() {
		return assocTypeId;
	}

	public void setAssocTypeId(Long assocTypeId) {
		this.assocTypeId = assocTypeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
