package com.develop.guestbook.Service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.develop.guestbook.DAO.PopItDAO;
import com.develop.guestbook.Mapper.PopItMapper;

@Service("com.develop.guestbook.service.PopItServiceImpl")
public class PopItServiceImpl implements PopItService{
	@Autowired
	private PopItMapper popItMapper;
	
	@Override
	public List<PopItDAO> selectListService() {
		return popItMapper.selectList();
	}

}
