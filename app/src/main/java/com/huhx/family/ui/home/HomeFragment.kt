package com.huhx.family.ui.home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.huhx.family.activity.ChatRoomActivity
import com.huhx.family.R
import com.huhx.family.adapter.UserRecyclerAdapter
import com.huhx.family.domain.User
import com.huhx.family.listener.OnItemClickListener
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initRefresh()
        initRecyclerView()
    }

    private fun initRefresh() {
        pull_refresh.setOnRefreshListener {
            Toast.makeText(activity, "fresh data", Toast.LENGTH_SHORT).show()
            pull_refresh.isRefreshing = false
        }
    }

    private fun initRecyclerView() {
        recycler_view.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        recycler_view.adapter = UserRecyclerAdapter(getUsers(), onItemClickListener())
    }

    private fun onItemClickListener(): OnItemClickListener {
        return object : OnItemClickListener {
            override fun onItemClick(user: User) {
                val intent = Intent(activity, ChatRoomActivity::class.java)
                intent.putExtra("username", user.fullname)
                startActivity(intent)
            }

            override fun onItemLongClick(user: User) {
                val vibrator = activity?.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
                vibrator.vibrate(VibrationEffect.createOneShot(500, VibrationEffect.DEFAULT_AMPLITUDE))
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