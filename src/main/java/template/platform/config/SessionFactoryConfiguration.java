package template.platform.config;

import java.io.IOException;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@Configuration
public class SessionFactoryConfiguration {

	@Value(value = "${mybatis_config_file}")
	private String mybatisConfigFilePath;
	
	@Value(value = "${mapper_path}")
	private String mapperPath;
	
	@Value(value = "${entity_package}")
	private String entityPackage;
	
	@Autowired
	@Qualifier("masteDataSource")
	private DataSource masteDataSource;
	
	

	@Bean(name="sqlSessionFactoryBean")
	public SqlSessionFactoryBean createSqlSessionFactoryBean() throws IOException {
		SqlSessionFactoryBean sqlSessionFactoryBean =new SqlSessionFactoryBean();
		//mybatis配置文件
		sqlSessionFactoryBean.setConfigLocation(new ClassPathResource(mybatisConfigFilePath));
		PathMatchingResourcePatternResolver resoulver = new PathMatchingResourcePatternResolver();
		//映射文件
		String packageSearchPath = PathMatchingResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX + mapperPath;
		sqlSessionFactoryBean.setMapperLocations(resoulver.getResources(packageSearchPath));
		//数据源
		sqlSessionFactoryBean.setDataSource(masteDataSource);
		//实体类
		sqlSessionFactoryBean.setTypeAliasesPackage(entityPackage);
		return sqlSessionFactoryBean;
	}
}
