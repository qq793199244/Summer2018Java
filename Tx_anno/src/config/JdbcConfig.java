package config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * 连接数据库的配置类
 * @author WY
 *
 */
public class JdbcConfig {
	
	@Bean(name="jdbcTemplate")
	public JdbcTemplate createJdbcTemplate(DataSource dataSource){
		return new JdbcTemplate(dataSource);
	}
	
	@Bean(name="dataSource")
	public DataSource createDataSource(){
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/jdbctemplate");
		ds.setUsername("root");
		ds.setPassword("root");
		return ds;
	}

}
