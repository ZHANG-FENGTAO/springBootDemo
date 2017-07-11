package com.example.demo.mapper;

import com.example.demo.bean.SiteBean;

public interface SiteBeanMapper {
    int deleteByPrimaryKey(String id);

    int insert(SiteBean record);

    int insertSelective(SiteBean record);

    SiteBean selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SiteBean record);

    int updateByPrimaryKey(SiteBean record);
}