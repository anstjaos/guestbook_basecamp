package com.develop.guestbook.Mapper;
import java.util.List;
import com.develop.guestbook.DAO.PopItDAO;

public interface PopItMapper {
	public List<PopItDAO> selectList();
}
