package com.huhx.wusq.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.huhx.wusq.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        forget_password.setOnClickListener {
            Toast.makeText(this, "forget password", Toast.LENGTH_SHORT).show()
        }
        user_register.setOnClickListener {
            Toast.makeText(this, "user register", Toast.LENGTH_SHORT).show()
        }
        ibt_submit.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}