package club.zqg.enter.service.impl;

import club.zqg.enter.domain.User;
import club.zqg.enter.mapper.UserMapper;
import club.zqg.enter.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    UserMapper  userMapper;

    @Override
    public List<User> getAllUser() {
        return userMapper.selectAllUser();
    }
}
