package com.lsb.dto;

import java.sql.Timestamp;

public class MemberVO {
	private String id;
	private String pwd;
	private String name;
	private String email;
	private String zip_num;
	private String address;
	private String phone;
	private String useyn;
	private String news_email_yn;
	
	public String getUseyn() {
		return useyn;
	}
	public void setUseyn(String useyn) {
		this.useyn = useyn;
	}
	public String getNews_email_yn() {
		return news_email_yn;
	}
	public void setNews_email_yn(String news_email_yn) {
		this.news_email_yn = news_email_yn;
	}
	private Timestamp regdate;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getZip_num() {
		return zip_num;
	}
	public void setZip_num(String zip_num) {
		this.zip_num = zip_num;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getuseyn() {
		return useyn;
	}
	public void setuseyn(String useyn) {
		this.useyn = useyn;
	}
	public Timestamp getRegdate() {
		return regdate;
	}
	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}
	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", pwd=" + pwd + ", name=" + name + ", email=" + email + ", zip_num=" + zip_num
				+ ", address=" + address + ", phone=" + phone + ", useyn=" + useyn + ", news_email_yn=" + news_email_yn
				+ ", regdate=" + regdate + "]";
	}
	
}
