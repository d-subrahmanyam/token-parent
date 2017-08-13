/**
 * 
 */
package com.subbu.tokensys.teller.core.entities;

import java.io.Serializable;

import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @author subbu
 *
 */

@Entity
@Table(name = "Teller", schema="TOKENSYS")
public class Teller implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = -8473854251386604046L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TELLER_SEQ")
	@SequenceGenerator(sequenceName = "TELLER_ID_PK_SEQ", allocationSize = 1, name = "TELLER_SEQ")
	@Column(name = "id")
	private Long Id;

	@Column(name = "teller_id")
	private String tellerId;

	@Column(name = "teller_fname")
	private String firstName;

	@Column(name = "teller_lname")
	private String lastName;

	@Column(name = "teller_email")
	private String email;

	@Column(name = "teller_mobile")
	private String mobile;

	public Teller() {

	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return Id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		Id = id;
	}

	/**
	 * @return the tellerId
	 */
	public String getTellerId() {
		return tellerId;
	}

	/**
	 * @param customerId
	 *            the tellerId to set
	 */
	public void setTellerId(String tellerId) {
		this.tellerId = tellerId;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the mobile
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * @param mobile
	 *            the mobile to set
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this, false);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj, false);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}

}
