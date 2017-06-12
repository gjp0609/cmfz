import com.baizhi.utils.SecurityUtils
import org.junit.Test
import java.net.URLDecoder
import java.net.URLEncoder
import java.util.*

/**
 * Created by gjp06 on 17.6.12.
 */
class CommonTest {

    @Test
    fun uuid() {
        val uuid = UUID.randomUUID().toString()
        println(uuid)
        val newUuid = uuid.replace("-", "")
        println("$newUuid ${newUuid.length}")
    }

    @Test
    fun md5() {
        val pwd = "123123"
        val md5 = SecurityUtils.getMD5(pwd)
        println(md5)
    }

    @Test
    fun cookie() {
        val name: String = "你好"
        val encode = URLEncoder.encode(name, "utf-8")
        println(encode)
        val decode = URLDecoder.decode(encode, "utf-8")
        println(decode)
    }
}