package com.huhx.wusq.activity

import android.app.Activity
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.EmbossMaskFilter
import android.graphics.Paint
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.View

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(MyView(this))
    }

    class MyView(context: Context?) : View(context) {
        private val paint: Paint = Paint(Paint.ANTI_ALIAS_FLAG)
        private var embossMaskFilter: EmbossMaskFilter
        override fun onDraw(canvas: Canvas) {
            super.onDraw(canvas)
            val displayMetrics = DisplayMetrics()
            display.getMetrics(displayMetrics)
            val width = displayMetrics.widthPixels
            val height = displayMetrics.heightPixels
            canvas.drawText("美", width / 10.toFloat(), height / 2 + 70.toFloat(), paint)
        }

        init {
            paint.color = Color.RED
            paint.style = Paint.Style.STROKE
            paint.strokeWidth = 64f
            paint.textSize = 1000f
            embossMaskFilter = EmbossMaskFilter(floatArrayOf(1f, 1f, 1f), 0.05f, 5f, 13f)
            paint.maskFilter = embossMaskFilter
        }
    }
}

