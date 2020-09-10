package club.zqg.enter;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@MapperScan("club.zqg.enter.mapper")
public class RunSpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(RunSpringbootApplication.class, args);
    }

}
