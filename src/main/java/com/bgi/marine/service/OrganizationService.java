package com.bgi.marine.service;

import com.bgi.marine.bean.Organization;
import com.bgi.marine.bean.vo.OrganizationVo;

import java.util.List;

public interface OrganizationService {
    List<OrganizationVo> getOrgTree();
}
