import com.bgi.marine.bean.vo.OrganizationVo;
import com.bgi.marine.javaEnum.Ajax;
import com.bgi.marine.util.CommonUtil;
import org.aspectj.weaver.loadtime.Aj;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext.xml"})
public class MyTest {
    @Test
    public void test(){
        OrganizationVo organizationVo1 = OrganizationVo.builder().id(1).orgName("1").parentId(0).build();
        OrganizationVo organizationVo2 = OrganizationVo.builder().id(2).orgName("2").parentId(1).build();
        OrganizationVo organizationVo3 = OrganizationVo.builder().id(3).orgName("3").parentId(1).build();
        OrganizationVo organizationVo4 = OrganizationVo.builder().id(4).orgName("4").parentId(3).build();
        OrganizationVo organizationVo5 = OrganizationVo.builder().id(5).orgName("5").parentId(3).build();
        OrganizationVo organizationVo6 = OrganizationVo.builder().id(6).orgName("6").parentId(5).build();
        OrganizationVo organizationVo7 = OrganizationVo.builder().id(7).orgName("7").parentId(5).build();
        OrganizationVo organizationVo8 =  OrganizationVo.builder().id(8).orgName("8").parentId(7).build();
        OrganizationVo organizationVo9 =  OrganizationVo.builder().id(9).orgName("9").parentId(7).build();
        List<OrganizationVo> organizationVoList = new ArrayList<>();
        List<OrganizationVo> resultTree = new ArrayList<>();

        organizationVoList.add(organizationVo1);
        organizationVoList.add(organizationVo2);
//        organizationVoList.add(organizationVo4);
//        organizationVoList.add(organizationVo6);
        organizationVoList.add(organizationVo3);
//        organizationVoList.add(organizationVo5);
//        organizationVoList.add(organizationVo7);
//        organizationVoList.add(organizationVo8);
//        organizationVoList.add(organizationVo9);
        CommonUtil.getTree(organizationVoList.get(0),organizationVoList,resultTree,true);
//        System.out.print(resultTree.toString());
    }
}
