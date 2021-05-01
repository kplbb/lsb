package com.lsb.dto;

import java.sql.Timestamp;

public class CartVO {
	    private int cseq;
	    private String id;
	    private int pseq;
	    private String mname;
	    private String pname;
	    
	    private String address;
	    private String payment;
	    
	    private int quantity;
	    private int price2;
	    private Timestamp indate;
	    
	    
		public int getCseq() {
			return cseq;
		}
		public void setCseq(int cseq) {
			this.cseq = cseq;
		}
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public int getPseq() {
			return pseq;
		}
		public void setPseq(int pseq) {
			this.pseq = pseq;
		}
		public String getMname() {
			return mname;
		}
		public void setMname(String mname) {
			this.mname = mname;
		}
		public String getPname() {
			return pname;
		}
		public void setPname(String pname) {
			this.pname = pname;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public String getPayment() {
			return payment;
		}
		public void setPayment(String payment) {
			this.payment = payment;
		}
		public int getQuantity() {
			return quantity;
		}
		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
		public int getPrice2() {
			return price2;
		}
		public void setPrice2(int price2) {
			this.price2 = price2;
		}
		public Timestamp getIndate() {
			return indate;
		}
		public void setIndate(Timestamp indate) {
			this.indate = indate;
		}
		@Override
		public String toString() {
			return "CartVO [cseq=" + cseq + ", id=" + id + ", pseq=" + pseq + ", mname=" + mname + ", pname=" + pname
					+ ", address=" + address + ", payment=" + payment + ", quantity=" + quantity + ", price2=" + price2
					+ ", indate=" + indate + "]";
		}
	    
	    
}