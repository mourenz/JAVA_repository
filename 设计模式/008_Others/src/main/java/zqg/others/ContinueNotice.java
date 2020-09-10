package zqg.others;

import java.util.Arrays;
import java.util.List;

public class ContinueNotice {
    /**
     *  continue 关键字是用于结束循环的 循环体内遇到 continue 时 会自动结束本次循环
     *     也就是 continue下面的代码就不执行了 ，开始下次循环
     *
     *     循环体内  如果if语句块 有 continue  则满足if时 if外的语句块也不执行
     *
     * @param args
     */

    public static void main(String[] args) {

        /*
        *  最终效果 【只有两次】
        * ---------------
        * ---------------
        * */

        List<String> stringList = Arrays.asList("zqg","zqg01", "zqg02");
        for (String s : stringList) {
            if(s.contains("zqg01")){
                continue; // 当满足时 外面的代码统统结束
            }
            System.out.println("---------------");
        }
    }
}
