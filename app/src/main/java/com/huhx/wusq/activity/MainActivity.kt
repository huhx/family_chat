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
import kotlinx.android.synthetic.main.main_toolbar.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        setSupportActionBar(findViewById(R.id.my_toolbar))

        recycler_view.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recycler_view.adapter = UserRecyclerAdapter(getUsers(), onItemClickListener())

        iv_back.setOnClickListener { finish() }
        iv_more.setOnClickListener { Toast.makeText(this, "show more", Toast.LENGTH_SHORT).show() }
    }

    private fun onItemClickListener(): OnItemClickListener {
        return object : OnItemClickListener {
            override fun onItemClick(user: User) {
                Toast.makeText(this@MainActivity, user.fullname, Toast.LENGTH_SHORT).show()
            }

            override fun onItemLongClick(user: User) {
                Toast.makeText(this@MainActivity, user.signature, Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun getUsers(): List<User> {
        return listOf(
            User(1, "胡红翔", "20200525055708455786.jpg", "才发现你离开之后，我的世界都黯淡无光。", "2002-10-04"),
            User(2, "巫施奇", "20200525111254714333.jpg", "如果我是DJ，你还会爱我吗？", "1993-08-29"),
            User(3, "赵德柱", "20200703120232912159.jpg", "我不是神仙，爱你我尽力了。", "2002-10-04"),
            User(4, "张得帅", "20200705064804724896.jpg", "我是男的，你是女的。我们为何不能在一起。", "2002-10-04"),
            User(5, "吴耀旺", "20200705065019009512.jpg", "你很好，但是我不能再爱了。", "2002-10-04")
        )
    }
}

