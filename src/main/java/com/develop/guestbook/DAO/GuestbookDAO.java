package com.develop.guestbook.DAO;

import java.util.Date;

public class GuestbookDAO {
	private int id;
	private String email;
	private String password;
	private String contents;
	private Date writeTime;
	private Date reviseTime;
	
	public GuestbookDAO(String email, String password, String contents){
		this.email = email;
		this.password = password;
		this.contents = contents;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setContents(String contents) {
		this.contents = contents;
	}
	
	public void setWriteTime(Date writeTime) {
		this.writeTime = writeTime;
	}
	
	public void setReviseTime(Date reviseTime) {
		this.reviseTime = reviseTime;
	}
	
	public int getId() {
		return id;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getContents() {
		return contents;
	}
	
	public Date getWriteTime() {
		return writeTime;
	}
	
	public Date getReviseTime() {
		return reviseTime;
	}
}
