package com.baizhi.service

import com.baizhi.entity.Log
import com.baizhi.entity.Page

/**
 * Created by gjp06 on 17.6.16.
 */
interface LogService {

    fun queryAllLog(page: Page): List<Log>

    fun addLog(log: Log)
}