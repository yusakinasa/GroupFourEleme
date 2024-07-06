package org.example.eleme.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.example.eleme.model.User;
import org.example.eleme.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Map<String, Object> register(@RequestBody User user) {
        Map<String, Object> response = new HashMap<>();
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("phone", user.getPhone());
        User existingUser = userService.getOne(queryWrapper);

        if (existingUser != null) {
            response.put("status", "error");
            response.put("message", "账号已存在");
        } else {
            try {
                userService.save(user);
                response.put("status", "success");
            } catch (Exception e) {
                response.put("status", "error");
                response.put("message", e.getMessage());
            }
        }
        return response;
    }

    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody User user) {
        Map<String, Object> response = new HashMap<>();
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("phone", user.getPhone());
        User foundUser = userService.getOne(queryWrapper);

        if (foundUser != null && foundUser.getPassword().equals(user.getPassword())) {
            response.put("status", "success");
        } else {
            response.put("status", "error");
            response.put("message", "账号或密码错误");
        }
        return response;
    }

    @GetMapping("/all")
    public Map<String, Object> getAll() {
        Map<String, Object> response = new HashMap<>();
        response.put("data", userService.getAllUsers());
        return response;
    }
}



