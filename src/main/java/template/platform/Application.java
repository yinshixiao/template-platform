package template.platform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Application  {
	public static void main(String[] args) {  
		SpringApplication.run(Application.class, args);  
    } 
}



/* 需要部署到tomcat时候这么写*/
/*
@SpringBootApplication
public class Application extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(Application.class);
    }

}  
*/

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    