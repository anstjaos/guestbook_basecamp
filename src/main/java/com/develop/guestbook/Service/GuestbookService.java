package com.develop.guestbook.Service;

import java.util.List;

import com.develop.guestbook.DAO.GuestbookDAO;

public interface GuestbookService {
	List<GuestbookDAO> getGuestbooks();
	void insertGuestbook(GuestbookDAO guestbook);
	void updateGuestbook(GuestbookDAO guestbook);
}