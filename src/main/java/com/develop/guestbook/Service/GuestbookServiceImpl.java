package com.develop.guestbook.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.develop.guestbook.DAO.GuestbookDAO;
import com.develop.guestbook.Mapper.GuestbookMapper;

@Service("com.develop.guestbook.service.GuestbookServiceImpl")
public class GuestbookServiceImpl implements GuestbookService {
	@Autowired
	private GuestbookMapper guestbookMapper;

	@Override
	public List<GuestbookDAO> getGuestbooks() {
		return guestbookMapper.getGuestbooks();
	}

	@Override
	public void insertGuestbook(GuestbookDAO guestbook) {
		guestbookMapper.insertGuestbook(guestbook);
	}

	@Override
	public void updateGuestbook(GuestbookDAO guestbook) {
		// TODO Auto-generated method stub
		
	}
}
