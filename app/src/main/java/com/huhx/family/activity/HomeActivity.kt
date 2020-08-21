package com.huhx.family.activity

import android.os.Bundle
import android.view.MenuItem
import android.view.View.INVISIBLE
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
import androidx.viewpager.widget.ViewPager
import com.huhx.family.R
import com.huhx.family.adapter.ViewPagerAdapter
import com.huhx.family.databinding.ActivityHomeBinding
import com.huhx.family.ui.dashboard.DashboardFragment
import com.huhx.family.ui.home.HomeFragment
import com.huhx.family.ui.me.MeFragment
import com.huhx.family.ui.notifications.NotificationsFragment

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val toolbar = findViewById<Toolbar>(R.id.my_toolbar)
        setSupportActionBar(toolbar)
        val imageView = toolbar.findViewById<ImageView>(R.id.iv_back)
        imageView.visibility = INVISIBLE

        setupViewPager()
        initEvent()
    }

    private fun initEvent() {
        binding.navView.setOnNavigationItemSelectedListener { item ->
            switchMenu(item)
            true
        }
        binding.viewPager.addOnPageChangeListener(object : ViewPager.SimpleOnPageChangeListener() {
            override fun onPageSelected(position: Int) {
                binding.navView.menu.getItem(position).isChecked = true
                switchMenu(binding.navView.menu.getItem(position))
            }
        })
    }

    private fun switchMenu(item: MenuItem?) {
        when (item?.itemId) {
            R.id.navigation_home -> binding.viewPager.currentItem = 0
            R.id.navigation_dashboard -> binding.viewPager.currentItem = 1
            R.id.navigation_notifications -> binding.viewPager.currentItem = 2
            R.id.navigation_me -> binding.viewPager.currentItem = 3
        }
    }

    private fun setupViewPager() {
        val viewPagerAdapter = ViewPagerAdapter(supportFragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT)
        viewPagerAdapter.addFragments(HomeFragment(), DashboardFragment(), NotificationsFragment(), MeFragment())
        binding.viewPager.adapter = viewPagerAdapter
    }
}