package co.tiagoaguiar.odin.log

import android.util.Log

class LogcatLogger : Logger {

    override var level: Level = Level.VERBOSE

    override fun v(message: String) {
        output(message) { tag, msg ->
            Log.v(tag, msg)
        }
    }

    override fun d(message: String) {
        output(message) { tag, msg ->
            Log.d(tag, msg)
        }
    }

    override fun i(message: String) {
        output(message) { tag, msg ->
            Log.i(tag, msg)
        }
    }

    override fun w(message: String) {
        output(message) { tag, msg ->
            Log.w(tag, msg)
        }
    }

    override fun e(message: String) {
        output(message) { tag, msg ->
            Log.e(tag, msg)
        }
    }

    private fun output(message: String, write: (String, String) -> Unit) {
        val (className, lineNumber, fileName) = buildTag()

        write("--$className", buildMessage(message, fileName, lineNumber))
    }
}
