package com.bgi.marine.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrganizationDto implements Serializable {

    private static final long serialVersionUID = -3358027111427663318L;
    private Integer orgId;
    private String orgName;
    private Integer parentOrgId;
    private String parentOrgName;

}
