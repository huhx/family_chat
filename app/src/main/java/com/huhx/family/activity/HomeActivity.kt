package com.huhx.family.activity

import android.os.Bundle
import android.view.MenuItem
import android.view.View.INVISIBLE
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
import androidx.viewpager.widget.ViewPager
import com.huhx.family.adapter.ViewPagerAdapter
import com.huhx.family.ui.dashboard.DashboardFragment
import com.huhx.family.ui.home.HomeFragment
import com.huhx.family.ui.me.MeFragment
import com.huhx.family.ui.notifications.NotificationsFragment
import com.huhx.family.R
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val toolbar = findViewById<Toolbar>(R.id.my_toolbar)
        setSupportActionBar(toolbar)
        val imageView = toolbar.findViewById<ImageView>(R.id.iv_back)
        imageView.visibility = INVISIBLE

        setupViewPager()
        initEvent()
    }

    private fun initEvent() {
        nav_view.setOnNavigationItemSelectedListener { item ->
            switchMenu(item)
            true
        }
        view_pager.addOnPageChangeListener(object : ViewPager.SimpleOnPageChangeListener() {
            override fun onPageSelected(position: Int) {
                nav_view.menu.getItem(position).isChecked = true
                switchMenu(nav_view.menu.getItem(position))
            }
        })
    }

    private fun switchMenu(item: MenuItem?) {
        when (item?.itemId) {
            R.id.navigation_home -> view_pager.currentItem = 0
            R.id.navigation_dashboard -> view_pager.currentItem = 1
            R.id.navigation_notifications -> view_pager.currentItem = 2
            R.id.navigation_me -> view_pager.currentItem = 3
        }
    }

    private fun setupViewPager() {
        val viewPagerAdapter = ViewPagerAdapter(supportFragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT)
        viewPagerAdapter.addFragments(HomeFragment(), DashboardFragment(), NotificationsFragment(), MeFragment())
        view_pager.adapter = viewPagerAdapter
    }
}