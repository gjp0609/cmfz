package dao

import com.baizhi.dao.ArticleDao
import com.baizhi.entity.Article
import com.baizhi.entity.Page
import org.junit.Test
import org.springframework.context.support.ClassPathXmlApplicationContext

/**
 * Created by gjp06 on 17.6.15.
 */
class ArticleDaoTest {
    @Test
    fun select() {
        val context = ClassPathXmlApplicationContext("spring.xml")
        val dao = context.getBean("articleDao") as ArticleDao
        val articleList = dao.selectArticle(Article(), Page())
        for (article in articleList) {
            println(article)
        }
    }

    @Test
    fun delete() {
        val context = ClassPathXmlApplicationContext("spring.xml")
        val dao = context.getBean("articleDao") as ArticleDao
        val i = dao.deleteArticle(Article())
        println(i)
    }
}