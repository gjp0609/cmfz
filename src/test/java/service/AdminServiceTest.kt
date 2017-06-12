package service

import com.baizhi.entity.Admin
import com.baizhi.service.AdminService
import org.junit.Test
import org.springframework.context.support.ClassPathXmlApplicationContext

/**
 * Created by gjp06 on 17.6.12.
 */
class AdminServiceTest {
    @Test
    fun query() {
        val context = ClassPathXmlApplicationContext("spring.xml")
        val service = context.getBean("adminService") as AdminService
        val admin = Admin()
        admin.username = "me"
        admin.password = "123123"
        val dbAdmin = service.queryAdmin(admin)
        println(dbAdmin)
    }

    @Test
    fun add() {

    }
}