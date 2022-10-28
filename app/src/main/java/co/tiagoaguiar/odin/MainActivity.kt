package co.tiagoaguiar.odin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import co.tiagoaguiar.odin.log.FileLogger
import co.tiagoaguiar.odin.log.Level
import co.tiagoaguiar.odin.log.LogcatLogger
import co.tiagoaguiar.odin.log.OdinLog
import java.io.File
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val button = Button(this)

        OdinLog.DEFAULT.level = Level.VERBOSE

        OdinLog.add(LogcatLogger().apply {
            level = Level.INFO
        })

        val file = File(applicationContext.filesDir, "app.log")
        OdinLog.add(FileLogger(file).apply {
            level = Level.WARNING
        })

        button.setOnClickListener {
            OdinLog.v("Verbose log")
            OdinLog.d("Mensagem de DEBUG")
            OdinLog.i("Mensagem de INFO")
            OdinLog.w("Warning log")
            OdinLog.e("Error log")
        }

        setContentView(button)

    }
}