import com.alibaba.druid.pool.DruidDataSource
import org.junit.Test
import org.springframework.context.support.ClassPathXmlApplicationContext

/**
 * Created by gjp06 on 17.6.12.
 */
class DataBaseTest {


    @Test
    fun datasource() {
        val context = ClassPathXmlApplicationContext("spring.xml")
        val ds = context.getBean("ds") as DruidDataSource
        val connection = ds.connection
        println(connection)
    }
}