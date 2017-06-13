package dao

import com.baizhi.dao.SlideImageDao
import com.baizhi.entity.Page
import com.baizhi.entity.SlideImage
import org.junit.Test
import org.springframework.context.support.ClassPathXmlApplicationContext
import java.util.*

/**
 * Created by gjp06 on 17.6.13.
 */
class SlideImageDaoTest {
    val context = ClassPathXmlApplicationContext("spring.xml")
    val dao = context.getBean("slideImageDao") as SlideImageDao

    @Test
    fun select() {
        val image = dao.selectSlideImage(SlideImage(), Page())
        for (im in image) {
            println(im)
        }
    }

    @Test
    fun insert() {
        val image = SlideImage()
        image.id = UUID.randomUUID().toString().replace("-", "")
        image.detail = "经院转经轮"
        image.status = "Y"
        image.src = "5.jpg"
        dao.insertSlideImage(image)
    }

    @Test
    fun update() {
        val im = SlideImage()
        im.id = "0cf82b10134741edb54a1b19ba6e6e82"
        val image = dao.selectSlideImage(im, Page())[0]
        image.status = "N"
        println(dao.updateSlideImage(image))
    }


}