package org.example.eleme.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.example.eleme.model.User;
import java.util.List;

public interface UserService extends IService<User> {
    List<User> getAllUsers();
    User createUser(User user);
    User getUserByPhone(String phone);
    Long getUserIdByPhone(String phone);
}
