package kr.co.work;

public interface UserDao {
	
	User selectUser(String id);
	void deleteAll() throws Exception;
	int insertUser(User user);
	int updateUser(User user);
	
}
