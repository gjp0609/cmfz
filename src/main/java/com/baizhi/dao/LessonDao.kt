package com.baizhi.dao

import com.baizhi.entity.Lesson
import com.baizhi.entity.Page
import org.apache.ibatis.annotations.Param

/**
 * Created by gjp06 on 17.6.16.
 */
interface LessonDao {
    fun selectLesson(@Param("lesson") lesson: Lesson, @Param("page") page: Page): List<Lesson>

    fun insertLesson(lesson: Lesson): Int

    fun updateLesson(lesson: Lesson): Int

    fun selectTotalRows(): Int
}