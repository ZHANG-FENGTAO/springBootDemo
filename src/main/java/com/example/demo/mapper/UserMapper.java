package com.example.demo.mapper;

import com.example.demo.bean.UserBean;
import org.apache.ibatis.annotations.*;

import java.util.List;
/**
 * Created by zft on 2017/7/10.
 */

public interface UserMapper {

    @Select("SELECT * FROM t_user")
    @Results({
            @Result(property = "iconServel",  column = "icon_servel"),
            @Result(property = "siteId", column = "site_id")
    })
    List<UserBean> getAll();

    @Select("SELECT * FROM t_user WHERE id = #{id}")
    @Results({
            @Result(property = "iconServel",  column = "icon_servel"),
            @Result(property = "siteId", column = "site_id"),
            @Result(property = "addDate", column = "add_date")
    })
    UserBean getOne(String id);

    @Insert("INSERT INTO t_user(name,phone,site_id) VALUES(#{name}, #{phone}, #{siteId})")
    void insert(UserBean user);

    @Update("UPDATE t_user SET name=#{name},phone=#{phone} WHERE id =#{id}")
    void update(UserBean user);

    @Delete("DELETE FROM t_user WHERE id =#{id}")
    void delete(Long id);

}
