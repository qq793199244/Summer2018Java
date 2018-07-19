package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Spring��������,�����൱��bean.xml
 * @author WY
 *
 */
@Configuration
@ComponentScan("com.wangyue")
@Import({JdbcConfig.class,TransactionManager.class})
@EnableTransactionManagement
public class SpringConfiguration {

}
