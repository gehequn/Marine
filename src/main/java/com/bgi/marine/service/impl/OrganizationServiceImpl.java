package com.bgi.marine.service.impl;

import com.bgi.marine.agent.OrganizationAgent;
import com.bgi.marine.bean.Organization;
import com.bgi.marine.bean.vo.OrganizationVo;
import com.bgi.marine.constants.Constants;
import com.bgi.marine.service.OrganizationService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by GeHeQun on 2017/11/28.
 */
public class OrganizationServiceImpl implements OrganizationService {

    @Resource
    private OrganizationAgent organizationAgent;

    @Override
    public List<OrganizationVo> getOrgTree() {
        List<Organization> organizationList = organizationAgent.queryAllOrganization();
        List<OrganizationVo> organizationVoList = Arrays.asList();
        List<OrganizationVo> resultTree = Arrays.asList();
        //Organization转为OrganizationVo
        if (organizationList != null && organizationList.size() > 0){
            for (Organization organization : organizationList){
                organizationVoList.add(OrganizationVo.builder()
                        .id(new Long(organization.getId()).intValue())
                        .orgCode(organization.getOrgCode())
                        .orgName(organization.getOrgName()
                        ).parentId(organization.getParentId())
                        .build());
            }
            getChildNode(organizationVoList.get(0),organizationVoList, resultTree);
        }
        return organizationVoList;
    }

    private void getChildNode(OrganizationVo parentNode, List<OrganizationVo> organizationVoList,List<OrganizationVo> resultTree){
        //移除当前父亲节点
        organizationVoList.remove(parentNode);
        int i = 0 ;
        while (i < organizationVoList.size()){
            if (parentNode.getId() == organizationVoList.get(i).getParentId()) {
                
            }
            i++;
        }
    }
}
