package com.huhx.wusq.activity

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.GridLayout
import com.huhx.wusq.R
import kotlinx.android.synthetic.main.main_activity.*

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        val titles = listOf("7", "8", "9", "+", "7", "8", "9", "+", "7", "8", "9", "+", "7", "8", "9", "+")
        for ((index, value) in titles.withIndex()) {
            val button = Button(this)
            button.text = value
            button.textSize = 36f
            val layoutParams = GridLayout.LayoutParams(GridLayout.spec(index / 4 + 2), GridLayout.spec(index % 4))
            myGridLayout.addView(button, layoutParams)
        }
    }
}

