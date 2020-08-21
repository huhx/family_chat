package com.huhx.family.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.huhx.family.R
import com.huhx.family.databinding.ActivityChatRoomBinding

class ChatRoomActivity : AppCompatActivity() {

    private lateinit var binding: ActivityChatRoomBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChatRoomBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(findViewById(R.id.my_toolbar))
        val username = intent.getStringExtra("username")
        binding.tvUsername.text = username

        binding.mainToobar.ivBack.setOnClickListener {
            this.finish()
        }
    }
}