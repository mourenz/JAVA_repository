import domain.Employee;
import strategy.BigFunction;
import strategy.FilterBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {

    static List<Employee> employeeList = Arrays.asList(new Employee("zs","001"),new Employee("zs2","002"),new Employee("zs3","003"));

    //匿名内部类实现策略
    static FilterBase filterIdStrategy = new FilterBase() {
        @Override
        public boolean operation(Employee employee) {
            return Integer.parseInt(employee.getEid()) > 2;
        }
    };






    //bigFunction  实现原理·
    public static String bigFunctionFilter(Long num1,Long num2,BigFunction<Long,String> bigFunction){
        return bigFunction.compute(num1+num2);
    }


    public static void main(String[] args) {
        filterId(employeeList,filterIdStrategy).forEach(System.out::println);

        System.out.println(bigFunctionFilter(10L, 20L, (x) -> x.intValue() + "---"));

    }






    //
    public static List<Employee> filterId(List<Employee> list,FilterBase filterBase){
        ArrayList<Employee> employees = new ArrayList<>();
        list.forEach((employee)->{
            if(filterBase.operation(employee)){
                employees.add(employee);
            }
        });
        return employees;
    }
}
