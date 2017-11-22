package com.bgi.marine.dao.common;

import com.bgi.marine.bean.common.BaseModel;
import org.springframework.stereotype.Repository;

@Repository
public interface BaseDao<T extends BaseModel> {
    int create(T t);

    T find(Long id);

    int delete(Long id);

    int update(T t);
}
