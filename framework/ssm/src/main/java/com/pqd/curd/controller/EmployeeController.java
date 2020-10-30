package com.pqd.curd.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pqd.curd.bean.Employee;
import com.pqd.curd.bean.Msg;
import com.pqd.curd.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author:PiQianDong
 * @Date:Created in 2019-01 29 11:25
 */
@Controller
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    /**
     * 删除（单个、批量）
     * @param id
     * @return
     */
    @RequestMapping(value = "/emp/{ids}", method = RequestMethod.DELETE)
    @ResponseBody()
    public Msg deleteEmp(@PathVariable("ids")String ids){
        if(ids.contains("-")){
            String[] str_ids = ids.split("-");
            List<Integer> del_ids = new ArrayList<>();
            // 组装id 的集合
            for (String str:str_ids) {
                del_ids.add(Integer.parseInt(str));
            }
            employeeService.deleteBatch(del_ids);
        }else{
            Integer id = Integer.parseInt(ids);
            employeeService.deleteEmp(id);
        }
        return Msg.success();
    }

    /**
     * 员工更新方法
     * @param employee
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/emp/{empId}", method = RequestMethod.PUT)
    public Msg saveEmp(Employee employee){
        employeeService.updateEmp(employee);
        return Msg.success();
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/emp/{id}",method = RequestMethod.GET)
    public Msg getEmp(@PathVariable("id") Integer id){ // 从路径中获取id的值
        Employee employee = employeeService.getEmp(id);
        return Msg.success().add("emp",employee);
    }

    @ResponseBody
    @RequestMapping("/checkUser")
    public Msg checkUser(@RequestParam("empName") String empName){
        // 先判断用户名是否是合法的表达式
        String reg = "(^[a-zA-Z0-9-_]{6,16}$)|(^[\\u2e80-\\u9fff]{2,5})";
        if(!empName.matches(reg)){
            return Msg.fail().add("va_msg","用户名可以是2-5位中文，或者6-16位英文和数字的组合");
        }
        // 数据库用户名重复校验
        boolean b = employeeService.checkUser(empName);
        if(b){
            return Msg.success();
        }else{
            return Msg.fail().add("va_msg","用户名不可用");
        }
    }
    /**
     * 支持JSR303校验
     * 导入Hibernate-Validator
     * 员工保存
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/emp",method = RequestMethod.POST)
    public Msg saveEmp(@Valid Employee employee,
                       BindingResult result){
        Map<String, Object> map = new HashMap<>();
        if(result.hasErrors()){
            // 校验失败,在模态框中显示校验失败信息
            List<FieldError> fieldErrors = result.getFieldErrors();
            for (FieldError fieldError:fieldErrors) {
                System.out.println("错误的字段名：" + fieldError.getField());
                System.out.println("错误信息：" + fieldError.getDefaultMessage());
                map.put(fieldError.getField(),fieldError.getDefaultMessage());
            }
            return Msg.fail().add("errorFields",map);
        }else{
            employeeService.saveEmp(employee);
            return Msg.success();
        }
    }
/*    @RequestMapping("/emps")
    public String getEmps(@RequestParam(value = "pn",defaultValue = "1") Integer pn, Model model){
        // 引入PageHelper 分页插件,在查询之前调用,页码，大小
        PageHelper.startPage(pn,5);
        // 开始查询
        List<Employee> emps = employeeService.getAll();
        // 封装了详细信息 ,连续显示的页数
        PageInfo pageInfo = new PageInfo(emps,5);
        model.addAttribute("page",pageInfo);
        return "list";
    }*/

    /**
     * 导入jackson包
     * @param pn
     * @param model
     * @return
     */
    @RequestMapping("/emps")
    @ResponseBody
    public Msg getEmpsWithJson(@RequestParam(value = "pn",defaultValue = "1") Integer pn){
        // 引入PageHelper 分页插件,在查询之前调用,页码，大小
        PageHelper.startPage(pn,5);
        // 开始查询
        List<Employee> emps = employeeService.getAll();
        // 封装了详细信息 ,连续显示的页数
        PageInfo pageInfo = new PageInfo(emps,5);
        return Msg.success().add("pageInfo", pageInfo);
    }
}

