package template.platform.config;
import javax.xml.ws.Endpoint;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import template.platform.service.UserService;
import template.platform.webservice.HelloService;

@Configuration
public class WebServiceConfig {

    @Autowired
    private Bus bus;
    
    @Autowired
  	UserService userService;
    

    @Bean
    public Endpoint endpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, new HelloService(userService));
        endpoint.publish("/test");
        return endpoint;
    }
}