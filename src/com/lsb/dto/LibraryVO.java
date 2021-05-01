package com.lsb.dto;

import java.sql.Timestamp;
import java.util.Arrays;

public class LibraryVO {
	private int lseq;
	private String subject;
	private String content;
	private String reply;
	private String id;
	private String rep;
	private Timestamp indate;
	private String[] images;
	
	public int getLseq() {
		return lseq;
	}
	public void setLseq(int lseq) {
		this.lseq = lseq;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getReply() {
		return reply;
	}
	public void setReply(String reply) {
		this.reply = reply;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRep() {
		return rep;
	}
	public void setRep(String rep) {
		this.rep = rep;
	}
	public Timestamp getIndate() {
		return indate;
	}
	public void setIndate(Timestamp indate) {
		this.indate = indate;
	}
	public String[] getImages() {
		return images;
	}
	public void setImages(String[] images) {
		this.images = images;
	}
	@Override
	public String toString() {
		return "LibraryVO [lseq=" + lseq + ", subject=" + subject + ", content=" + content + ", reply=" + reply
				+ ", id=" + id + ", rep=" + rep + ", indate=" + indate + ", images=" + Arrays.toString(images) + "]";
	}
}