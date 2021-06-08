package tech.jour.acg.net

import com.orhanobut.logger.Logger
import okhttp3.logging.HttpLoggingInterceptor

class HttpLogger : HttpLoggingInterceptor.Logger {
  private val mMessage = StringBuffer() //try to resolve the arrayIndexOutOfBoundsException
  override fun log(message: String) { // 请求或者响应开始
    var message = message
    if (message.startsWith("--> POST")) {
      mMessage.setLength(0)
    }
    // 以{}或者[]形式的说明是响应结果的json数据，需要进行格式化
    if (message.startsWith("{") && message.endsWith("}")
      || message.startsWith("[") && message.endsWith("]")
    ) {
      message = message.formatJson()
    }
    mMessage.append(message)
    mMessage.append("\n")
    // 请求或者响应结束，打印整条日志
    if (message.startsWith("<-- END HTTP")) {
      Logger.t("apilog").d(mMessage.toString())
      mMessage.setLength(0)
    }
  }
}

fun String.formatJson(): String {
  if ("" == this) return ""
  val sb = StringBuilder()
  var last = '\u0000'
  var current = '\u0000'
  var indent = 0
  for (element in this) {
    last = current
    current = element
    when (current) {
      '{', '[' -> {
        sb.append(current)
        sb.append('\n')
        indent++
        addIndentBlank(sb, indent)
      }
      '}', ']' -> {
        sb.append('\n')
        indent--
        addIndentBlank(sb, indent)
        sb.append(current)
      }
      ',' -> {
        sb.append(current)
        if (last != '\\') {
          sb.append('\n')
          addIndentBlank(sb, indent)
        }
      }
      else -> sb.append(current)
    }
  }
  return sb.toString()
}

private fun addIndentBlank(sb: java.lang.StringBuilder, indent: Int) {
  for (i in 0 until indent) {
    sb.append('\t')
  }
}
