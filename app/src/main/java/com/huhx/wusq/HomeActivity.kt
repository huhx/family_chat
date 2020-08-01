package com.huhx.wusq

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
import androidx.viewpager.widget.ViewPager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.huhx.wusq.adapter.ViewPagerAdapter
import com.huhx.wusq.ui.dashboard.DashboardFragment
import com.huhx.wusq.ui.home.HomeFragment
import com.huhx.wusq.ui.me.MeFragment
import com.huhx.wusq.ui.notifications.NotificationsFragment
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setSupportActionBar(findViewById(R.id.my_toolbar))

        setupViewPager()
        initEvent()
    }

    private fun initEvent() {
        nav_view.setOnNavigationItemSelectedListener(BottomNavigationView.OnNavigationItemSelectedListener { item ->
            switchMenu(item)
            return@OnNavigationItemSelectedListener true
        })
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
        val homeFragment = HomeFragment()
        val dashboardFragment = DashboardFragment()
        val notificationsFragment = NotificationsFragment()
        val meFragment = MeFragment()
        viewPagerAdapter.addFragment(homeFragment)
        viewPagerAdapter.addFragment(dashboardFragment)
        viewPagerAdapter.addFragment(notificationsFragment)
        viewPagerAdapter.addFragment(meFragment)
        view_pager.adapter = viewPagerAdapter
    }
}