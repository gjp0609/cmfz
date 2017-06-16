package dao

import com.baizhi.dao.UserDao
import com.baizhi.entity.Page
import com.baizhi.entity.User
import org.junit.Test
import org.springframework.context.support.ClassPathXmlApplicationContext

/**
 * Created by gjp06 on 17.6.16.
 */
class UserDaoTest {
    @Test
    fun select() {
        val context = ClassPathXmlApplicationContext("spring.xml")
        val dao = context.getBean("userDao") as UserDao
        println(dao.selectTotalRows())
        val users = dao.selectUser(User(), Page(1, 100))
        for (user in users) {
            println(user)
        }
    }


    @Test
    fun update() {
        val context = ClassPathXmlApplicationContext("spring.xml")
        val dao = context.getBean("userDao") as UserDao
        val user = User()
        user.id = "a3ceb3d57ed44ca5ad76dcbf3718a912"
        user.status = "N"
        println(dao.updateUser(user))
    }

    @Test
    fun delete() {
        val context = ClassPathXmlApplicationContext("spring.xml")
        val dao = context.getBean("userDao") as UserDao
        val user = User()
        user.id = "12ceb3d57ed44ca5ad76dcbf3718a912"
        println(dao.deleteUser(user))
    }
}