package dao

import com.baizhi.dao.LessonDao
import com.baizhi.entity.Lesson
import com.baizhi.entity.Page
import org.junit.Test
import org.springframework.context.support.ClassPathXmlApplicationContext

/**
 * Created by gjp06 on 17.6.16.
 */
class LessonDaoTest {

    @Test
    fun select() {
        val context = ClassPathXmlApplicationContext("spring.xml")
        val dao = context.getBean("lessonDao") as LessonDao
        for (lesson in dao.selectLesson(Lesson(), Page())) {
            println(lesson)
        }
    }

    @Test
    fun insert() {
        val context = ClassPathXmlApplicationContext("spring.xml")
        val dao = context.getBean("lessonDao") as LessonDao
        val lesson = Lesson()
        lesson.id = "a2587e06fc5d482c849650a183bd25e1"
        lesson.name = "进餐"
        println(dao.insertLesson(lesson))
    }

    @Test
    fun update() {
        val context = ClassPathXmlApplicationContext("spring.xml")
        val dao = context.getBean("lessonDao") as LessonDao
        val lesson = Lesson()
        lesson.id = "a2587e06fc5d482c849650a183bd25e1"
        lesson.name = "进食"
        println(dao.updateLesson(lesson))
    }
}