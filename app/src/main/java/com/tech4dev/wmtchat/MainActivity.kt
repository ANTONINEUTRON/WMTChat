package com.tech4dev.wmtchat

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.tech4dev.wmtchat.adapter.MainPageAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var toolbar: Toolbar
    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager: ViewPager2
    private lateinit var context: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        context = this

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        initTabLayout()
    }

    private fun initTabLayout() {
        tabLayout = findViewById(R.id.tab)

        viewPager = findViewById(R.id.viewPager)
        viewPager.adapter = MainPageAdapter(supportFragmentManager, lifecycle)

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            when (position) {
                0 -> tab.icon = getDrawable(R.drawable.ic_baseline_photo_camera_24)
                1 -> tab.text = "Chat"
                2 -> tab.text = "Status"
                3 -> tab.text = "Calls"
            }
        }.attach()

        //set default position to chatfragment
        viewPager.currentItem = 1

        viewPager.registerOnPageChangeCallback(
            object: ViewPager2.OnPageChangeCallback(){
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    if(position == 0){
                        val intent = Intent(context, CameraActivity::class.java)
                        startActivity(intent)
                        viewPager.currentItem=1
                    }
                }
            }
        )
    }
}