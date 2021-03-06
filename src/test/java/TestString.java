import com.alibaba.fastjson.JSONReader;
import com.baizhi.entity.Page;
import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by gjp06 on 17.6.16.
 */
public class TestString {
    @Test
    public void test1() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        UserService service = (UserService) ctx.getBean("userService");
//        byte[] loginChart = service.getLoginChart();
    }

    @Test
    public void getStr() {
        String field = "id";
        String methodName = "get" + field.substring(0, 1).toUpperCase() + field.substring(1);
        System.out.println(methodName);
    }

    @Test
    public void tr() throws Exception {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        UserService service = (UserService) ctx.getBean("userService");
        List<User> users = service.queryAllUser(new Page());
        User user = users.get(0);
        System.out.println(user);
        // 标题数组
        String[] titles1 = new String[]{"编号", "姓名", "faName", "createTime"};
        // 标题列数组
        String[] titles2 = new String[]{"id", "name", "faName", "registerTime"};
        // 遍历 User 方法
        Method[] methods = User.class.getMethods();
        for (String s : titles2) {
            // 将标题名转换为对应的get方法名  id --> getId   name --> getName
            String methodName = "get" + (char) (s.charAt(0) - 'a' + 'A') + s.substring(1);
            for (Method method : methods) {
                // 如果方法名对应则执行方法123
                if (method.getName().equals(methodName)) {
                    // 得到结果
                    System.out.println(method.invoke(user));
                    // 拿到方法返回类型
                    Class<?> type = method.getReturnType();
                    // 如果为日期类型，则自定义格式
                    if (type.newInstance() instanceof Date) {
                        System.out.println(true);
                    }
                }
            }
        }
    }

    @Test
    public void t() throws FileNotFoundException {
        HashMap map;
        JSONReader reader = new JSONReader(new FileReader("C:\\Files\\Workspaces\\cmfz\\target\\cmfz\\file\\model.json"));
        reader.startObject();
        while (reader.hasNext()) {
            String key = reader.readString();
            map = reader.readObject(HashMap.class);
            for (Object o : map.keySet()) {
                System.out.println(o);
            }
            // handle vo ...
            // 处理vo对象，比方说插入数据库，或者获取值做其他业务逻辑功能
        }
        reader.endObject();
        reader.close();
    }

}
