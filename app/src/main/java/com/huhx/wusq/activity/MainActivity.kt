package com.huhx.wusq.activity

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.huhx.wusq.R
import com.huhx.wusq.adapter.FruitAdapter
import com.huhx.wusq.domain.Fruit
import kotlinx.android.synthetic.main.main_activity.*

class MainActivity : AppCompatActivity() {

    private lateinit var actionBarDrawerToggle: ActionBarDrawerToggle
    private var fruits: ArrayList<Fruit> = ArrayList()
    private val fruitDatas = arrayOf(
        Fruit("Apple", R.drawable.ic_action_name),
        Fruit("Apple", R.drawable.ic_action_name),
        Fruit("Apple", R.drawable.ic_action_name),
        Fruit("Apple", R.drawable.ic_action_name),
        Fruit("Apple", R.drawable.ic_action_name),
        Fruit("Apple", R.drawable.ic_action_name),
        Fruit("Apple", R.drawable.ic_action_name)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        actionBarDrawerToggle = ActionBarDrawerToggle(this, drawer_layout, R.string.app_name, R.string.content)
        drawer_layout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        initFruits()
        recycler_view.layoutManager = GridLayoutManager(this, 3)
        recycler_view.adapter = FruitAdapter(fruits)

        nv_view.setNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.account -> {
                    Toast.makeText(this, "My Account", Toast.LENGTH_SHORT).show()
                }
                R.id.settings -> {
                    Toast.makeText(this, "My Setting", Toast.LENGTH_SHORT).show()
                }
                R.id.mycart -> {
                    Toast.makeText(this, "My Cart", Toast.LENGTH_SHORT).show()
                }
            }
            return@setNavigationItemSelectedListener true
        }

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Data deleted", Snackbar.LENGTH_SHORT).setAction("Undo") {
                Toast.makeText(this, "Data restored", Toast.LENGTH_SHORT).show()
            }.show()
        }
    }

    private fun initFruits() {
        fruits.clear()
        for (i in 0..50) {
            val index = (fruitDatas.indices).random()
            fruits.add(fruitDatas[index])
        }
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}

