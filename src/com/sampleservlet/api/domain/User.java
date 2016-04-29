package com.sampleservlet.api.domain;

import java.util.Date;

public class User {
	private int userid;
	private String firstName;
	private String lastName;
	private Date dob;
	private String Email;
	private String txtUserName;
	private String txtPass;

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getTxtUserName() {
		return txtUserName;
	}

	public void setTxtUserName(String txtUserName) {
		this.txtUserName = txtUserName;
	}

	public String getTxtPass() {
		return txtPass;
	}

	public void setTxtPass(String txtPass) {
		this.txtPass = txtPass;
	}

	@Override
	public String toString() {
		return "User [userid=" + userid + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", dob=" + dob + ", Email="
				+ Email + ", txtUserName=" + txtUserName + ", txtPass="
				+ txtPass + "]";
	}

}
