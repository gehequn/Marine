package com.bgi.marine.dao;

import com.bgi.marine.bean.Menu;
import com.bgi.marine.dao.common.BaseDao;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuDao extends BaseDao<Menu> {
    List<Menu> queryAll();
}
