package template.platform.webservice;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.jws.WebParam;
import javax.jws.WebService;

import template.platform.service.UserService;

@WebService(serviceName = "HelloService", targetNamespace = "http://webservice.platform.template/")
public class HelloService {

	private UserService userService;

	public HelloService() {
	}

	public HelloService(UserService userService) {
		this.userService = userService;
	}

	public String test(@WebParam(name = "name") String myname) {
		try {
			return "Hello, " + myname + "!!!";
		} catch (java.lang.Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
	}

	

	public String getUsers(String aaa) {

		StringBuilder xml = new StringBuilder("<root>");
		List<Map<String, Object>> list = userService.getUsers();
		for (Map<String, Object> map : list) {
			xml.append("<row>");
			Set<String> keys = map.keySet();
			for (String key : keys) {
				xml.append("<" + key + ">");
				xml.append(map.get(key));
				xml.append("</" + key + ">");
			}
			xml.append("</row>");
		}
		xml.append("</root>");
		System.out.println(xml.toString());
		return xml.toString();
	}

}