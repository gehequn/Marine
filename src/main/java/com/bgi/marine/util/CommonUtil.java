package com.bgi.marine.util;

import com.bgi.marine.bean.common.ResponseMap;
import com.bgi.marine.bean.vo.OrganizationVo;
import com.bgi.marine.bean.vo.Privilege;
import com.bgi.marine.constants.Constants;
import com.bgi.marine.constants.LoginConstants;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommonUtil {
    public static void setErrorMessage(int flag, String errorMessage, ResponseMap responseMap) {
        responseMap.setFlag(flag);
        responseMap.setMessage(errorMessage);
    }

    public static <T, E> void translate(T t, E e, HashMap<String, String> m) {
        Method[] tms = t.getClass().getDeclaredMethods();
        Method[] tes = e.getClass().getDeclaredMethods();
        HashMap<String, String> map = new HashMap<>();
        if (m != null && m.size() > 0) {
            for (Map.Entry<String, String> entry : m.entrySet()) {
                map.put(StringUtil.toUpperCaseFirstOne(entry.getKey()), StringUtil.toUpperCaseFirstOne(entry.getValue()));
            }
        }
        for (Method m1 : tms) {
            if (m1.getName().startsWith("get")) {
                String mNameSubFix = m1.getName().substring(3);
                String forName;
                if (map.containsKey(mNameSubFix)) {
                    forName = "set" + map.get(mNameSubFix);
                } else {
                    forName = "set" + mNameSubFix;
                }
                for (Method m2 : tes) {
                    if (m2.getName().equals(forName)) {
                        // 如果类型一致，或者m2的参数类型是m1的返回类型的父类或接口
                        boolean canContinue = m2.getParameterTypes()[0].isAssignableFrom(m1.getReturnType());
                        if (canContinue) {
                            try {
                                m2.invoke(e, m1.invoke(t));
                                break;
                            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e1) {
                                e1.printStackTrace();
                            }
                        }
                    }
                }
            }
        }
    }

    public static void setRequest(HttpSession session, HttpServletRequest request) {
        request.setAttribute(LoginConstants.USER_NAME, !session.getAttribute(Constants.USER_NAME).equals(Constants.ADMIN) ? session.getAttribute(Constants.USER_NAME) : Constants.ADMIN_NAME);
        request.setAttribute(LoginConstants.MENU_LIST, ((Privilege) session.getAttribute(LoginConstants.USER_PRIVILEGE)).getMenuList());
    }

    public static void removeSession(HttpSession session) {
        session.removeAttribute(Constants.USER_ID);
        session.removeAttribute(Constants.USER_NAME);
    }

    /**
     * 获取组织
     * */
    public static void getTree(OrganizationVo parentNode, List<OrganizationVo> organizationVoList, List<OrganizationVo> resultTree, boolean needAddResultTree) {
        if (organizationVoList.size() > 0) {
//            OrganizationVo parentNode = organizationVoList.get(0);
            //移除当前父亲节点
            organizationVoList.remove(parentNode);
            //从resultTree找到完整子节点
            boolean getChildTree = false;
            for (int i = 0; i < resultTree.size(); ) {
                if (parentNode.getId() == resultTree.get(i).getParentId()) {
                    if (parentNode.getChildOrg() == null) {
                        parentNode.setChildOrg(new ArrayList<>());
                    }
                    parentNode.getChildOrg().add(resultTree.get(i));
                    resultTree.remove(i);
                    getChildTree = true;
                } else {
                    i++;
                }
            }
            for (int i = 0; i < organizationVoList.size();) {
                if (parentNode.getId() == organizationVoList.get(i).getParentId()) {
                    if (parentNode.getChildOrg() == null) {
                        parentNode.setChildOrg(new ArrayList<>());
                    }
                    parentNode.getChildOrg().add(organizationVoList.get(i));
                    getTree(organizationVoList.get(i),organizationVoList, resultTree, false);
                    getChildTree = true;
                }else {
                    i++;
                }
            }
            if (needAddResultTree) {
                resultTree.add(parentNode);
            }
            if (!getChildTree && needAddResultTree) {
                getTree(organizationVoList.get(0),organizationVoList, resultTree, true);
            }
        }
    }
}
