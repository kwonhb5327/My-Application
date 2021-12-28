package com.example.myapplication1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.android.material.bottomnavigation.BottomNavigationView

import android.widget.LinearLayout


class MainActivity : AppCompatActivity() {
    val TAG = this.javaClass.simpleName
    var home_ly: LinearLayout? = null
    var bottomNavigationView: BottomNavigationView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init() //객체 정의
        SettingListener() //리스너 등록

        //맨 처음 시작할 탭 설정
        bottomNavigationView!!.selectedItemId = R.id.home
    }

    private fun init() {
        home_ly = findViewById(R.id.home_ly)
        bottomNavigationView = findViewById(R.id.bottomNavigationView)
    }

    private fun SettingListener() {
        //선택 리스너 등록
        bottomNavigationView!!.setOnNavigationItemSelectedListener(TabSelectedListener())
    }

    internal inner class TabSelectedListener :
        BottomNavigationView.OnNavigationItemSelectedListener {
        override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {
            when (menuItem.getItemId()) {
                R.id.tab_home -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.home_ly, HomeFragment())
                        .commit()
                    return true
                }
                R.id.tab_dog -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.home_ly, DogFragment())
                        .commit()
                    return true
                }
                R.id.tab_user -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.home_ly, UserFragment())
                        .commit()
                    return true
                }
                R.id.tab_settings -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.home_ly, SettingsFragment())
                        .commit()
                    return true
                }
            }
            return false
        }
    }
}