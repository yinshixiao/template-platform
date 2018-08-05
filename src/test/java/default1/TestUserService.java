package default1;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import template.platform.Application;
import template.platform.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class TestUserService {

	@Autowired
    private UserService userService;
	
	@Test
    public void test() {
		if(userService==null) {
			System.out.println(111111);
		}else {
			List<Map<String, Object>> a = userService.getUsers();
			System.out.println(a.get(0).values().toString());
		}
    }
}
