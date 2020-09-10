package service;

import domain.User;

public interface IUserService {
    boolean add(User user);


    // 事务处理
    // 转出
    void transt(Integer outUid,Integer inUid,Double money);


}
