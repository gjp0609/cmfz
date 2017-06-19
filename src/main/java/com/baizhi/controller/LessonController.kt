package com.baizhi.controller

import com.baizhi.entity.DataDTO
import com.baizhi.entity.Lesson
import com.baizhi.entity.Page
import com.baizhi.service.LessonService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody

/**
 * 123
 * Created by gjp06 on 17.6.16.
 */
@Controller("lessonController")
@RequestMapping("/lesson")
open class LessonController {

    @Autowired
    lateinit open var service: LessonService

    @RequestMapping("/queryAll")
    @ResponseBody
    fun queryAll(page: Int, rows: Int): DataDTO<Lesson> {
        val p = Page(page, rows)
        val lessonList = service.queryAllLesson(p)
        for (lesson in lessonList) {
            println(lesson)
        }
        val lessonDataDTO = DataDTO<Lesson>()
        lessonDataDTO.total = p.totalRows
        lessonDataDTO.rows = lessonList
        return lessonDataDTO
    }

    @RequestMapping("/queryOne")
    @ResponseBody
    fun queryOne(lesson: Lesson): Lesson {
        return service.queryOneLesson(lesson)
    }

    @RequestMapping("/modify")
    @ResponseBody
    fun modify(lesson: Lesson) {
        service.modifyLesson(lesson)
    }

    @RequestMapping("/add")
    @ResponseBody
    fun add(lesson: Lesson) {
        service.addLesson(lesson)
    }

}