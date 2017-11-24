import com.bgi.marine.javaEnum.Ajax;
import org.aspectj.weaver.loadtime.Aj;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext.xml"})
public class MyTest {

    public static void main(String[] args){
        String url = "Welcome/record";
        for (Ajax ajaxUrl : Ajax.values()){
            if (ajaxUrl.name().equals(url)){
                System.out.print("same");
            }
        }
    }
}
