package com.xhsf.bean;

public class User {

	private Integer account;
	private String username;
	private String password;
	private String sex;

	public User(Integer account, String username, String password, String sex) {
		this.account = account;
		this.username = username;
		this.password = password;
		this.sex = sex;
	}

	public Integer getAccount() {
		return account;
	}

	public void setAccount(Integer account) {
		this.account = account;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "User [account=" + account + ", username=" + username + ", password=" + password + ", sex=" + sex + "]";
	}

}
