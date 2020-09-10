package club.zqg.enter.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ConditionalOnClass(value = MyConfigProperties.class)
@EnableConfigurationProperties(value = MyConfigProperties.class)
public class MyConfigAutoConfiguration {
    @Autowired
    MyConfigProperties myConfigProperties;


}
