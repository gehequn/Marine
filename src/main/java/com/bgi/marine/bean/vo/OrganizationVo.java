package com.bgi.marine.bean.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrganizationVo implements Serializable {
    private static final long serialVersionUID = 5413189265644277787L;

    private int id;
    private String orgCode;
    private String orgName;
    private int parentId;
    private List<OrganizationVo> childOrg;
}
