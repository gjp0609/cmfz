package com.baizhi.service

import com.baizhi.entity.Lesson
import com.baizhi.entity.Page

/**
 * Created by gjp06 on 17.6.16.
 */
interface LessonService {

    fun queryAllLesson(page: Page): List<Lesson>

    fun queryOneLesson(lesson: Lesson): Lesson

    fun addLesson(lesson: Lesson)

    fun modifyLesson(lesson: Lesson)
}