package club.zqg.enter.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@ConfigurationProperties(prefix = "zqg")
public class MyConfigProperties {

    private String configName;

    @DateTimeFormat(pattern ="yyyy-MM-dd" )
    private Date configDate;
}
