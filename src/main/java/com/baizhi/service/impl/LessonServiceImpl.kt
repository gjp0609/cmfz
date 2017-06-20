package com.baizhi.service.impl

import com.baizhi.dao.LessonDao
import com.baizhi.entity.Lesson
import com.baizhi.entity.Page
import com.baizhi.service.LessonService
import com.baizhi.utils.MyUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional

/**
 * Created by gjp06 on 17.6.16.
 */
@Service("lessonService")
@Transactional
open class LessonServiceImpl() : LessonService {

    @Autowired
    lateinit open var dao: LessonDao

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    override fun queryAllLesson(page: Page): List<Lesson> {
        page.totalRows = dao.selectTotalRows()
        val lessonList = dao.selectLesson(Lesson(), page)
        return lessonList
    }

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    override fun queryOneLesson(lesson: Lesson): Lesson {
        val lessonList = dao.selectLesson(lesson, Page())
        if (lessonList.isEmpty()) throw RuntimeException("lesson not exist")
        return lessonList[0]
    }

    override fun addLesson(lesson: Lesson) {
        lesson.id = MyUtils.getUUID()
        val i = dao.insertLesson(lesson)
        if (i == 0) throw RuntimeException("add lesson fail")
    }

    override fun modifyLesson(lesson: Lesson) {
        val i = dao.updateLesson(lesson)
        if (i == 0) throw RuntimeException("modify lesson fail")
    }
}