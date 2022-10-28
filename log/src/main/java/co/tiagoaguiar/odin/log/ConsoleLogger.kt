package co.tiagoaguiar.odin.log

import java.text.SimpleDateFormat
import java.util.*


class ConsoleLogger : Logger {

    override var level: Level = Level.VERBOSE

    override fun v(message: String) {
        write(Level.VERBOSE, message)
    }

    override fun d(message: String) {
        write(Level.DEBUG, message)
    }

    override fun i(message: String) {
        write(Level.INFO, message)
    }

    override fun w(message: String) {
        write(Level.WARNING, message)
    }

    override fun e(message: String) {
        write(Level.ERROR, message)
    }

    private fun write(level: Level, message: String) {
        val (className, lineNumber, fileName) = buildTag()

        val sdf = SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.getDefault())
        val date = sdf.format(Date())

        println("$date $level $className ${buildMessage(message, fileName, lineNumber)}")
    }

}
