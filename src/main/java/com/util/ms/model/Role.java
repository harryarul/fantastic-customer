/**
 * 
 */
package com.util.ms.model;

/**
 * @author troy
 *
 */
public class Role {
	
	private Long roleId;
	private String roleName;
	private String roleDesc;
	
	public Role() {}
	
	/**
	 * @param roleId
	 * @param roleName
	 * @param roleDesc
	 */
	public Role(Long roleId, String roleName, String roleDesc) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
		this.roleDesc = roleDesc;
	}

	/**
	 * @return the roleId
	 */
	public Long getRoleId() {
		return roleId;
	}
	/**
	 * @param roleId the roleId to set
	 */
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	/**
	 * @return the roleName
	 */
	public String getRoleName() {
		return roleName;
	}
	/**
	 * @param roleName the roleName to set
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	/**
	 * @return the roleDesc
	 */
	public String getRoleDesc() {
		return roleDesc;
	}
	/**
	 * @param roleDesc the roleDesc to set
	 */
	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}

}
