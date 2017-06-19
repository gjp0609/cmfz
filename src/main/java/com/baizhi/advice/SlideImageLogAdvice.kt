package com.baizhi.advice

import com.baizhi.dao.SlideImageDao
import com.baizhi.entity.Admin
import com.baizhi.entity.Log
import com.baizhi.entity.Page
import com.baizhi.entity.SlideImage
import com.baizhi.service.LogService
import com.baizhi.utils.MyUtils
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.web.context.request.RequestContextHolder
import org.springframework.web.context.request.ServletRequestAttributes
import java.util.*


/**
 * log123
 * Created by gjp06 on 17.6.18.
 */
@Aspect
@Component
open class SlideImageLogAdvice {

    @Autowired
    lateinit open var service: LogService
    @Autowired
    lateinit open var dao: SlideImageDao

    @Around(value = "execution(* com.baizhi.service.impl.SlideImageServiceImpl.addSlideImage(..))")
    fun add(joinPoint: ProceedingJoinPoint) {
        val request = (RequestContextHolder.getRequestAttributes() as ServletRequestAttributes).request
        var admin = request.session.getAttribute("admin")
        if (admin == null) {
            admin = Admin()
            admin.realName = "未知用户"
        } else {
            admin as Admin
        }
        val image = joinPoint.args[0] as SlideImage

        val log = Log()
        log.id = MyUtils.getUUID()
        log.createUsername = admin.realName
        log.createTime = Date()
        log.action = "add"
        log.content = "用户：${log.createUsername}<br/>" +
                "时间：${MyUtils.fmtDate(log.createTime)}<br/>" +
                "操作：新增<br/>" +
                "详情：${image.detail}<br/>" +
                "状态：${image.status}"

        service.addLog(log)
        joinPoint.proceed()
    }

    @Around(value = "execution(* com.baizhi.service.impl.SlideImageServiceImpl.modifySlideImage(..))")
    fun modify(joinPoint: ProceedingJoinPoint) {
        val request = (RequestContextHolder.getRequestAttributes() as ServletRequestAttributes).request
        var admin = request.session.getAttribute("admin")
        if (admin == null) {
            admin = Admin()
            admin.realName = "未知用户"
        } else admin as Admin

        val image = joinPoint.args[0] as SlideImage
        val dbImage = dao.selectSlideImage(image, Page())[0]

        val log = Log()
        log.id = MyUtils.getUUID()
        log.createUsername = admin.realName
        log.createTime = Date()
        log.action = "modify"

        log.content = "用户：${log.createUsername}<br/>" +
                "时间：${MyUtils.fmtDate(log.createTime)}<br/>" +
                "操作：修改<br/>" +
                "编号：${image.id}<br/>" +
                "详情：${dbImage.detail} --> ${image.detail}<br/>" +
                "状态：${dbImage.status} --> ${image.status}"
        service.addLog(log)
        joinPoint.proceed()
    }
}