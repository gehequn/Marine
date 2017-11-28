package com.bgi.marine.dao;

import com.bgi.marine.bean.Organization;
import com.bgi.marine.dao.common.BaseDao;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrganizationDao extends BaseDao<Organization> {
    List<Organization> queryAll();
}
