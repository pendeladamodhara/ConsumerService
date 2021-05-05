package com.pkglobal.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "ERROR_LOG")
public class ErrorLog {

	@Id
	@Column(name = "ID")
	private int errorid;
	@Column(name = "ERROR_TYPE")
	private String errorType;
	@Column(name = "ERROR_DESC")
	private String errorDesc;
	@Lob
	private String payload;

	/**
	 * @return the errorid
	 */
	public int getErrorid() {
		return errorid;
	}

	/**
	 * @param errorid the errorid to set
	 */
	public void setErrorid(int errorid) {
		this.errorid = errorid;
	}

	/**
	 * @return the errorType
	 */
	public String getErrorType() {
		return errorType;
	}

	/**
	 * @param errorType the errorType to set
	 */
	public void setErrorType(String errorType) {
		this.errorType = errorType;
	}

	/**
	 * @return the errorDesc
	 */
	public String getErrorDesc() {
		return errorDesc;
	}

	/**
	 * @param errorDesc the errorDesc to set
	 */
	public void setErrorDesc(String errorDesc) {
		this.errorDesc = errorDesc;
	}

	/**
	 * @return the payload
	 */
	public String getPayload() {
		return payload;
	}

	/**
	 * @param payload the payload to set
	 */
	public void setPayload(String payload) {
		this.payload = payload;
	}

	@Override
	public String toString() {
		return "ErrorLog [errorid=" + errorid + ", errorType=" + errorType + ", errorDesc=" + errorDesc + ", payload="
				+ payload + "]";
	}

}
