import com.baizhi.entity.User
import com.baizhi.service.UserService
import org.junit.Test
import org.springframework.context.support.ClassPathXmlApplicationContext
import java.io.File

/**
 * Created by gjp06 on 17.6.17.
 */
class ExcelTest {
    @Test
    fun testtt(){
        println(123)
    }

    @Test
    fun test1() {
        val ctx = ClassPathXmlApplicationContext("spring.xml")
        val service = ctx.getBean("userService") as UserService
        val allDataExcel = service.allDataExcel
        allDataExcel.write(File("d://1.xls"))
    }

    @Test
    fun names() {
        val fields = User::class.java.fields
        for (field in fields) {
            println(field.name)
        }
    }

}