package dao

import com.baizhi.dao.LamaDao
import com.baizhi.entity.Lama
import com.baizhi.entity.Page
import org.junit.Test
import org.springframework.context.support.ClassPathXmlApplicationContext

/**
 * test
 * Created by gjp06 on 17.6.14.
 */
class LamaDaoTest {
    @Test
    fun select() {
        val context = ClassPathXmlApplicationContext("spring.xml")
        val dao = context.getBean("lamaDao") as LamaDao
        val lama = dao.selectLama(Lama(), Page())
        for (lm in lama) {
            println(lm)
        }
    }

    @Test
    fun insert() {
        val context = ClassPathXmlApplicationContext("spring.xml")
        val dao = context.getBean("lamaDao") as LamaDao
        val lama = dao.selectLama(Lama(), Page())
        for (lm in lama) {
            println(lm)
        }
    }


}