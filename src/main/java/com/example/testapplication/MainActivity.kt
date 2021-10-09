package com.example.testapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.testapplication.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_uaf.setOnClickListener { _ ->
            doUseAfterFree();
        }
        button_uaf_loop.setOnClickListener { _ ->
            doUseAfterFreeLoop();
        }
        button_oob.setOnClickListener { _ ->
            doHeapBufferOverflow();
        }
        button_oob_read_loop.setOnClickListener { _ ->
            doHeapBufferOverflowReadLoop();
        }
        button_double_free.setOnClickListener { _ ->
            doDoubleFree();
        }
        button_null_deref.setOnClickListener { _ ->
            doNullDeref();
        }
    }

    external fun doUseAfterFree()
    external fun doUseAfterFreeLoop()
    external fun doHeapBufferOverflow()
    external fun doHeapBufferOverflowReadLoop()
    external fun doDoubleFree()
    external fun doNullDeref()

    /**
     * A native method that is implemented by the 'testapplication' native library,
     * which is packaged with this application.
     */
    external fun stringFromJNI(): String

    companion object {
        // Used to load the 'testapplication' library on application startup.
        init {
            System.loadLibrary("testapplication")
        }
    }
}