package com.bgi.marine.service.impl;

import com.bgi.marine.agent.OrganizationAgent;
import com.bgi.marine.bean.Organization;
import com.bgi.marine.bean.vo.OrganizationVo;
import com.bgi.marine.service.OrganizationService;
import com.bgi.marine.util.CommonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by GeHeQun on 2017/11/28.
 */
@Service
public class OrganizationServiceImpl implements OrganizationService {

    private Logger logger = LoggerFactory.getLogger(OrganizationServiceImpl.class);

    @Resource
    private OrganizationAgent organizationAgent;

    @Override
    public List<OrganizationVo> getOrgTree() {
        List<OrganizationVo> organizationVoList = new ArrayList<>();
        List<OrganizationVo> resultTree = new ArrayList<>();
        try {
            List<Organization> organizationList = organizationAgent.queryAllOrganization();
            //Organization转为OrganizationVo
            if (organizationList != null && organizationList.size() > 0) {
                for (Organization organization : organizationList) {
                    organizationVoList.add(OrganizationVo.builder()
                            .id(new Long(organization.getId()).intValue())
                            .orgCode(organization.getOrgCode())
                            .orgName(organization.getOrgName())
                            .parentId(organization.getParentId())
                            .childOrg(new ArrayList<>())
                            .build());
                }
                CommonUtil.getTree(organizationVoList.get(0), organizationVoList, resultTree, true);
            }

        } catch (Exception e) {
            logger.error(e.toString());
        }
        return resultTree;
    }

}
