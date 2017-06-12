package dao

import com.baizhi.dao.AdminDao
import com.baizhi.entity.Admin
import com.baizhi.utils.SecurityUtils
import org.junit.Test
import org.springframework.context.support.ClassPathXmlApplicationContext
import java.util.*

/**
 * Created by gjp06 on 17.6.12.
 */
class AdminDaoTest {

    @Test
    fun selectAdmin() {
        val context = ClassPathXmlApplicationContext("spring.xml")
        val dao = context.getBean("adminDao") as AdminDao
        val admin = dao.selectAdmin(Admin())
        println(admin)
    }

    @Test
    fun insertAdmin() {
        val context = ClassPathXmlApplicationContext("spring.xml")
        val dao = context.getBean("adminDao") as AdminDao
        val admin = Admin()
        admin.id = UUID.randomUUID().toString().replace("-", "")
        admin.username = "你好"
        admin.realName = "GJP"
        admin.salt = SecurityUtils.getRandomCode(10)
        admin.password = SecurityUtils.getMD5("123123" + admin.salt)
        val i = dao.insertAdmin(admin)
        println("$i $admin")
    }

    @Test
    fun updateAdmin() {
        val context = ClassPathXmlApplicationContext("spring.xml")
        val dao = context.getBean("adminDao") as AdminDao
    }

    @Test
    fun deleteAdmin() {
        val context = ClassPathXmlApplicationContext("spring.xml")
        val dao = context.getBean("adminDao") as AdminDao
    }
}