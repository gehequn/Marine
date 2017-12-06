package com.bgi.marine.agent;

import com.bgi.marine.bean.Organization;
import com.bgi.marine.bean.vo.OrganizationVo;
import com.bgi.marine.dto.OrganizationDto;

import java.util.List;

public interface OrganizationAgent {
    List<Organization> queryAllOrganization();
    OrganizationVo addOrganization(OrganizationDto organizationDto);
}
