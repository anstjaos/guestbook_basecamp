package com.develop.guestbook.DAO;

import java.util.Date;

public class GuestbookDAO {
	private int id;
	private String email;
	private String password;
	private String contents;
	private String writeTime;
	private String reviseTime;
	
	GuestbookDAO() {}
	public GuestbookDAO(String email, String password, String contents, String writeTime){
		this.email = email;
		this.password = password;
		this.contents = contents;
		this.writeTime = writeTime;
	}
	
	public GuestbookDAO(int id, String contents, String reviseTime) {
		this.id = id;
		this.contents = contents;
		this.reviseTime = reviseTime;
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
	
	public void setWriteTime(String writeTime) {
		this.writeTime = writeTime;
	}
	
	public void setReviseTime(String reviseTime) {
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
	
	public String getWriteTime() {
		return writeTime;
	}
	
	public String getReviseTime() {
		return reviseTime;
	}
}
