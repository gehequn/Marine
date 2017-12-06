package com.bgi.marine.service;

import com.bgi.marine.bean.vo.OrganizationVo;
import com.bgi.marine.dto.OrganizationDto;

import java.util.List;

public interface OrganizationService {
    List<OrganizationVo> getOrgTree();
    OrganizationVo addOrganization(OrganizationDto organizationDto)  throws Exception;
    void editOrganization(OrganizationDto organizationDto)  throws Exception;
    void delOrganization(OrganizationDto organizationDto)  throws Exception;
    List<OrganizationVo> getOrgUpList(OrganizationDto organizationDto);
}
