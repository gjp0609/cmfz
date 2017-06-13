package dao

import com.baizhi.dao.MenuDao
import com.baizhi.entity.Menu
import org.junit.Test
import org.springframework.context.support.ClassPathXmlApplicationContext

/**
 * Created by gjp06 on 17.6.12.
 */

class MenuDaoTest {
    @Test
    fun query() {
        val context = ClassPathXmlApplicationContext("spring.xml")
        val dao = context.getBean("menuDao") as MenuDao
        val list = dao.selectMenu() as List<Menu>
        for (menu in list) {
            println(menu)
        }
    }
}

