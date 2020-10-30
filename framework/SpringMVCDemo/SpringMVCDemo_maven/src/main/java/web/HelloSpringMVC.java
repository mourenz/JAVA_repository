package web;
import org.springframework.ui.Model;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;


//注解开发
@Controller
public class HelloSpringMVC /*implements Controller*/ {
	
    @RequestMapping(value = "hello",method = RequestMethod.GET)
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse) throws Exception {
    	System.out.println(httpServletRequest.getRealPath(httpServletRequest.getServletPath()));
        System.out.println("hello spring-mvc");
        ModelAndView mv =new ModelAndView();
        mv.setViewName("index.jsp");
        mv.addObject("msg","hello spring-mvc");
        return mv;
    }
    @RequestMapping("test") // 规定访问uri
    public String testString(Model model){
        return "/index.jsp";
    }

    @RequestMapping("forward")
    public String forward(Model model){
        // return "redirect:/index.jsp" // 重定向
        return "forward:/index.jsp";  // 转发 地址栏不变
    }
    @RequestMapping("index")
    public String index(@ModelAttribute("name")String username){
        return "/index.jsp";
    }
    // @ModelAttribute("别名") 给请求参数起别名
	/*
	 * @RequestMapping("index02") public String index02(User user){
	 * System.out.println(user); return "/index.jsp"; }
	 */    // 获取请求头信息
    @RequestMapping("/index03")
    public String index03(@RequestHeader("User-Agent")String userAgent){
        System.out.println(userAgent);
        System.out.println("git test update ");
        return null;
    }

	/*
	 * @RequestMapping("json")
	 * 
	 * @ResponseBody // 将对象封装为json格式 public User userJson(){ // 这里会返回到
	 * User中去，也就是在页面中显示 user的json格式 User user = new User(); user.setUsername("zqg");
	 * return user; }
	 */

	/*
	 * @RequestMapping("/loginLog") public String loginLog(User user){
	 * System.out.println(user); return "/index.jsp"; }
	 */
	/*
	 * @RequestMapping("/jsonFormat")
	 * 
	 * @ResponseBody public User jsonFormat(User user){ return user; }
	 */
}
