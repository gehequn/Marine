package com.bgi.marine.service.impl;

import com.bgi.marine.agent.OrganizationAgent;
import com.bgi.marine.bean.Organization;
import com.bgi.marine.bean.vo.OrganizationVo;
import com.bgi.marine.dto.OrganizationDto;
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

    @Override
    public OrganizationVo addOrganization(OrganizationDto organizationDto) throws Exception {
        return organizationAgent.addOrganization(organizationDto);
    }

    @Override
    public void editOrganization(OrganizationDto organizationDto) throws Exception {
        Organization updateOrg = new Organization();
        Organization organization = organizationAgent.queryById(organizationDto.getOrgId());
        if (!organizationDto.getOrgName().equals(organization.getOrgName())){
            updateOrg.setOrgName(organizationDto.getOrgName());
        }
        if (organizationDto.getParentOrgId() != organization.getParentId()){
            updateOrg.setParentId(organizationDto.getParentOrgId());
        }
        updateOrg.setId(new Long(organizationDto.getOrgId()));
        organizationAgent.update(updateOrg);
    }

    @Override
    public void delOrganization(OrganizationDto organizationDto) throws Exception {
        organizationAgent.delete(organizationDto.getOrgId());
    }

    @Override
    public List<OrganizationVo> getOrgUpList(OrganizationDto organizationDto) {
        List<OrganizationVo> organizationVoList = new ArrayList<>();
        List<Organization> organizationList = organizationAgent.queryAllOrganization();
        if (organizationDto.getOrgId() != 0) {
            removeNode(organizationDto.getOrgId(), organizationList);
            removeChildOrg(organizationDto.getOrgId(), organizationList);
        }
        for (Organization organization : organizationList) {
            organizationVoList.add(OrganizationVo.builder()
                    .id(new Long(organization.getId()).intValue())
                    .orgName(organization.getOrgName())
                    .parentId(organization.getParentId())
                    .childOrg(new ArrayList<>())
                    .build());
        }
        return organizationVoList;
    }

    private void removeChildOrg(int orgId, List<Organization> organizationList) {
        for (int i = 0; i < organizationList.size(); i++) {
            if (organizationList.get(i).getParentId() == orgId) {
                Organization organization = organizationList.get(i);
                removeChildOrg(new Long(organization.getId()).intValue(), organizationList);
                organizationList.remove(organization);
                i--;
            }
        }
    }

    private void removeNode(int orgId, List<Organization> organizationList){
        for(int i = 0; i < organizationList.size(); i++) {
            if (organizationList.get(i).getId() == orgId){
                organizationList.remove(i);
                break;
            }
        }
    }
}
