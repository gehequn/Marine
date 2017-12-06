package com.bgi.marine.agent.impl;

import com.bgi.marine.agent.OrganizationAgent;
import com.bgi.marine.bean.Organization;
import com.bgi.marine.bean.vo.OrganizationVo;
import com.bgi.marine.dao.OrganizationDao;
import com.bgi.marine.dto.OrganizationDto;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrganizationAgentImpl implements OrganizationAgent {

    @Resource
    private OrganizationDao organizationDao;

    @Override
    public List<Organization> queryAllOrganization() {
        return organizationDao.queryAll();
    }

    @Override
    public OrganizationVo addOrganization(OrganizationDto organizationDto) {
        Organization organization = Organization.builder()
                .orgName(organizationDto.getOrgName())
                .parentId(organizationDto.getParentOrgId())
                .type(1)
                .build();
        return OrganizationVo.builder()
                .id(organizationDao.create(organization))
                .orgName(organizationDto.getOrgName())
                .parentId(organizationDto.getParentOrgId())
                .build();
    }

    @Override
    public Organization queryById(int orgId) {
        return organizationDao.find(new Long(orgId));
    }

    @Override
    public int update(Organization organization) {
        return organizationDao.update(organization);
    }

    @Override
    public int delete(int orgId) {
        return organizationDao.delete(new Long(orgId));
    }
}
