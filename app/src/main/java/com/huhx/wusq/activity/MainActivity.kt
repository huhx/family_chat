package com.huhx.wusq.activity

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.huhx.wusq.R
import com.huhx.wusq.listener.OnItemClickListener
import com.huhx.wusq.adapter.UserRecyclerAdapter
import com.huhx.wusq.domain.User
import kotlinx.android.synthetic.main.main_activity.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        recycler_view.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recycler_view.adapter = UserRecyclerAdapter(getUsers(), onItemClickListener())
    }

    private fun onItemClickListener(): OnItemClickListener {
        return object : OnItemClickListener {
            override fun onItemClick(user: User) {
                Toast.makeText(this@MainActivity, user.username, Toast.LENGTH_SHORT).show()
            }

            override fun onItemLongClick(user: User) {
                Toast.makeText(this@MainActivity, user.phone, Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun getUsers(): List<User> {
        return listOf(
            User("Belal Khan", "1234567890"),
            User("Ramiz Khan", "1234567893"),
            User("Faiz Khan", "1234565890"),
            User("Yashar Khan", "1214567890")
        )
    }
}

