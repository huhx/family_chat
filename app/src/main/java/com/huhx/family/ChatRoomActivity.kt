package com.huhx.family

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_chat_room.*
import kotlinx.android.synthetic.main.main_toolbar.*

class ChatRoomActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat_room)
        setSupportActionBar(findViewById(R.id.my_toolbar))
        val username = intent.getStringExtra("username")
        tv_username.text = username

        iv_back.setOnClickListener {
            this.finish()
        }
    }
}