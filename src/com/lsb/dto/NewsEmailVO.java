package com.lsb.dto;

import java.sql.Timestamp;

public class NewsEmailVO {
	private int neseq;
	private String email;
	private Timestamp regdate;
	public int getNeseq() {
		return neseq;
	}
	public void setNeseq(int neseq) {
		this.neseq = neseq;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Timestamp getRegdate() {
		return regdate;
	}
	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}
	@Override
	public String toString() {
		return "NewsEmailVO [neseq=" + neseq + ", email=" + email + ", regdate=" + regdate + "]";
	}
}
