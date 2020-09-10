package web;

import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("springmvc")
@SessionAttributes(value = "testSession")
public class MainSpringMVC {
	
//	 Session 处理
    @RequestMapping("01")
    public String test01(ModelMap modelMap){
        modelMap.addAttribute("testSession","testSessionValue");
        return "index";
    }
    
    
//  restful 风格 处理
    @RequestMapping("02/{id}")
    public String main02(@PathVariable("id")Long id) {
    	System.out.println("restful id 为"+id);
    	return "index";
    }
    
// 数组处理 批量处理
    @RequestMapping("03")
    public String main03(Long[] ids) {
    	System.out.println(Arrays.toString(ids));
    	return "index";
    }
}
