package club.zqg;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 方法引用 ===》引用的意思 也就是借用他人的  前提  他人的方法的形参和返回值 必须和当前函数式接口 一致
 *
 * 构造器引用 同上
 *
 *
 */
public class MethodReference {
    public static void main(String[] args) {

        // 方法引用
        List<String> strings = Arrays.asList("aaa", "bbb", "ccc", "ddd");
        strings.forEach(System.out::println);  // forEach() 即为Consume 函数式接口  和println()方法一致 即为方法引用
        /**
         * public void println(String x) {
         *         synchronized (this) {
         *             print(x);
         *             newLine();
         *         }
         *     }
         */

        System.out.println("-------------------------------");
        BinaryOperator<Double> binaryOperator = (x,y)->Math.pow(x,y);  // x的y次方
        //等同于
        BinaryOperator<Double> binaryOperator1 = Math::pow;

        System.out.println(binaryOperator1.apply(3.1,3.2));
        System.out.println("-------------------------------");




        //构造器引用
        Supplier<Employee1> supplier = Employee1::new;  //即调用无参数构造

        System.out.println(supplier.get());


        Function<Integer,Employee1> employeFunction = Employee1::new;  //即调用了 有一个参数的构造器
        System.out.println(employeFunction.apply(10).getAge());

    }

}

class Employee1{
    private String empNumber;
    private Integer age;

    public Employee1() {
    }

    public Employee1(Integer age) {
        this.age = age;
    }

    public Employee1(String empNumber, Integer age) {
        this.empNumber = empNumber;
        this.age = age;
    }

    public String getEmpNumber() {
        return empNumber;
    }

    public void setEmpNumber(String empNumber) {
        this.empNumber = empNumber;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
