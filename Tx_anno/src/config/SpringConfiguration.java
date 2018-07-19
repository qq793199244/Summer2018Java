package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Spring的配置类,作用相当于bean.xml
 * @author WY
 *
 */
@Configuration
@ComponentScan("com.wangyue")
@Import({JdbcConfig.class,TransactionManager.class})
@EnableTransactionManagement
public class SpringConfiguration {

}
