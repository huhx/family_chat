package com.huhx.wusq.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.huhx.wusq.HomeActivity
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
            val username = et_username.text.toString()
            val password = et_password.text.toString()
            if (username == "1234" && password == "huhx") {
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
                this.finish()
            } else {
                Toast.makeText(this, "密码不正确", Toast.LENGTH_SHORT).show()
            }
        }
    }
}