package com.culler.weatherlookup.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.culler.weatherlookup.R
import com.culler.weatherlookup.view.fragment.MainFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }
    }
}