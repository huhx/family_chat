package com.huhx.family.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.huhx.family.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.forgetPassword.setOnClickListener {
            Toast.makeText(this, "forget password", Toast.LENGTH_SHORT).show()
        }
        binding.userRegister.setOnClickListener {
            Toast.makeText(this, "user register", Toast.LENGTH_SHORT).show()
        }
        binding.ibtSubmit.setOnClickListener {
            val username = binding.etUsername.text.toString()
            val password = binding.etPassword.text.toString()
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