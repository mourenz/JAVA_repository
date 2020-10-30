package service.impl;

import dao.MoneyMapper;
import dao.UserMapper;
import domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.IUserService;

@Service
@Transactional
public class UserServiceImp implements IUserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public boolean add(User user) {
        int rows = userMapper.insert(user);
//        int j = 1/0;
        return rows==1? true:false;
    }

    @Autowired
    private MoneyMapper moneyMapper;

    @Override
    public void transt(Integer outUid, Integer inUid, Double money) {
        moneyMapper.updateMoneyWithReduce(inUid,money);

        int i = 1/0;
        moneyMapper.updateMoneyWithIncrese(outUid,money);
    }


}
