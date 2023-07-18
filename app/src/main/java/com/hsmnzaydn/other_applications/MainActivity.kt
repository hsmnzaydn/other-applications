package com.hsmnzaydn.other_applications

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        OtherApplicationsFragment.newInstance().show(
            supportFragmentManager, OtherApplicationsFragment.Companion::class.java.simpleName
        )
    }
}