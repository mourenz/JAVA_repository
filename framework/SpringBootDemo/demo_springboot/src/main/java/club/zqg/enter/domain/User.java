package club.zqg.enter.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private Integer uid;

    private String username;
    private String userpwd;

    //前端-->控制器
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    //控制器-->前端
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date createDate;
    
}
