package co.tiagoaguiar.odin.log

import android.util.Log
import java.io.File
import java.io.FileOutputStream
import java.text.SimpleDateFormat
import java.util.*

class FileLogger(private val file: File) : Logger {

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

        val res = "$date $level --$className ${buildMessage(message, fileName, lineNumber)}"

        var writer: FileOutputStream? = null
        try {
            writer = FileOutputStream(file, true)
            writer.write(res.toByteArray())
            writer.write("\n".toByteArray())
        } catch (e: Exception) {
           Log.e("--$className", buildMessage("Failed to write a file ${file.absolutePath} ${e.message}", fileName, lineNumber))
        } finally {
           writer?.close()
        }
    }

}
