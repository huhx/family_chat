package com.huhx.wusq.activity

import android.app.Activity
import android.os.Bundle
import com.huhx.wusq.R
import kotlinx.android.synthetic.main.main_activity.*

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        login.setOnClickListener {
            val account = myAccount.text.toString()
            val password = myPassword.text.toString()
            when {
                account.isEmpty() -> {
                    accountWrapper.error = "username canot be blank"
                }
                password.isEmpty() -> {
                    passwordWrapper.error = "password canot be blank"
                }
                else -> {
                    accountWrapper.isErrorEnabled = false
                    passwordWrapper.isErrorEnabled = false
                }
            }
        }
    }
}

