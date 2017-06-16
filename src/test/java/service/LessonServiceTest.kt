package service

import com.baizhi.entity.Page
import com.baizhi.service.LessonService
import org.junit.Test
import org.springframework.context.support.ClassPathXmlApplicationContext

/**
 * Created by gjp06 on 17.6.16.
 */
class LessonServiceTest {

    @Test
    fun select() {
        val context = ClassPathXmlApplicationContext("spring.xml")
        val service = context.getBean("lessonService") as LessonService
        for (lesson in service.queryAllLesson(Page())) {
            println(lesson)
        }
    }

}