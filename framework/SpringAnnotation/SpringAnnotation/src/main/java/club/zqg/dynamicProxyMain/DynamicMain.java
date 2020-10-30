package club.zqg.dynamicProxyMain;

import club.zqg.jdk_dynamic_proxy.DynamicProxy;
import club.zqg.service.IUserService;

public class DynamicMain {
    public static void main(String[] args) {
        DynamicProxy dynamicProxy = new DynamicProxy();
        IUserService proxyObject = (IUserService)dynamicProxy.getProxyObject(); //����ת��Ϊ�ӿ�����
        proxyObject.save();
    }
}
