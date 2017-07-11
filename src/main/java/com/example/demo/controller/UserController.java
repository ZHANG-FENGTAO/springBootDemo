package com.example.demo.controller;

import com.example.demo.bean.UserBean;
import com.example.demo.mapper.UserMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created zft
 */
@Controller
@RequestMapping("/api/user")
@Api(value = "用户信息")
public class UserController {

    private UserMapper userMapper;

    @Autowired
    public UserController(UserMapper userMapper) {
        this.userMapper = userMapper;
    }


    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    @ApiOperation(value = "获取用户信息",notes = "获取用户信息")
    public String test(ModelMap model,@PathVariable String id){
        UserBean user = userMapper.getOne(id);
        model.put("name",user.getName());
        model.put("phone",user.getPhone());
        model.put("date",user.getAddDate());
        return "index";
    }
}
