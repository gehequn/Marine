package com.bgi.marine.agent.impl;

import com.bgi.marine.agent.OrganizationAgent;
import com.bgi.marine.bean.Organization;
import com.bgi.marine.dao.OrganizationDao;

import javax.annotation.Resource;
import java.util.List;

public class OrganizationAgentImpl implements OrganizationAgent {

    @Resource
    private OrganizationDao organizationDao;

    @Override
    public List<Organization> queryAllOrganization() {
        return organizationDao.queryAll();
    }
}
