package com.bgi.marine.javaEnum;

public enum Ajax {
    Welcome_Record("/Welcome/record"),
    Organization_GetTree("/Organization/getTree"),
    Organization_AddOrganization("/Organization/addOrganization"),
    Organization_EditOrganization("/Organization/editOrganization"),
    Organization_DelOrganization("/Organization/delOrganization"),
    Organization_GetOrgUpList("/Organization/getOrgUpList"),
    User_Record("/User/record"),
    User_UserInfoInit("/User/userInfoInit");

    private String url;

    Ajax(String url){
        this.url = url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
