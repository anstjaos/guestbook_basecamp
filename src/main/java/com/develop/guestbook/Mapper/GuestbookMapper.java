package com.develop.guestbook.Mapper;

import java.util.List;

import com.develop.guestbook.DAO.GuestbookDAO;

public interface GuestbookMapper {
	List<GuestbookDAO> getGuestbooks();
	void insertGuestbook(GuestbookDAO guestbook);
	void updateGuestbook(GuestbookDAO guestbook);
}