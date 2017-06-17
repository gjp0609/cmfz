import com.baizhi.service.UserService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

/**
 * Created by gjp06 on 17.6.16.
 */
public class TestString {
    @Test
    public void test1() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        UserService service = (UserService) ctx.getBean("userService");
//        byte[] chart1 = service.getChart1();
    }

    @Test
    public void getStr() {
        byte[] bts = new byte[52];
        String s = Arrays.toString(bts);
        System.out.println(s);
    }
}
