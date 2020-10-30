package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration  // 为配置类
@Import(DataSource.class)
@ComponentScan(value = {"dao","service"})
@EnableTransactionManagement // 开启事务管理器 必须开启  否则 业务的 @Transacational 注解失效
public class MainConfig {


    // 注册 事务管理器
    @Bean
    public DataSourceTransactionManager txManager(javax.sql.DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }

}
