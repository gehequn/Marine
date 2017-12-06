package com.bgi.marine.util;

import java.lang.reflect.Type;
import java.util.List;

import com.bgi.marine.bean.vo.OrganizationVo;
import com.google.gson.Gson;

public class JsonUtil {

    private static Gson json = new Gson();

    private static String resultOrgJson;

    public static String parseJson(Object value) throws Exception {
        String str = json.toJson(value);
        return str;
    }

    public static Object JsonToList(String content, Type type) throws Exception {
        return json.fromJson(content, type);
    }

    public static String getOrganizationJson(List<OrganizationVo> organizationVoList) {
        resultOrgJson = "[";
        getChildOrganizationJson(organizationVoList);
        resultOrgJson += "]";
        return resultOrgJson;
    }

    private static void getChildOrganizationJson(List<OrganizationVo> childOrgList) {
        for (int i = 0; i < childOrgList.size(); i++) {
            OrganizationVo organizationVo = childOrgList.get(i);
            resultOrgJson += "{\"text\":\"" + organizationVo.getOrgName() + "\",\"id\":\"" + organizationVo.getId() + "\"";
            if (organizationVo.getChildOrg() != null && organizationVo.getChildOrg().size() > 0) {
                resultOrgJson += ",\"nodes\":[";
                getChildOrganizationJson(organizationVo.getChildOrg());
                if (i == childOrgList.size() - 1) {
                    resultOrgJson += "]}";
                } else {
                    resultOrgJson += "]},";
                }
            } else {
                if (i == childOrgList.size() - 1) {
                    resultOrgJson += "}";
                } else {
                    resultOrgJson += "},";
                }
            }
        }
    }
}
