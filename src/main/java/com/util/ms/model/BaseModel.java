package com.util.ms.model;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

public class BaseModel {
	
	private String creationUser;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
	private Timestamp creationDate;
	private String updateUser;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
	private Timestamp updateDate;

	public BaseModel() {
	}
	
	/**
	 * @return the creationUser
	 */
	public String getCreationUser() {
		return creationUser;
	}

	/**
	 * @param creationUser
	 *            the creationUser to set
	 */
	public void setCreationUser(String creationUser) {
		this.creationUser = creationUser;
	}

	/**
	 * @return the creationDate
	 */
	public Timestamp getCreationDate() {
		return creationDate;
	}

	/**
	 * @param creationDate
	 *            the creationDate to set
	 */
	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 * @return the updateUser
	 */
	public String getUpdateUser() {
		return updateUser;
	}

	/**
	 * @param updateUser
	 *            the updateUser to set
	 */
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	/**
	 * @return the updateDate
	 */
	public Timestamp getUpdateDate() {
		return updateDate;
	}

	/**
	 * @param updateDate
	 *            the updateDate to set
	 */
	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}

	/**
	 * Sets the creation (creationUser, creationDate) and update (updateUser, updateDate) details
	 * 
	 * @param creationUser
	 * @param creationDate
	 */
	public void setCreationAndUpdateDetails(String user, Timestamp date) {
		this.creationUser = user;
		this.creationDate = date;
		this.updateUser = user;
		this.updateDate = date;
	}

}
