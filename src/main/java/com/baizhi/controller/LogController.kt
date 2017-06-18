package com.baizhi.controller

import com.baizhi.entity.Page
import com.baizhi.service.LogService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import java.util.*

/**
 * Created by gjp06 on 17.6.16.
 */
@Controller("logController")
@RequestMapping("/log")
open class LogController {

    @Autowired
    lateinit open var service: LogService

    @RequestMapping("/queryAll")
    @ResponseBody
    fun queryAll(page: Int, rows: Int): HashMap<String, Any> {
        val p = Page(page, rows)
        val logList = service.queryAllLog(p)
        val logMap = HashMap<String, Any>()
        logMap["total"] = p.totalRows
        logMap["rows"] = logList
        return logMap
    }
}