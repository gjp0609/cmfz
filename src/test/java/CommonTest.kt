import com.baizhi.utils.MyUtils
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
        val md5 = MyUtils.getMD5(pwd)
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

    @Test
    fun getUUID() {
        var i = 0
        while (i < 10) {
            val uuid = UUID.randomUUID().toString().replace("-", "")
            println(uuid)
            i++
        }
    }

    @Test
    fun getRandom() {
        var i = 1
        while (i != 52) {
            print((Math.random() * 7).toInt() + 1)
            i++
        }
    }
}