package template.platform.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;



public interface UserDao {
	
	@Select(" select * from sys_user")
	List<Map<String,Object>> getUsers();
}
