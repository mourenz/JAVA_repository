package club.zqg;

public class TestThreadLocal {

    public static void main(String[] args) {

        //两者获取的对象一致
        DbUtilsThreadLocal.getConnectionFromThradLocal();
        new Thread(() -> {
            DbUtilsThreadLocal.getConnectionFromThradLocal();
        }).start();
    }
}
