package template.platform.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import template.platform.dao.UserDao;

@Service("userService")
public class UserService {

	@Autowired
	UserDao userDao;
	
	public List<Map<String, Object>> getUsers(){
		return userDao.getUsers();
	}
}
