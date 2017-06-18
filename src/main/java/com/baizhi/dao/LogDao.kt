package com.baizhi.dao

import com.baizhi.entity.Log
import com.baizhi.entity.Page
import org.apache.ibatis.annotations.Param

/**
 * 123
 * Created by gjp06 on 17.6.16.
 */
interface LogDao {
    fun selectLog(@Param("log") log: Log, @Param("page") page: Page): List<Log>

    fun insertLog(log: Log): Int

    fun selectTotalRows(): Int
}