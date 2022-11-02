package kr.co.heart.dao;

import kr.co.heart.domain.User;

public interface UserDao {

	User selectUser(String id);
	void daleteAll() throws Exception;
	int insertUser(User user);
	int updateUser(User user);
}
