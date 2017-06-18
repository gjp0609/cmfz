package com.baizhi.service.impl

import com.baizhi.dao.LogDao
import com.baizhi.entity.Log
import com.baizhi.entity.Page
import com.baizhi.service.LogService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional

/**
 * Created by gjp06 on 17.6.16.
 */
@Service("logService")
@Transactional
open class LogServiceImpl : LogService {

    @Autowired
    lateinit open var dao: LogDao

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    override fun queryAllLog(page: Page): List<Log> {
        page.totalRows = dao.selectTotalRows()
        val logList = dao.selectLog(Log(), page)
        return logList
    }

    override fun addLog(log: Log) {
        val i = dao.insertLog(log)
        if (i == 0) throw RuntimeException("add log fail")
    }

}