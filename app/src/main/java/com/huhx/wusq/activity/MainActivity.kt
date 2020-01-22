package com.huhx.wusq.activity

import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    val linearLayout = LinearLayout(this)
    super.setContentView(linearLayout)

    linearLayout.orientation = LinearLayout.VERTICAL
    val textView = TextView(this)
    textView.text = "Hello World!"
    textView.textSize = 20f

    val button = Button(this)
    button.text = "refresh"
    button.textSize = 20f
    button.setOnClickListener {
      textView.text = "date with ${Date()}"
    }

    linearLayout.addView(textView)
    linearLayout.addView(button)

  }
}
